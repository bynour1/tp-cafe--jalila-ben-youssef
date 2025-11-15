package com.example.tp_cafe_jalila_ben_youssef.SERVICES;

import com.example.tp_cafe_jalila_ben_youssef.DTO.AdresseResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Adresse;

import java.util.List;

public interface IAdresseServ {
    AdresseResponse addAdresse(Adresse adresse);

    List<Adresse> saveAdresse(List<Adresse> adresses);

    Adresse selectAdresseByIdWithGet(long id);

    Adresse selectAdresseByIdWithOrElse(long id);

    List<Adresse> selectAllAdresse();

    void deleteAdresse(Adresse adresse);

    void deleteAllAdresse();

    void deleteAdresseById(long id);

    long countingAdresse();

    boolean verifAdresseById(long id);

    boolean verifAdressById(long id);

    long countingAdress();

    void deleteAdressById(long id);
}
