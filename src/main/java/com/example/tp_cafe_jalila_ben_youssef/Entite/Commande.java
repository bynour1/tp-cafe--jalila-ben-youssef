package com.example.tp_cafe_jalila_ben_youssef.Entite;

import com.example.tp_cafe_jalila_ben_youssef.enums.StatusCommande;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "Commande")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCommande")
    private Long idCommande;

    @Column(name = "dateCommande")
    private LocalDate dateCommande;

    @Column(name = "totalCommande")
    private float totalCommande;

    @Enumerated(EnumType.STRING)
    @Column(name = "statusofCommande")
    private StatusCommande statusCommande;

    @ManyToOne
    private Client client;


    @OneToMany(mappedBy = "commande")
    List<DetailCommande> detail_Commandes;

}