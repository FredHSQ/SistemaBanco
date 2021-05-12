package applications;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;

public class MapConta {

    public static Map<String,Conta> mapaConta = new HashMap<String, Conta>();
    static ValueComparator comparador = new ValueComparator(mapaConta);
    static TreeMap<String, Conta> sorted_map = new TreeMap<String, Conta>(comparador);
    
	public static void leitorConta(String path) throws IOException {

		BufferedReader buffRead = new BufferedReader(new FileReader(path,StandardCharsets.UTF_8));
		String linha = "";

		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
				String[] lelinha = linha.split(";");
				if (lelinha[0].equalsIgnoreCase("Poupanca")) {
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
        sorted_map.putAll(mapaConta);
        return sorted_map;
    }
}
