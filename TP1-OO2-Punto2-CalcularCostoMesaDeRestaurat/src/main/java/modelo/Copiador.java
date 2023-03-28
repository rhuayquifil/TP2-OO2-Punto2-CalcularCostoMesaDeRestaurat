package modelo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Copiador implements GuardaDato {

	private InputStream input;
	private OutputStream output;

	public Copiador(InputStream input, OutputStream output) {
		super();
		this.input = input;
		this.output = output;
	}

	@Override
	public void copiar(double monto) throws IOException {
		try (Scanner scanner = new Scanner(input)) {

			String registro = LocalDateTime.now() + " || " + monto + '\n';
			output.write(registro.getBytes());
		}
	}
}
