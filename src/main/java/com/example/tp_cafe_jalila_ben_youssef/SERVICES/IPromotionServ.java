package com.example.tp_cafe_jalila_ben_youssef.SERVICES;

import com.example.tp_cafe_jalila_ben_youssef.DTO.PromotionResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Promotion;

import java.util.Date;
import java.util.List;

public interface IPromotionServ {
    PromotionResponse addPromotion(Promotion Promotion);

    Promotion addAdresse(Promotion Promotion);

    Promotion Promotion(Promotion Promotion);

    List<Promotion> savePromotion(List<Promotion> Promotion);

    Promotion selectPromotionleByIdWithGet(long id);

    Promotion selectPromotionByIdWithGet(long id);

    Promotion selectPromotionByIdWithOrElse(long id);

    List<Promotion> selectAllPromotion();

    void deletePromotion(Promotion Promotion);

    void deleteAllPromotion();

    void deletePromotioneById(long id);

    void deletePromotionById(long id);

    long countingPromotion();

    boolean verifPromotionById(long id);

    List<Promotion> selectAllPromotions();

    List<Promotion> findPromotionsByNom(long nom);

    long countingPromotions();

    void deleteAllPromotions();

    List<Promotion> findPromotionsActives(Date date);

    List<Promotion> findPromotionsByArticle(long idArticle);

    List<Promotion> savePromotions(List<Promotion> promotions);
}
