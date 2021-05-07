package escritorLeitor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import applications.Menu;

public class EscritorLeitor {
	public static void escritorMovimentacoes(String cpf, Integer agencia, Double valor, Double saldo) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter("../temp/"+LocalDateTime.now()+".txt", true));

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
		escritor.append("Realizador da movimentação: "+ cpf +" ");
		escritor.append(String.valueOf(agencia)+" ");
		escritor.append(String.valueOf(valor)+" ");
		escritor.append(String.valueOf(saldo)+" ");
		escritor.append(String.valueOf(LocalDateTime.now().format(formatter)));
		escritor.append(Menu.logo());
		escritor.close();
	}
}
