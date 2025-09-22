package paciente;
public class paciente_especial {
    public static void main(String[] args) {
        paciente p = new paciente();
        p.Nome = "João";
        //p.idade = 30; // Erro: idade é private
        //p.CPF = 123456789; // Erro: CPF é protected
    }   
}
