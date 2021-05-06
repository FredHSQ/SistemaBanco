package usuario;

public class Presidente extends Funcionario {
	private  static String tipoUsuario = "Presidente";
	// construtores
	public Presidente () {
		
	}
	
	public Presidente (String senha, String cpf, String cargo) {
		setCpf(cpf);
		setSenha(senha);
		setCargo(cargo);
	}
	
}
