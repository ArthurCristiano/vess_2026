package br.edu.utfpr.pb.pw45s.projetofinal.service;

import br.edu.utfpr.pb.pw45s.projetofinal.model.Camada;
import br.edu.utfpr.pb.pw45s.projetofinal.repository.CamadaRepository;
import br.edu.utfpr.pb.pw45s.projetofinal.shared.CrudService;
import org.springframework.stereotype.Service;

@Service
public class CamadaService extends CrudService<Long, Camada, CamadaRepository> {
}
