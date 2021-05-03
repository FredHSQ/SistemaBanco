package pessoal;

public class Presidente extends Funcionario {
	
	// construtores
	public Presidente () {
		
	}
	
	public Presidente (String senha, String cpf, String cargo) {
		setCpf(cpf);
		setSenha(senha);
		setCargo(cargo);
	}
	
}
