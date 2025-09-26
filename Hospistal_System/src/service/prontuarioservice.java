import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import Paciente.src.model.pessoas;


public class ProntuarioService {
    private final Map<String, Paciente> repositorioPacientes;
    private static final String NOME_ARQUIVO = "prontuarios.txt";

    public ProntuarioService() {
        this.repositorioPacientes = new HashMap<>();
        carregarDados(); // Tenta carregar os dados ao iniciar o serviço
    }
