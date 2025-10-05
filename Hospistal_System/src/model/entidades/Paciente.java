package model.entidades;
import model.entidades.Prontuario;
import com.sun.source.tree.NewArrayTree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa{
    private boolean plano_saude;
    private List<Consulta>historiConsulta;
    private Prontuario historicoProntuario;
    private List<SistemPagamento> historicoPagamento;
    private String nivel_plano;
    private float porcentagem_desconto;

    public Paciente(string nome, LocalDate datadenascimento, string cpf, Prontuario historicoProntuario, boolean plano_saude, String nivel_plano, boolean plano_saude){
        super(nome, cpf, datadenascimento);
        this.nome = nome;
        this.datadenascimento = datadenascimento;
        this.cpf = cpf;

    
        this.historicoProntuario = new Prontuario();
        this.historicoPagamento = newArrayList<>();
        this.historiConsulta = newArrayList<>();

        this.plano_saude = plano_saude;
        this.nivel_plano = nivel_plano;
}




}