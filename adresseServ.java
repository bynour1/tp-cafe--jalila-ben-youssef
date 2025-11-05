package com.example.tp_cafe_jalila_ben_youssef.SERVICES;

import com.example.tp_cafe_jalila_ben_youssef.DTO.AdresseResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Adresse;
import com.example.tp_cafe_jalila_ben_youssef.mappers.IAdresseMap;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.tp_cafe_jalila_ben_youssef.repositories.AdresseRepo;

import java.util.List;


@Service
@AllArgsConstructor
public class adresseServ implements IAdresseServ {
    private AdresseRepo adresseRepo;
    private IAdresseMap mapper;

    @Override
    public AdresseResponse addAdresse(Adresse adresse) {
        Adresse newadresse =  mapper.toEntity(adresse);
        adresseRepo.save(newadresse);

       AdresseResponse ad =mapper.toDto(newadresse);
        return ad;
    }

    @Override
    public List<Adresse> saveAdresse(List<Adresse> adresses) {
       List<Adresse> newadresses = adresseRepo.saveAll(adresses);
        return null;
    }

    @Override
    public Adresse selectAdresseByIdWithGet(long id) {
        adresseRepo.findById(id).get();
        return null;
    }

    @Override
    public Adresse selectAdresseByIdWithOrElse(long id) {
        Adresse Adressetest=
                Adresse.builder().idAdresse(0L).rue("nour").ville("nour").build();
        Adresse Adresse =adresseRepo.findById(id).orElse(Adressetest);
        return Adresse;
    }

    @Override
    public List<Adresse> selectAllAdresse() {
        List<Adresse> newadresse = adresseRepo.findAll();
        return List.of();
    }

    @Override
    public void deleteAdresse(Adresse adresse) {


    }

    @Override
    public void deleteAllAdresse() {

    }

    @Override
    public void deleteAdresseById(long id) {

    }

    @Override
    public long countingAdresse() {
        return 0;
    }

    @Override
    public boolean verifAdresseById(long id) {
        return false;
    }



}