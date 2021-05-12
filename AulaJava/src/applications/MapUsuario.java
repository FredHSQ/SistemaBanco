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

//criamos essa classe para podermos pegar em qualquer lugar o mapa criado
public class MapUsuario {

	// criador do mapa
    public static Map<String, Usuario> mapaUsuario = new HashMap<>();
    
    // leitor do mapa do usuario
    public static void leitorUsuario(String path) throws IOException {
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
				// if para fazer o construtor caso seja usuario cliente ou usuario gerente ou diretor ou presidente
				if(lelinha[0].equalsIgnoreCase(CargoEnum.CLIENTE.name())) {
					Usuario cliente = new Cliente(lelinha[2],lelinha[1]);
					MapUsuario.getMap().put(lelinha[1], cliente);
				}else if(lelinha[0].equalsIgnoreCase(CargoEnum.GERENTE.name())) {
					// unico que tem agencia no usuario
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
    
    // pega o mapa do usuario
    public static Map<String, Usuario> getMap() {
        return mapaUsuario;
    }
}
