package com.example.tp_cafe_jalila_ben_youssef.repositories;

import com.example.tp_cafe_jalila_ben_youssef.Entite.Commande;
import com.example.tp_cafe_jalila_ben_youssef.enums.StatusCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommandeRepo extends JpaRepository<Commande, Long> {

        @Query(value = "select * from commande where status_commande = ?1", nativeQuery = true)
        List<Commande> findByStatus(String status);

        @Query(value = "select * from commande where date_commande = ?1", nativeQuery = true)
        List<Commande> findByExactDate(LocalDate d);

        @Query(value = "select count(*) from commande where status_commande = ?1", nativeQuery = true)
        long countByStatus(String status);

        @Modifying
        @Query(value = "delete from commande where date_commande < ?1", nativeQuery = true)
        void deleteBefore(LocalDate d);

        @Query(value = "select * from commande where date_commande between ?1 and ?2 and status_commande = ?3", nativeQuery = true)
        List<Commande> betweenDatesAndStatus(LocalDate d1, LocalDate d2, String status);

        @Query(value = "select * from commande where total_commande > ?1 and status_commande <> ?2", nativeQuery = true)
        List<Commande> findTotalGreaterAndStatusNot(float total, String status);

        @Query(value = "select * from commande where status_commande in ?1 order by date_commande", nativeQuery = true)
        List<Commande> findByStatusInSorted(List<String> statuses);

        @Query(value = "select * from commande where date_commande < ?1 and total_commande between ?2 and ?3", nativeQuery = true)
        List<Commande> beforeDateAndTotalRange(LocalDate d, float min, float max);

        @Query(value = "select * from commande where status_commande like %?1", nativeQuery = true)
        List<Commande> statusEndsWith(String letter);

        @Query(value = "select * from commande where status_commande is null", nativeQuery = true)
        List<Commande> findWithoutStatus();

        @Query(value = "select * from commande where total_commande is not null", nativeQuery = true)
        List<Commande> findWithTotal();

        @Query(value = "select c.*, d.*, cl.* from commande c " +
                "join detail_commande d on c.id_commande = d.id_commande " +
                "join client cl on c.id_client = cl.id_client",
                nativeQuery = true)
        List<Object[]> findWithDetailsAndClient();

        @Query(value = "select * from commande order by date_commande desc limit 3", nativeQuery = true)
        List<Commande> top3();


    List<Commande> findByClientIdClient(Long idClient);
    List<Commande> findByStatusCommande(StatusCommande status);
}
