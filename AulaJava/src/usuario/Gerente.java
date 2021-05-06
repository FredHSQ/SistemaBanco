package usuario;

public class Gerente extends Usuario{
	private int agencia; //indentificador
	// construtores
	public Gerente () {
		setCargo("Gerente");
	}
	
	public Gerente (String senha, String cpf, int agencia){
		setCpf(cpf);
		setSenha(senha);
		this.agencia = agencia;
		setCargo("Gerente");
	}
	
	//getter agencia
	public int getAgencia() {
		return agencia;
	}
	
}
