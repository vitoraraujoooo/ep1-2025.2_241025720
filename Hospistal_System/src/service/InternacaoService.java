package service;

import model.entidades.Internacao;
import model.entidades.Medico;
import model.entidades.Paciente;
import model.entidades.StatusQuarto;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class InternacaoService {
    private Map<Integer, StatusQuarto> mapaQuartos;

    public InternacaoService() {
        this.mapaQuartos = new HashMap<>();
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 10; j++) {
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

    public Internacao internarPaciente(Paciente paciente, Medico medico) {
        int quartoDisponivel = encontrarQuartoLivre();

        if (quartoDisponivel != -1) {
            Internacao novaInternacao = new Internacao(paciente, medico, LocalDate.now(), quartoDisponivel);
            paciente.getProntuario().adicionarInternacao(novaInternacao);
            this.mapaQuartos.put(quartoDisponivel, StatusQuarto.OCUPADO);
            System.out.println("Paciente " + paciente.getNome() + " internado com sucesso no quarto " + quartoDisponivel);
            return novaInternacao;
        } else {
            System.out.println("Não há quartos disponíveis para internação.");
            return null;
        }
    }
}