package com.example.tp_cafe_jalila_ben_youssef.repositories;

import com.example.tp_cafe_jalila_ben_youssef.Entite.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdresseRepo extends JpaRepository<Adresse, Long> {

    List<Adresse> findByVilleEquals(String ville);
    List<Adresse> findByCodePostalEquals(String codePostal);
    long countByVille(String ville);
    void deleteByVille(String ville);
    List<Adresse> findByVilleAndCodePostal(String ville, String codePostal);
    List<Adresse> findByRueContainingIgnoreCaseAndVilleIgnoreCase(String rue, String ville);
    List<Adresse> findByVilleIn(List<String> villes);
    List<Adresse> findByCodePostalBetween(String min, String max);
    List<Adresse> findByCodePostalGreaterThan(String codePostal);
    List<Adresse> findByCodePostalGreaterThanOrEqualTo(String codePostal);
    List<Adresse> findByCodePostalLessThan(String codePostal);
    List<Adresse> findByCodePostalLessThanOrEqualTo(String codePostal);
    List<Adresse> findByRueStartingWithAndVilleOrderByCodePostalAsc(String rue, String ville);
    List<Adresse> findByRueStartingWith(String rue);
    List<Adresse> findByVilleEndingWith(String suffix);
    List<Adresse> findByRueIsNull();
    List<Adresse> findByVilleIsNotNull();



}
