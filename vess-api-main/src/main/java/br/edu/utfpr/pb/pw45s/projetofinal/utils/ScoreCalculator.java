package br.edu.utfpr.pb.pw45s.projetofinal.utils;

import br.edu.utfpr.pb.pw45s.projetofinal.model.Camada;

import java.util.List;

public class ScoreCalculator {

    public static double calcular(List<LayerData> camadas) {
        int sum = 0;
        int profundidadeTotal = 0;

        for (LayerData camada : camadas) {
            sum += (int) (camada.getLength() * camada.getScore());
            profundidadeTotal += camada.getLength();
        }

        return (double) sum / profundidadeTotal;
    }
}
