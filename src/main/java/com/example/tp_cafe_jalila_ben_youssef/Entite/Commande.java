package com.example.tp_cafe_jalila_ben_youssef.Entite;

import com.example.tp_cafe_jalila_ben_youssef.enums.StatusCommande;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "Commande")
@Getter//hethim teb3in lombok//enma obloigatoire
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor//contructeur par default
@AllArgsConstructor//constructeur parmettre complete
//@RequiredArgsConstructor//pour les contructeur non nul
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)//hata lhne2
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
    private Client client;//hethi met3 client


    @OneToMany(mappedBy = "commande")
    List<DetailCommande> detail_Commandes; // hethi met3 detaildecommande

}