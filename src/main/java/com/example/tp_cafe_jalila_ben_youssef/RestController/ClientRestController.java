package com.example.tp_cafe_jalila_ben_youssef.RestController;

import com.example.tp_cafe_jalila_ben_youssef.DTO.ClientResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Client;
import com.example.tp_cafe_jalila_ben_youssef.SERVICES.IClientServ;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/client")
public class ClientRestController {

    private final IClientServ clientServ;

    @GetMapping
    public ResponseEntity<List<Client>> getAll() {
        List<Client> clients = clientServ.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @PostMapping
    public ResponseEntity<ClientResponse> addClient(@RequestBody Client client) {
        ClientResponse response = clientServ.addClientWithResponse(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable long id) {
        Client client = clientServ.getClientById(id);
        return client != null ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponse> updateClient(@PathVariable long id, @RequestBody Client clientDetails) {
        try {
            ClientResponse updatedClient = clientServ.updateClientById(id, clientDetails);
            return updatedClient != null ? ResponseEntity.ok(updatedClient) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/byNom/{nom}")
    public ResponseEntity<List<Client>> getClientsByNom(@PathVariable String nom) {
        List<Client> clients = clientServ.findClientsByNom(nom);
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/byCarteFidelite/{idCarteFidelite}")
    public ResponseEntity<Client> getClientByCarteFidelite(@PathVariable long idCarteFidelite) {
        Client client = clientServ.getClientByCarteFidelite(idCarteFidelite);
        return client != null ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClientById(@PathVariable long id) {
        try {
            boolean exists = clientServ.verifClientById(id);
            if (exists) {
                clientServ.deleteClientById(id);
                return ResponseEntity.ok("Client supprimé avec succès !");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client non trouvé !");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur : " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllClients() {
        try {
            clientServ.deleteAllClient();
            return ResponseEntity.ok("Tous les clients ont été supprimés !");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur : " + e.getMessage());
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countClients() {
        long count = clientServ.countingClient();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable long id) {
        boolean exists = clientServ.verifClientById(id);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Client REST Controller fonctionne correctement !");
    }
    @PutMapping("/affecterClientAAdresse")
    public void affecterClientAAdresse(@RequestParam long idClient, @RequestParam long idAdresse) {
        clientServ.affecterClientAAdresse(idClient, idAdresse);
    }
}
