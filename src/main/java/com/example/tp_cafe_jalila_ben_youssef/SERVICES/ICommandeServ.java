package com.example.tp_cafe_jalila_ben_youssef.SERVICES;

import com.example.tp_cafe_jalila_ben_youssef.DTO.ClientResponse;
import com.example.tp_cafe_jalila_ben_youssef.DTO.CommandeResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Client;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Commande;

import java.util.List;

public interface ICommandeServ {
    CommandeResponse addCommande(Commande Commande);

    ClientResponse addClient(Client Client);

    Commande addAdresse(Commande Commande);

    List<Commande> saveCommande(List<Commande> Commandes);

    Commande selectCommandeByIdWithGet(long id);

    Commande selectCommandeByIdWithOrElse(long id);

    List<Commande> selectAllCommande();

    void deleteCommande(Commande Commande);

    void deleteAllCommande();

    boolean deleteCommandeById(long id);

    long countingCommande();

    boolean verifClientById(long id);

    boolean verifCommandeById(long id);

    void deleteAllCommandes();

    List<Commande> findCommandeByClient(long idClient);
}
