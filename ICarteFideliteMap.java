package com.example.tp_cafe_jalila_ben_youssef.mappers;


import com.example.tp_cafe_jalila_ben_youssef.DTO.CarteFideliteResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.CarteFidelite;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICarteFideliteMap {

    CarteFidelite toEntity (CarteFidelite CarteFidelitetRequest);
    CarteFideliteResponse toDto (CarteFidelite CarteFidelitet);
}
