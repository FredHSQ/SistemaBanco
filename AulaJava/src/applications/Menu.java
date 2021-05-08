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
	
	//função para criação do menu cliente
	public static void menuCLiente(Conta conta) throws ContaExceptions, IOException {
		int i = 1;
		do {
		System.out.println(
				"Bem vindo, "+ conta.getNome() +"!\nOque você gostaria de fazer?\n1 - Movimentações\n2 - Relátorios\n3 - Sair");
		int opcao = sc.nextInt();
		Menu.linha("Oque você gostaria de fazer?");
		switch (opcao) {
		case 1:
			menuMovimentacao(conta);
			break;
		case 2:
			menuRelatoriosCliente(conta);
			break;
		case 3:
			i=2;
			break;
		}
		}while(i!=2);
	}
	
	//função para criação do menu movimentaçãos
	public static void menuRelatoriosCliente(Conta conta) throws IOException {
		int i = 1;
		do {
			System.out.println(
					"Você gostaria de fazer qual tipo de relatório?\n1 - Saldo\n2 - Relatório de tributação\n3 - Simulação rendimento poupança\n4 - Sair");
			int opcao = sc.nextInt();
			Menu.linha("Você gostaria de fazer qual tipo de relatório?");
			switch (opcao) {
			case 1:
				System.out.println("O relatório de saldo foi gerado!\nO saldo atual é: R$" + conta.getSaldo());
				EscritorLeitor.escritorRelatorioSaldo();
				break;
			case 2:
				System.out.println("O relatório de tributação foi gerado!\nO gasto total é: R$" + conta.getQtdMovimentacao()*0.10);
				EscritorLeitor.escritorRelatorioTributacao();
				System.out.println("Para cada saque foi cobrado o valor de R$0.10 (dez centavos).");
				System.out.println("Para cada depósito foi cobrado o valor de R$0.10 (dez centavos).");
				System.out.println("Para cada transferência foi cobrado o valor de R$0.20 (dez centavos).");
				break;
			case 3:
				System.out.println("Você selecionou fazer uma simulação rendimento poupança.");
				System.out.printf("Por favor, digite o valor que quer colocar na poupança:\nR$");
				double valor = sc.nextDouble();
				System.out.println("Por favor, digite o valor de dias que o dinheiro ficará na poupança: ");
				double dias = sc.nextInt();
				System.out.println("Depositando R$" + valor + " por "+ dias + " você terá um rendimento de R$" + valor*dias*0.003/30 +"!");
				System.out.println("O relatório de simulação rendimento poupança foi gerado.");
				EscritorLeitor.escritorRelatorioPoupanca();
				break;
			case 4:
				break;
			}	
		}while (i!=2);
		
	}
	
	//função para criação do menu movimentaçãos
	public static void menuMovimentacao(Conta conta) throws ContaExceptions, IOException {
		int i = 1;
		do {
			System.out.println(
					"Você gostaria de fazer qual tipo de movimentação?\n1 - Depositar\n2 - Sacar\n3 - Transferir\n4 - Sair");
			int opcao = sc.nextInt();
			Menu.linha("Você gostaria de fazer qual tipo de movimentação?");
			switch (opcao) {
			case 1:
				System.out.println("\nDigite o valor que gostaria de depositar: ");
				Double valor = sc.nextDouble();
				Menu.linha("Você gostaria de fazer qual tipo de movimentação?");
				System.out.println();
				try {
					conta.depositar(valor);
					System.out.println("\nGostaria de realizar outra transação?\n1 - Sim\n2 - Não");
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
				System.out.println("\nDigite o valor que gostaria de sacar: ");
				valor = sc.nextDouble();
				Menu.linha("Você gostaria de fazer qual tipo de movimentação?");
				System.out.println();
				try {
					conta.sacar(valor);
					System.out.println("\nGostaria de realizar outra transação?\n1 - Sim\n2 - Não");
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
				System.out.println("\nDigite o valor que gostaria de transferir: ");
				valor = sc.nextDouble();
				System.out.println("Digite o cpf da conta que gostaria de transferir para: ");
				String cpf = sc.next();
				Menu.linha("Digite o cpf da conta que gostaria de transferir para: ");
				System.out.println();
					conta.transfere(valor, cpf);
					System.out.println("\nGostaria de realizar outra transação?\n1 - Sim\n2 - Não");
					i = sc.nextInt();
					if (i != 1 && i != 2) {
						System.out.println("O valor digitado não é válido. Repita por favor.");
						Menu.linha("O valor digitado não é válido. Repita por favor.");
						System.out.println();
						i = 1;
					}
				break;
			case 4:
				i = 2;
				break;
			default: 
				System.out.println("\nFoi digitado um valor inválido, por favor repita a operação!");				
			}	
		} while (i != 2);
	}
	
	//função para criação da logo
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
