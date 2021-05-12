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

//criamos essa classe para podermos pegar em qualquer lugar o mapa criado
public class MapConta {
	// criador do mapa
    public static Map<String,Conta> mapaConta = new HashMap<String, Conta>();
    // organizadores
    static ValueComparator comparador = new ValueComparator(mapaConta);
    static TreeMap<String, Conta> sorted_map = new TreeMap<String, Conta>(comparador);
    
    // leitor do mapa da conta
	public static void leitorConta(String path) throws IOException {
		// criação do leitor
		BufferedReader buffRead = new BufferedReader(new FileReader(path,StandardCharsets.UTF_8));
		String linha = "";
		// while para variar as linhas
		while (true) {
			linha = buffRead.readLine();
			// if para parar quando a linha for nula
			if (linha != null) {
				// armazenador de dados separados pelo ;
				String[] lelinha = linha.split(";");
				// if para fazer o construtor caso seja conta poupança ou caso seja conta corrente
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
	// pega o mapa sem ordenar
    public static Map<String, Conta> getMap() {
        return mapaConta;
    }
    // pega o mapa ordenado por nome
    public static Map<String, Conta> getMapS() {
        sorted_map.putAll(mapaConta);
        return sorted_map;
    }
}
