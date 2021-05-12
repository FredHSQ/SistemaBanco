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

import applications.Escritor;
import applications.MapConta;
import applications.Menu;

public abstract class Conta {
	
	protected String nome;
	protected String cpf;
	protected double saldo;
	protected int agencia;//indentificador
	private static int qtdMovimentacao;
	// criamos vetores para armazenar os valores quando acontecer transações, 
	// para evitar o problema de sobrescrever o arquivo de texto, e ter todas as transações em um mesmo arquivo
	private static String vetorTipoDaMovimentacao[] = new String[100];
    private static String vetorCPF[] = new String[100];
    private static String vetorCPFT[] = new String[100];
    private static String vetorAgencia[] = new String[100];
    private static String vetorValor[] = new String[100];
    private static String vetorSaldo[] = new String[100];
    private static String vetorTempo[] = new String[100];
	
    //função para depositar "valor" dentro do "saldo" da conta chamada
	public void depositar (Double valor) throws ContaExceptions, IOException {
		// formatter de data
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy"); 
		// "if" para tratamento de erro caso valor do deposito menor que 0
		if(valor <= 0) {
			 throw new ContaExceptions(Menu.erroMenu() + "Valor de depósito menor \nou igual a 0\n");
		} else {
			System.out.printf("O saldo era: R$%.2f\n",this.saldo);	
			System.out.printf("O custo da movimentação é: R$0,10\n");
			System.out.printf("O valor depositado foi de: R$%.2f\n",valor);
			this.saldo = this.saldo+valor-0.10;
			System.out.printf("O novo saldo é: R$%.2f\n",this.saldo);
			Menu.linha();
			// armazena os dados do deposito para podermos escrever no arquivo quando sai do programa
            vetorTipoDaMovimentacao[qtdMovimentacao] = "Deposito";
            vetorCPF[qtdMovimentacao] = this.getNome();
            vetorAgencia[qtdMovimentacao] = (String.valueOf(this.getAgencia())) ;
            vetorValor[qtdMovimentacao] = (String.valueOf(valor));
            vetorSaldo[qtdMovimentacao] = (String.valueOf(this.getSaldo())); 
            vetorTempo[qtdMovimentacao] = LocalDateTime.now().format(formatter);
            qtdMovimentacao++;
		}
	}
	
	//função para sacar "valor" de dentro do "saldo" da conta chamada
	public boolean sacar (double valor) throws ContaExceptions, IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy"); 
		// if para caso o valor do saque mais o custo da movimentação seja maior que o saldo da pessoa
		if (this.saldo<valor+0.10) {
			System.out.println("O valor requerido mais o custo \nda movimentação é maior que o saldo atual\n(" + this.saldo + 
					") da conta.");
			Menu.linha();
			return false;
		}else {
			System.out.printf("O saldo era: R$%.2f\n",this.saldo);	
			System.out.printf("O custo da movimentação é: R$0,10\n");
			System.out.printf("O valor sacado foi de: R$%.2f\n",valor);
			this.saldo = this.saldo-valor-0.10;
			System.out.printf("O novo saldo é: R$%.2f\n",this.saldo);
			Menu.linha();
			// armazena os dados do deposito para podermos escrever no arquivo quando sai do programa
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
	
	//função para tranferir "valor" de dentro do "saldo" da conta chamada
	//para uma conta destino.
	//não fizemos o transfere usando o sacar e o deposito para não entrar dentro das funções e sair muitos dados não desejados
	public void transfere(double valorTransfere, String cpf) throws ContaExceptions, IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy"); 
		// if para caso o valor da transferência mais o custo da movimentação seja maior que o saldo da pessoa
		if (this.saldo<valorTransfere+0.20) {
			throw new ContaExceptions(Menu.erroMenu() + "\nValor de transferência mais \no valor da movimentação é maior \ndo que o saldo atual da conta.\n");
		} else {
			System.out.printf("O saldo era: R$%.2f\n", this.saldo);
			System.out.printf("O custo da movimentação é: R$0,20\n");
			this.saldo = this.saldo - valorTransfere - 0.20;
			//utilizando o cpf digitado deposita o valor
			MapConta.getMap().get(cpf).setSaldo(MapConta.getMap().get(cpf).getSaldo() + valorTransfere);
			System.out.printf("O novo saldo é: R$%.2f\n", this.saldo);
			System.out.println("O valor de R$" + valorTransfere + " foi transferido \npara conta que tem como titular: "
					+ MapConta.getMap().get(cpf).getNome() + "!");
			Menu.linha();
			// armazena os dados do deposito para podermos escrever no arquivo quando sai do programa
			vetorTipoDaMovimentacao[qtdMovimentacao] = "Transferencia";
	        vetorCPF[qtdMovimentacao] = this.getNome();
	        vetorCPFT[qtdMovimentacao] = MapConta.getMap().get(cpf).getNome();
	        vetorAgencia[qtdMovimentacao] = (String.valueOf(this.getAgencia())) ;
	        vetorValor[qtdMovimentacao] = (String.valueOf(valorTransfere));
	        vetorSaldo[qtdMovimentacao] = (String.valueOf(this.getSaldo())); 
	        vetorTempo[qtdMovimentacao] = LocalDateTime.now().format(formatter);
	        qtdMovimentacao++;
	        // para efeito do calculo do custo tributário, transferencia contaria como duas transações na qtdMovimentacao
	        // porém no vetor conta só como 1, pois se tiver 1 vetor nulo, não imprime no arquivo. Usamos um vetor "vazio" para conseguirmos.
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
	
	// getters e setters dos vetores
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
	
	// getters e setters
	// qtdMovimentacao só muda quando há transação não precisa de set
	public static int getQtdMovimentacao() {
		return qtdMovimentacao;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
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
