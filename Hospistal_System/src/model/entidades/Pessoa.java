package model.entidades;
import java.time.LocalDate;
import java.time.Period;
public abstract class Pessoa {
    private String nome;
    private String cpf;
    private LocalDate datadenascimento;

    public  Pessoa(String nome, String cpf, LocalDate datadenascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.datadenascimento = datadenascimento;
    }

    
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDatadenascimento() {
        return datadenascimento;
    }
    public int getIdade() {
        return Period.between(getDatadenascimento(), LocalDate.now()).getYears();
    }
}