package model.entidades;

import java.time.LocalDateTime;

public class Consulta {
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime dataHora;
    private String tipoConsulta;
    private String local;
    private String estado;{
        
    }

    public Consulta(Paciente paciente, Medico medico, LocalDateTime dataHora, String tipoConsulta, String estado){
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
        this.tipoConsulta = tipoConsulta;
        this.estado = "agendada";

    }
   


}