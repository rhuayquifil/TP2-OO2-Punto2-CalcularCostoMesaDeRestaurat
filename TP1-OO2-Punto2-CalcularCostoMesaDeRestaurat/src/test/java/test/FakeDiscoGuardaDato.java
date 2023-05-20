package test;

import java.io.IOException;
import java.util.HashMap;

import exceptions.BaseDeDatosExceptions;
import exceptions.GuardaDatoExceptions;
import modelo.GuardaDato;

public class FakeDiscoGuardaDato implements GuardaDato {

	private String resultado;
	private String rutaArchivo;
	private String separador;

	public FakeDiscoGuardaDato(String rutaArchivo, String separador) {
		super();
		this.rutaArchivo = rutaArchivo;
		this.separador = separador;
		this.resultado = "";
	}

	@Override
	public void copiar(HashMap<String, String> datosAGuardar)
			throws IOException, GuardaDatoExceptions, BaseDeDatosExceptions {
		resultado = datosAGuardar.get("fecha") + separador + datosAGuardar.get("precioFinal");
	}

	String resultado() {
		return resultado;
	}
}
