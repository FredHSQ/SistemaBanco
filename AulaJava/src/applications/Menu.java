package applications;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import contas.Conta;
import exceptions.ContaExceptions;
import usuario.Usuario;

public class Menu {
	static Scanner sc =new Scanner(System.in);
	//função para criação do menu inicial
	public static void bemVindo() {
		linha("|Bem vindo ao banco Justice League|"); // chama função "linha()" usando a maior frase do que foi escrito no menu
		System.out.println("\n|Bem vindo ao banco Justice League|");
		linha("|Bem vindo ao banco Justice League|"); // chama função "linha()" usando a maior frase do que foi escrito no menu
		System.out.println();
		
		
	}
	
	public static void menuMovimentacao(Conta conta) throws ContaExceptions, IOException {
		int i = 1;
		do {
			System.out.println(
					"Você gostaria de fazer qual tipo de movimentação?\n1 - Depositar\n2 - Sacar\n3 - Transferir\n4 - Sair");
			int opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("Digite o valor que gostaria de depositar: ");
				Double valor = sc.nextDouble();
				Menu.linha("Você gostaria de fazer qual tipo de movimentação?");
				System.out.println();
				try {
					conta.depositar(valor);
					System.out.println("Gostaria de realizar outra transação?\n1 - Sim\n2 - Não");
					i = sc.nextInt();
					if (i != 1 && i != 2) {
						System.out.println("O valor digitado não é válido. Repita por favor.");
						Menu.linha("O valor digitado não é válido. Repita por favor.");
						System.out.println();
						i = 1;
					}
				} catch (ContaExceptions e) {
					System.out.println(e);
				}
				break;
			case 2:
				System.out.println("Digite o valor que gostaria de sacar: ");
				valor = sc.nextDouble();
				Menu.linha("Você gostaria de fazer qual tipo de movimentação?");
				System.out.println();
				try {
					conta.sacar(valor);
					System.out.println("Gostaria de realizar outra transação?\n1 - Sim\n2 - Não");
					i = sc.nextInt();
					if (i != 1 && i != 2) {
						System.out.println("O valor digitado não é válido. Repita por favor.");
						Menu.linha("O valor digitado não é válido. Repita por favor.");
						System.out.println();
						i = 1;
					}
				} catch (ContaExceptions e) {
					System.out.println(e);
				}
				break;
			case 3:
				System.out.println("Digite o valor que gostaria de transferir: ");
				valor = sc.nextDouble();
				System.out.println("Digite o cpf da conta que gostaria de transferir para: ");
				sc.next();
				String cpf = sc.next();
				Menu.linha("Você gostaria de fazer qual tipo de movimentação?");
				System.out.println();
				try {
					conta.transfere(valor, cpf);
					System.out.println("Gostaria de realizar outra transação?\n1 - Sim\n2 - Não");
					i = sc.nextInt();
					if (i != 1 && i != 2) {
						System.out.println("O valor digitado não é válido. Repita por favor.");
						Menu.linha("O valor digitado não é válido. Repita por favor.");
						System.out.println();
						i = 1;
					}
				} catch (ContaExceptions e) {
					System.out.println(e);
				}
				break;
			}
		} while (i != 2);
	}
	
	
	public static String logo() {
		
		return ("    @@@@@@@@@@@@@.@@@@@@@@@@@@@      \r\n"
				+ "    @@                       @@      \r\n"
				+ "    @@    @@@@@@@ @@@        @@      \r\n"
				+ "    @@        @@@ @@@        @@      \r\n"
				+ "    @@        @@@ @@@        @@      \r\n"
				+ "    @@        @@   @@        @@      \r\n"
				+ "    @@   /@.  @@@ @@@        @@      \r\n"
				+ "    @@  @@@.  @@@ @@@        @@      \r\n"
				+ "    @@  @@@@@@@@@ @@@/@@@@   @@      \r\n"
				+ "    @@   #@@@@@@  @@@@@@     @@      \r\n"
				+ "    @@                       @@      \r\n"
				+ "    @@@@@@@@@@@@@.@@@@@@@@@@@@@      \r\n"
				+ "                                ");
	}
	
	
	
	//função para criação de linhas, usar como variável a maior frase impressa sem "\n"
	public static void linha(String maiorFraseMenu) {
		for (int i=0;i<maiorFraseMenu.length();i++) {
			System.out.print("=");// imprime um "=" para cada caracter na frase usada como variável
		}
	}

	public static String erroMenu() {
		return "Erro encontrado: ";
	}

}
