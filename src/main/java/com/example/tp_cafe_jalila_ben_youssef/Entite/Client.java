package com.example.tp_cafe_jalila_ben_youssef.Entite;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Client")
@Getter//hethim teb3in lombok//enma obloigatoire
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor//contructeur par default
@AllArgsConstructor//constructeur parmettre complete
//@RequiredArgsConstructor//pour les contructeur non nul
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)//hata lhne2


public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClient")
    Long idClient;
    //@NonNull
    @Column(name = "nom")
    String nom;
    @Column(name = "prenom")
    String prenom;
    @Column(name = "dateNaissance")
    LocalDate dateNaissance;
    @OneToOne
    Adresse adress;
    @OneToOne
    private CarteFidelite cartefidelite; // or cartefidelite - use whatever name you prefer;

    @OneToMany(mappedBy = "client")
    List<Commande> commandes;
}