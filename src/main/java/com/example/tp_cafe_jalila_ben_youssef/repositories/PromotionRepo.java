package com.example.tp_cafe_jalila_ben_youssef.repositories;

import com.example.tp_cafe_jalila_ben_youssef.Entite.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PromotionRepo extends JpaRepository<Promotion, Long> {

        @Query(value = "select * from promotion where pourcentage_promo = ?1", nativeQuery = true)
        List<Promotion> findByPourcentage(float p);

        @Query(value = "select * from promotion where date_debut_promo = ?1", nativeQuery = true)
        List<Promotion> findByDateDebut(LocalDate d);

        @Query(value = "select * from promotion where date_fin_promo = ?1", nativeQuery = true)
        List<Promotion> findByDateFin(LocalDate d);

        @Query(value = "select count(*) from promotion where pourcentage_promo = ?1", nativeQuery = true)
        long existsByPourcentage(float p);

        @Query(value = "select count(*) from promotion where date_debut_promo > ?1", nativeQuery = true)
        long countDebutAfter(LocalDate d);

        @Query(value = "select * from promotion where date_debut_promo <= ?1 and date_fin_promo >= ?1", nativeQuery = true)
        List<Promotion> findActiveAt(LocalDate d);

        @Query(value = "select * from promotion where pourcentage_promo = ?1 and date_debut_promo between ?2 and ?3", nativeQuery = true)
        List<Promotion> findByPercentAndDebutRange(float p, LocalDate d1, LocalDate d2);

        @Query(value = "select * from promotion where date_debut_promo <= ?1 and date_fin_promo >= ?1", nativeQuery = true)
        List<Promotion> findValidOn(LocalDate d);

        @Query(value = "select * from promotion where pourcentage_promo in ?1 order by date_debut_promo", nativeQuery = true)
        List<Promotion> findByPourcentagesSorted(List<Float> pourcentages);

        @Query(value = "select * from promotion where date_debut_promo <= CURRENT_DATE and date_fin_promo >= CURRENT_DATE order by pourcentage_promo",
                nativeQuery = true)
        List<Promotion> findActivesSorted();

        @Query(value = "select * from promotion where date_fin_promo is null", nativeQuery = true)
        List<Promotion> findWithoutEndDate();

        @Query(value = "select * from promotion where pourcentage_promo is not null", nativeQuery = true)
        List<Promotion> findWithPourcentage();

        @Query(value = "select p.*, a.* from promotion p join article a on p.id_promotion = a.id_promotion", nativeQuery = true)
        List<Object[]> findWithArticles();

        @Query(value = "select * from promotion where date_fin_promo < CURRENT_DATE", nativeQuery = true)
        List<Promotion> findExpired();
    }


