package applications;

import java.io.IOException;
import java.util.InputMismatchException;
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
			System.out.println("\nBem vinda(o), " + conta.getNome()
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
				EscritorLeitor.escritorMovimentacoes();
				i = 2;
				break;
			default: 
				System.out.println("\nFoi digitado um valor inv�lido, por favor repita a opera��o!");	
				linha("\nFoi digitado um valor inv�lido, por favor repita a opera��o!");
			}
		} while (i != 2);
	}

	// fun��o para cria��o do menu de relat�rios do cliente
	public static void menuRelatoriosCliente(Conta conta) throws IOException {
		int i = 1;
		do {
			System.out.println(
					"\nVoc� gostaria de fazer qual tipo de relat�rio?\n1 - Saldo\n2 - Relat�rio de tributa��o\n3 - Simula��o rendimento poupan�a\n4 - Seguro de vida\n5 - Sair");
			int opcao = sc.nextInt();
			Menu.linha("Voc� gostaria de fazer qual tipo de relat�rio?");
			System.out.println();
			switch (opcao) {
			case 1:
				System.out.println("O relat�rio de saldo foi gerado!\nO saldo atual �: R$" + conta.getSaldo()+ ".");
				Menu.linha("O relat�rio de saldo foi gerado!");
				EscritorLeitor.escritorRelatorioSaldo(conta.getCpf(),conta.getNome(), conta.getSaldo());
				break;
			case 2:
				System.out.println("Para cada saque foi cobrado o valor de R$0.10 (dez centavos).");
				System.out.println("Para cada dep�sito foi cobrado o valor de R$0.10 (dez centavos).");
				System.out.println("Para cada transfer�ncia foi cobrado o valor de R$0.20 (vinte centavos).");
				System.out.println("O relat�rio de tributa��o foi gerado!\nO gasto total �: R$"
						+ conta.getQtdMovimentacao() * 0.10);
				if (MapUsuario.getMap().get(conta.getCpf()).getSeguroDeVida()>=0) {
					System.out.println("O valor aplicado em seguro de vida � de R$"+ MapUsuario.getMap().get(conta.getCpf()).getSeguroDeVida()+"\n");
				}
				EscritorLeitor.escritorRelatorioTributacao(conta.getCpf());
				Menu.linha("Para cada transfer�ncia foi cobrado o valor de R$0.20 (vinte centavos).");
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
				EscritorLeitor.escritorRelatorioPoupanca(valor, dias);
				break;
			case 4:
				System.out
						.println("Ser� debitado 20% do valor segurado.\nVoc� gostaria de continuar?\n1 - Sim\n2 - N�o");
				double opcaoSeguro = sc.nextDouble();
				linha("Ser� debitado 20% do valor segurado.");
				if (opcaoSeguro == 1) {
					System.out.println("\nQual valor voc� gostaria de aplicar no seguro de vida?");
					double aplicacao = sc.nextDouble();
					if (aplicacao * 0.2 < conta.getSaldo()) {
						conta.setSaldo(conta.getSaldo() - aplicacao * 0.20);
						System.out.println("Seguro de vida contratado com sucesso!");
						linha("Qual valor voc� gostaria de aplicar no seguro de vida?");
						MapUsuario.getMap().get(conta.getCpf()).setSeguroDeVida(aplicacao);
					} else {
						System.out.println("\nSaldo insuficiente para esta opera��o." + "\nOpera��o n�o realizada.");
					}
				}
				break;
			case 5:
				i = 2;
				break;
			default: 
				System.out.println("\nFoi digitado um valor inv�lido, por favor repita a opera��o!");	
				linha("\nFoi digitado um valor inv�lido, por favor repita a opera��o!");
			}
		} while (i != 2);

	}

	// fun��o para cria��o do menu Gerente
	public static void menuGerente(Conta conta) throws ContaExceptions, IOException {
		int i = 1;
		do {
			System.out.println("\nBem vinda(o) Gerente, " + conta.getNome()
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
				EscritorLeitor.escritorMovimentacoes();
				i = 2;
				break;
			default: 
				System.out.println("\nFoi digitado um valor inv�lido, por favor repita a opera��o!");	
				linha("\nFoi digitado um valor inv�lido, por favor repita a opera��o!");
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
				Menu.linha("O relat�rio de saldo foi gerado!");
				EscritorLeitor.escritorRelatorioSaldo(conta.getNome(),conta.getCpf(),conta.getSaldo());
				break;
			case 2:
				System.out.println("Para cada saque foi cobrado o valor de R$0.10 (dez centavos).");
				System.out.println("Para cada dep�sito foi cobrado o valor de R$0.10 (dez centavos).");
				System.out.println("Para cada transfer�ncia foi cobrado o valor de R$0.20 (vinte centavos).");
				System.out.println("O relat�rio de tributa��o foi gerado!\nO gasto total �: R$" + conta.getQtdMovimentacao()*0.10);
				EscritorLeitor.escritorRelatorioTributacao(conta.getCpf());
				Menu.linha("Para cada transfer�ncia foi cobrado o valor de R$0.20 (vinte centavos).");
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
				EscritorLeitor.escritorRelatorioPoupanca(valor, dias);
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
				EscritorLeitor.escritorRelatorioQtdAgencia(count, conta.getAgencia());
				break;
			case 5:
				i=2;
				break;
			default: 
				System.out.println("\nFoi digitado um valor inv�lido, por favor repita a opera��o!");	
				linha("\nFoi digitado um valor inv�lido, por favor repita a opera��o!");
			}
		}while (i!=2);
	}
		
	//fun��o para cria��o do menu Diretor
	public static void menuDiretor(Conta conta) throws ContaExceptions, IOException {
		int i = 1;
		do {
			System.out.println("\nBem vinda(o) Diretora(o), " + conta.getNome()
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
				EscritorLeitor.escritorMovimentacoes();
				i = 2;
				break;
			default: 
				System.out.println("\nFoi digitado um valor inv�lido, por favor repita a opera��o!");	
				linha("\nFoi digitado um valor inv�lido, por favor repita a opera��o!");
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
				Menu.linha("O relat�rio de saldo foi gerado!");
				EscritorLeitor.escritorRelatorioSaldo(conta.getNome(),conta.getCpf(),conta.getSaldo());
				break;
			case 2:
				System.out.println("Para cada saque foi cobrado o valor de R$0.10 (dez centavos).");
				System.out.println("Para cada dep�sito foi cobrado o valor de R$0.10 (dez centavos).");
				System.out.println("Para cada transfer�ncia foi cobrado o valor de R$0.20 (vinte centavos).");
				System.out.println("O relat�rio de tributa��o foi gerado!\nO gasto total �: R$"
						+ conta.getQtdMovimentacao() * 0.10);
				EscritorLeitor.escritorRelatorioTributacao(conta.getCpf());
				Menu.linha("Para cada transfer�ncia foi cobrado o valor de R$0.20 (vinte centavos).");
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
				EscritorLeitor.escritorRelatorioPoupanca(valor, dias);
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
				EscritorLeitor.escritorRelatorioQtdAgencia(count, conta.getAgencia());
				break;
			case 5:
				System.out.println("Nome       Cpf        Agencia");
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
			default: 
				System.out.println("\nFoi digitado um valor inv�lido, por favor repita a opera��o!");
				linha("\nFoi digitado um valor inv�lido, por favor repita a opera��o!");
			}
		} while (i != 2);
	}
	
	//fun��o para cria��o do menu Presidente
	public static void menuPresidente(Conta conta) throws ContaExceptions, IOException {
		int i = 1;
		do {
			System.out.println("\nBem vinda(o) Presidente, " + conta.getNome()
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
			default: 
				System.out.println("\nFoi digitado um valor inv�lido, por favor repita a opera��o!");	
				linha("\nFoi digitado um valor inv�lido, por favor repita a opera��o!");
			}
		} while (i != 2);
	}

	// fun��o para cria��o do menu de relat�rios do Presidente
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
				Menu.linha("O relat�rio de saldo foi gerado!");
				EscritorLeitor.escritorRelatorioSaldo(conta.getNome(),conta.getCpf(),conta.getSaldo());
				break;
			case 2:
				System.out.println("Para cada saque foi cobrado o valor de R$0.10 (dez centavos).");
				System.out.println("Para cada dep�sito foi cobrado o valor de R$0.10 (dez centavos).");
				System.out.println("Para cada transfer�ncia foi cobrado o valor de R$0.20 (vinte centavos).");
				System.out.println("O relat�rio de tributa��o foi gerado!\nO gasto total �: R$"
						+ conta.getQtdMovimentacao() * 0.10);
				EscritorLeitor.escritorRelatorioTributacao(conta.getCpf());
				Menu.linha("Para cada transfer�ncia foi cobrado o valor de R$0.20 (vinte centavos).");
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
				EscritorLeitor.escritorRelatorioPoupanca(valor, dias);
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
				EscritorLeitor.escritorRelatorioQtdAgencia(count, conta.getAgencia());
				break;
			case 5:
				System.out.println("Nome       Cpf        Agencia");
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
				EscritorLeitor.escritorRelatorioSaldoTotalBanco(sum);
				System.out.println();
				break;
			case 7:
				i = 2;
				break;
			default: 
				System.out.println("\nFoi digitado um valor inv�lido, por favor repita a opera��o!");	
				linha("\nFoi digitado um valor inv�lido, por favor repita a opera��o!");
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
				try {
					System.out.println("\nDigite o valor que gostaria de depositar: ");
					Double valor = sc.nextDouble();
					Menu.linha("Voc� gostaria de fazer qual tipo de movimenta��o?");
					System.out.println();
					conta.depositar(valor);
					System.out.println("\nGostaria de realizar outra transa��o?\n1 - Sim\n2 - N�o");
					i = sc.nextInt();
					Menu.linha("Voc� gostaria de fazer qual tipo de movimenta��o?");
					if (i != 1 && i != 2) {
						System.out.println("O valor digitado n�o � v�lido. Repita por favor.");
						Menu.linha("O valor digitado n�o � v�lido. Repita por favor.");
						System.out.println();
						i = 1;
					}
				} catch (ContaExceptions e) {
					System.out.println(e);
					linha("exceptions.ContaExcepetions: Erro encontrado: Valor de deposito menor ou igual a 0");
				} catch (Exception e) {
					System.out.println("Valor digitado inv�lido. Por favor tente novamente. "+e);
					linha("exceptions.ContaExcepetions: Erro encontrado: Valor de deposito menor ou igual a 0");
				}
				break;
			case 2:
				try {
					System.out.println("\nDigite o valor que gostaria de sacar: ");
					double valor = sc.nextDouble();
					Menu.linha("Voc� gostaria de fazer qual tipo de movimenta��o?");
					System.out.println();
					conta.sacar(valor);
					System.out.println("\nGostaria de realizar outra transa��o?\n1 - Sim\n2 - N�o");
					i = sc.nextInt();
					Menu.linha("Voc� gostaria de fazer qual tipo de movimenta��o?");
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
				try {
					System.out.println("\nDigite o valor que gostaria de transferir: ");
					double valor = sc.nextDouble();
					System.out.println("Digite o cpf da conta que gostaria de transferir para: ");
					String cpf = sc.next();
					Menu.linha("Digite o cpf da conta que gostaria de transferir para: ");
					System.out.println();
					conta.transfere(valor, cpf);
					System.out.println("\nGostaria de realizar outra transa��o?\n1 - Sim\n2 - N�o");
					i = sc.nextInt();
					Menu.linha("Voc� gostaria de fazer qual tipo de movimenta��o?");
					if (i != 1 && i != 2) {
						System.out.println("O valor digitado n�o � v�lido. Repita por favor.");
						Menu.linha("O valor digitado n�o � v�lido. Repita por favor.");
						System.out.println();
						i = 1;
					}
				} catch (ContaExceptions e) {
					System.out.println(e);
					linha("exceptions.ContaExcepetions: Erro encontrado: Valor de deposito menor ou igual a 0");
				} catch (Exception e) {
					System.out.println("Valor digitado inv�lido. Por favor tente novamente.");
					linha("exceptions.ContaExcepetions: Erro encontrado: Valor de deposito menor ou igual a 0");
				}
				break;
			case 4:
				i = 2;
				break;
			default:
				System.out.println("\nFoi digitado um valor inv�lido, por favor repita a opera��o!");
				linha("\nFoi digitado um valor inv�lido, por favor repita a opera��o!");
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
