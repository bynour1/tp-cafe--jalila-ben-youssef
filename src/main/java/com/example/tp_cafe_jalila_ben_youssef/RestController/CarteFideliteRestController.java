package com.example.tp_cafe_jalila_ben_youssef.RestController;

import com.example.tp_cafe_jalila_ben_youssef.DTO.CarteFideliteResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.CarteFidelite;
import com.example.tp_cafe_jalila_ben_youssef.SERVICES.ICarteFideliteServ;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/carteFidelite")
public class CarteFideliteRestController {

    private final ICarteFideliteServ carteFideliteServ;

    @GetMapping
    public List<CarteFidelite> getAll() {
        return carteFideliteServ.selectAllCartesFidelite();
    }

    @PostMapping
    public CarteFideliteResponse addCarteFidelite(@RequestBody CarteFidelite carteFidelite) {
        return carteFideliteServ.addCarteFidelite(carteFidelite);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarteFidelite> getCarteFideliteById(@PathVariable long id) {
        CarteFidelite carte = carteFideliteServ.selectCarteFideliteByIdWithOrElse(id);
        return carte != null ? ResponseEntity.ok(carte) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarteFideliteResponse> updateCarteFidelite(@PathVariable long id, @RequestBody CarteFidelite carteDetails) {
        try {
            CarteFidelite existingCarte = carteFideliteServ.selectCarteFideliteByIdWithOrElse(id);
            if (existingCarte != null) {
                existingCarte.setDateCreation(carteDetails.getDateCreation());
                existingCarte.setPointsAccumulés(carteDetails.getPointsAccumulés());
                CarteFideliteResponse updatedCarte = carteFideliteServ.addCarteFidelite(existingCarte);
                return ResponseEntity.ok(updatedCarte);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/updatePoints/{id}")
    public ResponseEntity<CarteFidelite> updatePoints(@PathVariable long id, @RequestParam int nouveauxPoints) {
        try {
            CarteFidelite updated = null;
            carteFideliteServ.wait(id, nouveauxPoints);
            return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCarteFideliteById(@PathVariable long id) {
        try {
            if (carteFideliteServ.verifCarteFideliteById(id)) {
                carteFideliteServ.deleteCarteFideliteById(id);
                return ResponseEntity.ok("Carte fidélité supprimée avec succès !");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carte non trouvée !");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur : " + e.getMessage());
        }
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll() {
        try {
            carteFideliteServ.deleteAllCarteFidelite();
            return ResponseEntity.ok("Toutes les cartes fidélité ont été supprimées !");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur : " + e.getMessage());
        }
    }
    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        try {
            long count = carteFideliteServ.countingCarteFidelite();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0L);
        }
    }
    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable long id) {
        return ResponseEntity.ok(carteFideliteServ.verifCarteFideliteById(id));
    }
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok(" CarteFidelite REST Controller fonctionne correctement !");
    }
}
