package com.example.tp_cafe_jalila_ben_youssef.DTO;

import com.example.tp_cafe_jalila_ben_youssef.Entite.Adresse;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientResponse {
    private Long idClient;
    private  String nom;
    private  String prenom;
    private LocalDate dateNaissance;
    private Adresse adress;

}
