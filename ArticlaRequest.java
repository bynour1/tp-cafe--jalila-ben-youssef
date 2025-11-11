package com.example.tp_cafe_jalila_ben_youssef.DTO;

import com.example.tp_cafe_jalila_ben_youssef.Entite.DetailCommande;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Promotion;
import com.example.tp_cafe_jalila_ben_youssef.enums.TypeArticle;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticlaRequest {

    private String nomArticle;
    private float prixArticle;
    private TypeArticle typeArticle;
    private List<DetailCommande> detailCommande;
    private List<Promotion> promotions;
}
