package model.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Exame {
    private String tipo;
    private LocalDate datadoexame;
    private String resultado;
    private double custo;

    private static List<Exame> exames = new ArrayList<>();

    public Exame(String tipo, LocalDate datadoexame, String resultado, double custo){
        this.tipo = tipo;
        this.datadoexame = datadoexame;
        this.resultado = resultado;
        this.custo = custo;
    } 

    public static void criaexame(Exame exame){
        exames.add(exame);
    }

    public static Exame BuscaExamePeloTipo(String tipo){
         return exames.stream()
                     .filter(exame -> exame.getTipo().equalsIgnoreCase(tipo))
                     .findFirst()
                     .orElse(null); 
    }

        public static void removerExame(String tipo) {
        exames.removeIf(exame -> exame.getTipo().equalsIgnoreCase(tipo));
    }
    public static List<Exame> listarExames() {
        return new ArrayList<>(exames);
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataDoExame() {
        return datadoexame;
    }

    public void setDataDoExame(LocalDate datadoexame) {
        this.datadoexame = datadoexame;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
}


