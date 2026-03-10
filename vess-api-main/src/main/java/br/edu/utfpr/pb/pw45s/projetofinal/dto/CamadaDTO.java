package br.edu.utfpr.pb.pw45s.projetofinal.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class CamadaDTO implements Serializable {
    private Long id;
    private Integer numeroCamada;
    private Float comprimentoCm;
    private Integer notaCamada;
    private Float escoreCamada;
}