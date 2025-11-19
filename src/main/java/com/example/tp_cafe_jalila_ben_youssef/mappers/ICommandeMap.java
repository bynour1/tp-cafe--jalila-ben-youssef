package com.example.tp_cafe_jalila_ben_youssef.mappers;

import com.example.tp_cafe_jalila_ben_youssef.DTO.CommandeResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Commande;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICommandeMap {
    Commande toEntity (Commande CommandeRequest);
    CommandeResponse toDto (Commande Commande);
}
