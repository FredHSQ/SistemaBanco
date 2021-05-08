package contas;

import exceptions.ContaExceptions;
import programa.SistemaInterno;
import usuario.Usuario;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
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
	
	
	//função para depositar "valor" dentro do "saldo" da conta chamada
	public void depositar (Double valor) throws ContaExceptions, IOException {
		if(valor <= 0) {
			 ;   
			 throw new ContaExceptions(Menu.erroMenu() + "Valor de deposito menor ou igual a 0\n");
		} else {
			System.out.printf("O saldo era: R$%.2f\n",this.saldo);	
			System.out.printf("O custo da movimentação é: R$0,10\n");
			System.out.printf("O valor depositado foi de: R$%.2f\n",valor);
			this.saldo = this.saldo+valor-0.10;
			System.out.printf("O novo saldo é: R$%.2f\n",this.saldo);
			Menu.linha("Digite o cpf da conta que gostaria de transferir ");
			qtdMovimentacao++;
			EscritorLeitor.escritorMovimentacoes(this.cpf, this.agencia, valor, this.saldo, "deposito");
		}
	}
	
	//função para sacar "valor" de dentro do "saldo" da conta chamada
	public boolean sacar (double valor) throws ContaExceptions, IOException {
		if (this.saldo<valor+0.10) {
			System.out.println("O valor requerido mais o custo da movimentação é maior que o saldo atual (" + this.saldo + 
					") da conta.");
			return false;
		}else {
			System.out.printf("O saldo era: R$%.2f\n",this.saldo);	
			System.out.printf("O custo da movimentação é: R$0,10\n");
			System.out.printf("O valor sacado foi de: R$%.2f\n",valor);
			this.saldo = this.saldo-valor-0.10;
			System.out.printf("O novo saldo é: R$%.2f\n",this.saldo);
			Menu.linha("Digite o cpf da conta que gostaria de transferir ");
			qtdMovimentacao++;
			EscritorLeitor.escritorMovimentacoes(this.cpf, this.agencia, valor, this.saldo, "saque");
			return true;
		}
	}	
	
	//função para tranferir "valor" de dentro do "saldo" da conta chamada
	//para uma conta destino
	public void transfere(double valorTransfere, String cpf) throws ContaExceptions, IOException {
		if (this.saldo<valorTransfere+0.20) {
			;
			throw new ContaExceptions(Menu.erroMenu() + "Valor de transferencia + o valor da movimentação é maior do que o saldo atual da conta.\n");
		} else {
			System.out.printf("O saldo era: R$%.2f\n", this.saldo);
			System.out.printf("O custo da movimentação é: R$0,20\n");
			this.saldo = this.saldo - valorTransfere - 0.20;
			MapConta.getMap().get(cpf).setSaldo(MapConta.getMap().get(cpf).getSaldo() + valorTransfere);
			qtdMovimentacao=qtdMovimentacao+2;
			EscritorLeitor.escritorMovimentacoes(this.cpf, this.agencia, valorTransfere, this.saldo, "Transferencia");
			System.out.printf("O novo saldo é: R$%.2f\n", this.saldo);
			System.out.println("O valor de R$" + valorTransfere + " foi transferido para conta que tem como titular: "
					+ MapConta.getMap().get(cpf).getNome() + "!");
			Menu.linha("Digite o cpf da conta que gostaria de transferir dsadsadsadsadsadsadsadsadsad");
		}
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
	
	//get e setter da "agencia"
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
