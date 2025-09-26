import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class ConsultaService {

    // Simula um banco de dados de médicos
    private final Map<String, Medico> repositorioMedicos;

    public ConsultaService() {
        this.repositorioMedicos = new HashMap<>();
    }

    public void cadastrarMedico(String nome, String cpf, int idade, String crm, String especialidade) {
        if (!repositorioMedicos.containsKey(cpf)) {
            Medico novoMedico = new Medico(nome, cpf, idade, crm, especialidade);
            repositorioMedicos.put(cpf, novoMedico);
            System.out.println("Médico " + nome + " cadastrado com sucesso.");
        } else {
            System.out.println("Erro: Médico com o CPF " + cpf + " já existe.");
        }
    }

    /**
     * Tenta marcar uma consulta na agenda de um médico específico.
     * @param cpfMedico O CPF do médico.
     * @param data A data da consulta.
     * @param horario O horário da consulta.
     * @param paciente O objeto Paciente que está marcando a consulta.
     * @return true se a consulta foi marcada com sucesso, false caso contrário.
     */
    public boolean marcarConsulta(String cpfMedico, LocalDate data, LocalTime horario, Paciente paciente) {
        Medico medico = repositorioMedicos.get(cpfMedico);

        if (medico == null) {
            System.out.println("Erro: Médico com o CPF " + cpfMedico + " não encontrado.");
            return false;
        }

        // Delega a tarefa de marcar o horário para a agenda do médico
        return medico.getAgenda().marcarConsulta(data, horario, paciente);
    }
    
    // Método para exibir horários disponíveis de um médico
    public void exibirHorariosDisponiveis(String cpfMedico, DiaDaSemana dia) {
        Medico medico = repositorioMedicos.get(cpfMedico);
        if (medico != null) {
            System.out.println("Horários disponíveis para o Dr. " + medico.getNome() + " na " + dia + ":");
            medico.getAgenda().getHorariosDisponiveis(dia)
                  .forEach(h -> System.out.println("- " + h));
        } else {
            System.out.println("Médico não encontrado.");
        }
    }
}