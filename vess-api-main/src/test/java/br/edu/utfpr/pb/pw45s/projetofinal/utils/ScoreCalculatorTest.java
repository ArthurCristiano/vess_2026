package br.edu.utfpr.pb.pw45s.projetofinal.utils;

import br.edu.utfpr.pb.pw45s.projetofinal.model.Camada;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreCalculatorTest {

    @Test
    void calcular() {
        //(1 x 10)/25 + (3 x 15)/25 = Sq 2.2.
        double resultado = ScoreCalculator.calcular(List.of(
                new LayerData(10F, 1F),
                new LayerData(15F, 3F)
        ));
        assertEquals(2.2, resultado, 0.01);
    }
}