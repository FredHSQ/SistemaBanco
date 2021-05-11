package usuario;

public abstract class Usuario {
	protected String cpf;
	protected String senha;
	protected String cargo;
	protected double seguroDeVida=0;
	
	public Usuario() {
		
	}
	public Usuario(String cpf, String senha) {
		this.cpf= cpf;
		this.senha=senha;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	public String getSenha() {
		return this.senha;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String tipoUsuario) {
		this.cargo = tipoUsuario;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public double getSeguroDeVida() {
		return 0;
	}
	public void setSeguroDeVida(double seguroDeVida) {
	
	}
}
