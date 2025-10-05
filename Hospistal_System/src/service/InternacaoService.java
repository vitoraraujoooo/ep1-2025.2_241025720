package service;

import model.entidades.Paciente;
import model.entidades.Medico;
import model.entidades.Internacao;

import model.service.StatusQuarto;
import java.util.Map;
import java.util.HashMap;

public class InternacaoService {
    private Map<Integer, StatusQuarto> mapaQuartos;
   
    public InternacaoService(){
        this.mapaQuartos = new HashMap<>();

        for(int i = 1; i<=6; i++){
            for(int j = 1; j<=10; j++){
                int numeroDoQuarto = (i * 100) + j;
                mapaQuartos.put(numeroDoQuarto, StatusQuarto.LIVRE);
            }
        }
    }
    public int encontrarQuartoLivre() {
        for (Map.Entry<Integer, StatusQuarto> entry : mapaQuartos.entrySet()) {
            if (entry.getValue() == StatusQuarto.LIVRE) {
                return entry.getKey(); 
            }
        }
    return -1;
    }
    public void internarPaciente(Paciente paciente, Medico medico){
        int quartoDisponivel = encontrarQuartoLivre();
        if(quartoDisponivel != -1){
            Internacao = nova Internacao

        }
    }

}

