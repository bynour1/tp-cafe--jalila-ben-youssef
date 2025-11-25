package com.example.tp_cafe_jalila_ben_youssef.repositories;

import com.example.tp_cafe_jalila_ben_youssef.Entite.Client;
import com.example.tp_cafe_jalila_ben_youssef.enums.TypeArticle;
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
/*
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

*/

    List<Client> findByNom(String nom);

    List<Client> findByPrenom(String prenom);

    Client findByNomAndPrenom(String nom, String prenom);

    boolean existsByNom(String nom);

    long countByDateNaissanceAfter(LocalDate date);

    List<Client> findByNomContainingOrPrenomContaining(String nom, String prenom);

    List<Client> findByNomContainingAndPrenomContaining(String nom, String prenom);

    List<Client> findByDateNaissanceBetween(LocalDate dateDebut, LocalDate dateFin);

    List<Client> findByNomStartingWithAndDateNaissanceBefore(String prefixe, LocalDate date);

    List<Client> findByAdressVille(String ville);

    List<Client> findByNomContainingOrderByPrenomAsc(String nom);

    List<Client> findByNomContainingOrderByPrenomDesc(String nom);

    List<Client> findByNomStartingWith(String lettre);

    List<Client> findByPrenomEndingWith(String terminaison);

    List<Client> findByDateNaissanceIsNull();

    List<Client> findByAdressIsNotNull();

    List<Client> findByAdressVilleIn(List<String> villes);

    List<Client> findByCartefidelitePointsAccumulésGreaterThan(int points);

    List<Client> findByCartefidelitePointsAccumulésGreaterThanEqual(int points);

    List<Client> findByCartefidelitePointsAccumulésBetween(int pointsMin, int pointsMax);

    List<Client> findByCommandes_DetailCommandes_Article_NomArticle(String nomArticle);

    List<Client> findByNomContainingAndCommandesDetailCommandesArticleTypeArticle( String nom, TypeArticle typeArticle);

}
