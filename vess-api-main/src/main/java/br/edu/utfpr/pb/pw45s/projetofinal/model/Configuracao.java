package br.edu.utfpr.pb.pw45s.projetofinal.model;

import br.edu.utfpr.pb.pw45s.projetofinal.shared.Identifiable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity @Table(name = "configuracao")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Configuracao implements Identifiable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String pais;
    private String idioma;

    @Column(name = "cidade_estado")
    private String cidadeEestado;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualiacao")
    private LocalDateTime dataAtualizacao;
}