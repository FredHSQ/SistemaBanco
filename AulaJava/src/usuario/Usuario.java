package usuario;

public abstract class Usuario {
	protected String cpf;
	protected String senha;
	protected String tipoUsuario;
	
	public Usuario() {
		
	}
	public Usuario(String cpf, String senha) {
		this.cpf= cpf;
		this.senha=senha;
	}
	
	//getter do cpf e da senha. N�o foi pedido altera��o de cpf nem de senha do sistema,
	//como n�o existem filhos de Usuarios n�o acredito que seja nesces�rio nada al�m disso.
	public String getCpf() {
		return this.cpf;
	}
	public String getSenha() {
		return this.senha;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
