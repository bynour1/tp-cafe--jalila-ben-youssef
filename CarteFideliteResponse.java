package com.example.tp_cafe_jalila_ben_youssef.DTO;

import com.example.tp_cafe_jalila_ben_youssef.Entite.Client;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarteFideliteResponse {
    private Long idCarteFidelite;
    private int pointsAccumulés;
    private LocalDate dateCreation;
    private Client client;
}
