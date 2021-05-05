package programa;

import java.util.*;

import applications.Menu;
import cliente.Conta;
import cliente.ContaCorrente;
import cliente.ContaPoupanca;
import exceptions.ContaExceptions;

public class SistemaInterno {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		Menu.bemVindo();
		
		
	
		//Fun��o depositar (lucas ta dando uma olhada)
		int i=0;
		do { 
			try {
				System.out.print("Digite o valor que gostaria de depositar:\nR$");
				conta4.depositar(sc.nextDouble());
			} catch (ContaExceptions e) {
				System.out.println(e+"\n");
			}
			System.out.println("Gostaria de fazer outro deposito?\n1 para sim\n2 para n�o");
			int sn=sc.nextInt();
				if (sn==1) {
					i=0;
				} else {
					i=1;
				}
		}while (i==0);
		
		
		// Todas as movimenta��es tem que ser registradas em um arquivo de texto
		// Todos os relat�rios tem que gerar arquivo de texto individual do relat�rio
		// pelo menos 1 tratamento de erro
		
		//importar o arquivo de texto com os clientes, contas e funcion�rios
		
		//Login testando CPF e senha
		//Resultado Login indentificar se �
		//cliente, gerente, diretor ou presidente
		
		// caso 1 Cliente
			// menu 0: movimenta��o 1 ou relat�rios 2
				// menu 1: saque 1, deposito 2, ou tranferencia 3
				// menu 2: saldo 1, relatorio tributa��o 2, relatorio de rendimento 3, desafio 4
		
		//caso 2 Gerente
			// menu 0: movimenta��o 1 ou relat�rios 2
				// menu 1: saque 1, deposito 2, ou tranferencia 3
				// menu 2: saldo 1, relatorio tributa��o 2, relatorio de rendimento 3, Numero de contas 4
		
		//caso 3 Direto
			// menu 0: movimenta��o 1 ou relat�rios 2
				// menu 1: saque 1, deposito 2, ou tranferencia 3
				// menu 2: saldo 1, relatorio tributa��o 2, relatorio de rendimento 3, Numero de contas 4, Todos os clientes 5
		
		//caso 4 Presidente
			// menu 0: movimenta��o 1 ou relat�rios 2
				// menu 1: saque 1, deposito 2, ou tranferencia 3
				// menu 2: saldo 1, relatorio tributa��o 2, relatorio de rendimento 3, Numero de contas 4, Todos os clientes 5, Valor total 6

		
		sc.close();
	}

}
