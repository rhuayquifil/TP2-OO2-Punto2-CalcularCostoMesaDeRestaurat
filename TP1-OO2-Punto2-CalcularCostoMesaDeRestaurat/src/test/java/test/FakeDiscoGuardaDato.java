package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import exceptions.BaseDeDatosExceptions;
import exceptions.GuardaDatoExceptions;
import modelo.GuardaDato;

public class FakeDiscoGuardaDato implements GuardaDato {

	private float resultado;
	private String rutaArchivo;

	public FakeDiscoGuardaDato(String rutaArchivo) {
		super();
		this.resultado = 0;
		this.rutaArchivo = rutaArchivo;
	}

	@Override
	public void copiar(String registro) throws GuardaDatoExceptions, BaseDeDatosExceptions, IOException {

		OutputStream output = new FileOutputStream(new File(rutaArchivo), true);

		String[] parts = registro.split(" \\| ");

		// TENES QUE HACER FUNCIONAR LOS TEST CON FAKE OBSJECT Y VER PORQUE NO ME
		// RETORNA RESULTADO

//		System.out.println(parts[0]);
//		System.out.println(parts[1]);
		resultado = Float.valueOf(parts[1]);
	}

	float resultado() {
		return this.resultado;
	}
}
