package usuario;

import bancoEnum.CargoEnum;

public class Cliente extends Usuario {
	public double seguroDeVida=0;
	
	public double getSeguroDeVida() {
		return seguroDeVida;
	}
	public void setSeguroDeVida(double seguroDeVida) {
		this.seguroDeVida = seguroDeVida;
	}
	public Cliente() {
		setCargo(CargoEnum.CLIENTE.name());
	}
	public Cliente(String senha, String cpf) {
		setCpf(cpf);
		setSenha(senha);
		setCargo(CargoEnum.CLIENTE.name());
	}
}
