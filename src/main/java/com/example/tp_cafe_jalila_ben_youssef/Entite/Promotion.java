package com.example.tp_cafe_jalila_ben_youssef.Entite;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Promotion {


    @Id
    private long idPromotion;
    private String pourcentagePromo;
    private LocalDate dateDebutPromo;
    private LocalDate dateFinPromo;
    @ManyToMany(mappedBy = "promotions")
    private List<Article> article;
}
