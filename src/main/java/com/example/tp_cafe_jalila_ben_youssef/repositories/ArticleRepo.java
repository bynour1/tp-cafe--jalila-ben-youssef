package com.example.tp_cafe_jalila_ben_youssef.repositories;

import com.example.tp_cafe_jalila_ben_youssef.Entite.Article;
import com.example.tp_cafe_jalila_ben_youssef.enums.TypeArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ArticleRepo extends JpaRepository<Article, Long> {
    @Query("SELECT a FROM Article a WHERE a.typeArticle = :type")
    List<Article> findByTypeArticle(@Param("type") TypeArticle type);

        @Query("select a from Article a where a.nomArticle = ?1")
        List<Article> findByNomExact(String nom);

        @Query("select a from Article a where a.typeArticle = ?1")
        List<Article> findByType(TypeArticle type);

        @Query("select a from Article a where a.prixArticle = ?1")
        List<Article> findByPrixExact(float prix);

        @Query("select count(a) from Article a where a.nomArticle = ?1")
        long existsByNom(String nom);

        @Query("select count(a) from Article a where a.typeArticle = ?1")
        long countByType(TypeArticle type);

        @Query("select a from Article a where a.nomArticle like %?1% and a.typeArticle = ?2")
        List<Article> findByNomContainsAndType(String mot, TypeArticle type);

        @Query("select a from Article a where a.prixArticle between ?1 and ?2 and a.typeArticle in ?3")
        List<Article> findByPrixRangeAndTypes(float min, float max, List<TypeArticle> types);

    @Query("select a from Article a where lower(a.nomArticle) like lower(concat(?1, '%')) order by a.prixArticle")
        List<Article> findByNomStartsIgnoreCaseSorted(String prefix);

        @Query("select a from Article a where a.typeArticle = ?1 and a.prixArticle = (" +
                "select max(a2.prixArticle) from Article a2 where a2.typeArticle = ?1)")
        List<Article> findMaxPrixByType(TypeArticle type);

        @Query("select a from Article a where a.nomArticle = ?1 or a.typeArticle = ?2 order by a.prixArticle desc")
        List<Article> findByNomOrTypeSorted(String nom, TypeArticle type);

        @Query("select a from Article a where a.nomArticle like ?1%")
        List<Article> startsWith(String prefix);

        @Query("select a from Article a where a.nomArticle like %?1")
        List<Article> endsWith(String suffix);

        @Query("select a from Article a where a.typeArticle is null")
        List<Article> findWithoutType();

        @Query("select a from Article a where a.prixArticle is not null")
        List<Article> findWithPrice();

        @Query("select a from Article a join a.promotions p where p.dateDebutPromo <= ?1 and p.dateFinPromo >= ?1")
        List<Article> findWithActivePromos(LocalDate d);

        @Query("select a from Article a where a.nomArticle like %?1% and a.prixArticle between ?2 and ?3")
        List<Article> findNomContainsAndPrixRange(String mot, float min, float max);


}
