
package com.example.tp_cafe_jalila_ben_youssef.RestController;

import com.example.tp_cafe_jalila_ben_youssef.DTO.PromotionResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Promotion;
import com.example.tp_cafe_jalila_ben_youssef.SERVICES.IPromotionServ;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/promotion")
public class PromotionRestController {

    private final IPromotionServ promotionServ;

    @GetMapping
    public List<Promotion> getAll(){
        return promotionServ.selectAllPromotions();
    }

    @PostMapping
    public PromotionResponse addPromotion(@RequestBody Promotion promotion){
        return promotionServ.addPromotion(promotion);
    }

    @PostMapping("/batch")
    public List<Promotion> addPromotions(@RequestBody List<Promotion> promotions){
        return promotionServ.savePromotions(promotions);
    }

    @GetMapping("selectbyId/{id}")
    public Promotion findbyId(@PathVariable("id") long id){
        return promotionServ.selectPromotionByIdWithOrElse(id);
    }

    @GetMapping("selectById2")
    public Promotion findbyId2(@RequestParam long id){
        return promotionServ.selectPromotionByIdWithOrElse(id);
    }

    @GetMapping("selectById3/{id}")
    public ResponseEntity<Promotion> findbyId3(@PathVariable("id") long id){
        Promotion promotion = promotionServ.selectPromotionByIdWithGet(id);
        if (promotion != null) {
            return ResponseEntity.ok(promotion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PromotionResponse> updatePromotion(@PathVariable long id, @RequestBody Promotion promotionDetails){
        try {
            Promotion existingPromotion = promotionServ.selectPromotionByIdWithOrElse(id);
            if (existingPromotion != null) {
                existingPromotion.setDateDebutPromo(promotionDetails.getDateDebutPromo());
                existingPromotion.setDateFinPromo(promotionDetails.getDateFinPromo());
                existingPromotion.setPourcentagePromo(promotionDetails.getPourcentagePromo());

                PromotionResponse updatedPromotion = promotionServ.addPromotion(existingPromotion);
                return ResponseEntity.ok(updatedPromotion);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promotion> getPromotionById(@PathVariable long id){
        try {
            Promotion promotion = promotionServ.selectPromotionByIdWithOrElse(id);
            if (promotion != null) {
                return ResponseEntity.ok(promotion);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/actives")
    public ResponseEntity<List<Promotion>> getPromotionsActives(@RequestParam Date date){
        try {
            List<Promotion> promotions = promotionServ.findPromotionsActives(date);
            return ResponseEntity.ok(promotions);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/byArticle/{idArticle}")
    public ResponseEntity<List<Promotion>> getPromotionsByArticle(@PathVariable long idArticle){
        try {
            List<Promotion> promotions = promotionServ.findPromotionsByArticle(idArticle);
            return ResponseEntity.ok(promotions);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePromotionById(@PathVariable long id){
        try {
            if (promotionServ.verifPromotionById(id)) {
                promotionServ.deletePromotionById(id);
                return ResponseEntity.ok("Promotion avec ID " + id + " supprimée avec succès");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Aucune promotion trouvée avec l'ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression de la promotion: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePromotion(@RequestBody Promotion promotion){
        try {
            promotionServ.deletePromotion(promotion);
            return ResponseEntity.ok("Promotion supprimée avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression de la promotion: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllPromotions(){
        try {
            promotionServ.deleteAllPromotions();
            return ResponseEntity.ok("Toutes les promotions ont été supprimées avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression de toutes les promotions: " + e.getMessage());
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countPromotions(){
        try {
            long count = promotionServ.countingPromotions();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0L);
        }
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable long id){
        try {
            boolean exists = promotionServ.verifPromotionById(id);
            return ResponseEntity.ok(exists);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok("Promotion REST Controller is working properly!");
    }
}
