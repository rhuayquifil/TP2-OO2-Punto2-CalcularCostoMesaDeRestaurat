package main;

import java.util.ArrayList;
import java.util.List;

import exceptions.AlmacenamientoExceptions;
import modelo.BaseDeDatoGuardaDato;
import modelo.BebidaConsumicion;
import modelo.Consumicion;
import modelo.DefaultVentaObservable;
import modelo.DiscoGuardaDato;
import modelo.GuardaDato;
import modelo.MonitorObserver;
import modelo.Observer;
import modelo.PlatoConsumicion;
import properties.DataBaseAlmacenamiento;
import ui.SeleccionDePlatosFrame;

public class Main {

	public static void main(String[] args) {
		try {
			List<Consumicion> platosYBebidas = new ArrayList<Consumicion>();
			platosYBebidas.add(new BebidaConsumicion("Coca Cola", 400));
			platosYBebidas.add(new BebidaConsumicion("Cerveza", 440));
			platosYBebidas.add(new PlatoConsumicion("Milanesa de Carne", 900));
			platosYBebidas.add(new PlatoConsumicion("Pure de Papa", 500000));

			List<Observer> listaSubs = new ArrayList<Observer>();
			listaSubs.add(new MonitorObserver());

			GuardaDato disco = new DiscoGuardaDato(
					"C:\\Users\\ezehu\\git\\TP1-OO2-Punto2-CalcularCostoMesaDeRestaurat\\salida.txt", " - ");

			DataBaseAlmacenamiento properties = new DataBaseAlmacenamiento(
					"jdbc:mysql://127.0.0.1/costo_de_mesa_restaurant", "root", "");

			GuardaDato baseDeDatos = new BaseDeDatoGuardaDato(properties,
					"INSERT INTO registro (fecha, monto)" + "VALUES (?, ?);");

			DefaultVentaObservable observable = new DefaultVentaObservable(baseDeDatos, listaSubs);

			SeleccionDePlatosFrame frame = new SeleccionDePlatosFrame(platosYBebidas, observable);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);

		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (AlmacenamientoExceptions e) {
			System.out.println(e.getMessage());
		}
	}
}
