package contas;

import exceptions.ContaExceptions;
import programa.SistemaInterno;
import usuario.Usuario;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import applications.EscritorLeitor;
import applications.MapConta;
import applications.Menu;

public abstract class Conta {
	
	protected String nome;
	protected String cpf;
	protected double saldo;
	protected int agencia;//indentificador
	private static int qtdMovimentacao;
	private static String vetorTipoDaMovimentacao[] = new String[100];
    private static String vetorCPF[] = new String[100];
    private static String vetorCPFT[] = new String[100];
    private static String vetorAgencia[] = new String[100];
    private static String vetorValor[] = new String[100];
    private static String vetorSaldo[] = new String[100];
    private static String vetorTempo[] = new String[100];
	
  //fun��o para depositar "valor" dentro do "saldo" da conta chamada
	public void depositar (Double valor) throws ContaExceptions, IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy"); 
		
		if(valor <= 0) {
			 throw new ContaExceptions(Menu.erroMenu() + "Valor de dep�sito menor \nou igual a 0\n");
		} else {
			System.out.printf("O saldo era: R$%.2f\n",this.saldo);	
			System.out.printf("O custo da movimenta��o �: R$0,10\n");
			System.out.printf("O valor depositado foi de: R$%.2f\n",valor);
			this.saldo = this.saldo+valor-0.10;
			System.out.printf("O novo saldo �: R$%.2f\n",this.saldo);
			Menu.linha();
            vetorTipoDaMovimentacao[qtdMovimentacao] = "Deposito";
            vetorCPF[qtdMovimentacao] = this.getNome();
            vetorAgencia[qtdMovimentacao] = (String.valueOf(this.getAgencia())) ;
            vetorValor[qtdMovimentacao] = (String.valueOf(valor));
            vetorSaldo[qtdMovimentacao] = (String.valueOf(this.getSaldo())); 
            vetorTempo[qtdMovimentacao] = LocalDateTime.now().format(formatter);
            qtdMovimentacao++;
		}
	}
	
	//fun��o para sacar "valor" de dentro do "saldo" da conta chamada
	public boolean sacar (double valor) throws ContaExceptions, IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy"); 
		if (this.saldo<valor+0.10) {
			System.out.println("O valor requerido mais o custo \nda movimenta��o � maior que o saldo atual (" + this.saldo + 
					") da conta.");
			Menu.linha();
			return false;
		}else {
			System.out.printf("O saldo era: R$%.2f\n",this.saldo);	
			System.out.printf("O custo da movimenta��o �: R$0,10\n");
			System.out.printf("O valor sacado foi de: R$%.2f\n",valor);
			this.saldo = this.saldo-valor-0.10;
			System.out.printf("O novo saldo �: R$%.2f\n",this.saldo);
			Menu.linha();
			vetorTipoDaMovimentacao[qtdMovimentacao] = "Saque";
	        vetorCPF[qtdMovimentacao] = this.getNome();
	        vetorAgencia[qtdMovimentacao] = (String.valueOf(this.getAgencia())) ;
	        vetorValor[qtdMovimentacao] = (String.valueOf(valor));
	        vetorSaldo[qtdMovimentacao] = (String.valueOf(this.getSaldo())); 
	        vetorTempo[qtdMovimentacao] = LocalDateTime.now().format(formatter);
	        qtdMovimentacao++;
			return true;
		}
	}	
	
	//fun��o para tranferir "valor" de dentro do "saldo" da conta chamada
	//para uma conta destino
	public void transfere(double valorTransfere, String cpf) throws ContaExceptions, IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy"); 
		if (this.saldo<valorTransfere+0.20) {
			throw new ContaExceptions(Menu.erroMenu() + "\nValor de transfer�ncia mais \no valor da movimenta��o � maior \ndo que o saldo atual da conta.\n");
		} else {
			System.out.printf("O saldo era: R$%.2f\n", this.saldo);
			System.out.printf("O custo da movimenta��o �: R$0,20\n");
			this.saldo = this.saldo - valorTransfere - 0.20;
			MapConta.getMap().get(cpf).setSaldo(MapConta.getMap().get(cpf).getSaldo() + valorTransfere);
			
			System.out.printf("O novo saldo �: R$%.2f\n", this.saldo);
			System.out.println("O valor de R$" + valorTransfere + " foi transferido \npara conta que tem como titular: "
					+ MapConta.getMap().get(cpf).getNome() + "!");
			Menu.linha();
			vetorTipoDaMovimentacao[qtdMovimentacao] = "Transferencia";
	        vetorCPF[qtdMovimentacao] = this.getNome();
	        vetorCPFT[qtdMovimentacao] = MapConta.getMap().get(cpf).getNome();
	        vetorAgencia[qtdMovimentacao] = (String.valueOf(this.getAgencia())) ;
	        vetorValor[qtdMovimentacao] = (String.valueOf(valorTransfere));
	        vetorSaldo[qtdMovimentacao] = (String.valueOf(this.getSaldo())); 
	        vetorTempo[qtdMovimentacao] = LocalDateTime.now().format(formatter);
	        qtdMovimentacao++;
	       
	        vetorTipoDaMovimentacao[qtdMovimentacao] = "0";
	        vetorCPF[qtdMovimentacao] = this.getNome();
	        vetorCPFT[qtdMovimentacao] = MapConta.getMap().get(cpf).getCpf();
	        vetorAgencia[qtdMovimentacao] = (String.valueOf(this.getAgencia())) ;
	        vetorValor[qtdMovimentacao] = (String.valueOf(valorTransfere));
	        vetorSaldo[qtdMovimentacao] = (String.valueOf(this.getSaldo())); 
	        vetorTempo[qtdMovimentacao] = LocalDateTime.now().format(formatter);
	        qtdMovimentacao++;
		}
	}
	
	
	public static String getVetorTipoDaMovimentacao(int posicao) {
		return vetorTipoDaMovimentacao[posicao];
	}

	public static String getVetorCPF(int posicao) {
		return vetorCPF[posicao];
	}

	public static String getVetorCPFT(int posicao) {
		return vetorCPFT[posicao];
	}

	public static String getVetorAgencia(int posicao) {
		return vetorAgencia[posicao];
	}

	public static String getVetorValor(int posicao) {
		return vetorValor[posicao];
	}

	public static String getVetorSaldo(int posicao) {
		return vetorSaldo[posicao];
	}

	public static String getVetorTempo(int posicao) {
		return vetorTempo[posicao];
	}

	public static int getQtdMovimentacao() {
		return qtdMovimentacao;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	//get e setter do "cpf"
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	//get e setter da "ag�ncia"
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
