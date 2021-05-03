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
	
	//getter do cpf e da senha. N�o foi pedido altera��o de cpf nem de senha do sistema,
	//como n�o existem filhos de clientes n�o acredito que seja nesces�rio nada al�m disso.
	public String getCpf() {
		return this.cpf;
	}
	public String getSenha() {
		return this.senha;
	}
}
