package usuario;

import bancoEnum.CargoEnum;

public class Cliente extends Usuario {

	
	public Cliente() {
		setCargo(CargoEnum.CLIENTE.name());
	}
	public Cliente(String senha, String cpf) {
		setCpf(cpf);
		setSenha(senha);
		setCargo(CargoEnum.CLIENTE.name());
	}
}
