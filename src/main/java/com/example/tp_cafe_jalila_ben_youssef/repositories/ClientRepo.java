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


        List<Client> findByNom(String nom);
        List<Client> findByPrenom(String prenom);

        Client findByNomAndPrenom(String nom, String prenom);

        boolean existsByNom(String nom);

        long countByDateNaissanceAfter(LocalDate date);

        List<Client> findByNomContainingOrPrenomContaining(String nom, String prenom);

        List<Client> findByNomContainingAndPrenomContaining(String nom, String prenom);

        List<Client> findByDateNaissanceBetween(LocalDate dateDebut, LocalDate dateFin);

        List<Client> findByNomStartingWithAndDateNaissanceBefore(String prefixe, LocalDate date);

        List<Client> findByAdressVille(String ville); // changer Adress si besoin

        List<Client> findByNomContainingOrderByPrenomAsc(String nom);

        List<Client> findByNomContainingOrderByPrenomDesc(String nom);

        List<Client> findByNomStartingWith(String lettre);

        List<Client> findByPrenomEndingWith(String terminaison);

        List<Client> findByDateNaissanceIsNull();

        List<Client> findByAdressIsNotNull(); // changer Adress si besoin

        List<Client> findByAdressVilleIn(List<String> villes); // changer Adress si besoin

        List<Client> findByCarteFidelite_PointsAccumulesGreaterThan(int points);

        List<Client> findByCarteFidelite_PointsAccumulesGreaterThanEqual(int points);

        List<Client> findByCarteFidelite_PointsAccumulesBetween(int pointsMin, int pointsMax);

        List<Client> findByCommandes_DetailCommandes_Article_NomArticle(String nomArticle);

        List<Client> findByNomContainingAndCommandesDetailCommandesArticleTypeArticle(String nom, TypeArticle typeArticle);
    }
