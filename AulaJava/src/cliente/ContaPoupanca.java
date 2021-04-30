package cliente;

public class ContaPoupanca extends Conta {
	private int tipo; //indentificador
	
	public ContaPoupanca (){
		
	}
	public ContaPoupanca(String cpf, int agencia) {
		setCpf(cpf);
		setAgencia(agencia);
	}
	public int getTipo() {
		return tipo;
	}

}
