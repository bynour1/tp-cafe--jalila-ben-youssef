package com.example.tp_cafe_jalila_ben_youssef.Entite;

import com.example.tp_cafe_jalila_ben_youssef.enums.TypeArticle;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity(name = "Article")
public class Article{


    @Id
    private long idArticle;
    private String nomArticle;
    private float prixArticle;
    private TypeArticle typeArticle;
    @OneToMany (mappedBy = "article")
    private List<DetailCommande> detailCommande;
    @ManyToMany
    @JoinTable(
            name = "Promotion_Article", joinColumns = @JoinColumn(name = "idArticle"),
            inverseJoinColumns = @JoinColumn(name = "idPromotion")
    )
    private List<Promotion> promotions;
}