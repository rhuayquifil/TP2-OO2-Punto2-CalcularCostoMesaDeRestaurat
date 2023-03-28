package modelo;

import java.io.IOException;

import exceptions.BaseDeDatosExceptions;
import exceptions.GuardaDatoExceptions;

public interface GuardaDato {

	void copiar(double monto) throws IOException, GuardaDatoExceptions, BaseDeDatosExceptions;
}
