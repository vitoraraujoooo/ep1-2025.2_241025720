package model.entidades;
import model.entidades.Especialidade;
import java.time.LocalDateTime;

public class Consulta {
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime dataHora;
    private String tipoConsulta;
    private String local;
    private String status;

    public Consulta(Paciente paciente, Medico medico, LocalDateTime dataHora, String tipoConsulta) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
        this.tipoConsulta = tipoConsulta;
        this.status = "agendada";
        this.local = "Consultório " + medico.getEspecialidade().toString();
    }

    public Paciente getPaciente() { return paciente; }
    public Medico getMedico() { return medico; }
    public LocalDateTime getDataHora() { return dataHora; }
    public String getTipoConsulta() { return tipoConsulta; }
    public String getLocal() { return local; }
    public String getStatus() { return status; }
}