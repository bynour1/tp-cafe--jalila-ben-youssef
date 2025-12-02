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
    //@Qualifier("IAdresseMap")
    private IAdresseMap mapper;

    @Override
    public AdresseResponse addAdresse(Adresse adresse) {
        // Save the adresse directly, no need to convert it to itself
        Adresse savedAdresse = adresseRepo.save(adresse);

        // Convert the saved adresse to a response DTO
        AdresseResponse adresseResponse = mapper.toDto(savedAdresse);
        return adresseResponse;
    }

    @Override
    public List<Adresse> saveAdresse(List<Adresse> adresses) {
       List<Adresse> newadresses = adresseRepo.saveAll(adresses);
        return newadresses;
    }

    @Override
    public Adresse selectAdresseByIdWithGet(long id) {
        return adresseRepo.findById(id).get();
    }

    @Override
    public Adresse selectAdresseByIdWithOrElse(long id) {
        Adresse Adressetest=
                Adresse.builder().idAdresse(0L).rue("nour").ville("nour").build();
        Adresse Adresse = adresseRepo.findById(id).orElse(Adressetest);
        return Adresse;
    }

    @Override
    public List<Adresse> selectAllAdresse() {
        List<Adresse> newadresse = adresseRepo.findAll();
        return newadresse;
    }

    @Override
    public void deleteAdresse(Adresse adresse) {
        adresseRepo.delete(adresse);
    }

    @Override
    public void deleteAllAdresse() {
        adresseRepo.deleteAll();
    }

    @Override
    public void deleteAdresseById(long id) {
        adresseRepo.deleteById(id);
    }

    @Override
    public long countingAdresse() {
        return adresseRepo.count();
    }

    @Override
    public boolean verifAdresseById(long id) {
        return adresseRepo.existsById(id);
    }

    @Override
    public boolean verifAdressById(long id) {
        // Call the correctly named method to avoid duplication
        return verifAdresseById(id);
    }

    @Override
    public long countingAdress() {
        // Call the correctly named method to avoid duplication
        return countingAdresse();
    }

    @Override
    public void deleteAdressById(long id) {
        // Call the correctly named method to avoid duplication
        deleteAdresseById(id);
    }


}
