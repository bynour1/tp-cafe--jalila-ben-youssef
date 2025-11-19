package com.example.tp_cafe_jalila_ben_youssef.SERVICES;

import com.example.tp_cafe_jalila_ben_youssef.DTO.ClientResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Client;
import com.example.tp_cafe_jalila_ben_youssef.mappers.IClientMap;
import com.example.tp_cafe_jalila_ben_youssef.repositories.ClientRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ClientServ implements IClientServ{
    private ClientRepo ClientRepo;
    @Qualifier( "IClientMap")
    private IClientMap mapper;

    @Override
    public ClientResponse addClient(Client Client) {
        Client newClient =  mapper.toEntity(Client);
        ClientRepo.save(newClient);

        ClientResponse Cl =mapper.toDto(newClient);
        return Cl;
    }

    @Override
    public Client addAdresse(Client Client) {
        return null;
    }

    @Override
    public Client Client(Client Client) {
        return null;
    }

    @Override
    public Client addClien(Client Clien) {
        return null;
    }

    @Override
    public Client Clien(Client Clien) {
        return null;
    }



    @Override
    public List<Client> saveClient(List<Client> Client) {
        return List.of();
    }

    @Override
    public Client selectClientleByIdWithGet(long id) {
        return null;
    }

    @Override
    public Client selectClientByIdWithGet(long id) {
        return null;
    }

    @Override
    public Client selectClientByIdWithOrElse(long id) {
        return null;
    }

    @Override
    public List<Client> selectAllClient() {
        return List.of();
    }

    @Override
    public void deleteClient(Client Client) {

    }

    @Override
    public void deleteAllClient() {

    }

    @Override
    public void deleteClienteById(long id) {

    }

    @Override
    public void deleteClientById(long id) {

    }

    @Override
    public long countingClient() {
        return 0;
    }

    @Override
    public boolean verifClientById(long id) {
        return false;
    }

    @Override
    public List<Client> selectAllClients() {
        return List.of();
    }

    @Override
    public List<Client> findClientsByNom(long nom) {
        return List.of();
    }

    @Override
    public IClientServ get() {
        return null;
    }

    @Override
    public List<Client> getAllClients() {
        return List.of();
    }

    @Override
    public Client getClientByCarteFidelite(long idCarteFidelite) {
        return null;
    }

    @Override
    public ClientResponse updateClient(long id, Client clientDetails) {
        return null;
    }

    @Override
    public Client getClientById(long id) {
        return null;
    }
}
