package com.example.tp_cafe_jalila_ben_youssef.SERVICES;

import com.example.tp_cafe_jalila_ben_youssef.DTO.ClientResponse;
import com.example.tp_cafe_jalila_ben_youssef.DTO.CommandeResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Client;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Commande;
import com.example.tp_cafe_jalila_ben_youssef.mappers.ICommandeMap;
import com.example.tp_cafe_jalila_ben_youssef.repositories.CommandeRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommandeServ implements ICommandeServ {

    private CommandeRepo commandeRepo;

    @Qualifier("ICommandeMap")
    private ICommandeMap mapper;

    @Override
    public CommandeResponse addCommande(Commande commande) {
        Commande newCommande = mapper.toEntity(commande);
        commandeRepo.save(newCommande);

        CommandeResponse cl = mapper.toDto(newCommande);
        return cl;
    }

    @Override
    public ClientResponse addClient(Client client) {
        return null;
    }

    @Override
    public Commande addAdresse(Commande commande) {
        return null;
    }

    @Override
    public List<Commande> saveCommande(List<Commande> commandes) {
        return List.of();
    }

    @Override
    public Commande selectCommandeByIdWithGet(long id) {
        return null;
    }

    @Override
    public Commande selectCommandeByIdWithOrElse(long id) {
        return null;
    }

    @Override
    public List<Commande> selectAllCommande() {
        return List.of();
    }

    @Override
    public void deleteCommande(Commande commande) {
    }

    @Override
    public void deleteAllCommande() {
    }

    @Override
    public boolean deleteCommandeById(long id) {
        return false;
    }

    @Override
    public long countingCommande() {
        return 0;
    }

    @Override
    public boolean verifClientById(long id) {
        return false;
    }

    @Override
    public boolean verifCommandeById(long id) {
        return false;
    }

    @Override
    public void deleteAllCommandes() {
    }

    @Override
    public List<Commande> findCommandeByClient(long idClient) {
        return List.of();
    }
}
