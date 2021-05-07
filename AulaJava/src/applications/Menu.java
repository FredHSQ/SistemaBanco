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
	//fun��o para cria��o do menu inicial
	public static void bemVindo() {
		linha("|Bem vindo ao banco Justice League|"); // chama fun��o "linha()" usando a maior frase do que foi escrito no menu
		System.out.println("\n|Bem vindo ao banco Justice League|");
		linha("|Bem vindo ao banco Justice League|"); // chama fun��o "linha()" usando a maior frase do que foi escrito no menu
		System.out.println();
		
		
	}
	
	public static void menuMovimentacao(Conta conta) throws ContaExceptions, IOException {
		int i = 1;
		do {
			System.out.println(
					"Voc� gostaria de fazer qual tipo de movimenta��o?\n1 - Depositar\n2 - Sacar\n3 - Transferir\n4 - Sair");
			int opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("Digite o valor que gostaria de depositar: ");
				Double valor = sc.nextDouble();
				Menu.linha("Voc� gostaria de fazer qual tipo de movimenta��o?");
				System.out.println();
				try {
					conta.depositar(valor);
					System.out.println("Gostaria de realizar outra transa��o?\n1 - Sim\n2 - N�o");
					i = sc.nextInt();
					if (i != 1 && i != 2) {
						System.out.println("O valor digitado n�o � v�lido. Repita por favor.");
						Menu.linha("O valor digitado n�o � v�lido. Repita por favor.");
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
				Menu.linha("Voc� gostaria de fazer qual tipo de movimenta��o?");
				System.out.println();
				try {
					conta.sacar(valor);
					System.out.println("Gostaria de realizar outra transa��o?\n1 - Sim\n2 - N�o");
					i = sc.nextInt();
					if (i != 1 && i != 2) {
						System.out.println("O valor digitado n�o � v�lido. Repita por favor.");
						Menu.linha("O valor digitado n�o � v�lido. Repita por favor.");
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
				Menu.linha("Voc� gostaria de fazer qual tipo de movimenta��o?");
				System.out.println();
				try {
					conta.transfere(valor, cpf);
					System.out.println("Gostaria de realizar outra transa��o?\n1 - Sim\n2 - N�o");
					i = sc.nextInt();
					if (i != 1 && i != 2) {
						System.out.println("O valor digitado n�o � v�lido. Repita por favor.");
						Menu.linha("O valor digitado n�o � v�lido. Repita por favor.");
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
	
	
	
	//fun��o para cria��o de linhas, usar como vari�vel a maior frase impressa sem "\n"
	public static void linha(String maiorFraseMenu) {
		for (int i=0;i<maiorFraseMenu.length();i++) {
			System.out.print("=");// imprime um "=" para cada caracter na frase usada como vari�vel
		}
	}

	public static String erroMenu() {
		return "Erro encontrado: ";
	}

}
