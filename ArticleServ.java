package com.example.tp_cafe_jalila_ben_youssef.SERVICES;


import com.example.tp_cafe_jalila_ben_youssef.DTO.ArticleResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Article;
import com.example.tp_cafe_jalila_ben_youssef.RestController.ArticleRestController;
import com.example.tp_cafe_jalila_ben_youssef.mappers.IArticleMap;
import com.example.tp_cafe_jalila_ben_youssef.repositories.ArticleRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ArticleServ implements IArticleServ{
    private ArticleRepo ArticleRepo;
    @Qualifier("IArticleMap")
    private IArticleMap mapper;

    @Override
    public ArticleResponse addArticle(Article Article) {
        Article newArticle =  mapper.toEntity(Article);
        ArticleRepo.save(newArticle);

        ArticleResponse ar =mapper.toDto(newArticle);
        return ar;
    }

    @Override
    public Article addAdresse(Article article) {
        return null;
    }

    @Override
    public List<Article> saveArticle(List<Article> Articles) {
        return List.of();
    }

    @Override
    public Article selectArticleByIdWithGet(long id) {
        return null;
    }

    @Override
    public Article selectArticleByIdWithOrElse(long id) {
        return null;
    }

    @Override
    public List<Article> selectAllArticle() {
        return List.of();
    }

    @Override
    public void deleteArticle(Article article) {

    }

    @Override
    public void deleteAllArticle() {

    }

    @Override
    public void deleteArticleById(long id) {

    }

    @Override
    public long countingArticle() {
        return 0;
    }

    @Override
    public boolean verifArticleById(long id) {
        return false;
    }



    @Override
    public List<Article> selectAllArticles() {
        return List.of();
    }

    @Override
    public ArticleRestController get() {
        return null;
    }

    public long countingArticles() {
        return 0;
    }

    public <TypeofArticle> List<Article> findArticleByType(TypeofArticle type) {
        return List.of();
    }
}
