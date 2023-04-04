package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import exceptions.MesaExceptions;
import exceptions.PropertiesExceptions;
import modelo.BebidaConsumicion;
import modelo.ComarcaPlusMedioDePago;
import modelo.Consumicion;
import modelo.Item;
import modelo.MastercardMedioDePago;
import modelo.MedioDePago;
import modelo.Mesa;
import modelo.Pedido;
import modelo.PlatoConsumicion;
import modelo.TarjetaMedioDePago;
import modelo.VisaMedioDePago;
import properties.DataBaseAlmacenamiento;

class PruebasUnitarias {

	@Test
	void CalculoDeCostoConTarjetaVisa() {
		Consumicion cocaCola = new BebidaConsumicion("Coca Cola", 400);
		Consumicion milanesa = new PlatoConsumicion("Milanesa de Carne", 900);

		Set<Item> listaConsumisionesPedido = new HashSet<Item>();
		listaConsumisionesPedido.add(new Item(cocaCola, 2));
		listaConsumisionesPedido.add(new Item(milanesa, 1));

		Pedido miPedido = new Pedido(1, listaConsumisionesPedido);

		FakeDiscoGuardaDato fakeDisco = new FakeDiscoGuardaDato(
				"C:\\Users\\ezehu\\git\\TP1-OO2-Punto2-CalcularCostoMesaDeRestaurat\\salida.txt");

		Mesa miMesa = new Mesa(1, fakeDisco);

		miMesa.nuevoPedido(miPedido);

		MedioDePago miTarjeta = new VisaMedioDePago();

		try {

			float costoMesa = miMesa.calcularCostoDeMesa(miTarjeta, 5);

			assertEquals(fakeDisco.resultado(), costoMesa);

//			assertEquals(814.8, miMesa.calcularCostoDeMesa(miTarjeta, 5), 0.001); // solo con bebidas
//			assertEquals(fakeDisco.resultado(), miMesa.calcularCostoDeMesa(miTarjeta, 5));

		} catch (NumberFormatException e) {
			fail("exceptions NumberFormatException");
		} catch (IOException e) {
			fail("exceptions IOException");
		} catch (MesaExceptions e) {
			fail("exceptions MesaExceptions");
		}
	}

	@Test
	void CalculoDeCostoConTarjetaMastercard() {
		Consumicion cocaCola = new BebidaConsumicion("Coca Cola", 400);
		Consumicion milanesa = new PlatoConsumicion("Milanesa de Carne", 900);

		Set<Item> listaConsumisionesPedido = new HashSet<Item>();
		listaConsumisionesPedido.add(new Item(cocaCola, 2));
		listaConsumisionesPedido.add(new Item(milanesa, 1));

		Pedido miPedido = new Pedido(1, listaConsumisionesPedido);

		try {

			DataBaseAlmacenamiento properties = new DataBaseAlmacenamiento(
					"C:\\Users\\ezehu\\git\\TP1-OO2-Punto2-CalcularCostoMesaDeRestaurat\\TP1-OO2-Punto2-CalcularCostoMesaDeRestaurat\\src\\main\\java\\properties\\database.properties");

			FakeBaseDeDatoGuardaDato fakeBase = new FakeBaseDeDatoGuardaDato(properties,
					"INSERT INTO registro (fecha, monto)" + "VALUES (?, ?);");

			Mesa miMesa = new Mesa(1, fakeBase);

			miMesa.nuevoPedido(miPedido);

			MedioDePago miTarjeta = new MastercardMedioDePago();

			float costoMesa = miMesa.calcularCostoDeMesa(miTarjeta, 3);

			assertEquals(fakeBase.resultado(), costoMesa);

		} catch (NumberFormatException e) {
			fail("exceptions NumberFormatException");
		} catch (IOException e) {
			fail("exceptions IOException");
		} catch (MesaExceptions e) {
			fail("exceptions MesaExceptions");
		} catch (PropertiesExceptions e) {
			fail("exceptions PropertiesExceptions");
		}
	}

	@Test
	void CalculoDeCostoConTarjetaComarcaPlus() {
		Consumicion cocaCola = new BebidaConsumicion("Coca Cola", 400);
		Consumicion milanesa = new PlatoConsumicion("Milanesa de Carne", 900);

		Set<Item> listaConsumisionesPedido = new HashSet<Item>();
		listaConsumisionesPedido.add(new Item(cocaCola, 2));
		listaConsumisionesPedido.add(new Item(milanesa, 1));

		Pedido miPedido = new Pedido(1, listaConsumisionesPedido);

		FakeDiscoGuardaDato fakeDisco = new FakeDiscoGuardaDato(
				"C:\\Users\\ezehu\\git\\TP1-OO2-Punto2-CalcularCostoMesaDeRestaurat\\salida.txt");

		Mesa miMesa = new Mesa(1, fakeDisco);

		miMesa.nuevoPedido(miPedido);

		MedioDePago miTarjeta = new ComarcaPlusMedioDePago();

		try {

			float costoMesa = miMesa.calcularCostoDeMesa(miTarjeta, 5);

			assertEquals(fakeDisco.resultado(), costoMesa);

		} catch (NumberFormatException e) {
			fail("exceptions NumberFormatException");
		} catch (IOException e) {
			fail("exceptions IOException");
		} catch (MesaExceptions e) {
			fail("exceptions MesaExceptions");
		}
	}

	@Test
	void CalculoDeCostoConTarjetaViedma() {
		Consumicion cocaCola = new BebidaConsumicion("Coca Cola", 400);
		Consumicion milanesa = new PlatoConsumicion("Milanesa de Carne", 900);

		Set<Item> listaConsumisionesPedido = new HashSet<Item>();
		listaConsumisionesPedido.add(new Item(cocaCola, 2));
		listaConsumisionesPedido.add(new Item(milanesa, 1));

		Pedido miPedido = new Pedido(1, listaConsumisionesPedido);

		try {

			DataBaseAlmacenamiento properties = new DataBaseAlmacenamiento(
					"C:\\Users\\ezehu\\git\\TP1-OO2-Punto2-CalcularCostoMesaDeRestaurat\\TP1-OO2-Punto2-CalcularCostoMesaDeRestaurat\\src\\main\\java\\properties\\database.properties");

			FakeBaseDeDatoGuardaDato fakeBase = new FakeBaseDeDatoGuardaDato(properties,
					"INSERT INTO registro (fecha, monto)" + "VALUES (?, ?);");

			Mesa miMesa = new Mesa(1, fakeBase);

			miMesa.nuevoPedido(miPedido);

			MedioDePago miTarjeta = new TarjetaMedioDePago();

			float costoMesa = miMesa.calcularCostoDeMesa(miTarjeta, 3);

			assertEquals(fakeBase.resultado(), costoMesa);

		} catch (NumberFormatException e) {
			fail("exceptions NumberFormatException");
		} catch (IOException e) {
			fail("exceptions IOException");
		} catch (MesaExceptions e) {
			fail("exceptions MesaExceptions");
		} catch (PropertiesExceptions e) {
			fail("exceptions PropertiesExceptions");
		}
	}
}
