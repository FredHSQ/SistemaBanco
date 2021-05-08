package programa;

import java.io.IOException;
import java.util.*;

import applications.EscritorLeitor;
import applications.MapConta;
import applications.MapUsuario;
import applications.Menu;
import bancoEnum.CargoEnum;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import exceptions.ContaExceptions;
import usuario.Gerente;
import usuario.Usuario;

public class SistemaInterno {

	public static void main(String[] args) throws IOException, ContaExceptions {
		Scanner sc = new Scanner (System.in);
		
		System.out.println(Menu.logo());
		Menu.bemVindo();
		
		// processo de login
		String acesso = null;
		String cpfInformado;
		
		do {
            System.out.println("Por favor informe o CPF: ");
            cpfInformado = sc.next();
            System.out.println("Por favor informe a senha: ");
            String senhaInformada =sc.next();
            if(MapUsuario.getMap().containsKey(cpfInformado) && MapUsuario.getMap().get(cpfInformado).getSenha().equals(senhaInformada)) {
                System.out.println("Login concluído");
                Menu.linha("Por favor informe a senha: ");
                acesso= MapUsuario.getMap().get(cpfInformado).getCargo();
            }else {
                System.out.println("Senha e CPF não correspondem a nenhum usuario.");
            }
        } while(acesso ==null);
		
		// a partir do login, escolhe 1 menu
		switch (acesso) {
		case CargoEnum.CLIENTE.name():
			Menu.menuCLiente(MapConta.getMap().get(cpfInformado));
			break;
		case CargoEnum.PRESIDENTE.name():
			menuPresidente();
			break;
		case CargoEnum.GERENTE.name():
			menuGerente();
			break;
		case CargoEnum.DIRETOR.name():
			menuDiretor();
			break;
		}		
		sc.close();
	}

}
