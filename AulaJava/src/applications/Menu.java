package applications;

import java.io.IOException;
import java.util.Scanner;

import contas.Conta;
import exceptions.ContaExceptions;

public class Menu {
	static Scanner sc = new Scanner(System.in);

	// fun��o para cria��o do menu inicial
	public static void bemVindo() {
		linha("|Bem vindo ao banco Justice League|"); // chama fun��o "linha()" usando a maior frase do que foi escrito
														// no menu
		System.out.println("\n|Bem vindo ao banco Justice League|");
		linha("|Bem vindo ao banco Justice League|"); // chama fun��o "linha()" usando a maior frase do que foi escrito
														// no menu
		System.out.println();
	}

	// fun��o para cria��o do menu cliente
	public static void menuCLiente(Conta conta) throws ContaExceptions, IOException {
		int i = 1;
		do {
			System.out.println("\nBem vindo, " + conta.getNome()
					+ "!\nO que voc� gostaria de fazer?\n1 - Movimenta��es\n2 - Rel�torios\n3 - Sair");
			int opcao = sc.nextInt();
			Menu.linha("Oque voc� gostaria de fazer?");
			switch (opcao) {
			case 1:
				menuMovimentacao(conta);
				break;
			case 2:
				menuRelatoriosCliente(conta);
				break;
			case 3:
				i = 2;
				break;
			}
		} while (i != 2);
	}

	// fun��o para cria��o do menu de relat�rios do cliente
	public static void menuRelatoriosCliente(Conta conta) throws IOException {
		int i = 1;
		do {
			System.out.println(
					"\nVoc� gostaria de fazer qual tipo de relat�rio?\n1 - Saldo\n2 - Relat�rio de tributa��o\n3 - Simula��o rendimento poupan�a\n4 - Sair");
			int opcao = sc.nextInt();
			Menu.linha("Voc� gostaria de fazer qual tipo de relat�rio?");
			System.out.println();
			switch (opcao) {
			case 1:
				System.out.println("O relat�rio de saldo foi gerado!\nO saldo atual �: R$" + conta.getSaldo());
				EscritorLeitor.escritorRelatorioSaldo(conta.getCpf(),conta.getNome(), conta.getSaldo());
				break;
			case 2:
				System.out.println("O relat�rio de tributa��o foi gerado!\nO gasto total �: R$"
						+ conta.getQtdMovimentacao() * 0.10);
				EscritorLeitor.escritorRelatorioTributacao();
				System.out.println("Para cada saque foi cobrado o valor de R$0.10 (dez centavos).");
				System.out.println("Para cada dep�sito foi cobrado o valor de R$0.10 (dez centavos).");
				System.out.println("Para cada transfer�ncia foi cobrado o valor de R$0.20 (dez centavos).");
				break;
			case 3:
				System.out.println("Voc� selecionou fazer uma simula��o rendimento poupan�a.");
				System.out.printf("Por favor, digite o valor que quer colocar na poupan�a:\nR$");
				double valor = sc.nextDouble();
				System.out.println("Por favor, digite o valor de dias que o dinheiro ficar� na poupan�a: ");
				int dias = sc.nextInt();
				System.out.println("Depositando R$" + valor + " por " + dias + " dias, voc� ter� um rendimento de R$"
						+ valor * dias * 0.003 / 30 + "!");
				System.out.println("O relat�rio de simula��o rendimento poupan�a foi gerado.");
				linha("O relat�rio de simula��o rendimento poupan�a foi gerado.");
				EscritorLeitor.escritorRelatorioPoupanca();
				break;
			case 4:
				i = 2;
				break;
			}
		} while (i != 2);

	}

	// fun��o para cria��o do menu Gerente
	public static void menuGerente(Conta conta) throws ContaExceptions, IOException {
		int i = 1;
		do {
			System.out.println("\nBem vindo Gerente, " + conta.getNome()
					+ "!\nO que voc� gostaria de fazer?\n1 - Movimenta��es\n2 - Rel�torios\n3 - Sair");
			int opcao = sc.nextInt();
			Menu.linha("Oque voc� gostaria de fazer?");
			switch (opcao) {
			case 1:
				menuMovimentacao(conta);
				break;
			case 2:
				menuRelatoriosGerente(conta);
				break;
			case 3:
				i = 2;
				break;
			}
		} while (i != 2);
	}

