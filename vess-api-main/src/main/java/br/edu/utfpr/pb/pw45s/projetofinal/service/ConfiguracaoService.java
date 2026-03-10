package br.edu.utfpr.pb.pw45s.projetofinal.service;

import br.edu.utfpr.pb.pw45s.projetofinal.dto.ConfiguracaoDTO;
import br.edu.utfpr.pb.pw45s.projetofinal.model.Configuracao;
import br.edu.utfpr.pb.pw45s.projetofinal.repository.ConfiguracaoRepository;
import br.edu.utfpr.pb.pw45s.projetofinal.shared.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfiguracaoService extends CrudService<Long, Configuracao, ConfiguracaoRepository> {

    public List<Configuracao> findAll() {
        return repository.findAll();
    }
}
