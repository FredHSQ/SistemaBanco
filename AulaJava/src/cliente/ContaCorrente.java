package cliente;

public class ContaCorrente extends Conta {
	
	private int tipo; //indentificador
	
	// construtores
	public ContaCorrente() {
		
	}
	
	public ContaCorrente(String cpf, int agencia) {
		setCpf(cpf);
		setAgencia(agencia);
	}
	
	// getter do "tipo"
	public int getTipo() {
		return tipo;
	}
}
