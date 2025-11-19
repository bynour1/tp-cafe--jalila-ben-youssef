package com.example.tp_cafe_jalila_ben_youssef.repositories;

import com.example.tp_cafe_jalila_ben_youssef.Entite.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

 @Query("select  c from  Client c  where  c.nom=?1 And c.prenom=?2 ")
 List <Client>  methode1JPQL(String nom , String prenom);
 @Query("select c from Client  c where  c.nom=:n And c.prenom=:p")
List<Client> methode2JPDL (@Param("n") String nom , String prenom);
 @Query(value = "select * from Client  where  " +"First_name=?2 and Last-name=?1  " ,nativeQuery = true)
 List<Client> methode1SQL ( String p , String n);

@Modifying
@Query (value = "delete  from Client  WHERE  dateNaissance between "+":dMin and :dMax " , nativeQuery = true)
void fasa5belDateSQl( @Param("dMin") LocalDate dMin, @Param("dMax") LocalDate dMax);

List<Client> jiblibiljpql (int code);
@Query ( "select  c from Client  c where c.adress.codePostal=?1")
List<Client> recupByAdresse (String adresse);
@Query (value = "Select c.* from t_client c join t_adresse a on" + " a.id_adresse=c.id_adresse where a.code_post=2020", nativeQuery = true)
List<Client> recupBySQL(int code);

// dans la base de donne (SQL) Select c.*from t_client c join t_adresse on a.id_adresse=c.id_adresse where a.code_post=2020




    List<Client> findByNom(String nom);

    List<Client> findByPrenom(String prenom);

    List<Client> findByNomAndPrenom(String nom, String prenom);
   List<Client> ExistByNom (String nom );

    long countBornAfterDateNaissance(LocalDate dateNaissance);
    List <Client> findByNomOrPrenomContains(String nom ,String prenom );
    List <Client> findByNomAndPrenomContains(String nom ,String prenom );
    List <Client> findBornBetweenDateNaissance(Date DateNaissance);
    List <Client> findNomStartsBornBeforeDateNaissance(String nom ,Date DateNaissance);
    List <Client> findByVilleJoin(String ville);
    List<Client> findByNomContainsOrderByPrenomAsc(String nom ,String Prenom);
    List<Client> findByNomContainsOrderByPrenomDesc(String nom);
    List<Client> findByNomStartsWithChar(String nom);
    List<Client> findByPrenomEndsWith(String prenpm);
    List<Client> findByDateNaissanceIsNull(Date DateNaissance);
    List<Client> findByAddressIsNotNull();
    List<Client> findByVilleIn(String villes);
    List<Client> findByPtsAccumulesGreaterThan(int value);
    List<Client> findByPtsAccumulesGreaterThanEqual(int value);
    List<Client> findByPtsAccumulesBetween(int min, int max);
    List<Client> findByCommandeArticleNom(String articleNom);
    List<Client> findByNomContainsAndCommandeArticleType(String nom, String type);


}
