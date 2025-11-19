package com.example.tp_cafe_jalila_ben_youssef.RestController;
import com.example.tp_cafe_jalila_ben_youssef.DTO.AdresseResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Adresse;
import com.example.tp_cafe_jalila_ben_youssef.SERVICES.IAdresseServ;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/Adressee")
public class AdresseRestController {

    private final IAdresseServ AdresseeServ;
    @GetMapping
    public List<Adresse> getAll(){
        return AdresseeServ.selectAllAdresse();
    }

    @PostMapping
    public AdresseResponse addAdresse(@RequestBody Adresse Adresse){
        return AdresseeServ.addAdresse(Adresse);
    }

    // CORRIGÉ : Ajout de {id} dans le mapping
    @GetMapping("selectbyId/{id}")
    public Adresse findbyId(@PathVariable("id") long id){
        return AdresseeServ.selectAdresseByIdWithOrElse(id);
    }

    @GetMapping("selectById2")
    public Adresse findbyId2(@RequestParam long id){
        return AdresseeServ.selectAdresseByIdWithOrElse(id);
    }

    @GetMapping("selectById3/{id}")
    public ResponseEntity<Adresse> findbyId3(@PathVariable("id") long id){
        Adresse Adresse = AdresseeServ.selectAdresseByIdWithGet(id);
        if (Adresse != null) {
            return ResponseEntity.ok(Adresse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<AdresseResponse> updateAdresse(@PathVariable long id, @RequestBody Adresse AdresseDetails){
        try {
            Adresse existingAdresse = AdresseeServ.selectAdresseByIdWithOrElse(id);
            if (existingAdresse != null) {

                existingAdresse.setRue(AdresseDetails.getRue());
                existingAdresse.setVille(AdresseDetails.getVille());

                existingAdresse.setCodePostal(AdresseDetails.getCodePostale());

                AdresseResponse updatedAdresse = AdresseeServ.addAdresse(existingAdresse);
                return ResponseEntity.ok(updatedAdresse);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdresseById(@PathVariable long id){
        try {
            if (AdresseeServ.verifAdresseById(id)) {
                AdresseeServ.deleteAdresseById(id);
                return ResponseEntity.ok("Adressee avec ID " + id + " supprimée avec succès");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Aucune Adressee trouvée avec l'ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression de l'Adressee: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAdresse(@RequestBody Adresse Adresse){
        try {
            AdresseeServ.deleteAdresse(Adresse);
            return ResponseEntity.ok("Adressee supprimée avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression de l'Adressee: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllAdressees(){
        try {
            AdresseeServ.deleteAllAdresse();
            return ResponseEntity.ok("Toutes les Adressees ont été supprimées avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression de toutes les Adressees: " + e.getMessage());
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAdressees(){
        try {
            long count = AdresseeServ.countingAdresse();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0L);
        }
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable long id){
        try {
            boolean exists = AdresseeServ.verifAdresseById(id);
            return ResponseEntity.ok(exists);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok("Adresse REST Controller is working properly!");
    }
}

