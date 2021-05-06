package usuario;


public class Cliente extends Usuario {

	
	public Cliente() {
		setCargo("Cliente");
	}
	public Cliente(String senha, String cpf) {
		setCpf(cpf);
		setSenha(senha);
		setCargo("Cliente");
	}
}
