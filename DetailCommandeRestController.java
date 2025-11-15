package com.example.tp_cafe_jalila_ben_youssef.RestController;

import com.example.tp_cafe_jalila_ben_youssef.Entite.DetailCommande;
import com.example.tp_cafe_jalila_ben_youssef.SERVICES.IDetailCommandeServ;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/detailCommande")
public class DetailCommandeRestController {

    private final IDetailCommandeServ detailCommandeServ;

    @GetMapping
    public List<DetailCommande> getAll(){
        return detailCommandeServ.selectAllDetailsCommande();
    }

    @PostMapping
    public DetailCommande addDetailCommande(@RequestBody DetailCommande detailCommande){
        return detailCommandeServ.addDetail_Commande(detailCommande);
    }

    @PostMapping("/batch")
    public List<DetailCommande> addDetailCommandes(@RequestBody List<DetailCommande> detailCommandes){
        return detailCommandeServ.saveDetailsCommande(detailCommandes);
    }

    @GetMapping("selectbyId/{id}")
    public DetailCommande findbyId(@PathVariable("id") long id){
        return detailCommandeServ.selectDetailCommandeByIdWithOrElse(id);
    }

    @GetMapping("selectById2")
    public DetailCommande findbyId2(@RequestParam long id){
        return detailCommandeServ.selectDetailCommandeByIdWithOrElse(id);
    }

    @GetMapping("selectById3/{id}")
    public ResponseEntity<DetailCommande> findbyId3(@PathVariable("id") long id){
        DetailCommande detailCommande = detailCommandeServ.selectDetailCommandeByIdWithGet(id);
        if (detailCommande != null) {
            return ResponseEntity.ok(detailCommande);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailCommande> updateDetailCommande(@PathVariable long id, @RequestBody DetailCommande detailCommandeDetails){
        try {
            DetailCommande existingDetailCommande = detailCommandeServ.selectDetailCommandeByIdWithOrElse(id);
            if (existingDetailCommande != null) {
                existingDetailCommande.setQuantiteArticle(detailCommandeDetails.getQuantiteArticle());
                existingDetailCommande.setSousTotalDetailArticle(detailCommandeDetails.getSousTotalDetailArticle());
                existingDetailCommande.setSousTotalDetailArticleApresPromo(detailCommandeDetails.getSousTotalDetailArticleApresPromo());
                existingDetailCommande.setArticle(detailCommandeDetails.getArticle());
                existingDetailCommande.setCommande(detailCommandeDetails.getCommande());

                DetailCommande updatedDetailCommande = detailCommandeServ.addDetail_Commande(existingDetailCommande);
                return ResponseEntity.ok(updatedDetailCommande);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailCommande> getDetailCommandeById(@PathVariable long id){
        try {
            DetailCommande detailCommande = detailCommandeServ.selectDetailCommandeByIdWithOrElse(id);
            if (detailCommande != null) {
                return ResponseEntity.ok(detailCommande);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDetailCommandeById(@PathVariable long id){
        try {
            if (detailCommandeServ.verifDetail_CommandeById(id)) {
                detailCommandeServ.deleteDetailCommandeById(id);
                return ResponseEntity.ok("Détail commande avec ID " + id + " supprimé avec succès");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Aucun détail commande trouvé avec l'ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression du détail commande: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteDetailCommande(@RequestBody DetailCommande detailCommande){
        try {
            detailCommandeServ.deleteDetailCommande(detailCommande);
            return ResponseEntity.ok("Détail commande supprimé avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression du détail commande: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllDetailsCommande(){
        try {
            detailCommandeServ.deleteAllDetailsCommande();
            return ResponseEntity.ok("Tous les détails commande ont été supprimés avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression de tous les détails commande: " + e.getMessage());
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countDetailsCommande(){
        try {
            long count = detailCommandeServ.countingDetailsCommande();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0L);
        }
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable long id){
        try {
            boolean exists = detailCommandeServ.verifDetailCommandeById(id);
            return ResponseEntity.ok(exists);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok("DetailCommande REST Controller is working properly!");
    }
}