	// fun��o para cria��o do menu de relat�rios do gerente
	public static void menuRelatoriosGerente(Conta conta) throws IOException {
		int i = 1;
		do {
			System.out.println(
					"\nVoc� gostaria de fazer qual tipo de relat�rio?\n1 - Saldo\n2 - Relat�rio de tributa��o\n3 - Simula��o rendimento poupan�a\n4 - N�mero de contas da agencia\n5 - Sair");
			int opcao = sc.nextInt();
			Menu.linha("Voc� gostaria de fazer qual tipo de relat�rio?");
			System.out.println();
			switch (opcao) {
			case 1:
				System.out.println("O relat�rio de saldo foi gerado!\nO saldo atual �: R$" + conta.getSaldo());
				EscritorLeitor.escritorRelatorioSaldo(conta.getNome(),conta.getCpf(),conta.getSaldo());
				break;
			case 2:
				System.out.println("O relat�rio de tributa��o foi gerado!\nO gasto total �: R$" + conta.getQtdMovimentacao()*0.10);
				EscritorLeitor.escritorRelatorioTributacao();
				System.out.println("Para cada saque foi cobrado o valor de R$0.10 (dez centavos).");
				System.out.println("Para cada dep�sito foi cobrado o valor de R$0.10 (dez centavos).");
				System.out.println("Para cada transfer�ncia foi cobrado o valor de R$0.20 (dez centavos).");
				break;
			case 3:
				System.out.println("Voc� selecionou fazer uma simula��o rendimento poupan�a.");
				System.out.printf("Por favor, digite o valor que quer colocar na poupan�a:\nR$");
				double valor = sc.nextDouble();
				System.out.println("Por favor, digite o valor de dias que o dinheiro ficar� na poupan�a: ");
				int dias = sc.nextInt();
				System.out.println("Depositando R$" + valor + " por " + dias + " dias, voc� ter� um rendimento de R$" + valor*dias*0.003/30 +"!");
				System.out.println("O relat�rio de simula��o rendimento poupan�a foi gerado.");
				linha("O relat�rio de simula��o rendimento poupan�a foi gerado.");
				EscritorLeitor.escritorRelatorioPoupanca();
				break;
			case 4:
				int count = 0;
				for(Conta value : MapConta.getMap().values()) {
				  if (value.getAgencia()==conta.getAgencia()) {
				    count++;
				  }
				}
				System.out.println("\nA quantidade de contas na agencia " + conta.getAgencia() + " �: " + count);
				linha("A quantidade de contas na agencia 3 �: 10");
				EscritorLeitor.escritorRelatorioQtdAgencia();
				break;
			case 5:
				i=2;
				break;
			}
		}while (i!=2);
	}
		
	//fun��o para cria��o do menu Diretor
	public static void menuDiretor(Conta conta) throws ContaExceptions, IOException {
		int i = 1;
		do {
			System.out.println("\nBem vindo Diretor, " + conta.getNome()
					+ "!\nO que voc� gostaria de fazer?\n1 - Movimenta��es\n2 - Rel�torios\n3 - Sair");
			int opcao = sc.nextInt();
			Menu.linha("Oque voc� gostaria de fazer?");
			switch (opcao) {
			case 1:
				menuMovimentacao(conta);
				break;
			case 2:
				menuRelatoriosDiretor(conta);
				break;
			case 3:
				i = 2;
				break;
			}
		} while (i != 2);
	}

