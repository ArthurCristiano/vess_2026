package br.edu.utfpr.pb.pw45s.projetofinal.controller;

import br.edu.utfpr.pb.pw45s.projetofinal.dto.AmostraDTO;
import br.edu.utfpr.pb.pw45s.projetofinal.dto.AvaliacaoDTO;
import br.edu.utfpr.pb.pw45s.projetofinal.model.Amostra;
import br.edu.utfpr.pb.pw45s.projetofinal.model.Avaliacao;
import br.edu.utfpr.pb.pw45s.projetofinal.repository.AmostraRepository;
import br.edu.utfpr.pb.pw45s.projetofinal.repository.AvaliacaoRepository;
import br.edu.utfpr.pb.pw45s.projetofinal.service.AmostraService;
import br.edu.utfpr.pb.pw45s.projetofinal.service.AvaliacaoService;
import br.edu.utfpr.pb.pw45s.projetofinal.shared.CrudController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("amostra")
public class AmostraController extends CrudController<Long, Amostra, AmostraDTO, AmostraRepository, AmostraService> {


    private final AmostraService amostraService;

    public AmostraController(AmostraService amostraService) {
        super(Amostra.class, AmostraDTO.class);
        this.amostraService = amostraService;
    }
    @GetMapping("/resumo-mapa")
    public List<Amostra> getResumoParaMapa() {
        return amostraService.findFirstSampleOfEachAvaliacao();
    }
}