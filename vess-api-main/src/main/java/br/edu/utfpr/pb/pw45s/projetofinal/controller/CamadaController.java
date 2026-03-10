package br.edu.utfpr.pb.pw45s.projetofinal.controller;

import br.edu.utfpr.pb.pw45s.projetofinal.dto.CamadaDTO;
import br.edu.utfpr.pb.pw45s.projetofinal.model.Camada;
import br.edu.utfpr.pb.pw45s.projetofinal.repository.CamadaRepository;
import br.edu.utfpr.pb.pw45s.projetofinal.service.CamadaService;
import br.edu.utfpr.pb.pw45s.projetofinal.shared.CrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("camada")
public class CamadaController extends CrudController<Long, Camada, CamadaDTO, CamadaRepository, CamadaService> {

    public CamadaController() {
        super(Camada.class, CamadaDTO.class);
    }

}