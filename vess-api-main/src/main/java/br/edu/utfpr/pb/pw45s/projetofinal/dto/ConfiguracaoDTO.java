package br.edu.utfpr.pb.pw45s.projetofinal.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ConfiguracaoDTO {
    private Long id;
    private String nome;
    private String email;
    private String pais;
    private String idioma;
    private String cidadeEestado;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}
