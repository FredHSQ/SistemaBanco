package applications;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import applications.EscritorLeitor;

public class MapConta {

//    static Conta contaC1 = new ContaCorrente("Lucas1","12345678910", 1, 100);
//    static Conta contaC2 = new ContaCorrente("Fred1","12345678911", 2, 200);
//    static Conta contaC3 = new ContaCorrente("Granato1","12345678912", 3, 300);
//    
//    static Conta contaC4 = new ContaCorrente("Lucas2","12345678913", 1, 400);
//    static Conta contaC5 = new ContaCorrente("Fred2","12345678914", 2, 500);
//    static Conta contaC6 = new ContaCorrente("Granato2","12345678915", 3, 600);
//    
//    static Conta contaP1 = new ContaPoupanca("Lucas3","12345678916", 1, 101);
//    static Conta contaP2 = new ContaPoupanca("Fred3","12345678917", 2, 202);
//    static Conta contaP3 = new ContaPoupanca("Granato3","12345678918", 3, 303);
//                                   
//    static Conta contaP4 = new ContaPoupanca("Lucas4","12345678919", 1, 404);
//    static Conta contaP5 = new ContaPoupanca("Fred4","12345678920", 2, 505);
//    static Conta contaP6 = new ContaPoupanca("Granato4","12345678921", 3, 606);

    public static Map<String,Conta> mapaConta = new HashMap<String, Conta>();
    static ValueComparator comparador = new ValueComparator(mapaConta);
    static TreeMap<String, Conta> sorted_map = new TreeMap<String, Conta>(comparador);
    
	public static void leitorConta(String path) throws IOException {

		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";

		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
				String[] lelinha = linha.split(";");
				if (lelinha[0].equalsIgnoreCase("Poupança")) {
					Conta poupanca = new ContaPoupanca(lelinha[1], lelinha[2], Integer.parseInt(lelinha[3]), Double.parseDouble(lelinha[4]));
					MapConta.getMap().put(lelinha[2], poupanca);
				} else if (lelinha[0].equalsIgnoreCase("Corrente")) {
					Conta corrente = new ContaCorrente(lelinha[1], lelinha[2], Integer.parseInt(lelinha[3]), Double.parseDouble(lelinha[4]));
					MapConta.getMap().put(lelinha[2], corrente);
				}
			} else
				break;
		}
		buffRead.close();
		
	}

    public static Map<String, Conta> getMap() {
       
        return mapaConta;
    }
    public static Map<String, Conta> getMapS() {
        
        return sorted_map;
    }
}
