package model.entidades;
import java.util.ArrayList;
import java.util.List;

public class Prontuario{
    private Paciente paciente;
    private List<Consulta> historicoConsulta;
    private List<Internacao> historicoInternacao;

    public Prontuario(){
        this.historicoConsulta = new ArrayList<>();
        this.historicoInternacao = new ArrayList<>();
    }
    //cria um prontuário como uma lista com o historico de consulta e de internação

    public void adicionaNovaConsulta(Consulta novConsulta){
        this.historicoConsulta.add(novConsulta);
    }
    public void adicionarInternacao(Internacao novaInternacao) {
        this.historicoInternacao.add(novaInternacao);
    }   
    public List<Consulta> getHistoricoConsulta() {
        return historicoConsulta;
    }
    public List<Internacao> getHistoricoInternacao() {
        return historicoInternacao;
    }


}