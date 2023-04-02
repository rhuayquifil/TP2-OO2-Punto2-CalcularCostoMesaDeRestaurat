package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exceptions.BaseDeDatosExceptions;
import exceptions.GuardaDatoExceptions;
import modelo.Almacenamiento;
import modelo.GuardaDato;

public class FakeBaseDeDatoGuardaDato implements GuardaDato {

	private float resultado;
	private Almacenamiento properties;
	private String sqlInsertRegistro;

	public FakeBaseDeDatoGuardaDato(Almacenamiento properties, String sqlInsertRegistro) {
		super();
		this.resultado = 0;
		this.properties = properties;
		this.sqlInsertRegistro = sqlInsertRegistro;
	}

	@Override
	public void copiar(String registro) throws IOException, GuardaDatoExceptions, BaseDeDatosExceptions {

		try (Connection conn = DriverManager.getConnection(properties.get("url"), properties.get("usuario"),
				properties.get("contrasena"));
				java.sql.PreparedStatement state = conn.prepareStatement(sqlInsertRegistro)) {

//			INSERT INTO registro (fecha, monto)" + "VALUES (?, ?);

			String[] parts = registro.split(" \\| ");

			resultado = Float.valueOf(parts[1]);

		} catch (SQLException e) {
			throw new BaseDeDatosExceptions("error al prosesar consulta");
		} catch (IllegalArgumentException e) {
			throw new BaseDeDatosExceptions("IllegalArgumentException");
		}
	}

	float resultado() {
		return resultado;
	}
}
