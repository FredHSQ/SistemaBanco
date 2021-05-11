package programa;

import java.io.IOException;
import java.util.*;

import applications.MapConta;
import applications.MapUsuario;
import applications.Menu;
import bancoEnum.CargoEnum;
import exceptions.ContaExceptions;

public class SistemaInterno {

	public static void main(String[] args) throws IOException, ContaExceptions {
		Scanner sc = new Scanner (System.in);
		System.out.println(Menu.logo());
		Menu.bemVindo();
		
		MapConta.leitorConta("./temp/Conta.txt");
		MapUsuario.leitorUsuario("./temp/Usuario.txt");
		
		// processo de login
		String acesso = null;
		String cpfInformado;

		do {       
			System.out.println("Por favor informe o CPF: ");
            cpfInformado = sc.next();
            System.out.println("Por favor informe a senha: ");
            String senhaInformada =sc.next();
            if(MapUsuario.getMap().containsKey(cpfInformado) && MapUsuario.getMap().get(cpfInformado).getSenha().equals(senhaInformada)) {
                System.out.println("Login conclu�do");
                Menu.linha();
                acesso = MapUsuario.getMap().get(cpfInformado).getCargo();
            }else {
                System.out.println("Senha e CPF n�o correspondem \na nenhum usuario.");
            }
        } while(acesso ==null);
		
		if(acesso.equals(CargoEnum.CLIENTE.name())) {
            Menu.menuCLiente(MapConta.getMap().get(cpfInformado));
        }else if (acesso.equals(CargoEnum.DIRETOR.name())) {
            Menu.menuDiretor(MapConta.getMap().get(cpfInformado));
        }else if(acesso.equals(CargoEnum.PRESIDENTE.name())) {
            Menu.menuPresidente(MapConta.getMap().get(cpfInformado));
        }else if(acesso.equals(CargoEnum.GERENTE.name())) {
            Menu.menuGerente(MapConta.getMap().get(cpfInformado));
        }	
		sc.close();
	}

}
