package applications;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import contas.Conta;

public class EscritorLeitor {
	static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";
	static DateTimeFormatter Format = DateTimeFormatter.ofPattern("ddMMyyyyss");
	static String dateString = LocalDateTime.now().format(Format);
	static DateTimeFormatter Format2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	static String dateString2 = LocalDateTime.now().format(Format2);

	public static void escritorMovimentacoes() throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH_BASICO + dateString + EXTENSAO,StandardCharsets.UTF_8));
		escritor.append(Menu.logo() + "\n");
		for (int i = 0; i < Conta.getQtdMovimentacao(); i++) {
			// Isso significa que a movimentação realizada foi um deposito

			if (Conta.getVetorTipoDaMovimentacao(i).equals("Deposito")) {
				escritor.append("==========Registro de Depósito=========\n");
				escritor.append("Realizador do deposito: \n" + Conta.getVetorCPF(i) + "\n");
				escritor.append("Agência da conta: " + Conta.getVetorAgencia(i) + "\n");
				escritor.append("Valor depositado: \nR$ " + Conta.getVetorValor(i) + "\n");
				escritor.append("Custo da movimentação: \nR$ 0,10\n");
				escritor.append("Saldo após o deposito: \nR$ " + Conta.getVetorSaldo(i) + "\n");
				escritor.append("Data da realização do deposito: \n" + Conta.getVetorTempo(i) + "\n\n");
			} else if (Conta.getVetorTipoDaMovimentacao(i).equals("Saque")) {
				escritor.append("==========Registro de Saque==========\n");
				escritor.append("Realizador do Saque: \n" + Conta.getVetorCPF(i) + "\n");
				escritor.append("Agência da conta: " + Conta.getVetorAgencia(i) + "\n");
				escritor.append("Valor sacado: \nR$ " + Conta.getVetorValor(i) + "\n");
				escritor.append("Custo da movimentação: \nR $0,10\n");
				escritor.append("Saldo após o saque: \nR$ " + Conta.getVetorSaldo(i) + "\n");
				escritor.append("Data da realização do saque: \n" + Conta.getVetorTempo(i) + "\n\n");
			} else if (Conta.getVetorTipoDaMovimentacao(i).equals("Transferencia")) {
				escritor.append("=======Registro de Transfêrencia=======\n");
				escritor.append("Realizador da transferência: \n" + Conta.getVetorCPF(i) + "\n");
				escritor.append("Agência da conta: " + Conta.getVetorAgencia(i) + "\n");
				escritor.append("Valor transferido: \nR$ " + Conta.getVetorValor(i) + "\n");
				escritor.append("Custo da movimentação: \nR$ 0,20\n");
				escritor.append("Saldo após a transfêrencia: \nR$ " + Conta.getVetorSaldo(i) + "\n");
				escritor.append("Conta que receberá a transferência: \n" + Conta.getVetorCPFT(i) + "\n");
				escritor.append("Data da realização da transferência: \n" + Conta.getVetorTempo(i) + "\n\n");
			}
		}
		escritor.close();
	}

	public static void escritorRelatorioSaldo(String nome, String cpf, double saldo) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH_BASICO + dateString + "RSaldo" + EXTENSAO,StandardCharsets.UTF_8));
		escritor.append(Menu.logo() + "\n");
		escritor.append("===========Registro de Saldo===========\n");
		escritor.append("O seu saldo, " + nome + " é de R$" + saldo +"\n");
		escritor.append("Data da realização do registro: \n" + dateString2 + "\n\n");
		escritor.close();
	}

	public static void escritorRelatorioTributacao(String cpf) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH_BASICO + dateString+ "RTributacao" + EXTENSAO,StandardCharsets.UTF_8));
		escritor.append(Menu.logo() + "\n");
		escritor.append("=========Registro de Tributação=========\n");
		escritor.append("Para cada saque foi cobrado o valor de\nR$0.10 (dez centavos).\n");
		escritor.append("Para cada depósito foi cobrado \no valor de R$0.10 (dez centavos).\n");
		escritor.append("Para cada transferência foi cobrado \no valor de R$0.20 (vinte centavos).\n\n");
		escritor.append("A quantidade de transações foi de "+ Conta.getQtdMovimentacao() +",\ntotalizando um valor total de R$"+ Conta.getQtdMovimentacao()*0.10+".\n\n");
		
		if (MapUsuario.getMap().get(cpf).getSeguroDeVida()>=0) {
			escritor.append("O valor aplicado em seguro \nde vida é de R$"+ MapUsuario.getMap().get(cpf).getSeguroDeVida()+"\n");
		}
		escritor.append("Data da realização do registro: \n" + dateString2 + "\n\n");
		escritor.close();
	}

	public static void escritorRelatorioPoupanca(double valor, int dias) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH_BASICO + dateString + "RPoupanca" + EXTENSAO,StandardCharsets.UTF_8));
		escritor.append(Menu.logo() + "\n");
		escritor.append("===Registro de relatório de Poupança===\n");
		escritor.append("Depositando R$" + valor + " por " + dias + " dias, \nvocê terá um rendimento de R$" + valor*dias*0.003/30 +" !\n");
		escritor.append("Data da realização do registro: \n" + dateString2 + "\n\n");
		escritor.close();
	}

	public static void escritorRelatorioQtdAgencia(int count, int agencia) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH_BASICO + dateString + "RQtdAgencia" + EXTENSAO,StandardCharsets.UTF_8));
		escritor.append(Menu.logo() + "\n");
		escritor.append("====Registro de relatório de Agencia====\n");
		escritor.append("\nA quantidade de contas na agência " + agencia + " \né igual a: " + count+".\n");
		escritor.append("Data da realização do registro: \n" + dateString2 + "\n\n");
		escritor.close();
	}

	public static void escritorRelatorioTodasContas() throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH_BASICO + dateString + "RTodasContas" + EXTENSAO,StandardCharsets.UTF_8));
		escritor.append(Menu.logo() + "\n");
		escritor.append("====Registro de relatório de Contas====\n");
		escritor.append("Nome       Cpf        Agência");
		for (Conta value : MapConta.getMapS().values()) {
			escritor.append("\n"+value.getNome()+" "+value.getCpf()+" "+value.getAgencia()+"\n");
		}
		escritor.append("Data da realização do registro: " + dateString2 + "\n\n");
		escritor.close();
	}

	public static void escritorRelatorioSaldoTotalBanco(double sum) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH_BASICO + dateString + "RSaldoTotalBanco" + EXTENSAO,StandardCharsets.UTF_8));
		escritor.append(Menu.logo() + "\n");
		escritor.append("=====Registro de relatório de Saldo======\n");
		escritor.append("\nO valor total, em todas as contas\n do banco, é de: R$"+ sum+".\n");
		escritor.append("Data da realização do registro: \n" + dateString2 + "\n\n");
		escritor.close();
	}
}
