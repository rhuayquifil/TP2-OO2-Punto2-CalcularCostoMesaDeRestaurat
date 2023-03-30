package modelo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;

import exceptions.BaseDeDatosExceptions;
import exceptions.GuardaDatoExceptions;

public class almacenarRegistrosEnBase implements GuardaDato {

	private Almacenamiento properties;
	private String sqlInsertRegistro;

	public almacenarRegistrosEnBase(Almacenamiento properties, String sqlInsertRegistro) {
		super();
		this.properties = properties;
		this.sqlInsertRegistro = sqlInsertRegistro;
	}

	@Override
	public void copiar(String registro) throws IOException, GuardaDatoExceptions, BaseDeDatosExceptions {
		try (Connection conn = DriverManager.getConnection(properties.get("url"), properties.get("usuario"),
				properties.get("contrasena"));
				java.sql.PreparedStatement state = conn.prepareStatement(sqlInsertRegistro)) {

//			INSERT INTO registro (fecha, monto)" + "VALUES (?, ?);

			String[] parts = registro.split("\\|");

//			LocalDateTime nuevo = LocalDateTime.parse(parts[0]);
			java.sql.Timestamp fechaRegistro = java.sql.Timestamp.valueOf(LocalDateTime.parse(parts[0]));
			state.setTimestamp(1, fechaRegistro);

			state.setDouble(2, Double.valueOf(parts[1]));

			int cantidad = state.executeUpdate();

			if (cantidad > 0) {
//				throw new DAOExceptions("Registro ingresado con exito");
			} else {
				throw new GuardaDatoExceptions("error al ingresar Registro");
			}

		} catch (SQLException e) {
			throw new BaseDeDatosExceptions("error al prosesar consulta");
		} catch (IllegalArgumentException e) {
			throw new BaseDeDatosExceptions("IllegalArgumentException");
		}
	}
}
