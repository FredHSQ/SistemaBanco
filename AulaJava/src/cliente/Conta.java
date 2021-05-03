package cliente;

public abstract class Conta {
	protected String cpf;
	protected double saldo;
	protected int agencia;//indentificador
	
	
	//função para depositar "valor" dentro do "saldo" da conta chamada
	public void depositar (double valor){
			this.saldo = this.saldo+valor;
	}	
	
	//função para sacar "valor" de dentro do "saldo" da conta chamada
	public boolean sacar (double valor){
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
	public void transfere (double valorTransfere, Conta contaDestino) {
		if (this.sacar(valorTransfere) == true) {
			contaDestino.depositar(valorTransfere);
			System.out.println("O valor "+ valorTransfere + " foi transferido!");
		}
	}
	
	//get do "saldo".
	//Não tem setter pq o saldo só muda com depositos, saques e transferencias
	public double getSaldo() {
		return saldo;
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
