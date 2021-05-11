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
	static DateTimeFormatter Format2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	static String dateString2 = LocalDateTime.now().format(Format2);

	public static void escritorMovimentacoes() throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH_BASICO + dateString + EXTENSAO));
		escritor.append(Menu.logo() + "\n");
		for (int i = 0; i < Conta.getQtdMovimentacao(); i++) {
			// Isso significa que a movimenta��o realizada foi um deposito

			if (Conta.getVetorTipoDaMovimentacao(i).equals("Deposito")) {
				escritor.append("===================Registro de Deposito==================\n");
				escritor.append("Realizador do deposito: " + Conta.getVetorCPF(i) + "\n");
				escritor.append("Ag�ncia da conta: " + Conta.getVetorAgencia(i) + "\n");
				escritor.append("Valor depositado: " + Conta.getVetorValor(i) + "\n");
				escritor.append("Custo da movimenta��o: R$0,10\n");
				escritor.append("Saldo apos o deposito: " + Conta.getVetorSaldo(i) + "\n");
				escritor.append("Data da realiza��o do deposito: " + Conta.getVetorTempo(i) + "\n\n");
			} else if (Conta.getVetorTipoDaMovimentacao(i).equals("Saque")) {
				escritor.append("====================Registro de Saque====================\n");
				escritor.append("Realizador do Saque: " + Conta.getVetorCPF(i) + "\n");
				escritor.append("Ag�ncia da conta: " + Conta.getVetorAgencia(i) + "\n");
				escritor.append("Valor sacado: " + Conta.getVetorValor(i) + "\n");
				escritor.append("Custo da movimenta��o: R$0,10\n");
				escritor.append("Saldo apos o saque: " + Conta.getVetorSaldo(i) + "\n");
				escritor.append("Data da realiza��o do saque: " + Conta.getVetorTempo(i) + "\n\n");
			} else if (Conta.getVetorTipoDaMovimentacao(i).equals("Transferencia")) {
				escritor.append("================Registro de Transferencia================\n");
				escritor.append("Realizador da transferencia: " + Conta.getVetorCPF(i) + "\n");
				escritor.append("Ag�ncia da conta: " + Conta.getVetorAgencia(i) + "\n");
				escritor.append("Valor transferido: " + Conta.getVetorValor(i) + "\n");
				escritor.append("Custo da movimenta��o: R$0,20\n");
				escritor.append("Saldo apos a transferencia: " + Conta.getVetorSaldo(i) + "\n");
				escritor.append("Conta que receber� a transfer�ncia: " + Conta.getVetorCPFT(i) + "\n");
				escritor.append("Data da realiza��o da transfer�ncia: " + Conta.getVetorTempo(i) + "\n\n");
			}
		}
		escritor.close();
	}

	public static void escritorRelatorioSaldo(String nome, String cpf, double saldo) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH_BASICO + dateString + "RSaldo" + EXTENSAO));
		escritor.append(Menu.logo() + "\n");
		escritor.append("================Registro de Saldo================\n");
		escritor.append("O seu saldo, " + nome + " � R$" + saldo +".\n");
		escritor.append("Data da realiza��o do registro: " + dateString2 + "\n\n");
		escritor.close();
	}

	public static void escritorRelatorioTributacao(String cpf) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH_BASICO + dateString+ "RTributacao" + EXTENSAO));
		escritor.append(Menu.logo() + "\n");
		escritor.append("================Registro de tributa��o================\n");
		escritor.append("Para cada saque foi cobrado o valor de R$0.10 (dez centavos).\n");
		escritor.append("Para cada dep�sito foi cobrado o valor de R$0.10 (dez centavos).\n");
		escritor.append("Para cada transfer�ncia foi cobrado o valor de R$0.20 (vinte centavos).\n\n");
		escritor.append("A quantidade de transa��es foi de "+ Conta.getQtdMovimentacao() +", totalizando um valor total de R$"+ Conta.getQtdMovimentacao()*0.10+".\n\n");
		
		if (MapUsuario.getMap().get(cpf).getSeguroDeVida()>=0) {
			escritor.append("O valor aplicado em seguro de vida � de R$"+ MapUsuario.getMap().get(cpf).getSeguroDeVida()+"\n");
		}
		escritor.append("Data da realiza��o do registro: " + dateString2 + "\n\n");
		escritor.close();
	}

	public static void escritorRelatorioPoupanca(double valor, int dias) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH_BASICO + dateString + "RPoupanca" + EXTENSAO));
		escritor.append(Menu.logo() + "\n");
		escritor.append("================Registro de relat�rio de poupan�a================\n");
		escritor.append("Depositando R$" + valor + " por " + dias + " dias, voc� ter� um rendimento de R$" + valor*dias*0.003/30 +"!\n");
		escritor.append("Data da realiza��o do registro: " + dateString2 + "\n\n");
		escritor.close();
	}

	public static void escritorRelatorioQtdAgencia(int count, int agencia) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH_BASICO + dateString + "RQtdAgencia" + EXTENSAO));
		escritor.append(Menu.logo() + "\n");
		escritor.append("================Registro de relat�rio de agencia================\n");
		escritor.append("\nA quantidade de contas na agencia" + agencia + " �: " + count+".\n");
		escritor.append("Data da realiza��o do registro: " + dateString2 + "\n\n");
		escritor.close();
	}

	public static void escritorRelatorioTodasContas() throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH_BASICO + dateString + "RTodasContas" + EXTENSAO));
		escritor.append(Menu.logo() + "\n");
		escritor.append("================Registro de relat�rio de contas================\n");
		escritor.append("Nome       Cpf        Agencia");
		for (Conta value : MapConta.getMapS().values()) {
			escritor.append("\n"+value.getNome()+" "+value.getCpf()+" "+value.getAgencia()+"\n");
		}
		escritor.append("Data da realiza��o do registro: " + dateString2 + "\n\n");
		escritor.close();
	}

	public static void escritorRelatorioSaldoTotalBanco(double sum) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH_BASICO + dateString + "RSaldoTotalBanco" + EXTENSAO));
		escritor.append(Menu.logo() + "\n");
		escritor.append("================Registro de relat�rio de saldo================\n");
		escritor.append("\nO valor total, em todas as contas do banco, � de: R$"+ sum+".\n");
		escritor.append("Data da realiza��o do registro: " + dateString2 + "\n\n");
		escritor.close();
	}
}
