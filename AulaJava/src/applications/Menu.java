package applications;

import exceptions.ContaExceptions;

public class Menu {
	
	//função para criação do menu inicial
	public static void bemVindo() {
		linha("|Bem vindo ao banco Liga da Justiça|"); // chama função "linha()" usando a maior frase do que foi escrito no menu
		System.out.println("\n|Bem vindo ao banco Liga da Justiça|");
		linha("|Bem vindo ao banco Liga da Justiça|"); // chama função "linha()" usando a maior frase do que foi escrito no menu
		System.out.println();
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
}
