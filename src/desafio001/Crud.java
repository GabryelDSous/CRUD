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

			chamandoMetodos(escolha);
			
		} while(escolha != 5);
		
		System.out.println("----------------------");
		System.out.println("Fim programa");
		
	}
	
	private static void removerPessoa() {
		System.out.println("----------------------");
		if(Pessoa.size() == 0) System.out.println("Nenhuma pessoa cadastrada!");
		else {
			int cont = 0;
			for(Pessoa pessoa : Pessoa) {
				cont++;
				System.out.printf("[%d] - %s%n", cont, pessoa.getNome());
			}
			System.out.println("----------------------");
			System.out.print("Informe o índice da pessoa a ser removido: ");
			int indice;
			do {
				try {
					indice = scanner.nextInt();
					if(indice < 0 || indice > Pessoa.size()) System.out.println("Informe um dos índice listados: ");
					else {
						Pessoa.remove(indice-1);
						break;
					}
				} catch(InputMismatchException e) {
					System.out.println("Informe um dos índice listados: ");
					scanner.nextLine();
				}
			} while(true);
		}
	}
	
	private static void mudaSexo(int index) {
		System.out.println("----------------------");
		System.out.print("Informe a novo sexo: ");
		String sexo = verificarSexo();
		
		String antigoSexo = Pessoa.get(index).getSexo().getSexo();
		Pessoa.get(index).setSexo(sexo.equalsIgnoreCase("F")?Sexo.FEMININO:Sexo.MASCULINO);
		
		System.out.println(antigoSexo + " -> " + Pessoa.get(index).getSexo().getSexo());
	}
	
	private static void mudarIdade(int index) {
		System.out.println("----------------------");
		System.out.print("Informe a novo idade: ");
		int idade = verificadorIdade();
		
		int idadeAntiga = Pessoa.get(index).getIdade();
		Pessoa.get(index).setIdade(idade);
		
		System.out.println("----------------------");
		System.out.println(idadeAntiga + " -> " + idade);
	}
	
	private static void mudarNome(int index) {
		
		System.out.println("----------------------");
		System.out.print("Informe o novo nome: ");
		String nome;
		do {
			nome = scanner.nextLine();
		} while(!nome.matches("[\\p{L}\\s]+"));
		
		String nomeAntigo = Pessoa.get(index).getNome();
		Pessoa.get(index).setNome(nome);
		System.out.println("----------------------");
		System.out.println(nomeAntigo + " -> " + nome);
	}
	
	private static void atualizarDados() {
		if(Pessoa.size() == 0) {
			System.out.println("----------------------");
			System.out.println("Nenhuma pessoa cadastrada!");
		}
		else {
			System.out.println("----------------------");
			int cont = 0;
			for(Pessoa pessoa : Pessoa) {
				cont++;
				System.out.printf("[%d] - %s%n", cont, pessoa.getNome());
			}
			
			System.out.println("----------------------");
			
			System.out.print("índice do usuário a ser modificado: ");
			int indice;
			do {
				try {
					indice = scanner.nextInt();
					if(indice < 1 || indice > Pessoa.size()+1) System.out.print("Informe um dos índice listados: ");
					else break;
				} catch(InputMismatchException e) {
					System.out.print("Informe um dos índice numérico: ");
					scanner.nextLine();
				}
			} while(true);
			int escolha = 0;
			do {
				System.out.println("----------------------");
				System.out.println("O que deseja modificar sobre o usuário " + Pessoa.get(indice-1).getNome().toUpperCase() + "?");
				System.out.println("[1] - Nome");
				System.out.println("[2] - Idade");
				System.out.println("[3] - Sexo");
				System.out.println("[4] - Sair");
				System.out.println("----------------------");
				System.out.print("Escolha: ");
				do {
					try {
						escolha = scanner.nextInt();
						if(escolha < 1 || escolha > 4) System.out.print("Informe um valor do menu: ");
						else break;
					} catch(InputMismatchException e) {
						System.out.print("Informe um dos índice numérico: ");
						scanner.nextLine();
					}
					
				}while(true);
				switch(escolha) {
				case 1 -> mudarNome(indice-1);
				case 2 -> mudarIdade(indice-1);
				case 3 -> mudaSexo(indice-1);
				
				}
			}while(escolha != 4);
		}
	}
	
	private static void listarPessoa() {
		if(Pessoa.size() == 0) {
			System.out.println("----------------------");
			System.out.println("Nenhuma pessoa cadastrada!");
		}
		else for(Pessoa pessoa : Pessoa) System.out.println(pessoa.toString());
	}
	
	private static String verificarSexo() {
		String sexo;
		scanner.nextLine();
		do {
			 sexo = scanner.nextLine();
			 if(!sexo.equalsIgnoreCase("F") && !sexo.equalsIgnoreCase("M")) System.out.print("Informe apenas [F/M]: ");
			 else return sexo;
		} while(true);
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
		int idade = verificadorIdade();
		pessoa.setIdade(idade);
		
		System.out.println("----------------------");
		System.out.print("Informe seu sexo [F/M]: ");
		String sexo = verificarSexo();
		
		
		
		if(sexo.equalsIgnoreCase("F")) pessoa.setSexo(Sexo.FEMININO);	
		else if(sexo.equalsIgnoreCase("M")) pessoa.setSexo(Sexo.MASCULINO);	
		System.out.println("----------------------");
		Pessoa.add(pessoa);
		System.out.printf("%s cadastrado com sucesso!%n", nome.toUpperCase());
	}
	
	private static int verificadorIdade() {
		int idade;
		do {
			try {
				idade = scanner.nextInt();
				
				if(idade >= 0 && idade <= 130) return idade;
				else System.out.print("Informe uma idade entre 0 e 130 anos: ");
			} catch(InputMismatchException e) {
				System.out.print("Informe em padrão numérico: ");
				scanner.nextLine();
			}
		} while(true);
	}
	
	private static void chamandoMetodos(int escolha) {
		switch(escolha) {
		case 1 -> cadastrarPessoa();
		case 2 -> listarPessoa();
		case 3 -> atualizarDados();
		case 4 -> removerPessoa();
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
