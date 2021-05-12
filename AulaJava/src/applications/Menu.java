package applications;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import contas.Conta;
import exceptions.ContaExceptions;

public class Menu {
	static Scanner sc = new Scanner(System.in);

	// função para criação do menu inicial
	public static void bemVindo() {
		linha(); // chama função "linha()" 
														// no menu
		System.out.println("\n   |Bem vindo ao Banco Justice League|");
		linha(); 
		System.out.println();
	}

	// função para criação do menu cliente
	public static void menuCLiente(Conta conta) throws ContaExceptions, IOException {
		int i = 1;
		do {
			System.out.println("\nBem vinda(o), " + conta.getNome()
					+ "!\nO que você gostaria de fazer?\n1 - Movimentações\n2 - Relatórios\n3 - Sair");
			int opcao = sc.nextInt();
			Menu.linha();
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
				System.out.println("\nFoi digitado um valor inválido, \npor favor repita a operação!");	
				linha();
			}
		} while (i != 2);
	}

	// função para criação do menu de relatórios do cliente
	public static void menuRelatoriosCliente(Conta conta) throws IOException {
		int i = 1;
		do {
			System.out.println(
					"\nvocê gostaria de fazer qual tipo de \nrelatório\n1 - Saldo\n2 - Relatório de tributação\n3 - Simulação rendimento poupança\n4 - Seguro de vida\n5 - Sair");
			int opcao = sc.nextInt();
			Menu.linha();
			System.out.println();
			switch (opcao) {
			case 1:
				System.out.println("O Relatório de saldo foi gerado!\nO saldo atual é: R$" + conta.getSaldo()+ ".");
				Menu.linha();
				EscritorLeitor.escritorRelatorioSaldo(conta.getCpf(),conta.getNome(), conta.getSaldo());
				break;
			case 2:
				System.out.println("Para cada saque foi cobrado o valor \nde R$0.10 (dez centavos).");
				System.out.println("Para cada depósito foi cobrado o valor \nde R$0.10 (dez centavos).");
				System.out.println("Para cada transferência foi cobrado o valor \nde R$0.20 (vinte centavos).");
				System.out.println("O Relatório de tributação foi gerado!\nO gasto total é: R$"
						+ conta.getQtdMovimentacao() * 0.10);
				if (MapUsuario.getMap().get(conta.getCpf()).getSeguroDeVida()>=0) {
					System.out.println("O valor aplicado em seguro de vida é \nde R$"+ MapUsuario.getMap().get(conta.getCpf()).getSeguroDeVida()+"\n");
				}
				EscritorLeitor.escritorRelatorioTributacao(conta.getCpf());
				Menu.linha();
				break;
			case 3:
				System.out.println("você selecionou fazer uma simulação \nrendimento poupança.");
				System.out.printf("Por favor, digite o valor que quer \ncolocar na poupança:\nR$");
				double valor = sc.nextDouble();
				System.out.println("Por favor, digite o valor de dias \nque o dinheiro ficará na poupança: ");
				int dias = sc.nextInt();
				 System.out.println("Depositando R$" + valor + " por " + dias + " dias, \nvocê terá um rendimento de R$"
						+ valor * dias * 0.003 / 30 + "!");
				System.out.println("O Relatório de simulação rendimento \nde poupança foi gerado.");
				linha();
				EscritorLeitor.escritorRelatorioPoupanca(valor, dias);
				break;
			case 4:
				System.out
						.println("Será debitado 20% do valor segurado.\nvocê gostaria de continuar?\n1 - Sim\n2 - Não");
				double opcaoSeguro = sc.nextDouble();
				linha();
				if (opcaoSeguro == 1) {
					System.out.println("\nQual valor você gostaria de aplicar \nno seguro de vida?");
					double aplicacao = sc.nextDouble();
					if (aplicacao * 0.2 < conta.getSaldo()) {
						conta.setSaldo(conta.getSaldo() - aplicacao * 0.20);
						System.out.println("Seguro de vida contratado com \nsucesso!");
						linha();
						MapUsuario.getMap().get(conta.getCpf()).setSeguroDeVida(aplicacao);
					} else {
						System.out.println("\nSaldo insuficiente para esta \noperação." + "\noperação não realizada.");
					}
				}
				break;
			case 5:
				i = 2;
				break;
			default: 
				System.out.println("\nFoi digitado um valor inválido, \npor favor repita a operação!");	
				linha();
			}
		} while (i != 2);

	}

	// função para criação do menu Gerente
	public static void menuGerente(Conta conta) throws ContaExceptions, IOException {
		int i = 1;
		do {
			System.out.println("\nBem vinda(o) Gerente, " + conta.getNome()
					+ "!\nO que você gostaria de fazer?\n1 - Movimentações\n2 - Relatórios\n3 - Sair");
			int opcao = sc.nextInt();
			Menu.linha();
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
				System.out.println("\nFoi digitado um valor inválido, \npor favor repita a operação!");	
				linha();
			}
		} while (i != 2);
	}

	// função para criação do menu de Relatórios do gerente
	public static void menuRelatoriosGerente(Conta conta) throws IOException {
		int i = 1;
		do {
			System.out.println(
					"\nVocê gostaria de fazer qual tipo de \nrelatório\n1 - Saldo\n2 - Relatório de tributação\n3 - Simulação rendimento poupança\n4 - Número de contas da agência\n5 - Sair");
			int opcao = sc.nextInt();
			Menu.linha();
			System.out.println();
			switch (opcao) {
			case 1:
				System.out.println("O Relatório de saldo foi gerado!\nO saldo atual é: R$" + conta.getSaldo());
				Menu.linha();
				EscritorLeitor.escritorRelatorioSaldo(conta.getNome(),conta.getCpf(),conta.getSaldo());
				break;
			case 2:
				System.out.println("Para cada saque foi cobrado o \nvalor de R$0.10 (dez centavos).");
				System.out.println("Para cada depósito foi cobrado o \nvalor de R$0.10 (dez centavos).");
				System.out.println("Para cada transferência foi cobrado o \nvalor de R$0.20 (vinte centavos).");
				System.out.println("O Relatório de tributação foi gerado!\nO gasto total é: R$" + conta.getQtdMovimentacao()*0.10);
				EscritorLeitor.escritorRelatorioTributacao(conta.getCpf());
				Menu.linha();
				break;
			case 3:
				System.out.println("você selecionou fazer uma simulação \nrendimento poupança.");
				System.out.printf("Por favor, digite o valor que quer \ncolocar na poupança:\nR$");
				double valor = sc.nextDouble();
				System.out.println("Por favor, digite o valor de dias \nque o dinheiro ficará na poupança: ");
				int dias = sc.nextInt();
				System.out.println("Depositando R$" + valor + "\npor " + dias + " dias, \nvocê terá um rendimento de R$" + valor*dias*0.003/30 +"!");
				System.out.println("O Relatório de simulação rendimento \npoupança foi gerado.");
				linha();
				EscritorLeitor.escritorRelatorioPoupanca(valor, dias);
				break;
			case 4:
				int count = 0;
				for(Conta value : MapConta.getMap().values()) {
				  if (value.getAgencia()==conta.getAgencia()) {
				    count++;
				  }
				}
				System.out.println("A quantidade de contas na agência \n" + conta.getAgencia() + " é: " + count);
				linha();
				EscritorLeitor.escritorRelatorioQtdAgencia(count, conta.getAgencia());
				break;
			case 5:
				i=2;
				break;
			default: 
				System.out.println("\nFoi digitado um valor inválido, \npor favor repita a operação!");	
				linha();
			}
		}while (i!=2);
	}
		
	//função para criação do menu Diretor
	public static void menuDiretor(Conta conta) throws ContaExceptions, IOException {
		int i = 1;
		do {
			System.out.println("\nBem vinda(o) Diretora(o), " + conta.getNome()
					+ "!\nO que você gostaria de fazer?\n1 - Movimentações\n2 - Relatórios\n3 - Sair");
			int opcao = sc.nextInt();
			Menu.linha();
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
				System.out.println("\nFoi digitado um valor inválido, \npor favor repita a operação!");	
				linha();
			}
		} while (i != 2);
	}

	// função para criação do menu de Relatórios do Diretor
	public static void menuRelatoriosDiretor(Conta conta) throws IOException {
		int i = 1;
		do {
			System.out.println(
					"\nvocê gostaria de fazer qual tipo de \nrelatório\n1 - Saldo\n2 - Relatório de tributação\n3 - Simulação rendimento poupança\n4 - Número de contas da agência\n5 - Nome, CPF e Agência de todas as \ncontas\n6 - Sair");
			int opcao = sc.nextInt();
			Menu.linha();
			System.out.println();
			switch (opcao) {
			case 1:
				System.out.println("O Relatório de saldo foi gerado!\nO saldo atual é: R$" + conta.getSaldo());
				Menu.linha();
				EscritorLeitor.escritorRelatorioSaldo(conta.getNome(),conta.getCpf(),conta.getSaldo());
				break;
			case 2:
				System.out.println("Para cada saque foi cobrado o \nvalor de R$0.10 (dez centavos).");
				System.out.println("Para cada depósito foi cobrado o \nvalor de R$0.10 (dez centavos).");
				System.out.println("Para cada transferência foi cobrado o \nvalor de R$0.20 (vinte centavos).");
				System.out.println("O Relatório de tributação foi gerado!\nO gasto total é: R$"
						+ conta.getQtdMovimentacao() * 0.10);
				EscritorLeitor.escritorRelatorioTributacao(conta.getCpf());
				Menu.linha();
				break;
			case 3:
				System.out.println("você selecionou fazer uma simulação \nrendimento poupança.");
				System.out.printf("Por favor, digite o valor que quer \ncolocar na poupança:\nR$");
				double valor = sc.nextDouble();
				System.out.println("Por favor, digite o valor de dias \nque o dinheiro ficará na poupança: ");
				int dias = sc.nextInt();
				System.out.println("Depositando R$" + valor + " por " + dias + " dias, \nvocê terá um rendimento de R$"
						+ valor * dias * 0.003 / 30 + "!");
				System.out.println("O Relatório de simulação rendimento \npoupança foi gerado.");
				linha();
				EscritorLeitor.escritorRelatorioPoupanca(valor, dias);
				break;
			case 4:
				int count = 0;
				for (Conta value : MapConta.getMap().values()) {
					if (value.getAgencia() == conta.getAgencia()) {
						count++;
					}
				}
				System.out.println("\nA quantidade de contas na agência \n" + conta.getAgencia() + " é: " + count);
				linha();
				EscritorLeitor.escritorRelatorioQtdAgencia(count, conta.getAgencia());
				break;
			case 5:
				System.out.println("Nome       Cpf        Agência");
				for (Conta value : MapConta.getMapS().values()) {
					System.out.println("\n"+value.getNome()+" "+value.getCpf()+" "+value.getAgencia());
				}
				linha();
				System.out.println();
				EscritorLeitor.escritorRelatorioTodasContas();
				break;
			case 6:
				i = 2;
				break;
			default: 
				System.out.println("\nFoi digitado um valor inválido, \npor favor repita a operação!");
				linha();
			}
		} while (i != 2);
	}
	
	//função para criação do menu Presidente
	public static void menuPresidente(Conta conta) throws ContaExceptions, IOException {
		int i = 1;
		do {
			System.out.println("\nBem vinda(o) Presidente, " + conta.getNome()
					+ "!\nO que você gostaria de fazer?\n1 - Movimentações\n2 - Relatórios\n3 - Sair");
			int opcao = sc.nextInt();
			Menu.linha();
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
				System.out.println("\nFoi digitado um valor inválido, \npor favor repita a operação!");	
				linha();
			}
		} while (i != 2);
	}

	// função para criação do menu de Relatórios do Presidente
	public static void menuRelatoriosPresidente(Conta conta) throws IOException {
		int i = 1;
		do {
			System.out.println(
					"\nvocê gostaria de fazer qual tipo de \nrelatório\n1 - Saldo\n2 - Relatório de tributação\n3 - simulação rendimento poupança\n4 - Némero de contas da agência\n5 - Nome, CPF e Agencia de todas as \ncontas\n6 - Valor total dentro do banco\n7 - Sair");
			int opcao = sc.nextInt();
			Menu.linha();
			System.out.println();
			switch (opcao) {
			case 1:
				System.out.println("O Relatório de saldo foi gerado!\nO saldo atual é: R$" + conta.getSaldo());
				Menu.linha();
				EscritorLeitor.escritorRelatorioSaldo(conta.getNome(),conta.getCpf(),conta.getSaldo());
				break;
			case 2:
				System.out.println("Para cada saque foi cobrado o \nvalor de R$0.10 (dez centavos).");
				System.out.println("Para cada depósito foi cobrado o \nvalor de R$0.10 (dez centavos).");
				System.out.println("Para cada transferência foi cobrado o \nvalor de R$0.20 (vinte centavos).");
				System.out.println("O Relatório de tributação foi gerado!\nO gasto total é: R$"
						+ conta.getQtdMovimentacao() * 0.10);
				EscritorLeitor.escritorRelatorioTributacao(conta.getCpf());
				Menu.linha();
				break;
			case 3:
				System.out.println("você selecionou fazer uma simulação \nrendimento poupança.");
				System.out.printf("Por favor, digite o valor que quer \ncolocar na poupança:\nR$");
				double valor = sc.nextDouble();
				System.out.println("Por favor, digite o valor de dias que \no dinheiro ficará na poupança: ");
				int dias = sc.nextInt();
				System.out.println("Depositando R$" + valor + " por " + dias + " dias, \nvocê terá um rendimento de R$"
						+ valor * dias * 0.003 / 30 + "!");
				System.out.println("O Relatório de simulação rendimento \npoupança foi gerado.");
				linha();
				EscritorLeitor.escritorRelatorioPoupanca(valor, dias);
				break;
			case 4:
				int count = 0;
				for (Conta value : MapConta.getMap().values()) {
					if (value.getAgencia() == conta.getAgencia()) {
						count++;
					}
				}
				System.out.println("\nA quantidade de contas na agência " + conta.getAgencia() + " é: " + count);
				linha();
				EscritorLeitor.escritorRelatorioQtdAgencia(count, conta.getAgencia());
				break;
			case 5:
				System.out.println("Nome       Cpf        Agência");
				for (Conta value : MapConta.getMapS().values()) {
					System.out.println("\n"+value.getNome()+" "+value.getCpf()+" "+value.getAgencia());
				}
				
				linha();
				System.out.println();
				EscritorLeitor.escritorRelatorioTodasContas();
				break;
			case 6:
				double sum = 0;
				for (Conta value : MapConta.getMap().values()) {
						sum=sum+value.getSaldo();
				}
				System.out.printf("\nO valor total, em todas as contas do banco, é \nde: R$"+ sum);
				linha();
				EscritorLeitor.escritorRelatorioSaldoTotalBanco(sum);
				System.out.println();
				break;
			case 7:
				i = 2;
				break;
			default: 
				System.out.println("\nFoi digitado um valor inválido, \npor favor repita a operação!");	
				linha();
			}
		} while (i != 2);
	}
	//função para criação do menu movimentações
	public static void menuMovimentacao(Conta conta) throws ContaExceptions, IOException {
		int i = 1;
		do {
			System.out.println(
					"\nvocê gostaria de fazer qual tipo de \nmovimentação?\n1 - Depositar\n2 - Sacar\n3 - Transferir\n4 - Sair");
			int opcao = sc.nextInt();
			Menu.linha();
			switch (opcao) {
			case 1:
				try {
					System.out.println("\nDigite o valor que gostaria de \ndepositar: ");
					Double valor = sc.nextDouble();
					Menu.linha();
					System.out.println();
					conta.depositar(valor);
					System.out.println("\nGostaria de realizar outra transação?\n1 - Sim\n2 - Não");
					i = sc.nextInt();
					Menu.linha();
					if (i != 1 && i != 2) {
						System.out.println("O valor digitado não é válido.\n Repita por favor.");
						Menu.linha();
						System.out.println();
						i = 1;
					}
				} catch (ContaExceptions e) {
					System.out.println(e);
					linha();
				} catch (Exception e) {
					System.out.println("Valor digitado inválido. \nPor favor tente novamente. "+e);
					linha();
				}
				break;
			case 2:
				try {
					System.out.println("\nDigite o valor que gostaria de sacar: ");
					double valor = sc.nextDouble();
					Menu.linha();
					System.out.println();
					conta.sacar(valor);
					System.out.println("\nGostaria de realizar outra transação?\n1 - Sim\n2 - Não");
					i = sc.nextInt();
					Menu.linha();
					if (i != 1 && i != 2) {
						System.out.println("O valor digitado não é válido. Repita por favor.");
						Menu.linha();
						System.out.println();
						i = 1;
					}
				} catch (ContaExceptions e) {
					System.out.println(e);
				}
				break;
			case 3:
				try {
					System.out.println("\nDigite o valor que gostaria de \ntransferir: ");
					double valor = sc.nextDouble();
					System.out.println("Digite o cpf da conta que gostaria \nde transferir para: ");
					String cpf = sc.next();
					Menu.linha();
					System.out.println();
					conta.transfere(valor, cpf);
					System.out.println("\nGostaria de realizar outra transação?\n1 - Sim\n2 - Não");
					i = sc.nextInt();
					Menu.linha();
					if (i != 1 && i != 2) {
						System.out.println("O valor digitado não é válido. \nRepita por favor.");
						Menu.linha();
						System.out.println();
						i = 1;
					}
				} catch (ContaExceptions e) {
					System.out.println(e);
					linha();
				} catch (Exception e) {
					System.out.println("Valor digitado inválido. \nPor favor tente novamente.");
					linha();
				}
				break;
			case 4:
				i = 2;
				break;
			default:
				System.out.println("\nFoi digitado um valor inválido, \npor favor repita a operação!");
				linha();
			}
		} while (i != 2);
	}
	
	//função para criação da logo
	public static String logo() {
		
		return ("      @@@@@@@@@@@@@.@@@@@@@@@@@@@      \r\n"
				+ "      @@                       @@       \r\n"
				+ "      @@    @@@@@@@ @@@        @@       \r\n"
				+ "      @@        @@@ @@@        @@       \r\n"
				+ "      @@        @@@ @@@        @@       \r\n"
				+ "      @@        @@   @@        @@       \r\n"
				+ "      @@   /@.  @@@ @@@        @@       \r\n"
				+ "      @@  @@@.  @@@ @@@        @@       \r\n"
				+ "      @@  @@@@@@@@@ @@@/@@@@   @@       \r\n"
				+ "      @@   #@@@@@@  @@@@@@     @@       \r\n"
				+ "      @@                       @@       \r\n"
				+ "      @@@@@@@@@@@@@.@@@@@@@@@@@@@       \r\n"
				+ "                                ");
	}
	
	//função para criação de linhas"\n"
	public static void linha() {
		for (int i=0;i <= 40;i++) {
			System.out.print("=");
		}
	}

	public static String erroMenu() {
		return "\nErro encontrado: ";
	}
	
}