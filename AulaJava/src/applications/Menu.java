package applications;

import java.util.HashMap;
import java.util.Map;

import exceptions.ContaExceptions;
import usuario.Usuario;

public class Menu {
	
	//função para criação do menu inicial
	public static void bemVindo() {
		linha("|Bem vindo ao banco Justice League|"); // chama função "linha()" usando a maior frase do que foi escrito no menu
		System.out.println("\n|Bem vindo ao banco Justice League|");
		linha("|Bem vindo ao banco Justice League|"); // chama função "linha()" usando a maior frase do que foi escrito no menu
		System.out.println();
		
		
	}
	
	
	public static String logo() {
		
		return ("    @@@@@@@@@@@@@.@@@@@@@@@@@@@      \r\n"
				+ "    @@                       @@      \r\n"
				+ "    @@    @@@@@@@ @@@        @@      \r\n"
				+ "    @@        @@@ @@@        @@      \r\n"
				+ "    @@        @@@ @@@        @@      \r\n"
				+ "    @@        @@   @@        @@      \r\n"
				+ "    @@   /@.  @@@ @@@        @@      \r\n"
				+ "    @@  @@@.  @@@ @@@        @@      \r\n"
				+ "    @@  @@@@@@@@@ @@@/@@@@   @@      \r\n"
				+ "    @@   #@@@@@@  @@@@@@     @@      \r\n"
				+ "    @@                       @@      \r\n"
				+ "    @@@@@@@@@@@@@.@@@@@@@@@@@@@      \r\n"
				+ "                                ");
	}
	
	
	
	//função para criação de linhas, usar como variável a maior frase impressa sem "\n"
	public static void linha(String maiorFraseMenu) {
		for (int i=0;i<maiorFraseMenu.length();i++) {
			System.out.print("=");// imprime um "=" para cada caracter na frase usada como variável
		}
	}

	public static String erroMenu() {
		return "Erro encontrado: ";
	}
	public boolean sacar (double valor) throws ContaExceptions {
		if (acesso==null) {
			System.out.println("O valor requerido é maior que o saldo atual (" + this.saldo + 
					") da conta.");
			return false;
		}else {
			this.saldo = this.saldo-valor;
			return true;
		}
	}
}
