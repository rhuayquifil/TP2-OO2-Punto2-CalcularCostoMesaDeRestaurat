package modelo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

import exceptions.BaseDeDatosExceptions;
import exceptions.GuardaDatoExceptions;

public class DiscoGuardaDato implements GuardaDato {

	private String rutaArchivo;
	private String separador;

	public DiscoGuardaDato(String rutaArchivo, String separador) {
		super();
		this.rutaArchivo = rutaArchivo;
		this.separador = separador;
	}

	@Override
	public void copiar(HashMap<String, String> datosAGuardar)
			throws IOException, GuardaDatoExceptions, BaseDeDatosExceptions {
		OutputStream output = new FileOutputStream(new File(rutaArchivo), true);

		String guardar = datosAGuardar.get("fecha") + separador + datosAGuardar.get("precioFinal") + '\n';
		output.write(guardar.getBytes());

	}
}
