package service;

import model.entidades.Especialidade;
import model.entidades.Internacao;
import model.entidades.Paciente;
import model.entidades.Medico;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

public class HospitalService {
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<Internacao> internacoes;

    public HospitalService() {
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.internacoes = new ArrayList<>();
    }

    public void adicionarPaciente(Paciente paciente) { this.pacientes.add(paciente); }
    public void adicionarMedico(Medico medico) { this.medicos.add(medico); }
    public void adicionarInternacao(Internacao internacao) { this.internacoes.add(internacao); }

    public List<Paciente> getPacientes() { return this.pacientes; }
    public List<Medico> getMedicos() { return this.medicos; }
    public List<Internacao> getInternacoes() { return this.internacoes; }

    public Paciente encontrarPacientePorCpf(String cpf) {
        for (Paciente p : pacientes) { if (p.getCpf().equals(cpf)) return p; }
        return null;
    }

    public Medico encontrarMedicoPorCrm(String crm) {
        for (Medico m : medicos) { if (m.getCrm().equals(crm)) return m; }
        return null;
    }

    public List<Medico> encontrarMedicosPorEspecialidade(Especialidade especialidade) {
        return medicos.stream()
                .filter(m -> m.getEspecialidade() == especialidade)
                .collect(Collectors.toList());
    }

    public void salvarPacientesEmCsv(String nomeArquivo) {
        try (PrintWriter escritor = new PrintWriter(new FileWriter(nomeArquivo))) {
            escritor.println("nome;cpf;dataNascimento;temPlano;nivelPlano");
            for (Paciente paciente : this.pacientes) {
                String nivelPlano = paciente.getPlanoDeSaude() != null ? paciente.getPlanoDeSaude().getNivelPlano() : "N/A";
                String linha = paciente.getNome() + ";" + paciente.getCpf() + ";" + paciente.getDatadenascimento() + ";" + paciente.temPlanoSaude() + ";" + nivelPlano;
                escritor.println(linha);
            }
        } catch (IOException e) { System.err.println("Erro ao salvar pacientes: " + e.getMessage()); }
    }

    public void carregarPacientesDeCsv(String nomeArquivo) {
        try {
            if (!Files.exists(Paths.get(nomeArquivo))) return;
            List<String> linhas = Files.readAllLines(Paths.get(nomeArquivo));
            if (linhas.isEmpty() || linhas.size() == 1) return;
            linhas.remove(0);
            for (String linha : linhas) {
                String[] dados = linha.split(";");
                if (dados.length < 5) continue;
                Paciente paciente = new Paciente(dados[0], dados[1], LocalDate.parse(dados[2]), Boolean.parseBoolean(dados[3]), dados[4].equals("N/A") ? null : dados[4]);
                this.adicionarPaciente(paciente);
            }
        } catch (Exception e) { System.err.println("Erro ao carregar pacientes: " + e.getMessage()); }
    }

    public void salvarMedicosEmCsv(String nomeArquivo) {
        try (PrintWriter escritor = new PrintWriter(new FileWriter(nomeArquivo))) {
            escritor.println("nome;cpf;dataNascimento;crm;especialidade;custoConsulta");
            for (Medico medico : this.medicos) {
                String linha = medico.getNome() + ";" + medico.getCpf() + ";" + medico.getDatadenascimento() + ";" + medico.getCrm() + ";" + medico.getEspecialidade() + ";" + medico.getCustoConsulta();
                escritor.println(linha);
            }
        } catch (IOException e) { System.err.println("Erro ao salvar médicos: " + e.getMessage()); }
    }

    public void carregarMedicosDeCsv(String nomeArquivo) {
        try {
            if (!Files.exists(Paths.get(nomeArquivo))) return;
            List<String> linhas = Files.readAllLines(Paths.get(nomeArquivo));
            if (linhas.isEmpty() || linhas.size() == 1) return;
            linhas.remove(0);
            for (String linha : linhas) {
                String[] dados = linha.split(";");
                if (dados.length < 6) continue;
                Medico medico = new Medico(dados[0], dados[1], LocalDate.parse(dados[2]), dados[3], Especialidade.valueOf(dados[4]), Double.parseDouble(dados[5]));
                this.adicionarMedico(medico);
            }
        } catch (Exception e) { System.err.println("Erro ao carregar médicos: " + e.getMessage()); }
    }
}