package com.example.tp_cafe_jalila_ben_youssef.SERVICES;

import com.example.tp_cafe_jalila_ben_youssef.DTO.ClientResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Adresse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Client;
import com.example.tp_cafe_jalila_ben_youssef.mappers.IClientMap;
import com.example.tp_cafe_jalila_ben_youssef.repositories.AdresseRepo;
import com.example.tp_cafe_jalila_ben_youssef.repositories.CarteFideliteRepo;
import com.example.tp_cafe_jalila_ben_youssef.repositories.ClientRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServ implements IClientServ{
    private ClientRepo clientRepo;
    @Qualifier("IClientMap")
    private IClientMap mapper;
    private AdresseRepo adresseRepo;
    private CarteFideliteRepo carteFideliteRepo;

    @Override
    public ClientResponse addClientWithResponse(Client client) {
        Client newClient = clientRepo.save(client);
        return mapper.toDto(newClient);
    }

    @Override
    public Client addAdresse(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public Client createClient(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public Client updateClientDetails(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public List<Client> saveClient(List<Client> clients) {
        return clientRepo.saveAll(clients);
    }

    @Override
    public Client selectClientByIdWithGetOptional(long id) {
        Optional<Client> client = clientRepo.findById(id);
        return client.orElse(null);
    }

    @Override
    public Client selectClientByIdWithGet(long id) {
        Optional<Client> client = clientRepo.findById(id);
        return client.isPresent() ? client.get() : null;
    }

    @Override
    public Client selectClientByIdWithOrElse(long id) {
        return clientRepo.findById(id).orElse(null);
    }

    @Override
    public List<Client> selectAllClient() {
        return clientRepo.findAll();
    }

    @Override
    public void deleteClient(Client client) {
        clientRepo.delete(client);
    }

    @Override
    public void deleteAllClient() {
        clientRepo.deleteAll();
    }

    @Override
    public void deleteClientById(long id) {
        clientRepo.deleteById(id);
    }

    @Override
    public long countingClient() {
        return clientRepo.count();
    }

    @Override
    public boolean verifClientById(long id) {
        return clientRepo.existsById(id);
    }

    @Override
    public List<Client> selectAllClients() {
        return clientRepo.findAll();
    }

    @Override
    public List<Client> findClientsByNom(String nom) {
        return clientRepo.findByNom(nom);
    }

    @Override
    public IClientServ get() {
        return this;
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }

    @Override
    public Client getClientByCarteFidelite(long idCarteFidelite) {
        return carteFideliteRepo.findById(idCarteFidelite)
                .map(carteFidelite -> carteFidelite.getClient())
                .orElse(null);
    }

    @Override
    public ClientResponse updateClientById(long id, Client clientDetails) {
        Client existingClient = clientRepo.findById(id).orElse(null);
        if (existingClient != null) {
            existingClient.setNom(clientDetails.getNom());
            existingClient.setPrenom(clientDetails.getPrenom());
            existingClient.setDateNaissance(clientDetails.getDateNaissance());
            existingClient.setAdress(clientDetails.getAdress());
            existingClient.setCartefidelite(clientDetails.getCartefidelite());
            clientRepo.save(existingClient);
            return mapper.toDto(existingClient);
        }
        return null;
    }

    @Override
    public Client getClientById(long id) {
        return clientRepo.findById(id).orElse(null);
    }

    @Override
    public void affecterClientAAdresse(long idClient, long idAdresse) {
        try {
            // 1- récupérer des objets Client et Adresse
            Optional<Adresse> adresseOpt = adresseRepo.findById(idAdresse);
            Optional<Client> clientOpt = clientRepo.findById(idClient);

            if (adresseOpt.isPresent() && clientOpt.isPresent()) {
                // 2- affecter l'adresse au client
                Client client = clientOpt.get();
                client.setAdress(adresseOpt.get());
                // 3- sauvegarder le client a la base de données
                clientRepo.save(client);
            }
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            throw new RuntimeException("Erreur lors de l'affectation de l'adresse au client: " + e.getMessage(), e);
        }
    }

    @Override
    public ClientResponse addClient(Client client) {
        Client savedClient = clientRepo.save(client);
        return mapper.toDto(savedClient);
    }

}
