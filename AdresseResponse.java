package com.example.tp_cafe_jalila_ben_youssef.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdresseResponse {
    private Long idAdresse;
    private String rue;
    private String ville;
    private int codePostal;

}
