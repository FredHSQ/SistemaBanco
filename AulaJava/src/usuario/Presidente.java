package usuario;

import bancoEnum.CargoEnum;

public class Presidente extends Usuario {

	// construtores
	public Presidente () {
		setCargo(CargoEnum.PRESIDENTE.name());
	}
	
	public Presidente (String senha, String cpf, String cargo) {
		setCpf(cpf);
		setSenha(senha);
		setCargo(CargoEnum.PRESIDENTE.name());
	}
	
}
