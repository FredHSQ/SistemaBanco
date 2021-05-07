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

import applications.Menu;
import escritorLeitor.EscritorLeitor;

public abstract class Conta {
	
	protected String cpf;
	protected double saldo;
	protected int agencia;//indentificador
	private static int qtdMovimentacao;
	
	
	//fun��o para depositar "valor" dentro do "saldo" da conta chamada
	public void depositar (Double valor) throws ContaExceptions, IOException {
		if(valor <= 0) {
			 ;   
			 throw new ContaExceptions(Menu.erroMenu() + "Valor de deposito menor ou igual a 0\n");
		} else {
			System.out.printf("O saldo era: R$%.2f\n",this.saldo);	
			System.out.printf("O custo da movimenta��o �: R$0,10\n");
			System.out.printf("O valor depositado foi de: R$%.2f\n",valor);
			this.saldo = this.saldo+valor-0.10;
			System.out.printf("O novo saldo �: R$%.2f\n",this.saldo);
			qtdMovimentacao++;
			EscritorLeitor.escritorMovimentacoes(this.cpf, this.agencia, valor, this.saldo, "deposito");
		}
	}
	
	//fun��o para sacar "valor" de dentro do "saldo" da conta chamada
	public boolean sacar (double valor) throws ContaExceptions, IOException {
		if (this.saldo<valor) {
			System.out.println("O valor requerido � maior que o saldo atual (" + this.saldo + 
					") da conta.");
			return false;
		}else {
			System.out.printf("O saldo era: R$%.2f\n",this.saldo);	
			System.out.printf("O custo da movimenta��o �: R$0,10\n");
			System.out.printf("O valor sacado foi de: R$%.2f\n",valor);
			this.saldo = this.saldo-valor-0.10;
			System.out.printf("O novo saldo �: R$%.2f\n",this.saldo);
			qtdMovimentacao++;
			EscritorLeitor.escritorMovimentacoes(this.cpf, this.agencia, valor, this.saldo, "saque");
			return true;
		}
	}	
	
	//fun��o para tranferir "valor" de dentro do "saldo" da conta chamada
	//para uma conta destino
	public void transfere (double valorTransfere, String cpf) {
		Map<String, Usuario> mapaUsuario = new HashMap<>();
		if (this.sacar(valorTransfere) == true) {
			mapaUsuario.get(cpf).depositar(valorTransfere);
			System.out.println("O valor "+ valorTransfere + " foi transferido!");
		}
	}
	
	//get do "saldo".
	//N�o tem setter pq o saldo s� muda com depositos, saques e transferencias
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
	
}
