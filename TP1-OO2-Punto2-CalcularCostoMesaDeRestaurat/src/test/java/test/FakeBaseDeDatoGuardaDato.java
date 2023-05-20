package test;

import java.io.IOException;
import java.util.HashMap;

import exceptions.BaseDeDatosExceptions;
import exceptions.GuardaDatoExceptions;
import modelo.Almacenamiento;
import modelo.GuardaDato;

public class FakeBaseDeDatoGuardaDato implements GuardaDato {

	private String resultado;
	private Almacenamiento properties;
	private String sqlInsertRegistro;

	public FakeBaseDeDatoGuardaDato(Almacenamiento properties, String sqlInsertRegistro) {
		super();
		this.resultado = "";
		this.properties = properties;
		this.sqlInsertRegistro = sqlInsertRegistro;
	}

	@Override
	public void copiar(HashMap<String, String> datosAGuardar)
			throws IOException, GuardaDatoExceptions, BaseDeDatosExceptions {

		resultado = datosAGuardar.get("fecha") + " - " + datosAGuardar.get("precioFinal");

	}

	String resultado() {
		return resultado;
	}
}
