package contas;

public class ContaPoupanca extends Conta {
	private int tipo = 2; //indentificador
	
	//construtores
	public ContaPoupanca (){
		
	}
	public ContaPoupanca(String nome,String cpf, int agencia, double saldo) {
		setNome(nome);
		setCpf(cpf);
		setAgencia(agencia);
		setSaldo(saldo);
	}
	//getter do "tipo", não tem setter pq não planejamos uma mudança de tipo de conta, ou é poupança ou é corrente
	public int getTipo() {
		return tipo;
	}

}
