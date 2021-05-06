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
	
	//getter do cpf e da senha. Não foi pedido alteração de cpf nem de senha do sistema,
	//como não existem filhos de Usuarios não acredito que seja nescesário nada além disso.
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
