package test;

import java.io.IOException;

import exceptions.BaseDeDatosExceptions;
import exceptions.GuardaDatoExceptions;
import modelo.GuardaDato;

public class FakeDiscoGuardaDato implements GuardaDato {

	private String resultado;
	private String rutaArchivo;

	public FakeDiscoGuardaDato(String rutaArchivo) {
		super();
		this.resultado = "";
		this.rutaArchivo = rutaArchivo;
	}

	@Override
	public void copiar(String registro) throws GuardaDatoExceptions, BaseDeDatosExceptions, IOException {
		String[] parts = registro.split(" \\| ");

		resultado = parts[1];
	}

	String resultado() {
		return resultado;
	}
}
