package cliente;

public class ContaPoupanca extends Conta {
	private int tipo; //indentificador
	
	//construtores
	public ContaPoupanca (){
		
	}
	public ContaPoupanca(String cpf, int agencia) {
		setCpf(cpf);
		setAgencia(agencia);
	}
	//getter do "tipo"
	public int getTipo() {
		return tipo;
	}

}
