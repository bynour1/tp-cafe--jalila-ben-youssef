package com.example.tp_cafe_jalila_ben_youssef.SERVICES;

import com.example.tp_cafe_jalila_ben_youssef.DTO.DetailCommandeResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Client;
import com.example.tp_cafe_jalila_ben_youssef.Entite.DetailCommande;

import java.util.List;

public interface IDetailCommandeServ {
    DetailCommandeResponse addDetailCommande(DetailCommande DetailCommande);

    Client addAdresse(Client Client);

    List<DetailCommande> saveDetailCommande(List<DetailCommande> DetailCommande);

    DetailCommande selectDetailCommandeByIdWithGet(long id);

    DetailCommande selectDetailCommandeByIdWithOrElse(long id);

    List<DetailCommande> selectAllDetailCommande();

    void deleteDetailCommande(DetailCommande DetailCommande);

    void deleteAllDetailCommande();

    boolean deleteDetailCommandeById(long id);

    long countingDetailCommande();

    boolean verifClientById(long id);

    boolean verifDetailCommandeById(long id);

    boolean verifDetail_CommandeById(long id);

    DetailCommande addDetail_Commande(DetailCommande detailCommande);

    List<DetailCommande> saveDetailsCommande(List<DetailCommande> detailCommandes);

    long countingDetailsCommande();

    void deleteAllDetailsCommande();

    List<DetailCommande> selectAllDetailsCommande();
}
