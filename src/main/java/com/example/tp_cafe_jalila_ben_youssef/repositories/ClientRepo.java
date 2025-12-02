package com.example.tp_cafe_jalila_ben_youssef.repositories;

import com.example.tp_cafe_jalila_ben_youssef.Entite.Client;
import com.example.tp_cafe_jalila_ben_youssef.enums.TypeArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {


        List<Client> findByNom(String nom);

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

        List<Client> findByAdressIsNotNull();

        List<Client> findByAdressVilleIn(List<String> villes);

        List<Client> findByCartefidelitePointsAccumulésGreaterThan(int points);

        List<Client> findByCommandesDetail_CommandesArticleNomArticle(String nomArticle);

        List<Client> findByNomContainingAndCommandesDetail_CommandesArticleTypeArticle(String nom, TypeArticle typeArticle);
    }
