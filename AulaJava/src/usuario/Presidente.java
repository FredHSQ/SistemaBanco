package usuario;

public class Presidente extends Usuario {
	private final String cargo = "Presidente";
	// construtores
	public Presidente () {
		setCargo("Presidente");
	}
	
	public Presidente (String senha, String cpf, String cargo) {
		setCpf(cpf);
		setSenha(senha);
		setCargo("Presidente");
	}
	
}
