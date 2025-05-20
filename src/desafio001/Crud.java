package desafio001;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Crud {
	
	private static Scanner scanner = new Scanner(System.in);
	
	private static ArrayList<Pessoa> Pessoa = new ArrayList<Pessoa>();
	
	
	
	public static void main(String[] args) {
		
		
		int escolha;
		
		do {
			System.out.println("----------------------");
			mostrarMenu();
			
			escolha = verificarEscolha();
			System.out.println("----------------------");
			chamandoMetodos(escolha);
			
		} while(escolha != 5);
		
		System.out.println("Fim programa");
		
	}
	
	private static void listarPessoa(ArrayList<Pessoa> Pessoa) {
		if(Pessoa.size() == 0) System.out.println("Nenhuma pessoa cadastrada!");
		else {
			for(Pessoa pessoa : Pessoa) {
				System.out.println(pessoa.toString());
			}
		}
	}
	
	private static void cadastrarPessoa() {
		
		Pessoa pessoa = new Pessoa();
		scanner.nextLine();
		System.out.println("Bem-vindo(a) vamos iniciar o seu cadastro!");
		System.out.println("----------------------");
		
		System.out.print("Qual é o seu nome: ");
		String nome;
		do {
			nome = scanner.nextLine();
			if(!nome.matches("[\\p{L}\\s]+")) {
				
				System.out.print("Seu nome não deve conter números: ");
				
			} else break;
		} while(true);
		
		pessoa.setNome(nome);
		
		System.out.println("----------------------");
		System.out.print("Qual é sua idade: ");
		int idade = 0;
		boolean controle = false;
		do {
			try {
				idade = scanner.nextInt();
				
				if(idade >= 0 && idade <= 130) controle = true;
				else System.out.print("Informe uma idade entre 0 e 130 anos: ");
			} catch(InputMismatchException e) {
				System.out.print("Informe em padrão numérico: ");
				scanner.nextLine();
			}
		} while(!controle);
		
		pessoa.setIdade(idade);
		
		System.out.println("----------------------");
		System.out.print("Informe seu sexo [F/M]: ");
		String sexo;
		scanner.nextLine();
		do {
			 sexo = scanner.nextLine();
			 if(!sexo.equalsIgnoreCase("F") && !sexo.equalsIgnoreCase("M")) {
				 System.out.print("Informe apenas [F/M]: ");
				 
			 }
			 else break;
		} while(true);
		
		if(sexo.equalsIgnoreCase("F")) pessoa.setSexo(Sexo.FEMININO);	
		else if(sexo.equalsIgnoreCase("M")) pessoa.setSexo(Sexo.MASCULINO);	
		System.out.println("----------------------");
		Pessoa.add(pessoa);
		System.out.printf("%s cadastrado com sucesso!%n", nome.toUpperCase());
	}
	
	private static void chamandoMetodos(int escolha) {
		switch(escolha) {
		case 1 -> cadastrarPessoa();
		case 2 -> listarPessoa(Pessoa);
		}
	}
	
	private static int verificarEscolha() {
		int escolha;
		do {
			try {
				escolha = scanner.nextInt();
				if(escolha >= 1 && escolha <= 5) return escolha;
				else System.out.print("Informe uma das opções do menu: ");
			} catch(InputMismatchException e) {
				System.out.print("Informe uma das opções do menu: ");
				scanner.nextLine();
			}
		} while(true);
	}
	
	private static void mostrarMenu() {
		System.out.println("[1] Cadastrar pessoa");
		System.out.println("[2] Listar pessoas");
		System.out.println("[3] Atualizar dados de uma pessoa");
		System.out.println("[4] Remover pessoa");
		System.out.println("[5] Sair");
		System.out.println("----------------------");
		System.out.print("ESCOLHA: ");
	}

}
