package service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



class SlotHorario{
//atributos dos slot horário de um certo dia
    private final LocalTime Hora;
    private boolean estaOcupado;

    //inicializando os atributos
    public SlotHorario(LocalTime Hora){
        this.Hora = Hora;
        this.estaOcupado = false;
    }

    //inicializando na memoria
    public LocalTime getHora(){
        return Hora;
    }
    public boolean isestaOcupado(){
        return estaOcupado;
    }

    //metodos para mudança de estado
    public void Liberar(){
        this.estaOcupado = false;
    }

    public void Reservar(){
        this.estaOcupado = true;
    }

    // Método para retornar o status como String
    public String getStatusString() {
        return estaOcupado ? "Ocupado" : "Livre";
    }

}

public class Agenda_medico{
    private Map<DayOfWeek, List<SlotHorario>> agendaSemanal;
    
    public Agenda_medico(){
        this.agendaSemanal = new HashMap<>();

        for(DayOfWeek dia : DayOfWeek.values()){
            if (dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY){
                continue;
            }
            agendaSemanal.put(dia, new ArrayList<>()); 

        }
    }

 //metodo para incializar oslot do dia   

private void listarHorariosDisponiveis() {
    LocalTime inicio = LocalTime.of(8, 0); 
  
    LocalTime fim = LocalTime.of(18, 0);  

    for (DayOfWeek dia : agendaSemanal.keySet()) {

        LocalTime horaAtual = inicio;

        
        while (horaAtual.isBefore(fim)) {
            SlotHorario novoSlot = new SlotHorario(horaAtual);
            agendaSemanal.get(dia).add(novoSlot);
            horaAtual = horaAtual.plusMinutes(30);
        }
    }
}


public void exportarParaCSV() {

    String DIRETORIO = "Dados";
    String NOME_ARQUIVO = "Agenda_medico.csv";
    Path caminhoDiretorio = Paths.get("C:\\Trabalhos\\OO25.2\\Hospistal_System\\Dados\\Agenda_medico.csv");

    try {
        
        if (!Files.exists(caminhoDiretorio)) {
            Files.createDirectories(caminhoDiretorio);
        }

        try (PrintWriter escritor = new PrintWriter(new FileWriter(DIRETORIO + "/" + NOME_ARQUIVO, false))) {
            
            // Escreve o CABEÇALHO do arquivo CSV
            escritor.println("Dia_da_Semana;Hora;Status");

            // 3. Itera sobre a agenda semanal
            for (Map.Entry<DayOfWeek, List<SlotHorario>> entrada : agendaSemanal.entrySet()) {
                DayOfWeek dia = entrada.getKey();
                List<SlotHorario> slots = entrada.getValue();

                // 4. Itera sobre os slots daquele dia
                for (SlotHorario slot : slots) {
                    
                    String linha = String.format("%s;%s;%s",
                        dia.toString(),
                        slot.getHora().toString(),
                        slot.getStatusString()
                    );
                    escritor.println(linha);
                }
            }

            System.out.println("✅ Agenda salva com sucesso em " + DIRETORIO + "/" + NOME_ARQUIVO);
        }

    } catch (IOException e) {
        System.err.println("❌ Erro ao salvar a agenda: " + e.getMessage());
        e.printStackTrace();
    }
}



















}