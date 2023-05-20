package modelo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import exceptions.BaseDeDatosExceptions;
import exceptions.GuardaDatoExceptions;

public class BaseDeDatoGuardaDato implements GuardaDato {

	private Almacenamiento properties;
	private String sqlInsertRegistro;

	public BaseDeDatoGuardaDato(Almacenamiento properties, String sqlInsertRegistro) {
		super();
		this.properties = properties;
		this.sqlInsertRegistro = sqlInsertRegistro;
	}

	@Override
	public void copiar(HashMap<String, String> datosAGuardar)
			throws IOException, GuardaDatoExceptions, BaseDeDatosExceptions {
		try (Connection conn = DriverManager.getConnection(properties.get("url"), properties.get("usuario"),
				properties.get("contrasena"));
				java.sql.PreparedStatement state = conn.prepareStatement(sqlInsertRegistro)) {

//			INSERT INTO registro (fecha, monto)" + "VALUES (?, ?);

			SimpleDateFormat formatoOriginal = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS");
			Date dateOriginal = formatoOriginal.parse(datosAGuardar.get("fecha"));

			Timestamp fechaRegistro = new Timestamp(dateOriginal.getTime());

			state.setTimestamp(1, fechaRegistro);

			state.setDouble(2, Double.valueOf(datosAGuardar.get("precioFinal")));

			int cantidad = state.executeUpdate();

			if (cantidad <= 0) {
				throw new GuardaDatoExceptions("error al ingresar Registro");
			}

		} catch (SQLException e) {
			throw new BaseDeDatosExceptions("error al prosesar consulta");
		} catch (IllegalArgumentException e) {
			throw new BaseDeDatosExceptions("IllegalArgumentException");
		} catch (ParseException e) {
			throw new BaseDeDatosExceptions("ParseException");
		}
	}
}
