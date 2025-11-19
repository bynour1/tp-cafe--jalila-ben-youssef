package com.example.tp_cafe_jalila_ben_youssef.Entite;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Client")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)


public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClient")
    Long idClient;

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