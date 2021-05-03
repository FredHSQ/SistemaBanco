package pessoal;

public class Gerente extends Funcionario{
	private int agencia; //indentificador
	
	// construtores
	public Gerente () {
		
	}
	
	public Gerente (String senha, String cpf, String cargo, int agencia){
		setCpf(cpf);
		setSenha(senha);
		setCargo(cargo);
		this.agencia = agencia;
	}
	
	//getter agencia
	public int getAgencia() {
		return agencia;
	}
	
}
