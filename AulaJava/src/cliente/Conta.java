package cliente;

public class Conta {
	private String cpf;
	private double saldo;
	private int agencia;//indentificador
	
	
	//Construtor default para n�o quebrar o programa caso eu altere algo no pai,
	//que n�o � nescess�rio em todos os filhos
	public Conta() {
	}
	
	//Construtor. Tem a fun��o de criar e armazenar os dados "cpf" em uma "Conta"
	public Conta(String cpf, int agencia) {
		this.cpf = cpf;
		this.agencia = agencia;
	}
	
	//fun��o para depositar "valor" dentro do "saldo" da conta chamada
	public void depositar (double valor){
			this.saldo = this.saldo+valor;
	}	
	
	//fun��o para sacar "valor" de dentro do "saldo" da conta chamada
	public boolean sacar (double valor){
		if (this.saldo<valor) {
			System.out.println("O valor requerido � maior que o saldo atual (" + this.saldo + 
					") da conta.");
			return false;
		}else {
			this.saldo = this.saldo-valor;
			return true;
		}
	}	
	
	//fun��o para tranferir "valor" de dentro do "saldo" da conta chamada para uma conta destino
	public void transfere (double valorTransfere, Conta contaDestino) {
		if (this.sacar(valorTransfere) == true) {
			contaDestino.depositar(valorTransfere);
			System.out.println("O valor "+ valorTransfere + " foi transferido!");
		} 
	}
	
	//get do "saldo". N�o tem setter pq o saldo s� muda com depositos, saques e transferencias
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

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
}
