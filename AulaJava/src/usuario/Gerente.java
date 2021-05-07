package usuario;

import bancoEnum.CargoEnum;

public class Gerente extends Usuario{
	private int agencia; //indentificador
	// construtores
	public Gerente () {
		setCargo(CargoEnum.GERENTE.name());
	}
	
	public Gerente (String senha, String cpf, int agencia){
		setCpf(cpf);
		setSenha(senha);
		this.agencia = agencia;
		setCargo(CargoEnum.GERENTE.name());
	}
	
	//getter agencia
	public int getAgencia() {
		return agencia;
	}
	
}
