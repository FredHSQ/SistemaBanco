package pessoal;

public class Funcionario {
	private String cpf;
	private String senha;
	private String cargo; //indentificador
	
	public Funcionario () {
	}
	
	public Funcionario (String senha, String cpf, String cargo) {
		this.cpf =cpf;
		this.senha = senha;
		this.cargo = cargo;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
