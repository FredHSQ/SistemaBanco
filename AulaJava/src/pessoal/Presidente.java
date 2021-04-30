package pessoal;

public class Presidente extends Funcionario {
	private int agencia; //indentificador
	
	public Presidente () {
		
	}
	
	public Presidente (String senha, String cpf, String cargo) {
		setCpf(cpf);
		setSenha(senha);
		setCargo(cargo);
	}
	
}
