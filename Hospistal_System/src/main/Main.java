
import service.HospitalService;
import service.InternacaoService;
import service.RelatorioService;
import model.entidades.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static HospitalService hospitalService = new HospitalService();
    private static InternacaoService internacaoService = new InternacaoService();
    private static RelatorioService relatorioService = new RelatorioService();
    private static final String ARQUIVO_PACIENTES = "pacientes.csv";
    private static final String ARQUIVO_MEDICOS = "medicos.csv";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        hospitalService.carregarPacientesDeCsv(ARQUIVO_PACIENTES);
        hospitalService.carregarMedicosDeCsv(ARQUIVO_MEDICOS);

        while (true) {
            System.out.println("\n++++++ Bem Vindo(a) ao HCC (Health Care Center) ++++++");
            System.out.println("1. Menu do Paciente");
            System.out.println("2. Menu do Médico");
            System.out.println("3. Menu de Relatórios");
            System.out.println("0. Sair do Sistema");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    menuPaciente(scanner);
                    break;
                case 2:
                    menuMedico(scanner);
                    break;
                case 3:
                    menuRelatorios(scanner);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void menuPaciente(Scanner scanner) {
        System.out.println("\n--- Menu do Paciente ---");
        System.out.println("1. Cadastrar Novo Paciente");
        System.out.println("2. Agendar Consulta");
        System.out.println("3. Internar Paciente");
        System.out.println("9. Voltar");
        System.out.print("Escolha uma opção: ");

        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1:
                cadastrarNovoPaciente(scanner);
                break;
            case 2:
                agendarConsulta(scanner);
                break;
            case 3:
                internarPacientePeloMenu(scanner);
                break;
            case 9:
                return;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public static void menuMedico(Scanner scanner) {
        System.out.println("\n--- Menu do Médico ---");
        System.out.println("1. Cadastrar Novo Médico");
        System.out.println("9. Voltar");
        System.out.print("Escolha uma opção: ");

        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1:
                cadastrarNovoMedico(scanner);
                break;
            case 9:
                return;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public static void menuRelatorios(Scanner scanner) {
        System.out.println("\n--- Menu de Relatórios ---");
        System.out.println("1. Listar Pacientes");
        System.out.println("2. Listar Médicos");
        System.out.println("3. Listar Pacientes Internados");
        System.out.println("9. Voltar");
        System.out.print("Escolha uma opção: ");

        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1:
                relatorioService.imprimirPacientes(hospitalService.getPacientes());
                break;
            case 2:
                relatorioService.imprimirMedicos(hospitalService.getMedicos());
                break;
            case 3:
                relatorioService.imprimirPacientesInternados(hospitalService.getInternacoes());
                break;
            case 9:
                return;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public static void cadastrarNovoPaciente(Scanner scanner) {
        System.out.println("\n--- Cadastro de Novo Paciente ---");
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite a data de nascimento (AAAA-MM-DD): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());
        System.out.print("Tem plano de saúde? (s/n): ");
        boolean temPlano = scanner.nextLine().equalsIgnoreCase("s");
        String nivelPlano = null;
        if (temPlano) {
            System.out.print("Qual o nível do plano? (Premium/Gold): ");
            nivelPlano = scanner.nextLine();
        }
        Paciente novoPaciente = new Paciente(nome, cpf, dataNascimento, temPlano, nivelPlano);
        hospitalService.adicionarPaciente(novoPaciente);
        hospitalService.salvarPacientesEmCsv(ARQUIVO_PACIENTES);
        System.out.println("Paciente " + nome + " cadastrado com sucesso!");
    }

    public static void cadastrarNovoMedico(Scanner scanner) {
        System.out.println("\n--- Cadastro de Novo Médico ---");
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite a data de nascimento (AAAA-MM-DD): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());
        System.out.print("Digite o CRM: ");
        String crm = scanner.nextLine();
        System.out.print("Digite a especialidade (ex: CARDIOLOGIA, PEDIATRIA): ");
        Especialidade especialidade = Especialidade.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Digite o custo da consulta: ");
        double custoConsulta = scanner.nextDouble();
        scanner.nextLine();
        Medico novoMedico = new Medico(nome, cpf, dataNascimento, crm, especialidade, custoConsulta);
        hospitalService.adicionarMedico(novoMedico);
        hospitalService.salvarMedicosEmCsv(ARQUIVO_MEDICOS);
        System.out.println("Médico " + nome + " cadastrado com sucesso!");
    }

    private static void agendarConsulta(Scanner scanner) {
        System.out.println("\n--- Agendamento de Consulta ---");
        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();
        Paciente paciente = hospitalService.encontrarPacientePorCpf(cpf);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        System.out.println("Especialidades disponíveis: ");
        for (Especialidade e : Especialidade.values()) {
            System.out.println("- " + e);
        }
        System.out.print("Digite a especialidade desejada: ");
        Especialidade esp = Especialidade.valueOf(scanner.nextLine().toUpperCase());
        List<Medico> medicos = hospitalService.encontrarMedicosPorEspecialidade(esp);
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico encontrado para esta especialidade.");
            return;
        }

        System.out.println("Médicos disponíveis:");
        for (Medico m : medicos) {
            System.out.println("- Dr(a). " + m.getNome() + " (CRM: " + m.getCrm() + ")");
        }
        System.out.print("Digite o CRM do médico escolhido: ");
        String crm = scanner.nextLine();
        Medico medico = hospitalService.encontrarMedicoPorCrm(crm);
        if (medico == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        System.out.print("Digite a data e hora da consulta (AAAA-MM-DDTHH:MM): ");
        LocalDateTime dataHora = LocalDateTime.parse(scanner.nextLine());

        System.out.println("Agendamento ainda não implementado no serviço.");
    }

    private static void internarPacientePeloMenu(Scanner scanner) {
        System.out.println("\n--- Internar Paciente ---");
        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();
        Paciente paciente = hospitalService.encontrarPacientePorCpf(cpf);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        System.out.print("Digite o CRM do médico responsável: ");
        String crm = scanner.nextLine();
        Medico medico = hospitalService.encontrarMedicoPorCrm(crm);
        if (medico == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        internacaoService.internarPaciente(paciente, medico);
    }
}
