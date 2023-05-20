package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import exceptions.AlmacenamientoExceptions;
import modelo.BebidaConsumicion;
import modelo.ComarcaPlusMedioDePago;
import modelo.Consumicion;
import modelo.DefaultVentaObservable;
import modelo.Item;
import modelo.MastercardMedioDePago;
import modelo.Observer;
import modelo.PlatoConsumicion;
import modelo.TarjetaMedioDePago;
import modelo.VentasExceptions;
import modelo.VisaMedioDePago;
import properties.DataBaseAlmacenamiento;

class PruebasUnitarias {

	@Test
	void CalculoDeCostoConTarjetaVisa() {

		Consumicion cocaCola = new BebidaConsumicion("Coca Cola", 400);
		Consumicion milanesa = new PlatoConsumicion("Milanesa de Carne", 900);

		Set<Item> listaConsumisiones = new HashSet<Item>();

		listaConsumisiones.add(new Item(cocaCola, 2));
		listaConsumisiones.add(new Item(milanesa, 1));

		FakeDiscoGuardaDato disco = new FakeDiscoGuardaDato(
				"C:\\Users\\ezehu\\git\\TP1-OO2-Punto2-CalcularCostoMesaDeRestaurat\\salida.txt", " - ");

		List<Observer> listaSubs = new ArrayList<Observer>();
		listaSubs.add(new FakeMonitorObserver());

		DefaultVentaObservable ventas = new DefaultVentaObservable(disco, listaSubs);

		int propina = 2;

		try {
			ventas.registrar(listaConsumisiones, LocalDate.of(2023, 05, 18), new VisaMedioDePago(), propina);
			String resultado = disco.resultado();
			assertEquals("2023-05-18 - 1709.52", resultado);

		} catch (VentasExceptions e1) {
			fail("exceptions VentasExceptions");
		}
	}

	@Test
	void CalculoDeCostoConTarjetaMastercard() {

		Consumicion milanesa = new PlatoConsumicion("Milanesa de Carne", 900);
		Consumicion pureDePapa = new PlatoConsumicion("Pure de Papa", 500);
		Consumicion cocaCola = new BebidaConsumicion("Coca Cola", 400);

		Set<Item> listaConsumisiones = new HashSet<Item>();
		listaConsumisiones.add(new Item(cocaCola, 2));
		listaConsumisiones.add(new Item(milanesa, 1));
		listaConsumisiones.add(new Item(pureDePapa, 2));

		try {

			DataBaseAlmacenamiento properties = new DataBaseAlmacenamiento(
					"jdbc:mysql://127.0.0.1/costo_de_mesa_restaurant", "root", "");

			FakeBaseDeDatoGuardaDato fakeBase = new FakeBaseDeDatoGuardaDato(properties,
					"INSERT INTO registro (fecha, monto)" + "VALUES (?, ?);");

			List<Observer> listaSubs = new ArrayList<Observer>();
			listaSubs.add(new FakeMonitorObserver());

			DefaultVentaObservable ventas = new DefaultVentaObservable(fakeBase, listaSubs);

			int propina = 5;

			ventas.registrar(listaConsumisiones, LocalDate.of(2023, 05, 18), new MastercardMedioDePago(), propina);
			String resultado = fakeBase.resultado();
			assertEquals("2023-05-18 - 2795.1", resultado);

		} catch (VentasExceptions e1) {
			fail("exceptions VentasExceptions");
		} catch (AlmacenamientoExceptions e) {
			fail("exceptions AlmacenamientoExceptions");
		}
	}

	@Test
	void CalculoDeCostoConTarjetaComarcaPlus() {
		Consumicion cerveza = new BebidaConsumicion("Cerveza", 440);

		Set<Item> listaConsumisiones = new HashSet<Item>();
		listaConsumisiones.add(new Item(cerveza, 10));

		FakeDiscoGuardaDato disco = new FakeDiscoGuardaDato(
				"C:\\Users\\ezehu\\git\\TP1-OO2-Punto2-CalcularCostoMesaDeRestaurat\\salida.txt", " - ");

		List<Observer> listaSubs = new ArrayList<Observer>();
		listaSubs.add(new FakeMonitorObserver());

		DefaultVentaObservable ventas = new DefaultVentaObservable(disco, listaSubs);

		int propina = 2;

		try {
			ventas.registrar(listaConsumisiones, LocalDate.of(2023, 05, 18), new ComarcaPlusMedioDePago(), propina);
			String resultado = disco.resultado();
			assertEquals("2023-05-18 - 4398.24", resultado);

		} catch (VentasExceptions e1) {
			fail("exceptions VentasExceptions");
		}
	}

	@Test
	void CalculoDeCostoConTarjetaViedma() {
		Consumicion milanesa = new PlatoConsumicion("Milanesa de Carne", 900);
		Consumicion pureDePapa = new PlatoConsumicion("Pure de Papa", 500);
		Consumicion cocaCola = new BebidaConsumicion("Coca Cola", 400);
		Consumicion cerveza = new BebidaConsumicion("Cerveza", 440);

		Set<Item> listaConsumisiones = new HashSet<Item>();
		listaConsumisiones.add(new Item(cocaCola, 1));
		listaConsumisiones.add(new Item(milanesa, 1));
		listaConsumisiones.add(new Item(pureDePapa, 1));
		listaConsumisiones.add(new Item(cerveza, 1));

		try {

			DataBaseAlmacenamiento properties = new DataBaseAlmacenamiento(
					"jdbc:mysql://127.0.0.1/costo_de_mesa_restaurant", "root", "");

			FakeBaseDeDatoGuardaDato fakeBase = new FakeBaseDeDatoGuardaDato(properties,
					"INSERT INTO registro (fecha, monto)" + "VALUES (?, ?);");

			List<Observer> listaSubs = new ArrayList<Observer>();
			listaSubs.add(new FakeMonitorObserver());

			DefaultVentaObservable ventas = new DefaultVentaObservable(fakeBase, listaSubs);

			int propina = 3;

			ventas.registrar(listaConsumisiones, LocalDate.of(2023, 05, 18), new TarjetaMedioDePago(), propina);
			String resultado = fakeBase.resultado();
			assertEquals("2023-05-18 - 2307.2", resultado);

		} catch (VentasExceptions e1) {
			fail("exceptions VentasExceptions");
		} catch (AlmacenamientoExceptions e) {
			fail("exceptions AlmacenamientoExceptions");
		}
	}
}
