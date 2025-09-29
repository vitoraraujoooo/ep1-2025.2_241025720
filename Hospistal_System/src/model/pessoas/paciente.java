import



public class Paciente extends Pessoa{
    private String nome;
    private int idade;
    private int cpf;
    //Prontuário;
}
public Paciente (string nome, int idade, int cpf, list Prontuário){
    this.nome = nome;
    this.idade = idade;
    this.cpf = cpf;
    this.Prontuário = Prontuário;
}

public void MarcarConsulta(){

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





