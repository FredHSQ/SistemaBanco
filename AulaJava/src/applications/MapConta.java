package applications;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;

public class MapConta {

    static Conta contaC1 = new ContaCorrente("Lucas","12345678910", 1, 100);
    static Conta contaC2 = new ContaCorrente("Fred1","12345678911", 2, 200);
    static Conta contaC3 = new ContaCorrente("Granato1","12345678912", 3, 300);
    
    static Conta contaC4 = new ContaCorrente("Lucas2","12345678913", 1, 400);
    static Conta contaC5 = new ContaCorrente("Fred2","12345678914", 2, 500);
    static Conta contaC6 = new ContaCorrente("Granato2","12345678915", 3, 600);
    
    static Conta contaP1 = new ContaPoupanca("Lucas","12345678916", 1, 101);
    static Conta contaP2 = new ContaPoupanca("Fred3","12345678917", 2, 202);
    static Conta contaP3 = new ContaPoupanca("Granato3","12345678918", 3, 303);
                                   
    static Conta contaP4 = new ContaPoupanca("Lucas","12345678919", 1, 404);
    static Conta contaP5 = new ContaPoupanca("Fred4","12345678920", 2, 505);
    static Conta contaP6 = new ContaPoupanca("Granato4","12345678921", 3, 606);

    public static Map<String,Conta> mapaConta = new HashMap<String, Conta>();
    static ValueComparator comparador = new ValueComparator(mapaConta);
    static TreeMap<String, Conta> sorted_map = new TreeMap<String, Conta>(comparador);
//    public void addContaToMap(String name, Conta conta) {
//        mapaConta.put(name, conta);
//
//    }

    
    public static Map<String, Conta> getMap() {
    	mapaConta.put(contaC1.getCpf(), contaC1);
        mapaConta.put(contaC2.getCpf(), contaC2);
        mapaConta.put(contaC3.getCpf(), contaC3);
    	mapaConta.put(contaC4.getCpf(), contaC4);
        mapaConta.put(contaC5.getCpf(), contaC5);
        mapaConta.put(contaC6.getCpf(), contaC6);
        
    	mapaConta.put(contaP1.getCpf(), contaP1);
        mapaConta.put(contaP2.getCpf(), contaP2);
        mapaConta.put(contaP3.getCpf(), contaP3);
    	mapaConta.put(contaP4.getCpf(), contaP4);
        mapaConta.put(contaP5.getCpf(), contaP5);
        mapaConta.put(contaP6.getCpf(), contaP6);
        
        sorted_map.putAll(mapaConta);
        return sorted_map;
    }

}
