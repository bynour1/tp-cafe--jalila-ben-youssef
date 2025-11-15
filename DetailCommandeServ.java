package com.example.tp_cafe_jalila_ben_youssef.SERVICES;

import com.example.tp_cafe_jalila_ben_youssef.DTO.DetailCommandeResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Client;
import com.example.tp_cafe_jalila_ben_youssef.Entite.DetailCommande;

import com.example.tp_cafe_jalila_ben_youssef.mappers.IDetailCommandeMap;
import com.example.tp_cafe_jalila_ben_youssef.repositories.DetailCommandeRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class DetailCommandeServ implements IDetailCommandeServ{
    private DetailCommandeRepo DetailCommandeRepo;
    @Qualifier( "IDetailCommandeMap")
    private IDetailCommandeMap mapper;

    @Override
    public DetailCommandeResponse addDetailCommande(DetailCommande DetailCommande) {
        DetailCommande newDetailCommande =  mapper.toEntity(DetailCommande);
        DetailCommandeRepo.save(newDetailCommande);

        DetailCommandeResponse Cl =mapper.toDto(newDetailCommande);
        return Cl;
    }

    @Override
    public Client addAdresse(Client Client) {
        return null;
    }

    @Override
    public List<DetailCommande> saveDetailCommande(List<DetailCommande> DetailCommande) {
        return List.of();
    }

    @Override
    public DetailCommande selectDetailCommandeByIdWithGet(long id) {
        return null;
    }

    @Override
    public DetailCommande selectDetailCommandeByIdWithOrElse(long id) {
        return null;
    }

    @Override
    public List<DetailCommande> selectAllDetailCommande() {
        return List.of();
    }

    @Override
    public void deleteDetailCommande(DetailCommande DetailCommande) {

    }

    @Override
    public void deleteAllDetailCommande() {

    }

    @Override
    public boolean deleteDetailCommandeById(long id) {

        return false;
    }

    @Override
    public long countingDetailCommande() {
        return 0;
    }

    @Override
    public boolean verifClientById(long id) {
        return false;
    }

    @Override
    public boolean verifDetailCommandeById(long id) {
        return false;
    }

    @Override
    public boolean verifDetail_CommandeById(long id) {
        return false;
    }

    @Override
    public DetailCommande addDetail_Commande(DetailCommande detailCommande) {
        return null;
    }

    @Override
    public List<DetailCommande> saveDetailsCommande(List<DetailCommande> detailCommandes) {
        return List.of();
    }

    @Override
    public long countingDetailsCommande() {
        return 0;
    }

    @Override
    public void deleteAllDetailsCommande() {

    }

    @Override
    public List<DetailCommande> selectAllDetailsCommande() {
        return List.of();
    }
}
