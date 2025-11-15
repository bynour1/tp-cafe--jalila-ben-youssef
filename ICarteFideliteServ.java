package com.example.tp_cafe_jalila_ben_youssef.SERVICES;


import com.example.tp_cafe_jalila_ben_youssef.DTO.ArticleResponse;
import com.example.tp_cafe_jalila_ben_youssef.DTO.CarteFideliteResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Article;
import com.example.tp_cafe_jalila_ben_youssef.Entite.CarteFidelite;

import java.util.List;

public interface ICarteFideliteServ {
    CarteFidelite addAdresse(CarteFidelite CarteFidelite);

    ArticleResponse addArticle(Article Article);

    Article addAdresse(Article article);

    CarteFidelite CarteFidelite(CarteFidelite CarteFidelite);

    CarteFideliteResponse addCarteFidelite(CarteFidelite CarteFidelite);

    List<CarteFidelite> saveCarteFidelite(List<CarteFidelite> CarteFidelite);

    CarteFidelite selectCarteFideliteleByIdWithGet(long id);

    CarteFidelite selectCarteFideliteByIdWithOrElse(long id);

    List<CarteFidelite> selectAllCarteFidelite();

    void deleteCarteFidelite(CarteFidelite CarteFidelite);

    void deleteAllCarteFidelite();

    void deleteCarteFideliteById(long id);

    long countingCarteFidelite();

    boolean verifCarteFideliteById(long id);

    List<CarteFidelite> selectAllCartesFidelite();
}
