package br.edu.utfpr.pb.pw45s.projetofinal.model;

import br.edu.utfpr.pb.pw45s.projetofinal.shared.Identifiable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "camada")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Camada implements Identifiable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "amostra_id")
    @JsonBackReference
    @ToString.Exclude
    private Amostra amostra;

    @Column(name = "numero_camada")
    private Integer numeroCamada;

    @Column(name = "comprimento_cm")
    private Float comprimentoCm;

    @Column(name = "nota_camada")
    private Integer notaCamada;

    @Column(name = "escore_camada")
    private Float escoreCamada;

}