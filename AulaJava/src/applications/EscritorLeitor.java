package applications;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import bancoEnum.CargoEnum;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import usuario.Cliente;
import usuario.Diretor;
import usuario.Gerente;
import usuario.Presidente;
import usuario.Usuario;

public class EscritorLeitor {
	static final String PATH_BASICO = "../temp/";
	static final String EXTENSAO = ".txt";
	static DateTimeFormatter Format = DateTimeFormatter.ofPattern("ddMMyyyyss");
	static String dateString = LocalDateTime.now().format(Format);

	public static void escritorMovimentacoes() throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH_BASICO + dateString + EXTENSAO));
		escritor.append(Menu.logo() + "\n");
		for (int i = 0; i < Conta.getQtdMovimentacao(); i++) {
			// Isso significa que a movimentação realizada foi um deposito
//			switch (Conta.getVetorTipoDaMovimentacao(i)) {
//			case ("Deposito"):
//				escritor.append("================Registro de Deposito================\n");
//				escritor.append("Realizador do deposito: " + Conta.getVetorCPF(i) + "\n");
//				escritor.append("Agência da conta: " + Conta.getVetorAgencia(i) + "\n");
//				escritor.append("Valor depositado: " + Conta.getVetorValor(i) + "\n");
//				escritor.append("Custo da movimentação: R$0,10\n");
//				escritor.append("Saldo apos o deposito: " + Conta.getVetorSaldo(i) + "\n");
//				escritor.append("Data da realização do deposito: " + Conta.getVetorTempo(i) + "\n\n");
//				break;
//			case ("Saque"):
//				escritor.append("================Registro de Saque================\n");
//				escritor.append("Realizador do Saque: " + Conta.getVetorCPF(i) + "\n");
//				escritor.append("Agência da conta: " + Conta.getVetorAgencia(i) + "\n");
//				escritor.append("Valor sacado: " + Conta.getVetorValor(i) + "\n");
//				escritor.append("Custo da movimentação: R$0,10\n");
//				escritor.append("Saldo apos o saque: " + Conta.getVetorSaldo(i) + "\n");
//				escritor.append("Data da realização do saque: " + Conta.getVetorTempo(i) + "\n\n");
//				break;
//			case ("Transferencia"):
//				escritor.append("================Registro de Transferencia================\n");
//				escritor.append("Realizador da transferencia: " + Conta.getVetorCPF(i) + "\n");
//				escritor.append("Agência da conta: " + Conta.getVetorAgencia(i) + "\n");
//				escritor.append("Valor transferido: " + Conta.getVetorValor(i) + "\n");
//				escritor.append("Custo da movimentação: R$0,20\n");
//				escritor.append("Saldo apos a transferencia: " + Conta.getVetorSaldo(i) + "\n");
//				escritor.append("Conta que receberá a transferência: " + Conta.getVetorCPFT(i) + "\n");
//				escritor.append("Data da realização da transferência: " + Conta.getVetorTempo(i) + "\n\n");
//				break;
//			default:
//				break;
//			}
			if (Conta.getVetorTipoDaMovimentacao(i).equals("Deposito")) {
				escritor.append("================Registro de Deposito================\n");
				escritor.append("Realizador do deposito: " + Conta.getVetorCPF(i) + "\n");
				escritor.append("Agência da conta: " + Conta.getVetorAgencia(i) + "\n");
				escritor.append("Valor depositado: " + Conta.getVetorValor(i) + "\n");
				escritor.append("Custo da movimentação: R$0,10\n");
				escritor.append("Saldo apos o deposito: " + Conta.getVetorSaldo(i) + "\n");
				escritor.append("Data da realização do deposito: " + Conta.getVetorTempo(i) + "\n\n");
			} else if (Conta.getVetorTipoDaMovimentacao(i).equals("Saque")) {
				escritor.append("================Registro de Saque================\n");
				escritor.append("Realizador do Saque: " + Conta.getVetorCPF(i) + "\n");
				escritor.append("Agência da conta: " + Conta.getVetorAgencia(i) + "\n");
				escritor.append("Valor sacado: " + Conta.getVetorValor(i) + "\n");
				escritor.append("Custo da movimentação: R$0,10\n");
				escritor.append("Saldo apos o saque: " + Conta.getVetorSaldo(i) + "\n");
				escritor.append("Data da realização do saque: " + Conta.getVetorTempo(i) + "\n\n");
			} else if (Conta.getVetorTipoDaMovimentacao(i).equals("Transferencia")) {
				escritor.append("================Registro de Transferencia================\n");
				escritor.append("Realizador da transferencia: " + Conta.getVetorCPF(i) + "\n");
				escritor.append("Agência da conta: " + Conta.getVetorAgencia(i) + "\n");
				escritor.append("Valor transferido: " + Conta.getVetorValor(i) + "\n");
				escritor.append("Custo da movimentação: R$0,20\n");
				escritor.append("Saldo apos a transferencia: " + Conta.getVetorSaldo(i) + "\n");
				escritor.append("Conta que receberá a transferência: " + Conta.getVetorCPFT(i) + "\n");
				escritor.append("Data da realização da transferência: " + Conta.getVetorTempo(i) + "\n\n");
			}
		}
		escritor.close();
	}


	public static void escritorRelatorioSaldo(String nome, String cpf, double saldo) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH_BASICO + dateString + EXTENSAO+"RSaldo"));
		escritor.append("================Registro de Saldo================\n");
		escritor.append("O seu saldo, " + nome + " é R$" + saldo +".\n");
		escritor.append("Data da realização do registro: " + dateString + "\n\n");
	}

	public static void escritorRelatorioTributacao() throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH_BASICO + dateString + EXTENSAO+"RSaldo"));
		escritor.append("================Registro de tributação================\n");
		escritor.append("A quantidade de transações foi de "+ Conta.getQtdMovimentacao() +", totalizando um valor total de R$"+ Conta.getQtdMovimentacao()*0.10+".\n");
		escritor.append("Data da realização do registro: " + dateString + "\n\n");
	}

	public static void escritorRelatorioPoupanca(double valor, int dias) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH_BASICO + dateString + EXTENSAO+"RSaldo"));
		escritor.append("================Registro de relatório de poupança================\n");
		escritor.append("Depositando R$" + valor + " por " + dias + " dias, você terá um rendimento de R$" + valor*dias*0.003/30 +"!\n");
		escritor.append("Data da realização do registro: " + dateString + "\n\n");
	}

	public static void escritorRelatorioQtdAgencia(int count, int agencia) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH_BASICO + dateString + EXTENSAO+"RSaldo"));
		escritor.append("================Registro de relatório de agencia================\n");
		escritor.append("\nA quantidade de contas na agencia" + agencia + " é: " + count+".\n");
		escritor.append("Data da realização do registro: " + dateString + "\n\n");
	}

	public static void escritorRelatorioTodasContas() throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH_BASICO + dateString + EXTENSAO+"RSaldo"));
		escritor.append("================Registro de relatório de contas================\n");
		for (Conta value : MapConta.getMapS().values()) {
			escritor.append("\n"+value.getNome()+" "+value.getCpf()+" "+value.getAgencia()+"\n");
		}
		escritor.append("Data da realização do registro: " + dateString + "\n\n");
	}

	public static void escritorRelatorioSaldoTotalBanco(double sum) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH_BASICO + dateString + EXTENSAO+"RSaldo"));
		escritor.append("================Registro de relatório de saldo================\n");
		escritor.append("\nO valor total, em todas as contas do banco, é de: R$"+ sum+".\n");
		escritor.append("Data da realização do registro: " + dateString + "\n\n");
	}
}
