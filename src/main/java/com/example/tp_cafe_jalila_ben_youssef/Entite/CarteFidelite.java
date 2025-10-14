package com.example.tp_cafe_jalila_ben_youssef.Entite;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "CarteFidelite")
@Getter//hethim teb3in lombok//enma obloigatoire
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor//contructeur par default
@AllArgsConstructor//constructeur parmettre complete
//@RequiredArgsConstructor//pour les contructeur non nul
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)//hata lhne2
public class CarteFidelite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarteFidelite")
    private Long idCarteFidelite;

    @Column(name = "pointsAccumulés")
    private int pointsAccumulés;

    @Column(name = "dateCreation")
    private LocalDate dateCreation;
    @OneToOne(mappedBy = "cartefidelite") // This must match EXACTLY the field name in Client
    private Client client;
}