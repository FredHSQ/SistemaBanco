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
	static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";
	static DateTimeFormatter Format = DateTimeFormatter.ofPattern("ddMMyyyyss");
	static String dateString = LocalDateTime.now().format(Format);

	public static void escritorMovimentacoes() throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH_BASICO + dateString + EXTENSAO));
		escritor.append(Menu.logo() + "\n");
		for (int i = 0; i < Conta.getQtdMovimentacao(); i++) {
			// Isso significa que a movimentação realizada foi um deposito
			if (Conta.getVetorTipoDaMovimentacao(i).equals("Deposito")) {
				escritor.append("================Registro de Deposito================\n");
				escritor.append("Realizador do deposito: " + Conta.getVetorCPF(i) + "\n");
				escritor.append("Agência da conta: " + Conta.getVetorAgencia(i) + "\n");
				escritor.append("Valor depositado: " + Conta.getVetorValor(i) + "\n");
				escritor.append("Saldo apos o deposito: " + Conta.getVetorSaldo(i) + "\n");
				escritor.append("Data da realização do deposito: " + Conta.getVetorTempo(i) + "\n\n");
			}else if (Conta.getVetorTipoDaMovimentacao(i).equals("Saque")) {
				escritor.append("================Registro de Saque================\n");
				escritor.append("Realizador do Saque: " + Conta.getVetorCPF(i) + "\n");
				escritor.append("Agência da conta: " + Conta.getVetorAgencia(i) + "\n");
				escritor.append("Valor sacado: " + Conta.getVetorValor(i) + "\n");
				escritor.append("Saldo apos o saque: " + Conta.getVetorSaldo(i) + "\n");
				escritor.append("Data da realização do saque: " + Conta.getVetorTempo(i) + "\n\n");
			}else if (Conta.getVetorTipoDaMovimentacao(i).equals("Transferencia")) {
				escritor.append("================Registro de Transferencia================\n");
				escritor.append("Realizador da transferencia: " + Conta.getVetorCPF(i) + "\n");
				escritor.append("Agência da conta: " + Conta.getVetorAgencia(i) + "\n");
				escritor.append("Valor transferido: " + Conta.getVetorValor(i) + "\n");
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
		escritor.append("O seu saldo, " + nome + " é R$" + saldo);
		escritor.append("Data da realização do deposito: " + dateString + "\n\n");
	}

	public static void escritorRelatorioTributacao() throws IOException {

	}

	public static void escritorRelatorioPoupanca() throws IOException {

	}

	public static void escritorRelatorioQtdAgencia() throws IOException {

	}

	public static void escritorRelatorioTodasContas() throws IOException {

	}

	public static void escritorRelatorioSaldoTotalBanco() throws IOException {

	}
}
