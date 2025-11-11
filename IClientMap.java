package com.example.tp_cafe_jalila_ben_youssef.mappers;

import com.example.tp_cafe_jalila_ben_youssef.DTO.ClientResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IClientMap {
    Client toEntity (Client ClientRequest);
    ClientResponse toDto (Client Client);


}
