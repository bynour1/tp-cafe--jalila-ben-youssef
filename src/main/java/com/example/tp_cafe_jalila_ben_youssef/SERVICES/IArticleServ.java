package com.example.tp_cafe_jalila_ben_youssef.SERVICES;


import com.example.tp_cafe_jalila_ben_youssef.DTO.ArticleResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Article;
import com.example.tp_cafe_jalila_ben_youssef.RestController.ArticleRestController;

import java.util.List;

public interface IArticleServ {


    Article addAdresse(Article article);

    List<Article> saveArticle(List<Article> adresses);

    Article selectArticleByIdWithGet(long id);

    Article selectArticleByIdWithOrElse(long id);

    List<Article> selectAllArticle();

    void deleteArticle(Article article);

    void deleteAllArticle();

    void deleteArticleById(long id);

    long countingArticle();

    boolean verifArticleById(long id);

    ArticleResponse addArticle(Article article);

    List<Article> selectAllArticles();

    ArticleRestController get();
}


