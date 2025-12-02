package com.example.tp_cafe_jalila_ben_youssef.SERVICES;

import com.example.tp_cafe_jalila_ben_youssef.DTO.ClientResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Article;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Client;

import java.time.LocalDate;
import java.util.List;

public interface IClientServ {
    ClientResponse addClientWithResponse(Client client);

    Client addAdresse(Client client);

    Client updateClient(Client client);

    Client createClient(Client client);

    Client updateClientDetails(Client client);

    List<Client> saveClient(List<Client> clients);

    Client selectClientByIdWithGetOptional(long id);

    Client selectClientByIdWithGet(long id);

    Client selectClientByIdWithOrElse(long id);

    List<Client> selectAllClient();

    void deleteClient(Client client);

    void deleteAllClient();

    void deleteClientById(long id);

    long countingClient();

    boolean verifClientById(long id);

    List<Client> selectAllClients();

    List<Client> findClientsByNom(String nom);

    IClientServ get();

    List<Client> getAllClients();

    Client getClientByCarteFidelite(long idCarteFidelite);

    ClientResponse updateClientById(long id, Client clientDetails);

    Client getClientById(long id);

    void affecterClientAAdresse(long idClient, long idAdresse);

    ClientResponse addClient(Client client);

    default String affecterAdresseAClient(String rue, long cin) {
        return "";
    }

    default void affecterCarteAClient(long idCarte, long idClient) {

    }

    default void affecterCommandeAClient(long idCommande, long idClient) {

    }

    default void affecterCommandeAClient(LocalDate dateCommande, String nomClient, String prenomClient) {

    }

    default void desaffecterClientDeCommande(long idCommande) {

    }

    default void affecterPromotionAArticle(long idArticle, long idPromo) {

    }

    default void desaffecterPromotionDUnArticle(long idArticle, long idPromo) {

    }

    default Client ajouterClientEtCarteFidelite(Client client) {
        return null;
    }

    default Article ajouterArticleEtPromotions(Article article) {
        return null;
    }
}
