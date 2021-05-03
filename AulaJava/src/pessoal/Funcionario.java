package pessoal;

public class Funcionario {
	private String cpf;
	private String senha;
	private String cargo; //indentificador. (discutir) 
						  //professor falou que pode ser em lugares diferentes
	
	// construtores
	public Funcionario () {
	}
	
	public Funcionario (String senha, String cpf, String cargo) {
		this.cpf =cpf;
		this.senha = senha;
		this.cargo = cargo;
	}
	
	
	//getters e setters CPF
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	//getters e setters cargo
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	//getters e setters Senha. 
	//setSenha é protected para os "filhos" poderem "setar" a senha,
	//mas ninguem mais poder, ou seja só será usado nos construtores.
	public String getSenha() {
		return senha;
	}
	protected void setSenha(String senha) {
		this.senha = senha;
	}
}
