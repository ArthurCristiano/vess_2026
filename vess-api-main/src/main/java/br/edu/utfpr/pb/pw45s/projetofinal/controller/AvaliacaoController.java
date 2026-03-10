package br.edu.utfpr.pb.pw45s.projetofinal.controller;

import br.edu.utfpr.pb.pw45s.projetofinal.dto.AvaliacaoDTO;
import br.edu.utfpr.pb.pw45s.projetofinal.model.Amostra;
import br.edu.utfpr.pb.pw45s.projetofinal.model.Avaliacao;
import br.edu.utfpr.pb.pw45s.projetofinal.repository.AvaliacaoRepository;
import br.edu.utfpr.pb.pw45s.projetofinal.service.AmostraService;
import br.edu.utfpr.pb.pw45s.projetofinal.service.AvaliacaoService;
import br.edu.utfpr.pb.pw45s.projetofinal.shared.CrudController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("avaliacao")
public class AvaliacaoController extends CrudController<Long, Avaliacao, AvaliacaoDTO, AvaliacaoRepository, AvaliacaoService> {

    private final AmostraService amostraService;
    private final AvaliacaoService avaliacaoService;
    private final HttpServletRequest request;

    @Value("${app.security.mobile-api-key}")
    private String correctApiKey;

    public AvaliacaoController(AmostraService amostraService, AvaliacaoService avaliacaoService, HttpServletRequest request) {
        super(Avaliacao.class, AvaliacaoDTO.class);

        this.amostraService = amostraService;
        this.avaliacaoService = avaliacaoService;
        this.request = request;
    }

    @GetMapping("/{id}/completa")
    public ResponseEntity<Avaliacao> findAvaliacaoCompleta(@PathVariable Long id) {
        return service.findById(id)
                .map(avaliacao -> {
                    avaliacao.getAmostras().size();
                    return ResponseEntity.ok(avaliacao);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @PostMapping
    public ResponseEntity<Long> create(@RequestBody @Valid AvaliacaoDTO dto) {

        String requestApiKey = this.request.getHeader("X-API-Key");
        if (requestApiKey == null || !requestApiKey.equals(correctApiKey)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Chave de API inválida ou ausente.");
        }

        System.out.println("debug: " + dto);
        Avaliacao entity = toEntity(dto);

        if (entity.getAmostras() != null) {
            entity.getAmostras().forEach(amostra -> {
                amostra.setAvaliacao(entity);

                if (amostra.getCamadas() != null) {
                    amostra.getCamadas().forEach(camada -> {
                        camada.setAmostra(amostra);
                    });
                }
            });
        }

        Avaliacao savedEntity = service.save(entity);
        return new ResponseEntity<>(savedEntity.getId(), HttpStatus.CREATED);
    }
}