	// fun��o para cria��o do menu de relat�rios do Diretor
	public static void menuRelatoriosDiretor(Conta conta) throws IOException {
		int i = 1;
		do {
			System.out.println(
					"\nVoc� gostaria de fazer qual tipo de relat�rio?\n1 - Saldo\n2 - Relat�rio de tributa��o\n3 - Simula��o rendimento poupan�a\n4 - N�mero de contas da agencia\n5 - Nome, CPF e Agencia de todas as contas\n6 - Sair");
			int opcao = sc.nextInt();
			Menu.linha("Voc� gostaria de fazer qual tipo de relat�rio?");
			System.out.println();
			switch (opcao) {
			case 1:
				System.out.println("O relat�rio de saldo foi gerado!\nO saldo atual �: R$" + conta.getSaldo());
				EscritorLeitor.escritorRelatorioSaldo(conta.getNome(),conta.getCpf(),conta.getSaldo());
				break;
			case 2:
				System.out.println("O relat�rio de tributa��o foi gerado!\nO gasto total �: R$"
						+ conta.getQtdMovimentacao() * 0.10);
				EscritorLeitor.escritorRelatorioTributacao();
				System.out.println("Para cada saque foi cobrado o valor de R$0.10 (dez centavos).");
				System.out.println("Para cada dep�sito foi cobrado o valor de R$0.10 (dez centavos).");
				System.out.println("Para cada transfer�ncia foi cobrado o valor de R$0.20 (dez centavos).");
				break;
			case 3:
				System.out.println("Voc� selecionou fazer uma simula��o rendimento poupan�a.");
				System.out.printf("Por favor, digite o valor que quer colocar na poupan�a:\nR$");
				double valor = sc.nextDouble();
				System.out.println("Por favor, digite o valor de dias que o dinheiro ficar� na poupan�a: ");
				int dias = sc.nextInt();
				System.out.println("Depositando R$" + valor + " por " + dias + " dias, voc� ter� um rendimento de R$"
						+ valor * dias * 0.003 / 30 + "!");
				System.out.println("O relat�rio de simula��o rendimento poupan�a foi gerado.");
				linha("O relat�rio de simula��o rendimento poupan�a foi gerado.");
				EscritorLeitor.escritorRelatorioPoupanca();
				break;
			case 4:
				int count = 0;
				for (Conta value : MapConta.getMap().values()) {
					if (value.getAgencia() == conta.getAgencia()) {
						count++;
					}
				}
				System.out.println("\nA quantidade de contas na agencia " + conta.getAgencia() + " �: " + count);
				linha("A quantidade de contas na agencia 3 �: 10");
				EscritorLeitor.escritorRelatorioQtdAgencia();
				break;
			case 5:
				for (Conta value : MapConta.getMapS().values()) {
					System.out.println("\n"+value.getNome()+" "+value.getCpf()+" "+value.getAgencia());
				}
				
				linha("A quantidade de contas na agencia 3 �: 10");
				System.out.println();
				EscritorLeitor.escritorRelatorioTodasContas();
				break;
			case 6:
				i = 2;
				break;
			}
		} while (i != 2);
	}
	
	//fun��o para cria��o do menu Presidente
	public static void menuPresidente(Conta conta) throws ContaExceptions, IOException {
		int i = 1;
		do {
			System.out.println("\nBem vindo Presidente, " + conta.getNome()
					+ "!\nO que voc� gostaria de fazer?\n1 - Movimenta��es\n2 - Rel�torios\n3 - Sair");
			int opcao = sc.nextInt();
			Menu.linha("Oque voc� gostaria de fazer?");
			switch (opcao) {
			case 1:
				menuMovimentacao(conta);
				break;
			case 2:
				menuRelatoriosPresidente(conta);
				break;
			case 3:
				EscritorLeitor.escritorMovimentacoes();
				i = 2;
				break;
			}
		} while (i != 2);
	}

