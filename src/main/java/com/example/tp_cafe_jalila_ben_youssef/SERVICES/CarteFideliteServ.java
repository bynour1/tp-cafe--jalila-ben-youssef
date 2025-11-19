package com.example.tp_cafe_jalila_ben_youssef.SERVICES;
import com.example.tp_cafe_jalila_ben_youssef.DTO.ArticleResponse;
import com.example.tp_cafe_jalila_ben_youssef.DTO.CarteFideliteResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Article;
import com.example.tp_cafe_jalila_ben_youssef.Entite.CarteFidelite;
import com.example.tp_cafe_jalila_ben_youssef.mappers.ICarteFideliteMap;
import com.example.tp_cafe_jalila_ben_youssef.repositories.CarteFideliteRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarteFideliteServ implements ICarteFideliteServ{
    private CarteFideliteRepo CarteFideliteRepo;
    @Qualifier("ICarteFideliteMap")
    private ICarteFideliteMap mapper;

    @Override
    public CarteFideliteResponse addCarteFidelite(CarteFidelite CarteFidelite) {
        CarteFidelite newCarteFidelite =  mapper.toEntity(CarteFidelite);
        CarteFideliteRepo.save(newCarteFidelite);

        CarteFideliteResponse CF =mapper.toDto(newCarteFidelite);
        return CF;
    }

    @Override
    public CarteFidelite addAdresse(CarteFidelite CarteFidelite) {
        return null;
    }


    @Override
    public ArticleResponse addArticle(Article Article) {
        return null;
    }

    @Override
    public Article addAdresse(Article article) {
        return null;
    }

    @Override
    public CarteFidelite CarteFidelite(CarteFidelite CarteFidelite) {
        return null;
    }



    @Override
    public List<CarteFidelite> saveCarteFidelite(List<CarteFidelite> CarteFidelite) {
        return List.of();
    }

    @Override
    public CarteFidelite selectCarteFideliteleByIdWithGet(long id) {
        return null;
    }

    @Override
    public CarteFidelite selectCarteFideliteByIdWithOrElse(long id) {
        return null;
    }

    @Override
    public List<CarteFidelite> selectAllCarteFidelite() {
        return List.of();
    }

    @Override
    public void deleteCarteFidelite(CarteFidelite CarteFidelite) {

    }

    @Override
    public void deleteAllCarteFidelite() {

    }

    @Override
    public void deleteCarteFideliteById(long id) {

    }

    @Override
    public long countingCarteFidelite() {
        return 0;
    }

    @Override
    public boolean verifCarteFideliteById(long id) {
        return false;
    }

    @Override
    public List<CarteFidelite> selectAllCartesFidelite() {
        return List.of();
    }
}
