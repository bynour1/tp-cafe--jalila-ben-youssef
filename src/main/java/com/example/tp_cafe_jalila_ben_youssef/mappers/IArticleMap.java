package com.example.tp_cafe_jalila_ben_youssef.mappers;

import com.example.tp_cafe_jalila_ben_youssef.DTO.ArticleResponse;
import com.example.tp_cafe_jalila_ben_youssef.Entite.Article;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface IArticleMap {

        Article toEntity (Article ArticleRequest);
        ArticleResponse toDto (Article Article);



}
