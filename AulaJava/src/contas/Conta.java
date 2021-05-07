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
			qtdMovimentacao++;
			EscritorLeitor.escritorMovimentacoes(this.cpf, this.agencia, valor, this.saldo, "deposito");
		}
	}
	
	//função para sacar "valor" de dentro do "saldo" da conta chamada
	public boolean sacar (double valor) throws ContaExceptions {
		if (this.saldo<valor) {
			System.out.println("O valor requerido é maior que o saldo atual (" + this.saldo + 
					") da conta.");
			return false;
		}else {
			this.saldo = this.saldo-valor;
			return true;
		}
	}	
	
	//função para tranferir "valor" de dentro do "saldo" da conta chamada
	//para uma conta destino
	public void transfere (double valorTransfere, String cpf) {
		Map<String, Usuario> mapaUsuario = new HashMap<>();
		if (this.sacar(valorTransfere) == true) {
			mapaUsuario.get(cpf).depositar(valorTransfere);
			System.out.println("O valor "+ valorTransfere + " foi transferido!");
		}
	}
	
	//get do "saldo".
	//Não tem setter pq o saldo só muda com depositos, saques e transferencias
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
