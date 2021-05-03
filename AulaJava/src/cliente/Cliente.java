package cliente;


public class Cliente {
	private String cpf;
	private String senha;
	
	//construtores
	private Cliente() {
		
	}
	private Cliente(String cpf, String senha) {
		this.cpf= cpf;
		this.senha=senha;
	}
	
	//getter do cpf e da senha. Não foi pedido alteração de cpf nem de senha do sistema,
	//como não existem filhos de clientes não acredito que seja nescesário nada além disso.
	public String getCpf() {
		return this.cpf;
	}
	public String getSenha() {
		return this.senha;
	}
}
