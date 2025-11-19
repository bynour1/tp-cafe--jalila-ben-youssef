package com.example.tp_cafe_jalila_ben_youssef.mappers;

import com.example.tp_cafe_jalila_ben_youssef.DTO.AdresseResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Adresse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAdresseMap {
Adresse toEntity (Adresse adresseRequest);
   // Adresse toEntity2 (AdresseResponse adresseResponse);

AdresseResponse toDto (Adresse adresse);

//http://localhost:8088/swagger-ui/index.html#/
}
