package com.example.tp_cafe_jalila_ben_youssef.Entite;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@Entity
@Table(name = "DetailCommande")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DetailCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetailCommande")
    private Long idDetailCommande;

    @Column(name = "quantiteArticle")
    private int quantiteArticle;

    @Column(name = "sousTotalDetailArticle")
    private float sousTotalDetailArticle;

    @Column(name = "sousTotalDetailArticleApresPromo")
    private float sousTotalDetailArticleApresPromo;


    @ManyToOne
    @JoinColumn(name = "Commande")
    private  Commande commande;


    @ManyToOne
    private Article article;
}