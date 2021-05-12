package applications;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import bancoEnum.CargoEnum;
import usuario.Cliente;
import usuario.Diretor;
import usuario.Gerente;
import usuario.Presidente;
import usuario.Usuario;

public class MapUsuario {

	
    public static Map<String, Usuario> mapaUsuario = new HashMap<>();

    public static void leitorUsuario(String path) throws IOException {

		BufferedReader buffRead = new BufferedReader(new FileReader(path,StandardCharsets.UTF_8));
		String linha = "";

		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
				String[] lelinha = linha.split(";");
				if(lelinha[0].equalsIgnoreCase(CargoEnum.CLIENTE.name())) {
					Usuario cliente = new Cliente(lelinha[2],lelinha[1]);
					MapUsuario.getMap().put(lelinha[1], cliente);
				}else if(lelinha[0].equalsIgnoreCase(CargoEnum.GERENTE.name())) {
					Usuario gerente = new Gerente(lelinha[2],lelinha[1],Integer.parseInt(lelinha[3]));
					MapUsuario.getMap().put(lelinha[1], gerente);
				}else if(lelinha[0].equalsIgnoreCase(CargoEnum.DIRETOR.name())) {
					Usuario diretor = new Diretor(lelinha[2],lelinha[1]);
					MapUsuario.getMap().put(lelinha[1], diretor);
				}else if(lelinha[0].equalsIgnoreCase(CargoEnum.PRESIDENTE.name())) {
					Usuario presidente = new Presidente(lelinha[2],lelinha[1]);
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
