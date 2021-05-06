package usuario;

public class Diretor extends Funcionario {
	private  static String tipoUsuario = "Diretor";
	// construtores
	public Diretor() {
		
	}
	public Diretor(String senha, String cpf, String cargo) {
		setCpf(cpf);
		setSenha(senha);
		setCargo(cargo);
	}
	
}
