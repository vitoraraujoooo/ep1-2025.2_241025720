package service;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class{
    public static void main_hospital_system{
        System.out.println("++++++Bem Vindo(a) ao HCC(Health Care Center)++++++");
        System.out.println("Você é Paciente? Selecione a Opção abaixo");
        System.out.println("1. Paciente");
        System.out.println("Você é Médico(a)? Selecione a Opção abaixo");
        System.out.println("2.Médico");

    }
    
    Scanner scanner = new Scanner(System.in);


    int opcao = scanner.nextInt();


    
    if(opçao == 1){
        System.out.println("Digite o seu nome");
        String nome = scanner.nextline();


        System.out.println("Digite sua Idade");
        int idade = 0;
        try {
            idade = nextline();
            
        } catch (java.util.InputMismatchException e) {
            System.err.println("Erro: Digite uma idade inteira");
            scanner.close();
            return;
        }

        System.out.println("Digite seu CPF sem pontos e traços");
        cpf = scanner.nextline();
        



    }else if(opçao == 2){

    }
}