package model.entidades;
import model.service.InternacaoService;
import java.time.LocalDate;
import model.entidades.Paciente;
import model.entidades.Medico;
public class Internacao{
    private Paciente paciente;
    private Medico medicoResponsavel;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private int numeroQuarto;

    public Internacao(Paciente paciente, Medico medicoResponsavel, LocalDate dataEntrada, LocalDate dataSaida, int numeroQuarto){
        this.paciente = paciente;
        this.medicoResponsavel = medicoResponsavel;
        this.dataEntrada = dataEntrada;
        this.dataSaida = null;
        this.numeroQuarto = numeroQuarto;
    }
    
}
