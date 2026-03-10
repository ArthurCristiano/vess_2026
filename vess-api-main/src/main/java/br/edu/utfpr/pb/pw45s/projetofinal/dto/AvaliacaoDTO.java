package br.edu.utfpr.pb.pw45s.projetofinal.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AvaliacaoDTO {
    private Long id;
    private ConfiguracaoDTO configuracao;
    private String nomeAvaliacao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private LocalDateTime dataCriacao;
    private String resumoAvaliacao;
    private String descricaoManejoLocal;
    private Integer totalAmostras;
    private Float escoreMedioGeral;
    private String avaliador;
    private String informacoes;
    private String status;
    private List<AmostraDTO> amostras;
}
