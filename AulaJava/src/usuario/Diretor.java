package usuario;

public class Diretor extends Usuario {
	private final String cargo = "Diretor";
	// construtores
	public Diretor() {
		setCargo("Diretor");
	}
	public Diretor(String senha, String cpf, String cargo) {
		setCpf(cpf);
		setSenha(senha);
		setCargo("Diretor");
	}
}
