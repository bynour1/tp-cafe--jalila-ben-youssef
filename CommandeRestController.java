package com.example.tp_cafe_jalila_ben_youssef.RestController;

import com.example.tp_cafe_jalila_ben_youssef.DTO.CommandeResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Commande;
import com.example.tp_cafe_jalila_ben_youssef.SERVICES.ICommandeServ;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/commande")
public class CommandeRestController {

    private final ICommandeServ commandeServ;

    @GetMapping
    public List<Commande> getAll(){
        return commandeServ.selectAllCommande();
    }

    @PostMapping
    public CommandeResponse addCommande(@RequestBody Commande commande){
        return commandeServ.addCommande(commande);
    }

    @GetMapping("selectbyId/{id}")
    public Commande findbyId(@PathVariable("id") long id){
        return commandeServ.selectCommandeByIdWithOrElse(id);
    }

    @GetMapping("selectById2")
    public Commande findbyId2(@RequestParam long id){
        return commandeServ.selectCommandeByIdWithOrElse(id);
    }

    @GetMapping("selectById3/{id}")
    public ResponseEntity<Commande> findbyId3(@PathVariable("id") long id){
        Commande commande = commandeServ.selectCommandeByIdWithGet(id);
        if (commande != null) {
            return ResponseEntity.ok(commande);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommandeResponse> updateCommande(@PathVariable long id, @RequestBody Commande commandeDetails){
        try {
            Commande existingCommande = commandeServ.selectCommandeByIdWithOrElse(id);
            if (existingCommande != null) {
                existingCommande.setDateCommande(commandeDetails.getDateCommande());
                existingCommande.setTotalCommande(commandeDetails.getTotalCommande());
                existingCommande.setStatusCommande(commandeDetails.getStatusCommande());
                existingCommande.setClient(commandeDetails.getClient());

                CommandeResponse updatedCommande = commandeServ.addCommande(existingCommande);
                return ResponseEntity.ok(updatedCommande);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/updateStatus/{id}")
    public <StatusofCommande> ResponseEntity<Boolean> updateStatus(@PathVariable long id, @RequestParam StatusofCommande nouveauStatus){
        try {
            boolean updatedCommande = commandeServ.equals(id);
            if (updatedCommande != Boolean.parseBoolean(null)) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(updatedCommande);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable long id){
        try {
            Commande commande = commandeServ.selectCommandeByIdWithOrElse(id);
            if (commande != null) {
                return ResponseEntity.ok(commande);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/byClient/{idClient}")
    public ResponseEntity<List<Commande>> getCommandesByClient(@PathVariable long idClient){
        try {
            List<Commande> commandes = commandeServ.findCommandeByClient(idClient);
            return ResponseEntity.ok(commandes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/byStatus/{status}")
    public <StatusofCommande> ResponseEntity<List<Commande>> getCommandesByStatus(@PathVariable StatusofCommande status){
        try {
            List<Commande> commandes = commandeServ.findCommandeByClient((Long) status);
            return ResponseEntity.ok(commandes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCommandeById(@PathVariable long id){
        try {
            if (commandeServ.verifCommandeById(id)) {
                commandeServ.deleteCommandeById(id);
                return ResponseEntity.ok("Commande avec ID " + id + " supprimée avec succès");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Aucune commande trouvée avec l'ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression de la commande: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCommande(@RequestBody Commande commande){
        try {
            commandeServ.deleteCommande(commande);
            return ResponseEntity.ok("Commande supprimée avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression de la commande: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllCommandes(){
        try {
            commandeServ.deleteAllCommande();
            return ResponseEntity.ok("Toutes les commandes ont été supprimées avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression de toutes les commandes: " + e.getMessage());
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countCommandes(){
        try {
            long count = commandeServ.countingCommande();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0L);
        }
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable long id){
        try {
            boolean exists = commandeServ.verifCommandeById(id);
            return ResponseEntity.ok(exists);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok("Commande REST Controller is working properly!");
    }
}
