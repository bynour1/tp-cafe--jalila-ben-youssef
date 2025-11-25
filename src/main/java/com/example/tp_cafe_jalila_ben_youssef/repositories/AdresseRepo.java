package com.example.tp_cafe_jalila_ben_youssef.repositories;

import com.example.tp_cafe_jalila_ben_youssef.Entite.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdresseRepo extends JpaRepository<Adresse, Long> {


        List<Adresse> findByVilleAndCodePostale(String ville, String codePostale);
        List<Adresse> findByRueContainingAndVilleIgnoreCase(String rue, String ville);

        List<Adresse> findByVilleIn(List<String> villes);

        List<Adresse> findByCodePostaleBetween(String codePostaleDebut, String codePostaleFin);

        List<Adresse> findByCodePostaleGreaterThan(String codePostale);
        List<Adresse> findByCodePostaleGreaterThanEqual(String codePostale);

        List<Adresse> findByCodePostaleLessThan(String codePostale);
        List<Adresse> findByCodePostaleLessThanEqual(String codePostale);

        List<Adresse> findByRueStartingWithAndVilleOrderByCodePostaleAsc(String rue, String ville);

        List<Adresse> findByRueStartingWith(String rue);

        List<Adresse> findByVilleEndingWith(String terminaison);

        List<Adresse> findByRueIsNull();

        List<Adresse> findByVilleIsNotNull();


}
