package applications;

import exceptions.ContaExceptions;
import usuario.Usuario;

public class Menu {
	
	//fun��o para cria��o do menu inicial
	public static void bemVindo() {
		linha("|Bem vindo ao banco Liga da Justi�a|"); // chama fun��o "linha()" usando a maior frase do que foi escrito no menu
		System.out.println("\n|Bem vindo ao banco Liga da Justi�a|");
		linha("|Bem vindo ao banco Liga da Justi�a|"); // chama fun��o "linha()" usando a maior frase do que foi escrito no menu
		System.out.println();
		
		Usuario acesso = null;

			for(int i = 1; i <= mapaDeSenhas.size(); i++) {
				if(CPF.equals(mapaDeCPF.get(i))) {
					if(senha.equals(mapaDeSenhas.get(i))) {
						System.out.println("Usuario Correto!!!");
						acesso = mapaDeObjetos.get(i);
						break;
						}
				}
			}
			if (acesso == null) {
				System.out.println("Senha e CPF n�o correspondem a nenhum usuario!!!");
			}
	}
	
	//fun��o para cria��o de linhas, usar como vari�vel a maior frase impressa sem "\n"
	public static void linha(String maiorFraseMenu) {
		for (int i=0;i<maiorFraseMenu.length();i++) {
			System.out.print("=");// imprime um "=" para cada caracter na frase usada como vari�vel
		}
	}

	public static String erroMenu() {
		return "Erro encontrado: ";
	}
	public boolean sacar (double valor) throws ContaExceptions {
		if (acesso==null) {
			System.out.println("O valor requerido � maior que o saldo atual (" + this.saldo + 
					") da conta.");
			return false;
		}else {
			this.saldo = this.saldo-valor;
			return true;
		}
	}
}
