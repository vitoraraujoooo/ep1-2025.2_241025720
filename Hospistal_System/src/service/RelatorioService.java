package service;

import model.entidades.Internacao;
import model.entidades.Medico;
import model.entidades.Paciente;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class RelatorioService {

    public void imprimirPacientes(List<Paciente> pacientes) {
        System.out.println("\n--- Relatório de Pacientes Cadastrados ---");
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }
        for (Paciente paciente : pacientes) {
            System.out.println("Nome: " + paciente.getNome() + " | CPF: " + paciente.getCpf() + " | Idade: " + paciente.getIdade());
        }
    }

    public void imprimirMedicos(List<Medico> medicos) {
        System.out.println("\n--- Relatório de Médicos Cadastrados ---");
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
            return;
        }
        for (Medico medico : medicos) {
            System.out.println("Nome: " + medico.getNome() + " | CRM: " + medico.getCrm() + " | Especialidade: " + medico.getEspecialidade());
        }
    }

    public void imprimirPacientesInternados(List<Internacao> internacoes) {
        System.out.println("\n--- Relatório de Pacientes Internados ---");
        boolean encontrou = false;
        for (Internacao internacao : internacoes) {
            if (internacao.getDataSaida() == null) {
                long diasInternado = ChronoUnit.DAYS.between(internacao.getDataEntrada(), LocalDate.now());
                System.out.println("Paciente: " + internacao.getPaciente().getNome() + " | Quarto: " + internacao.getNumeroQuarto() + " | Dias de internação: " + diasInternado);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum paciente internado no momento.");
        }
    }
}