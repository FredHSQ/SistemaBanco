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
		System.out.println(Menu.logo());// menu do logo para ficar bonitinho
		Menu.bemVindo();// menu bem vindo para ficar bonitinho
		
		// leitor dos arquivos
		// caso de erro de leitura de arquivo tenta tirar 1 ponto
		MapConta.leitorConta("../temp/Conta.txt");
		MapUsuario.leitorUsuario("../temp/Usuario.txt");
		
		// processo de login
		String acesso = null;
		String cpfInformado;
		// fazer enquanto não der certo o login
		do {       
			System.out.println("Por favor informe o CPF: ");
            cpfInformado = sc.next();
            System.out.println("Por favor informe a senha: ");
            String senhaInformada =sc.next();
            // verifica senha e login.
            if(MapUsuario.getMap().containsKey(cpfInformado) && MapUsuario.getMap().get(cpfInformado).getSenha().equals(senhaInformada)) {
                System.out.println("Login concluído");
                Menu.linha();
                // coloca o cargo dentro dessa variável, para poder ser conferido no "if" e sair do loop
                acesso = MapUsuario.getMap().get(cpfInformado).getCargo();
            }else {
                System.out.println("Senha e CPF não correspondem \na nenhum usuário.");
                Menu.linha();
                System.out.println();
            }
        } while(acesso ==null);
		
		// if que de acordo com o cargo joga no menu especifico
		if(acesso.equals(CargoEnum.CLIENTE.name())) {
            Menu.menuCLiente(MapConta.getMap().get(cpfInformado));// joga a conta dentro do menuCliente
        }else if (acesso.equals(CargoEnum.DIRETOR.name())) {
            Menu.menuDiretor(MapConta.getMap().get(cpfInformado));// joga a conta dentro do menuDiretor
        }else if(acesso.equals(CargoEnum.PRESIDENTE.name())) {
            Menu.menuPresidente(MapConta.getMap().get(cpfInformado));// joga a conta dentro do menuPresidente
        }else if(acesso.equals(CargoEnum.GERENTE.name())) {
            Menu.menuGerente(MapConta.getMap().get(cpfInformado));// joga a conta dentro do menuGerente
        }	
		sc.close();
	}

}
