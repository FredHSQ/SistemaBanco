package applications;

import java.util.HashMap;
import java.util.Map;

import contas.Conta;
import contas.ContaCorrente;

public class MapConta {

    static Conta conta1 = new ContaCorrente("Lucas","12345678910", 1, 100);
    static Conta conta2 = new ContaCorrente("Fred","12345678911", 2, 200);
    static Conta conta3 = new ContaCorrente("Granato","12345678912", 3, 300);

    public static Map<String,Conta> mapaConta = new HashMap<String, Conta>();

//    public void addContaToMap(String name, Conta conta) {
//        mapaConta.put(name, conta);
//
//    }
//

    public static Map<String, Conta> getMap() {
    	mapaConta.put(conta1.getCpf(), conta1);
        mapaConta.put(conta2.getCpf(), conta2);
        mapaConta.put(conta3.getCpf(), conta3);
        return mapaConta;
    }

}
