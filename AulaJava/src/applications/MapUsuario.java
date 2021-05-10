package applications;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import java.util.Map;

import bancoEnum.CargoEnum;
import usuario.Cliente;
import usuario.Diretor;
import usuario.Gerente;
import usuario.Presidente;
import usuario.Usuario;

public class MapUsuario {
	
//	static Usuario g1 = new Gerente("lasanhamilanesa","12345678910",1);
//	static Usuario g2 = new Gerente("lasanhamilanesa","12345678911",2);
//	static Usuario g3 = new Gerente("lasanhamilanesa","12345678912",3);
//	
//	static Usuario c1 = new Cliente("lasanhamilanesa","12345678913");
//	static Usuario c2 = new Cliente("lasanhamilanesa","12345678914");
//	static Usuario c3 = new Cliente("lasanhamilanesa","12345678915");
//	
//	static Usuario p1 = new Presidente("lasanhamilanesa","12345678916");
//	static Usuario p2 = new Presidente("lasanhamilanesa","12345678917");
//	static Usuario p3 = new Presidente("lasanhamilanesa","12345678918");
//	
//	static Usuario d1 = new Diretor("lasanhamilanesa","12345678919");
//	static Usuario d2 = new Diretor("lasanhamilanesa","12345678920");
//	static Usuario d3 = new Diretor("lasanhamilanesa","12345678921");

	
    public static Map<String, Usuario> mapaUsuario = new HashMap<>();

    public static void leitorUsuario(String path) throws IOException {

		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";

		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
				String[] lelinha = linha.split(";");
				if(lelinha[0].equalsIgnoreCase(CargoEnum.CLIENTE.name())) {
					Usuario cliente = new Cliente(lelinha[1],lelinha[2]);
					MapUsuario.getMap().put(lelinha[1], cliente);
				}else if(lelinha[0].equalsIgnoreCase(CargoEnum.GERENTE.name())) {
					Usuario gerente = new Gerente(lelinha[1],lelinha[2],Integer.parseInt(lelinha[3]));
					MapUsuario.getMap().put(lelinha[1], gerente);
				}else if(lelinha[0].equalsIgnoreCase(CargoEnum.DIRETOR.name())) {
					Usuario diretor = new Diretor(lelinha[1],lelinha[2]);
					MapUsuario.getMap().put(lelinha[1], diretor);
				}else if(lelinha[0].equalsIgnoreCase(CargoEnum.PRESIDENTE.name())) {
					Usuario presidente = new Presidente(lelinha[1],lelinha[2]);
					MapUsuario.getMap().put(lelinha[1], presidente);
				}
			} else
				break;
		}
		buffRead.close();
	}
    public static Map<String, Usuario> getMap() {
 
        return mapaUsuario;
    }
}
