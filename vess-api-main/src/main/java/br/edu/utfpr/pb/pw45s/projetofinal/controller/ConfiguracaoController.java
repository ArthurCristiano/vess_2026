package br.edu.utfpr.pb.pw45s.projetofinal.controller;

import br.edu.utfpr.pb.pw45s.projetofinal.dto.ConfiguracaoDTO;
import br.edu.utfpr.pb.pw45s.projetofinal.model.Configuracao;
import br.edu.utfpr.pb.pw45s.projetofinal.repository.ConfiguracaoRepository;
import br.edu.utfpr.pb.pw45s.projetofinal.service.ConfiguracaoService;
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
@RequestMapping("configuracao")
public class ConfiguracaoController extends CrudController<Long, Configuracao, ConfiguracaoDTO, ConfiguracaoRepository, ConfiguracaoService> {

    @Value("${app.security.mobile-api-key}")
    private String correctApiKey;

    private final HttpServletRequest request;

    public ConfiguracaoController(HttpServletRequest request) {
        super(Configuracao.class, ConfiguracaoDTO.class);
        this.request = request;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ConfiguracaoDTO> findById(@PathVariable Long id) {
        List<Configuracao> configs = service.findAll();
        if (!configs.isEmpty()) {
            return ResponseEntity.ok(toDto(configs.getFirst()));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    @PostMapping
    public ResponseEntity<Long> create(@RequestBody @Valid ConfiguracaoDTO dto) {
        validateApiKey();
        return super.create(dto);
    }
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Long> update(@RequestBody @Valid ConfiguracaoDTO dto, @PathVariable Long id) {
        validateApiKey();
        return super.update(dto, id);
    }

    private void validateApiKey() {
        String requestApiKey = this.request.getHeader("X-API-Key");
        if (requestApiKey == null || !requestApiKey.equals(correctApiKey)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Chave de API (X-API-Key) inválida ou ausente.");
        }
    }
}