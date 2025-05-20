package desafio001;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Crud {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		int escolha;
		
		do {
			System.out.println("----------------------");
			mostrarMenu();
			
			escolha = verificarEscolha();
			
		} while(escolha != 5);
		
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
