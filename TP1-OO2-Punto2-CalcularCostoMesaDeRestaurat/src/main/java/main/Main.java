package main;

import java.util.ArrayList;
import java.util.List;

import modelo.BebidaConsumicion;
import modelo.Consumicion;
import modelo.DefaultVentaObservable;
import modelo.DiscoGuardaDato;
import modelo.MonitorObserver;
import modelo.Observer;
import modelo.PlatoConsumicion;
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

			DefaultVentaObservable observable = new DefaultVentaObservable(
					new DiscoGuardaDato(
							"C:\\Users\\ezehu\\git\\TP1-OO2-Punto2-CalcularCostoMesaDeRestaurat\\salida.txt"),
					listaSubs);

			SeleccionDePlatosFrame frame = new SeleccionDePlatosFrame(platosYBebidas, observable);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);

			// COPIA REGISTROS EN .TXT

//			Mesa miMesa = new Mesa(1, new DiscoGuardaDato(
//					"C:\\Users\\ezehu\\git\\TP1-OO2-Punto2-CalcularCostoMesaDeRestaurat\\salida.txt"));

			// COPIA REGISTROS EN .DATABASE

//			DataBaseAlmacenamiento properties = new DataBaseAlmacenamiento(
//					"jdbc:mysql://127.0.0.1/costo_de_mesa_restaurant", "root", "");
//
//			Mesa miMesa = new Mesa(1,
//					new BaseDeDatoGuardaDato(properties, "INSERT INTO registro (fecha, monto)" + "VALUES (?, ?);"));

//			miMesa.nuevoPedido(primerPedido);
//			miMesa.nuevoPedido(segundoPedido);
//
//			MedioDePago medioDePago = new VisaMedioDePago();
//
//			float costoMesa = miMesa.calcularCostoDeMesa(medioDePago, 5);

		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
//		} catch (FileNotFoundException e) {
//			System.out.println(e.getMessage());
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		} catch (AlmacenamientoExceptions e) {
//			System.out.println(e.getMessage());
//		} catch (MesaExceptions e) {
//			System.out.println(e.getMessage());
		}
	}
}
