package model.entidades;

import java.time.LocalDate;

public class Internacao {
    private Paciente paciente;
    private Medico medicoResponsavel;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private int numeroQuarto;

    public Internacao(Paciente paciente, Medico medicoResponsavel, LocalDate dataEntrada, int numeroQuarto) {
        this.paciente = paciente;
        this.medicoResponsavel = medicoResponsavel;
        this.dataEntrada = dataEntrada;
        this.numeroQuarto = numeroQuarto;
        this.dataSaida = null;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Paciente getPaciente() { return paciente; }
    public Medico getMedicoResponsavel() { return medicoResponsavel; }
    public int getNumeroQuarto() { return numeroQuarto; }
}