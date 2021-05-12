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
		System.out.println("\n   |Bem vindo ao Banco Justice League|");
		linha(); 
		System.out.println();
	}

	// função para criação do menu cliente
	public static void menuCLiente(Conta conta) throws ContaExceptions, IOException {
		// variavel para parar o "do"
		int i = 1;
		// do para repetir o menu caso de algum erro ou a pessoa volte de um menu mais avançado, só sai do menu caso a pessoa aperte o numero de saida
		do {
			System.out.println("\nBem vinda(o), " + conta.getNome()
					+ "!\nO que você gostaria de fazer?\n1 - Movimentações\n2 - Relatórios\n3 - Sair");
			// variavel para entrar nos casos
			String opcao = sc.next();
			Menu.linha();
			// switch case para fazer oque está escrito no System.out.println
			switch (opcao) {
			case "1":
				menuMovimentacao(conta);
				break;
			case "2":
				menuRelatoriosCliente(conta);
				break;
			case "3":
				Escritor.escritorMovimentacoes();
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
		// variavel para parar o "do"
		int i = 1;
		// do para repetir o menu caso de algum erro ou a pessoa volte de um menu mais avançado, só sai do menu caso a pessoa aperte o numero de saida
		do {
			System.out.println(
					"\nVocê gostaria de fazer qual tipo de \nrelatório\n1 - Saldo\n2 - Relatório de tributação\n3 - Simulação rendimento poupança\n4 - Seguro de vida\n5 - Sair");
			// variavel para entrar nos casos
			String opcao = sc.next();
			Menu.linha();
			System.out.println();
			// switch case para fazer oque está escrito no System.out.println
			switch (opcao) {
			// relatório de saldo, mostra o saldo atual da conta do login, e chama o escritor, jogando os dados nescessários
			case "1":
				System.out.println("O Relatório de saldo foi gerado!\nO saldo atual é: R$" + conta.getSaldo()+ ".");
				Menu.linha();
				Escritor.escritorRelatorioSaldo(conta.getCpf(),conta.getNome(), conta.getSaldo());
				break;
			// relatório de tributação, mostra o custo das movimentações da conta do login, e chama o escritor, jogando os dados nescessários
			case "2":
				System.out.println("Para cada saque foi cobrado o valor \nde R$0.10 (dez centavos).");
				System.out.println("Para cada depósito foi cobrado o valor \nde R$0.10 (dez centavos).");
				System.out.println("Para cada transferência foi cobrado o valor \nde R$0.20 (vinte centavos).");
				System.out.println("O Relatório de tributação foi gerado!\nO gasto total é: R$"
						+ conta.getQtdMovimentacao() * 0.10);
				// if para caso o usuario tenha seguro de vida
				if (MapUsuario.getMap().get(conta.getCpf()).getSeguroDeVida()>=0) {
					System.out.println("O valor aplicado em seguro de vida é \nde R$"+ MapUsuario.getMap().get(conta.getCpf()).getSeguroDeVida()+"\n");
				}
				Escritor.escritorRelatorioTributacao(conta.getCpf());
				Menu.linha();
				break;
			// relatório de simulação de rendimento da poupança, pede dados e retorna a simulação, e chama o escritor, jogando os dados nescessário
			case "3":
				System.out.println("Você selecionou fazer uma simulação \nrendimento poupança.");
				System.out.printf("Por favor, digite o valor que quer \ncolocar na poupança:\nR$");
				double valor = sc.nextDouble();
				System.out.println("Por favor, digite o valor de dias \nque o dinheiro ficará na poupança: ");
				int dias = sc.nextInt();
				// faz o calculo, pegamos o rendimento por mês e dividimos pela quantidade de dias
				// como é uma simulação não tratamos o fato do valor só poder ser resgatado a cada 30 dias
				 System.out.println("Depositando R$" + valor + " por " + dias + " dias, \nvocê terá um rendimento de R$"
						+ valor * dias * 0.003 / 30 + "!");
				System.out.println("O Relatório de simulação rendimento \nde poupança foi gerado.");
				linha();
				Escritor.escritorRelatorioPoupanca(valor, dias);
				break;
			// desafio proposto
			// criador de seguro de vida, pede dados e da avisos, e chama o escritor, jogando os dados nescessário
			case "4":
				// informativo do custo, e verifica se a pessoa quer ou não fazer o seguro sabendo do custo.
				System.out
						.println("Será debitado 20% do valor segurado.\nvocê gostaria de continuar?\n1 - Sim\n2 - Não");
				String opcaoSeguro = sc.next();
				linha();
				// if para decisão feita a cima
				if (opcaoSeguro == "1") {
					System.out.println("\nQual valor você gostaria de aplicar \nno seguro de vida?");
					double aplicacao = sc.nextDouble();
					// se o custo da aplicação for maior que o saldo não permite a operação
					if (aplicacao * 0.2 < conta.getSaldo()) {
						// faz o debito do saldo do custo da aplicação
						conta.setSaldo(conta.getSaldo() - aplicacao * 0.20);
						System.out.println("Seguro de vida contratado com \nsucesso!");
						linha();
						// guarda o valor aplicado
						MapUsuario.getMap().get(conta.getCpf()).setSeguroDeVida(aplicacao);
					} else {
						System.out.println("\nSaldo insuficiente para esta \noperação." + "\noperação não realizada.");
						linha();
					}
				}else {
					System.out.println("\nFoi digitado um valor inválido, \npor favor repita a operação!");	
					linha();
				}
				break;
			case "5":
				i = 2;
				break;
			default: 
				System.out.println("\nFoi digitado um valor inválido, \npor favor repita a operação!");	
				linha();
			}
		} while (i != 2);

	}

	// função para criação do menu Gerente, o menu gerente é iqual ao menu cliente porém jogando nas funções especificas
	// qualquer outra diferença será comentada
	public static void menuGerente(Conta conta) throws ContaExceptions, IOException {
		int i = 1;
		do {
			System.out.println("\nBem vinda(o) Gerente, " + conta.getNome()
					+ "!\nO que você gostaria de fazer?\n1 - Movimentações\n2 - Relatórios\n3 - Sair");
			String opcao = sc.next();
			Menu.linha();
			switch (opcao) {
			case "1":
				menuMovimentacao(conta);
				break;
			case "2":
				menuRelatoriosGerente(conta);
				break;
			case "3":
				Escritor.escritorMovimentacoes();
				i = 2;
				break;
			default: 
				System.out.println("\nFoi digitado um valor inválido, \npor favor repita a operação!");	
				linha();
			}
		} while (i != 2);
	}

	// função para criação do menu relatórios do Gerente, o menu relatórios do Gerente é iqual ao menu relatórios do cliente
	// porém jogando nas funções especificas
	// qualquer outra diferença será comentada
	public static void menuRelatoriosGerente(Conta conta) throws IOException {
		int i = 1;
		do {
			System.out.println(
					"\nVocê gostaria de fazer qual tipo de \nrelatório\n1 - Saldo\n2 - Relatório de tributação\n3 - Simulação rendimento poupança\n4 - Número de contas da agência\n5 - Sair");
			String opcao = sc.next();
			Menu.linha();
			System.out.println();
			switch (opcao) {
			case "1":
				System.out.println("O Relatório de saldo foi gerado!\nO saldo atual é: R$" + conta.getSaldo());
				Menu.linha();
				Escritor.escritorRelatorioSaldo(conta.getNome(),conta.getCpf(),conta.getSaldo());
				break;
			case "2":
				System.out.println("Para cada saque foi cobrado o \nvalor de R$0.10 (dez centavos).");
				System.out.println("Para cada depósito foi cobrado o \nvalor de R$0.10 (dez centavos).");
				System.out.println("Para cada transferência foi cobrado o \nvalor de R$0.20 (vinte centavos).");
				System.out.println("O Relatório de tributação foi gerado!\nO gasto total é: R$" + conta.getQtdMovimentacao()*0.10);
				Escritor.escritorRelatorioTributacao(conta.getCpf());
				Menu.linha();
				break;
			case "3":
				System.out.println("Você selecionou fazer uma simulação \nrendimento poupança.");
				System.out.printf("Por favor, digite o valor que quer \ncolocar na poupança:\nR$");
				double valor = sc.nextDouble();
				System.out.println("Por favor, digite o valor de dias \nque o dinheiro ficará na poupança: ");
				int dias = sc.nextInt();
				System.out.println("Depositando R$" + valor + "\npor " + dias + " dias, \nvocê terá um rendimento de R$" + valor*dias*0.003/30 +"!");
				System.out.println("O Relatório de simulação rendimento \npoupança foi gerado.");
				linha();
				Escritor.escritorRelatorioPoupanca(valor, dias);
				break;
			// caso que não existe no cliente
			// para pegar a quantidade de contas na agencia
			case "4":
				// variavel para contar o numero de contas
				int count = 0;
				// variar entre todas as contas do sistema
				for(Conta value : MapConta.getMap().values()) {
				  if (value.getAgencia()==conta.getAgencia()) {
				    count++;
				  }
				}
				System.out.println("A quantidade de contas na agência \n" + conta.getAgencia() + " é: " + count);
				linha();
				Escritor.escritorRelatorioQtdAgencia(count, conta.getAgencia());
				break;
			case "5":
				i=2;
				break;
			default: 
				System.out.println("\nFoi digitado um valor inválido, \npor favor repita a operação!");	
				linha();
			}
		}while (i!=2);
	}
		
	// função para criação do menu Diretor, o menu diretor é iqual ao menu gerente porém jogando nas funções especificas
	// qualquer outra diferença será comentada
	public static void menuDiretor(Conta conta) throws ContaExceptions, IOException {
		int i = 1;
		do {
			System.out.println("\nBem vinda(o) Diretora(o), " + conta.getNome()
					+ "!\nO que você gostaria de fazer?\n1 - Movimentações\n2 - Relatórios\n3 - Sair");
			String opcao = sc.next();
			Menu.linha();
			switch (opcao) {
			case "1":
				menuMovimentacao(conta);
				break;
			case "2":
				menuRelatoriosDiretor(conta);
				break;
			case "3":
				Escritor.escritorMovimentacoes();
				i = 2;
				break;
			default: 
				System.out.println("\nFoi digitado um valor inválido, \npor favor repita a operação!");	
				linha();
			}
		} while (i != 2);
	}

	// função para criação do menu relatórios do Diretor, o menu relatórios do Diretor é iqual ao menu relatórios do gerente
	// porém jogando nas funções especificas
	// qualquer outra diferença será comentada
	public static void menuRelatoriosDiretor(Conta conta) throws IOException {
		int i = 1;
		do {
			System.out.println(
					"\nVocê gostaria de fazer qual tipo de \nrelatório\n1 - Saldo\n2 - Relatório de tributação\n3 - Simulação rendimento poupança\n4 - Número de contas da agência\n5 - Nome, CPF e Agência de todas as \ncontas\n6 - Sair");
			String opcao = sc.next();
			Menu.linha();
			System.out.println();
			switch (opcao) {
			case "1":
				System.out.println("O Relatório de saldo foi gerado!\nO saldo atual é: R$" + conta.getSaldo());
				Menu.linha();
				Escritor.escritorRelatorioSaldo(conta.getNome(),conta.getCpf(),conta.getSaldo());
				break;
			case "2":
				System.out.println("Para cada saque foi cobrado o \nvalor de R$0.10 (dez centavos).");
				System.out.println("Para cada depósito foi cobrado o \nvalor de R$0.10 (dez centavos).");
				System.out.println("Para cada transferência foi cobrado o \nvalor de R$0.20 (vinte centavos).");
				System.out.println("O Relatório de tributação foi gerado!\nO gasto total é: R$"
						+ conta.getQtdMovimentacao() * 0.10);
				Escritor.escritorRelatorioTributacao(conta.getCpf());
				Menu.linha();
				break;
			case "3":
				System.out.println("Você selecionou fazer uma simulação \nrendimento poupança.");
				System.out.printf("Por favor, digite o valor que quer \ncolocar na poupança:\nR$");
				double valor = sc.nextDouble();
				System.out.println("Por favor, digite o valor de dias \nque o dinheiro ficará na poupança: ");
				int dias = sc.nextInt();
				System.out.println("Depositando R$" + valor + " por " + dias + " dias, \nvocê terá um rendimento de R$"
						+ valor * dias * 0.003 / 30 + "!");
				System.out.println("O Relatório de simulação rendimento \npoupança foi gerado.");
				linha();
				Escritor.escritorRelatorioPoupanca(valor, dias);
				break;
			case "4":
				int count = 0;
				for (Conta value : MapConta.getMap().values()) {
					if (value.getAgencia() == conta.getAgencia()) {
						count++;
					}
				}
				System.out.println("\nA quantidade de contas na agência \n" + conta.getAgencia() + " é: " + count);
				linha();
				Escritor.escritorRelatorioQtdAgencia(count, conta.getAgencia());
				break;
			// caso que não existe no gerente
			// para pegar todos os nomes, cpf e agencias, de todas as contas do banco
			case "5":
				System.out.println("Nome       Cpf        Agência");
				// for para variar em todas as contas e imprimir os valores do mapa já ordenado
				for (Conta value : MapConta.getMapS().values()) {
					System.out.println("\n"+value.getNome()+" "+value.getCpf()+" "+value.getAgencia());
				}
				linha();
				System.out.println();
				Escritor.escritorRelatorioTodasContas();
				break;
			case "6":
				i = 2;
				break;
			default: 
				System.out.println("\nFoi digitado um valor inválido, \npor favor repita a operação!");
				linha();
			}
		} while (i != 2);
	}
	
	// função para criação do menu presidente, o menu presidente é iqual ao menu diretor porém jogando nas funções especificas
	// qualquer outra diferença será comentada
	public static void menuPresidente(Conta conta) throws ContaExceptions, IOException {
		int i = 1;
		do {
			System.out.println("\nBem vinda(o) Presidente, " + conta.getNome()
					+ "!\nO que você gostaria de fazer?\n1 - Movimentações\n2 - Relatórios\n3 - Sair");
			String opcao = sc.next();
			Menu.linha();
			switch (opcao) {
			case "1":
				menuMovimentacao(conta);
				break;
			case "2":
				menuRelatoriosPresidente(conta);
				break;
			case "3":
				Escritor.escritorMovimentacoes();
				i = 2;
				break;
			default: 
				System.out.println("\nFoi digitado um valor inválido, \npor favor repita a operação!");	
				linha();
			}
		} while (i != 2);
	}

	// função para criação do menu relatórios do Presidente, o menu relatórios do Presidente é iqual ao menu relatórios do Diretor
	// porém jogando nas funções especificas
	// qualquer outra diferença será comentada
	public static void menuRelatoriosPresidente(Conta conta) throws IOException {
		int i = 1;
		do {
			System.out.println(
					"\nVocê gostaria de fazer qual tipo de \nrelatório\n1 - Saldo\n2 - Relatório de tributação\n3 - simulação rendimento poupança\n4 - Némero de contas da agência\n5 - Nome, CPF e Agencia de todas as \ncontas\n6 - Valor total dentro do banco\n7 - Sair");
			String opcao = sc.next();
			Menu.linha();
			System.out.println();
			switch (opcao) {
			case "1":
				System.out.println("O Relatório de saldo foi gerado!\nO saldo atual é: R$" + conta.getSaldo());
				Menu.linha();
				Escritor.escritorRelatorioSaldo(conta.getNome(),conta.getCpf(),conta.getSaldo());
				break;
			case "2":
				System.out.println("Para cada saque foi cobrado o \nvalor de R$0.10 (dez centavos).");
				System.out.println("Para cada depósito foi cobrado o \nvalor de R$0.10 (dez centavos).");
				System.out.println("Para cada transferência foi cobrado o \nvalor de R$0.20 (vinte centavos).");
				System.out.println("O Relatório de tributação foi gerado!\nO gasto total é: R$"
						+ conta.getQtdMovimentacao() * 0.10);
				Escritor.escritorRelatorioTributacao(conta.getCpf());
				Menu.linha();
				break;
			case "3":
				System.out.println("Você selecionou fazer uma simulação \nrendimento poupança.");
				System.out.printf("Por favor, digite o valor que quer \ncolocar na poupança:\nR$");
				double valor = sc.nextDouble();
				System.out.println("Por favor, digite o valor de dias que \no dinheiro ficará na poupança: ");
				int dias = sc.nextInt();
				System.out.println("Depositando R$" + valor + " por " + dias + " dias, \nvocê terá um rendimento de R$"
						+ valor * dias * 0.003 / 30 + "!");
				System.out.println("O Relatório de simulação rendimento \npoupança foi gerado.");
				linha();
				Escritor.escritorRelatorioPoupanca(valor, dias);
				break;
			case "4":
				int count = 0;
				for (Conta value : MapConta.getMap().values()) {
					if (value.getAgencia() == conta.getAgencia()) {
						count++;
					}
				}
				System.out.println("\nA quantidade de contas na agência " + conta.getAgencia() + " é: " + count);
				linha();
				Escritor.escritorRelatorioQtdAgencia(count, conta.getAgencia());
				break;
			case "5":
				System.out.println("Nome       Cpf        Agência");
				for (Conta value : MapConta.getMapS().values()) {
					System.out.println("\n"+value.getNome()+" "+value.getCpf()+" "+value.getAgencia());
				}
				
				linha();
				System.out.println();
				Escritor.escritorRelatorioTodasContas();
				break;
			// caso que não existe no Diretor
			// para pegar a soma dos saldos de todas as contas do banco
			case "6":
				// armazenador da soma
				double sum = 0;
				//for para variar em todas as contas e somar seus saldos
				for (Conta value : MapConta.getMap().values()) {
						sum=sum+value.getSaldo();
				}
				System.out.printf("\nO valor total, em todas as contas do banco, é \nde: R$"+ sum);
				linha();
				Escritor.escritorRelatorioSaldoTotalBanco(sum);
				System.out.println();
				break;
			case "7":
				i = 2;
				break;
			default: 
				System.out.println("\nFoi digitado um valor inválido, \npor favor repita a operação!");	
				linha();
			}
		} while (i != 2);
	}

	//função para criação do menu movimentações, padrão para todos os tipos de usuários
	public static void menuMovimentacao(Conta conta) throws ContaExceptions, IOException {
		String i = "1";
		// do para repetir o menu caso de algum erro ou a pessoa volte de um menu mais avançado, só sai do menu caso a pessoa aperte o numero de saida
		do {
			System.out.println(
					"\nVocê gostaria de fazer qual tipo de \nmovimentação?\n1 - Depositar\n2 - Sacar\n3 - Transferir\n4 - Sair");
			String opcao = sc.next();
			Menu.linha();
			switch (opcao) {
			// caso do desposito, pede um valor para o usuario e joga na função que deposita na conta logada
			case "1":
				// tratamento de erro caso valor do deposito seja menor ou iqual a 0
				try {
					System.out.println("\nDigite o valor que gostaria de \ndepositar: ");
					Double valor = sc.nextDouble();
					Menu.linha();
					System.out.println();
					conta.depositar(valor);

				} catch (ContaExceptions e) {
					System.out.println(e);
					linha();
				} catch (Exception e) {
					System.out.println("\nValor digitado inválido. \nPor favor tente novamente. "+e);
					linha();
				}
				break;
			// caso do saque, pede um valor para o usuario e joga na função que saca na conta logada
			case "2":
				try {
					System.out.println("\nDigite o valor que gostaria de sacar: ");
					double valor = sc.nextDouble();
					Menu.linha();
					System.out.println();
					conta.sacar(valor);

				} catch (ContaExceptions e) {
					System.out.println(e);
				}
				break;
			// caso da transferência, pede um valor para o usuario e uma conta destino. Joga na função que transfere na conta logada para conta destino.
			case "3":
				try {
					System.out.println("\nDigite o valor que gostaria de \ntransferir: ");
					double valor = sc.nextDouble();
					System.out.println("Digite o cpf da conta que gostaria \nde transferir para: ");
					String cpf = sc.next();
					Menu.linha();
					System.out.println();
					conta.transfere(valor, cpf);

				} catch (ContaExceptions e) {
					System.out.println(e);
					linha();
				} catch (Exception e) {
					System.out.println("Valor digitado inválido. \nPor favor tente novamente.");
					linha();
				}
				break;
			case "4":
				i = "2";
				break;
			default:
				System.out.println("\nFoi digitado um valor inválido, \npor favor repita a operação!");
				linha();
			}
		} while (i != "2");
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