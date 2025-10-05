package model.entidades;
import model.entidades.Consulta;
import java.util.ArrayList;
import java.util.List;
import model.entidades.Internaçao;

public class Prontuario{
    private Paciente paciente;
    private List<Consulta> historicoconsulta;
    private List<Internaçao> historicointernaçao;

    public Prontuario(){
    this.historicoconsulta = new ArrayList<>();
    this.historicointernaçao = new ArrayList<>();
    }
//cria um prontuário como uma lista com o historico de consulta e de internação

    public void adicionaNovaConsulta(Consulta novConsulta){
    this.historicoconsulta.add(novConsulta);
    }




}