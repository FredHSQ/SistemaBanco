package contas;

public class ContaCorrente extends Conta {
	
	private int tipo = 1; //indentificador
	
	// construtores
	public ContaCorrente() {
		
	}
	
	public ContaCorrente(String nome, String cpf, int agencia, double saldo) {
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
