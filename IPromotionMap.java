package com.example.tp_cafe_jalila_ben_youssef.mappers;

import com.example.tp_cafe_jalila_ben_youssef.DTO.PromotionResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Promotion;

public interface IPromotionMap {
    Promotion toEntity (Promotion PromotionRequest);
    PromotionResponse toDto (Promotion Promotion);
}
