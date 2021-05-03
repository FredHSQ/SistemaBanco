package pessoal;

public class Diretor extends Funcionario {
	
	// construtores
	public Diretor() {
		
	}
	public Diretor(String senha, String cpf, String cargo) {
		setCpf(cpf);
		setSenha(senha);
		setCargo(cargo);
	}
	
}
