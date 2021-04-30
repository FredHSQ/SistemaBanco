package cliente;

public class ContaCorrente extends Conta {
	
	private int tipo; //indentificador
	
	public ContaCorrente() {
		
	}
	public ContaCorrente(String cpf, int agencia) {
		setCpf(cpf);
		setAgencia(agencia);
	}
	public int getTipo() {
		return tipo;
	}
}
