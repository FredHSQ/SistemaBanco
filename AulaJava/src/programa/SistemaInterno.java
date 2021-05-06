package programa;

import java.util.*;

import applications.Menu;
import bancoEnum.CargoEnum;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import exceptions.ContaExceptions;
import usuario.Gerente;
import usuario.Usuario;

public class SistemaInterno {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		Menu.bemVindo();
		
		String acesso = null;
		Gerente g1 = new Gerente("123456","12345678910",1);
        Gerente g2 = new Gerente("paodequeijo","12345678911",2);
        Gerente g3 = new Gerente("lasanhamilanesa","12345678912",3);

        Map<String, String> mapaLogin = new HashMap<>();
		mapaLogin.put(g1.getCpf(), g1.getSenha());
		mapaLogin.put(g2.getCpf(), g2.getSenha());
		mapaLogin.put(g3.getCpf(), g3.getSenha());
		
		Map<String, String> mapaCargo = new HashMap<>();
		mapaCargo.put(g1.getCpf(), g1.getCargo());
		mapaCargo.put(g2.getCpf(), g2.getCargo());
		mapaCargo.put(g3.getCpf(), g3.getCargo());
		
		do {
			System.out.println("Por favor informe o CPF: ");
			String cpfInformado = sc.next();
			System.out.println("Por favor informe a senha: ");
			String senhaInformada =sc.next();
			if(mapaLogin.containsKey(cpfInformado) && mapaLogin.containsValue(senhaInformada)) {
				System.out.println("Usuario Correto!!!");
				acesso= mapaCargo.get(cpfInformado);
			}
			if (acesso == null) {
				System.out.println("Senha e CPF não correspondem a nenhum usuario!!!");
			}
		} while(acesso ==null);
		System.out.println(acesso);
		
		
		switch(acesso) {
		case "Cliente":
			menuCliente();
			break;
		case "Presidente":
			menuPresidente();
			break;
		case "Gerente":
			menuPresidente();
			break;
		case "Diretor":
			menuPresidente();
			break;
		}
//		&& mapaUsuarios.containsKey(senhaInformada)
		//Função depositar (lucas ta dando uma olhada)
//		int i=0;
//		do { 
//			try {
//				System.out.print("Digite o valor que gostaria de depositar:\nR$");
//				"atribuição".depositar(sc.nextDouble());
//			} catch (ContaExceptions e) {
//				System.out.println(e+"\n");
//			}
//			System.out.println("Gostaria de fazer outro deposito?\n1 para sim\n2 para não");
//			int sn=sc.nextInt();
//				if (sn==1) {
//					i=0;
//				} else {
//					i=1;
//				}
//		}while (i==0);
		
		
		// Todas as movimentações tem que ser registradas em um arquivo de texto
		// Todos os relatórios tem que gerar arquivo de texto individual do relatório
		// pelo menos 1 tratamento de erro
		
		//importar o arquivo de texto com os clientes, contas e funcionários
		
		//Login testando CPF e senha
		//Resultado Login indentificar se é
		//cliente, gerente, diretor ou presidente
		
		// caso 1 Cliente
			// menu 0: movimentação 1 ou relatórios 2
				// menu 1: saque 1, deposito 2, ou tranferencia 3
				// menu 2: saldo 1, relatorio tributação 2, relatorio de rendimento 3, desafio 4
		
		//caso 2 Gerente
			// menu 0: movimentação 1 ou relatórios 2
				// menu 1: saque 1, deposito 2, ou tranferencia 3
				// menu 2: saldo 1, relatorio tributação 2, relatorio de rendimento 3, Numero de contas 4
		
		//caso 3 Direto
			// menu 0: movimentação 1 ou relatórios 2
				// menu 1: saque 1, deposito 2, ou tranferencia 3
				// menu 2: saldo 1, relatorio tributação 2, relatorio de rendimento 3, Numero de contas 4, Todos os clientes 5
		
		//caso 4 Presidente
			// menu 0: movimentação 1 ou relatórios 2
				// menu 1: saque 1, deposito 2, ou tranferencia 3
				// menu 2: saldo 1, relatorio tributação 2, relatorio de rendimento 3, Numero de contas 4, Todos os clientes 5, Valor total 6

		
		sc.close();
	}

}