	// fun��o para cria��o do menu de relat�rios do Diretor
	public static void menuRelatoriosPresidente(Conta conta) throws IOException {
		int i = 1;
		do {
			System.out.println(
					"\nVoc� gostaria de fazer qual tipo de relat�rio?\n1 - Saldo\n2 - Relat�rio de tributa��o\n3 - Simula��o rendimento poupan�a\n4 - N�mero de contas da agencia\n5 - Nome, CPF e Agencia de todas as contas\n6 - Valor total dentro do banco\n7 - Sair");
			int opcao = sc.nextInt();
			Menu.linha("Voc� gostaria de fazer qual tipo de relat�rio?");
			System.out.println();
			switch (opcao) {
			case 1:
				System.out.println("O relat�rio de saldo foi gerado!\nO saldo atual �: R$" + conta.getSaldo());
				EscritorLeitor.escritorRelatorioSaldo(conta.getNome(),conta.getCpf(),conta.getSaldo());
				break;
			case 2:
				System.out.println("O relat�rio de tributa��o foi gerado!\nO gasto total �: R$"
						+ conta.getQtdMovimentacao() * 0.10);
				EscritorLeitor.escritorRelatorioTributacao();
				System.out.println("Para cada saque foi cobrado o valor de R$0.10 (dez centavos).");
				System.out.println("Para cada dep�sito foi cobrado o valor de R$0.10 (dez centavos).");
				System.out.println("Para cada transfer�ncia foi cobrado o valor de R$0.20 (dez centavos).");
				break;
			case 3:
				System.out.println("Voc� selecionou fazer uma simula��o rendimento poupan�a.");
				System.out.printf("Por favor, digite o valor que quer colocar na poupan�a:\nR$");
				double valor = sc.nextDouble();
				System.out.println("Por favor, digite o valor de dias que o dinheiro ficar� na poupan�a: ");
				int dias = sc.nextInt();
				System.out.println("Depositando R$" + valor + " por " + dias + " dias, voc� ter� um rendimento de R$"
						+ valor * dias * 0.003 / 30 + "!");
				System.out.println("O relat�rio de simula��o rendimento poupan�a foi gerado.");
				linha("O relat�rio de simula��o rendimento poupan�a foi gerado.");
				EscritorLeitor.escritorRelatorioPoupanca();
				break;
			case 4:
				int count = 0;
				for (Conta value : MapConta.getMap().values()) {
					if (value.getAgencia() == conta.getAgencia()) {
						count++;
					}
				}
				System.out.println("\nA quantidade de contas na agencia " + conta.getAgencia() + " �: " + count);
				linha("A quantidade de contas na agencia 3 �: 10");
				EscritorLeitor.escritorRelatorioQtdAgencia();
				break;
			case 5:
				for (Conta value : MapConta.getMapS().values()) {
					System.out.println("\n"+value.getNome()+" "+value.getCpf()+" "+value.getAgencia());
				}
				
				linha("A quantidade de contas na agencia 3 �: 10");
				System.out.println();
				EscritorLeitor.escritorRelatorioTodasContas();
				break;
			case 6:
				double sum = 0;
				for (Conta value : MapConta.getMap().values()) {
						sum=sum+value.getSaldo();
				}
				System.out.println("\nO valor total, em todas as contas do banco, � de: R$"+ sum);
				linha("\nO valor total, em todas as contas do banco, � de: R$12345678910");
				EscritorLeitor.escritorRelatorioSaldoTotalBanco();
				System.out.println();
				break;
			case 7:
				i = 2;
				break;
			}
		} while (i != 2);
	}
	
	//fun��o para cria��o do menu movimenta��os
	public static void menuMovimentacao(Conta conta) throws ContaExceptions, IOException {
		int i = 1;
		do {
			System.out.println(
					"\nVoc� gostaria de fazer qual tipo de movimenta��o?\n1 - Depositar\n2 - Sacar\n3 - Transferir\n4 - Sair");
			int opcao = sc.nextInt();
			Menu.linha("Voc� gostaria de fazer qual tipo de movimenta��o?");
			switch (opcao) {
			case 1:
				System.out.println("\nDigite o valor que gostaria de depositar: ");
				Double valor = sc.nextDouble();
				Menu.linha("Voc� gostaria de fazer qual tipo de movimenta��o?");
				System.out.println();
				try {
					conta.depositar(valor);
					System.out.println("\nGostaria de realizar outra transa��o?\n1 - Sim\n2 - N�o");
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
				System.out.println("\nDigite o valor que gostaria de sacar: ");
				valor = sc.nextDouble();
				Menu.linha("Voc� gostaria de fazer qual tipo de movimenta��o?");
				System.out.println();
				try {
					conta.sacar(valor);
					System.out.println("\nGostaria de realizar outra transa��o?\n1 - Sim\n2 - N�o");
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
				System.out.println("\nDigite o valor que gostaria de transferir: ");
				valor = sc.nextDouble();
				System.out.println("Digite o cpf da conta que gostaria de transferir para: ");
				String cpf = sc.next();
				Menu.linha("Digite o cpf da conta que gostaria de transferir para: ");
				System.out.println();
					conta.transfere(valor, cpf);
					System.out.println("\nGostaria de realizar outra transa��o?\n1 - Sim\n2 - N�o");
					i = sc.nextInt();
					if (i != 1 && i != 2) {
						System.out.println("O valor digitado n�o � v�lido. Repita por favor.");
						Menu.linha("O valor digitado n�o � v�lido. Repita por favor.");
						System.out.println();
						i = 1;
					}
				break;
			case 4:
				i = 2;
				break;
			default: 
				System.out.println("\nFoi digitado um valor inv�lido, por favor repita a opera��o!");				
			}	
		} while (i != 2);
	}
	
	//fun��o para cria��o da logo
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
