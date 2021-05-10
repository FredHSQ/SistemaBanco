package applications;

import java.util.HashMap;
import java.util.Map;

import contas.Conta;
import contas.ContaCorrente;
import usuario.Gerente;
import usuario.Usuario;

public class MapUsuario {
	
	static Gerente g1 = new Gerente("123456","12345678910",1);
	static Gerente g2 = new Gerente("paodequeijo","12345678911",3);
	static Gerente g3 = new Gerente("lasanhamilanesa","12345678912",3);

    public static Map<String, Usuario> mapaUsuario = new HashMap<>();
	

//    public void addContaToMap(String name, Conta conta) {
//        mapaConta.put(name, conta);
//
//    }
//

    public static Map<String, Usuario> getMap() {
    	mapaUsuario.put(g1.getCpf(), g1);
    	mapaUsuario.put(g2.getCpf(), g2);
    	mapaUsuario.put(g3.getCpf(), g3);
        return mapaUsuario;
    }

}
