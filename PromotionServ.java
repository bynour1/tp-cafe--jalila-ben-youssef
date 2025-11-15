package com.example.tp_cafe_jalila_ben_youssef.SERVICES;

import com.example.tp_cafe_jalila_ben_youssef.DTO.PromotionResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Promotion;
import com.example.tp_cafe_jalila_ben_youssef.mappers.IPromotionMap;
import com.example.tp_cafe_jalila_ben_youssef.repositories.PromotionRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
public class PromotionServ implements IPromotionServ {
    private PromotionRepo PromotionRepo;
    @Qualifier( "IPromotionMap")
    private IPromotionMap mapper;
    @Override
    public PromotionResponse addPromotion(Promotion Promotion) {
        Promotion newPromotion =  mapper.toEntity(Promotion);
        PromotionRepo.save(newPromotion);

        PromotionResponse pr =mapper.toDto(newPromotion);
        return pr;}

    @Override
    public Promotion addAdresse(Promotion Promotion) {
        return null;
    }
    @Override
    public Promotion Promotion(Promotion Promotion) {
        return null;
    }
    @Override
    public List<Promotion> savePromotion(List<Promotion> Promotion) {
        return List.of();
    }
    @Override
    public Promotion selectPromotionleByIdWithGet(long id) {
        return null;
    }
    @Override
    public Promotion selectPromotionByIdWithGet(long id) {
        return null;
    }

    @Override
    public Promotion selectPromotionByIdWithOrElse(long id) {
        return null;
    }

    @Override
    public List<Promotion> selectAllPromotion() {
        return List.of();
    }

    @Override
    public void deletePromotion(Promotion Promotion) {}
    @Override
    public void deleteAllPromotion() {}
    @Override
    public void deletePromotioneById(long id) {}
    @Override
    public void deletePromotionById(long id) {}
    @Override
    public long countingPromotion() {
        return 0;
    }
    @Override
    public boolean verifPromotionById(long id) {
        return false;
    }
    @Override
    public List<Promotion> selectAllPromotions() {
        return List.of();
    }

    @Override
    public List<Promotion> findPromotionsByNom(long nom) {
        return List.of();
    }

    @Override
    public long countingPromotions() {
        return 0;
    }

    @Override
    public void deleteAllPromotions() {

    }

    @Override
    public List<Promotion> findPromotionsActives(Date date) {
        return List.of();
    }

    @Override
    public List<Promotion> findPromotionsByArticle(long idArticle) {
        return List.of();
    }

    @Override
    public List<Promotion> savePromotions(List<Promotion> promotions) {
        return List.of();
    }
}
