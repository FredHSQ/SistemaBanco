package usuario;

import bancoEnum.CargoEnum;

public class Diretor extends Usuario {
	// construtores
	public Diretor() {
		setCargo(CargoEnum.DIRETOR.name());
	}
	public Diretor(String senha, String cpf) {
		setCpf(cpf);
		setSenha(senha);
		setCargo(CargoEnum.DIRETOR.name());
	}
}
