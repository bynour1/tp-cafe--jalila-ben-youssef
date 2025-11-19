package com.example.tp_cafe_jalila_ben_youssef.mappers;

import com.example.tp_cafe_jalila_ben_youssef.DTO.DetailCommandeResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.DetailCommande;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IDetailCommandeMap {

        DetailCommande toEntity (DetailCommande DetailCommandeMapRequest);
        DetailCommandeResponse toDto (DetailCommande DetailCommandeMap);
}
