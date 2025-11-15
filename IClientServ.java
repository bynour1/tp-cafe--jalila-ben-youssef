package com.example.tp_cafe_jalila_ben_youssef.SERVICES;

import com.example.tp_cafe_jalila_ben_youssef.DTO.ClientResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Client;

import java.util.List;

public interface IClientServ {
    Client addAdresse(Client Client);

    Client Client(Client Client);

    Client addClien(Client Clien);

    Client Clien(Client Clien);

    ClientResponse addClient(Client Client);

    List<Client> saveClient(List<Client> Client);

    Client selectClientleByIdWithGet(long id);

    Client selectClientByIdWithGet(long id);

    Client selectClientByIdWithOrElse(long id);

    List<Client> selectAllClient();

    void deleteClient(Client Client);

    void deleteAllClient();

    void deleteClienteById(long id);

    void deleteClientById(long id);

    long countingClient();

    boolean verifClientById(long id);

    List<Client> selectAllClients();

    List<Client> findClientsByNom(long nom);

    IClientServ get();

    List<Client> getAllClients();

    Client getClientByCarteFidelite(long idCarteFidelite);

    ClientResponse updateClient(long id, Client clientDetails);

    Client getClientById(long id);
}
