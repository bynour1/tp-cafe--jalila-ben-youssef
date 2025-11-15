package com.example.tp_cafe_jalila_ben_youssef.RestController;


import com.example.tp_cafe_jalila_ben_youssef.DTO.ArticleResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Article;

import com.example.tp_cafe_jalila_ben_youssef.SERVICES.ArticleServ;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/article")
public class ArticleRestController {


    private final ArticleServ articleServ;

    @GetMapping
    public List<Article> getAll(){
        return articleServ.selectAllArticle();
    }

    @PostMapping
    public ArticleResponse addArticle(@RequestBody Article article){
        return articleServ.addArticle(article);
    }

    @GetMapping("selectbyId/{id}")
    public Article findbyId(@PathVariable("id") long id){
        return articleServ.selectArticleByIdWithOrElse(id);
    }

    @GetMapping("selectById2")
    public Article findbyId2(@RequestParam long id){
        return articleServ.selectArticleByIdWithOrElse(id);
    }

    @GetMapping("selectById3/{id}")
    public ResponseEntity<Article> findbyId3(@PathVariable("id") long id){
        Article article = articleServ.selectArticleByIdWithGet(id);
        if (article != null) {
            return ResponseEntity.ok(article);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleResponse> updateArticle(@PathVariable long id, @RequestBody Article articleDetails){
        try {
            Article existingArticle = articleServ.selectArticleByIdWithOrElse(id);
            if (existingArticle != null) {
                existingArticle.setNomArticle(articleDetails.getNomArticle());
                existingArticle.setPrixArticle(articleDetails.getPrixArticle());
                existingArticle.setTypeArticle(articleDetails.getTypeArticle());

                ArticleResponse updatedArticle = articleServ.addArticle(existingArticle);
                return ResponseEntity.ok(updatedArticle);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable long id){
        try {
            Article article = articleServ.selectArticleByIdWithOrElse(id);
            if (article != null) {
                return ResponseEntity.ok(article);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArticleById(@PathVariable long id){
        try {
            if (articleServ.verifArticleById(id)) {
                articleServ.deleteArticleById(id);
                return ResponseEntity.ok("Article avec ID " + id + " supprimé avec succès");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Aucun article trouvé avec l'ID: " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression de l'article: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteArticle(@RequestBody Article article){
        try {
            articleServ.deleteArticle(article);
            return ResponseEntity.ok("Article supprimé avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression de l'article: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllArticles(){
        try {
            articleServ.deleteAllArticle();
            return ResponseEntity.ok("Tous les articles ont été supprimés avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression de tous les articles: " + e.getMessage());
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countArticles(){
        try {
            long count = articleServ.countingArticles();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0L);
        }
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable long id){
        try {
            boolean exists = articleServ.verifArticleById(id);
            return ResponseEntity.ok(exists);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    @GetMapping("/byType/{type}")
    public <TypeofArticle> ResponseEntity<List<Article>> getArticlesByType(@PathVariable TypeofArticle type){
        try {
            List<Article> articles = articleServ.findArticleByType(type);
            return ResponseEntity.ok(articles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok("Article REST Controller is working properly!");
    }
}
