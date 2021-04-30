package cliente;

public class Cliente {
	private String cpf;
	private String senha;
	
	private Cliente() {
		
	}
	private Cliente(String cpf, String senha) {
		this.cpf= cpf;
		this.senha=senha;
	}
	public String getCpf() {
		return cpf;
	}
}
