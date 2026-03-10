package br.edu.utfpr.pb.pw45s.projetofinal.controller;

import br.edu.utfpr.pb.pw45s.projetofinal.utils.ScoreCalculator;
import br.edu.utfpr.pb.pw45s.projetofinal.utils.ScoreRequest;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("score")
public class ScoreController {

    @PutMapping("block")
    public double getBlockScore(@RequestBody ScoreRequest request) {
        return ScoreCalculator.calcular(request.getCamadas());
    }
}
