package com.example.tp_cafe_jalila_ben_youssef.repositories;

import com.example.tp_cafe_jalila_ben_youssef.Entite.CarteFidelite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarteFideliteRepo extends JpaRepository<CarteFidelite, Long> {

        @Query("select c from CarteFidelite c where c.pointsAccumulés = ?1")
        List<CarteFidelite> findByExactPoints(int pts);

        @Query("select c from CarteFidelite c where c.dateCreation = ?1")
        List<CarteFidelite> findByDate(LocalDate d);

        @Query("select count(c) from CarteFidelite c where c.pointsAccumulés > ?1")
        long countByPointsGreater(int pts);

        @Modifying
        @Query("delete from CarteFidelite c where c.dateCreation < ?1")
        void deleteBefore(LocalDate d);

        @Query("select c from CarteFidelite c where c.pointsAccumulés between ?1 and ?2 and c.dateCreation > ?3")
        List<CarteFidelite> findInRangeAfterDate(int min, int max, LocalDate date);

        @Query("select c from CarteFidelite c where c.pointsAccumulés >= ?1 order by c.dateCreation")
        List<CarteFidelite> findMinPointsSorted(int pts);

        @Query("select c from CarteFidelite c where c.dateCreation between ?1 and ?2")
        List<CarteFidelite> findBetweenDates(LocalDate d1, LocalDate d2);

        @Query("select c from CarteFidelite c where c.pointsAccumulés < ?1 or c.dateCreation < ?2")
        List<CarteFidelite> findFewPointsOrOld(int pts, LocalDate d);

        @Query("select c from CarteFidelite c order by c.pointsAccumulés desc")
        List<CarteFidelite> findAllSorted(Pageable pageable);

        @Query("select c from CarteFidelite c where c.dateCreation is null")
        List<CarteFidelite> findNoDate();

        @Query("select c from CarteFidelite c where c.pointsAccumulés is not null")
        List<CarteFidelite> findPointsNotNull();

        @Query("select c from CarteFidelite c where c.client.nom = ?1 and c.client.prenom = ?2")
        List<CarteFidelite> findByClient(String nom, String prenom);
    }

