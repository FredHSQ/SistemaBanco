package contas;

public class ContaCorrente extends Conta {
	
	private int tipo = 1; //indentificador
	
	// construtores
	public ContaCorrente() {
		
	}
	
	public ContaCorrente(String cpf, int agencia, double saldo) {
		setCpf(cpf);
		setAgencia(agencia);
		setSaldo(saldo);
	}
	
	// getter do "tipo"
	public int getTipo() {
		return tipo;
	}
}
