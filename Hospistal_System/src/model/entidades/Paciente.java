package model.entidades;
import Prontuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa{
    private boolean plano_saude;
    private List<Consulta>historiConsulta;
    private List<Prontuario>historicoProntuario;
    private List<Pagamento> historicoPagamento;
    private String nivel_plano;
    private float porcentagem_desconto;
}

public Paciente (string nome, int idade, int cpf, List historicoProntuario, boolean plano_saude, String nivel_plano, boolean plano_saude){
    this.nome = nome;
    this.idade = idade;
    this.cpf = cpf;
    this.historicoProntuario = historicoProntuario;
    this.plano_saude = plano_saude;
    this.nivel_plano = nivel_plano;
}


public void MarcarConsulta(){
    if(    )
    //verificar médicos disponiveis+ horários
    // se medico x disponivel
    // escolher medico x
    //listar horários disponiveis do medico x;
    listarHorariosDisponiveis();

    //escolher horario medico x
    // verificar de consulta foi marcada
    //return consulta marcada
    //voltar ao inicio

}

public void DesmarcarConsulta(){
    //tem consulta marcada?
    //desmarcar consulta
    //remover consulta da agenda de hoararios medico

}


public void AplicarDesconto(){
    if(plano_saude == true){
        System.out.println("Qual seu plano?");
        if(nivel_plano == "Premium"){
            porcentagem_desconto += 0.2;
        }else if(nivel_plano == "Gold"){
            porcentagem_desconto += 0.4;
        }else if(nivel_plano == 'Senior'){
            porcentagem_desconto += 0.6;
        }
    }else
        return 0;
    
}


public String toCsvString() {
        return nome + ";" + idade + ";" + cpf;
    }


