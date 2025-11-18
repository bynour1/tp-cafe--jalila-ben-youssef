package com.example.tp_cafe_jalila_ben_youssef.repositories;

import com.example.tp_cafe_jalila_ben_youssef.Entite.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {
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
