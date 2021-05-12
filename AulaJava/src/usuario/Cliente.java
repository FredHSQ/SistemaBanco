package usuario;

import bancoEnum.CargoEnum;

public class Cliente extends Usuario {
	public double seguroDeVida=0;// não criamos classe de seguro de vida, achamos que ia ser uma bazzuca para matar uma formiga
	
	public Cliente() {
		setCargo(CargoEnum.CLIENTE.name());
	}
	public Cliente(String senha, String cpf) {
		setCpf(cpf);
		setSenha(senha);
		setCargo(CargoEnum.CLIENTE.name());
	}
	// recriação do seguro de vida para clientes, só clientes tem essa capacidade
	public double getSeguroDeVida() {
		return seguroDeVida;
	}
	public void setSeguroDeVida(double seguroDeVida) {
		this.seguroDeVida = seguroDeVida;
	}
}
