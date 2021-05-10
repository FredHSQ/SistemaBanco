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
	public static void escritorMovimentacoes(String cpf, Integer agencia, Double valor, Double saldo,
			String indentificadorTransicao) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter("../temp/log.txt", true));

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
		escritor.append("Tipo de transi��o: " + indentificadorTransicao + "\n");
		escritor.append("CPF do titular: " + cpf + "\n");
		escritor.append("Agencia da conta: " + String.valueOf(agencia) + "\n");
		escritor.append("Custo da transa��o: R$00,10" + String.valueOf(valor) + "\n");
		escritor.append("Valor da movimenta��o: R$" + String.valueOf(valor) + "\n");
		escritor.append("Valor do saldo atual: R$" + String.valueOf(saldo) + "\n");
		escritor.append("Data: " + String.valueOf(LocalDateTime.now().format(formatter)) + "\n");
		escritor.append(Menu.logo() + "\n");
		escritor.close();
	}

	public static void escritorRelatorioSaldo() throws IOException {

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
