package modelo;

import java.io.IOException;
import java.util.HashMap;

import exceptions.BaseDeDatosExceptions;
import exceptions.GuardaDatoExceptions;

public interface GuardaDato {

	void copiar(HashMap<String, String> datosAGuardar) throws IOException, GuardaDatoExceptions, BaseDeDatosExceptions;
}
