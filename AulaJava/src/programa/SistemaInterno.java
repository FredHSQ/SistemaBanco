package programa;

import java.io.IOException;
import java.util.*;

import applications.Menu;
import bancoEnum.CargoEnum;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import escritorLeitor.EscritorLeitor;
import exceptions.ContaExceptions;
import usuario.Gerente;
import usuario.Usuario;
import escritorLeitor.EscritorLeitor;

public class SistemaInterno {

	public static void main(String[] args) throws IOException, ContaExceptions {
		Scanner sc = new Scanner (System.in);
		
		System.out.println(Menu.logo());
		Menu.bemVindo();
		
		
		Conta conta1 = new ContaCorrente("Lucas" , 1, 100);

      	Conta conta2 = new ContaCorrente("Marcelo",2,200);

      	Conta conta3 = new ContaCorrente("Rafael",3,300);
      	
      	Map<String, Conta> mapaConta = new HashMap<>();
    	mapaConta.put(conta1.getCpf(), conta1);
    	mapaConta.put(conta2.getCpf(), conta2);
    	mapaConta.put(conta3.getCpf(), conta3);
    	
		Gerente g1 = new Gerente("123456","12345678910",1);
        Gerente g2 = new Gerente("paodequeijo","12345678911",2);
        Gerente g3 = new Gerente("lasanhamilanesa","12345678912",3);

        Map<String, Usuario> mapaUsuario = new HashMap<>();
		mapaUsuario.put(g1.getCpf(), g1);
		mapaUsuario.put(g2.getCpf(), g2);
		mapaUsuario.put(g3.getCpf(), g3);
		
		
		
		Menu.menuMovimentacao(conta1);
		
		// processo de login
//		String acesso = null;
//		String cpfInformado;
//		
//		do {
//            System.out.println("Por favor informe o CPF: ");
//            cpfInformado = sc.next();
//            System.out.println("Por favor informe a senha: ");
//            String senhaInformada =sc.next();
//            if(mapaUsuario.containsKey(cpfInformado) && mapaUsuario.get(cpfInformado).getSenha().equals(senhaInformada)) {
//                System.out.println("Login concluído");
//                Menu.linha("Por favor informe a senha: ");
//                acesso= mapaUsuario.get(cpfInformado).getCargo();
//            }
//            if (acesso == null) {
//                System.out.println("Senha e CPF não correspondem a nenhum usuario!!!");
//            }
//        } while(acesso ==null);
//		
		// apartir do login, escolhe 1 menu
//		switch (acesso) {
//		case CargoEnum.CLIENTE.name():
//			menuCliente(mapaUsuario.get(cpfInformado));
//			break;
//		case CargoEnum.PRESIDENTE.name():
//			menuPresidente();
//			break;
//		case CargoEnum.GERENTE.name():
//			menuGerente();
//			break;
//		case CargoEnum.DIRETOR.name():
//			menuDiretor();
//			break;
//		}
//		
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
