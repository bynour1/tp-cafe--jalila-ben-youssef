package com.example.tp_cafe_jalila_ben_youssef.repositories;

import com.example.tp_cafe_jalila_ben_youssef.Entite.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdresseRepo extends JpaRepository<Adresse, Long> {

    List<Adresse> findByVilleEquals(String ville);
    List<Adresse> findByCodePostalEquals(int codePostal);

    void deleteByVille(String ville);
    List<Adresse> findByVilleAndCodePostal(String ville, int codePostal);
    List<Adresse> findByRueContainingIgnoreCaseAndVilleIgnoreCase(String rue, String ville);
    List<Adresse> findByVilleIn(List<String> villes);
    List<Adresse> findByCodePostalBetween(int codePostal, int codePostal2);
    List<Adresse> findByCodePostalGreaterThan(int codePostal);

    List<Adresse> findByCodePostalLessThan(int codePostal);

    List<Adresse> findByRueStartingWithAndVilleOrderByCodePostalAsc(String rue, String ville);
    List<Adresse> findByRueStartingWith(String rue);
    List<Adresse> findByVilleEndingWith(String suffix);
    List<Adresse> findByRueIsNull();
    List<Adresse> findByVilleIsNotNull();



}
