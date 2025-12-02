package com.example.tp_cafe_jalila_ben_youssef.repositories;

import com.example.tp_cafe_jalila_ben_youssef.Entite.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdresseRepo extends JpaRepository<Adresse, Long> {


        List<Adresse> findByVilleAndCodePostal(String ville, int codePostal);
        List<Adresse> findByRueContainingAndVilleIgnoreCase(String rue, String ville);

        List<Adresse> findByVilleIn(List<String> villes);

        List<Adresse> findByCodePostalBetween(int CodePostal, int CodePostal2);

        List<Adresse> findByCodePostalGreaterThan(int CodePostal);
        List<Adresse> findByCodePostalGreaterThanEqual(int CodePostal);

        List<Adresse> findByCodePostalLessThan(int CodePostal);
        List<Adresse> findByCodePostalLessThanEqual(int CodePostal);

        List<Adresse> findByRueStartingWithAndVilleOrderByCodePostalAsc(String rue, String ville);

        List<Adresse> findByRueStartingWith(String rue);

        List<Adresse> findByVilleEndingWith(String terminaison);

        List<Adresse> findByRueIsNull();

        List<Adresse> findByVilleIsNotNull();


}
