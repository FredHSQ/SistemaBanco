package applications;


import java.util.HashMap;

import java.util.Map;
import usuario.Cliente;
import usuario.Diretor;
import usuario.Gerente;
import usuario.Presidente;
import usuario.Usuario;

public class MapUsuario {
	
	static Usuario g1 = new Gerente("lasanhamilanesa","12345678910",1);
	static Usuario g2 = new Gerente("lasanhamilanesa","12345678911",2);
	static Usuario g3 = new Gerente("lasanhamilanesa","12345678912",3);
	
	static Usuario c1 = new Cliente("lasanhamilanesa","12345678913");
	static Usuario c2 = new Cliente("lasanhamilanesa","12345678914");
	static Usuario c3 = new Cliente("lasanhamilanesa","12345678915");
	
	static Usuario p1 = new Presidente("lasanhamilanesa","12345678916");
	static Usuario p2 = new Presidente("lasanhamilanesa","12345678917");
	static Usuario p3 = new Presidente("lasanhamilanesa","12345678918");
	
	static Usuario d1 = new Diretor("lasanhamilanesa","12345678919");
	static Usuario d2 = new Diretor("lasanhamilanesa","12345678920");
	static Usuario d3 = new Diretor("lasanhamilanesa","12345678921");

	
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
    	
    	mapaUsuario.put(c1.getCpf(), c1);
    	mapaUsuario.put(c2.getCpf(), c2);
    	mapaUsuario.put(c3.getCpf(), c3);
    	
    	mapaUsuario.put(d1.getCpf(), d1);
    	mapaUsuario.put(d2.getCpf(), d2);
    	mapaUsuario.put(d3.getCpf(), d3);
    	
    	mapaUsuario.put(p1.getCpf(), p1);
    	mapaUsuario.put(p2.getCpf(), p2);
    	mapaUsuario.put(p3.getCpf(), p3);
        return mapaUsuario;
    }
}
