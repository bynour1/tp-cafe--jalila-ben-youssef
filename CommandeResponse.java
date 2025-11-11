package com.example.tp_cafe_jalila_ben_youssef.DTO;

import com.example.tp_cafe_jalila_ben_youssef.Entite.Client;
import com.example.tp_cafe_jalila_ben_youssef.Entite.DetailCommande;
import com.example.tp_cafe_jalila_ben_youssef.enums.StatusCommande;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommandeResponse {
    private Long idCommande;
    private LocalDate dateCommande;


    private float totalCommande;
    private StatusCommande statusCommande;


    private Client client;



    List<DetailCommande> detail_Commandes;
}
