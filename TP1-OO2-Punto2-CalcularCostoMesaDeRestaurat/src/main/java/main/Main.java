package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import exceptions.MesaExceptions;
import exceptions.PropertiesExceptions;
import modelo.BaseDeDatoGuardaDato;
import modelo.BebidaConsumicion;
import modelo.Item;
import modelo.MedioDePago;
import modelo.Mesa;
import modelo.Pedido;
import modelo.PlatoConsumicion;
import modelo.TarjetaMedioDePago;
import properties.DataBaseAlmacenamiento;

public class Main {

	public static void main(String[] args) {
		BebidaConsumicion cocaCola = new BebidaConsumicion("Coca Cola", 400);
		BebidaConsumicion cerveza = new BebidaConsumicion("Cerveza", 440);
		PlatoConsumicion milanesa = new PlatoConsumicion("Milanesa de Carne", 900);
		PlatoConsumicion pureDePapa = new PlatoConsumicion("Pure de Papa", 500);

//		Set<Consumicion> listaConsumisionesMenu = new HashSet<Consumicion>();
//		listaConsumisionesMenu.add(cocaCola);
//		listaConsumisionesMenu.add(cerveza);
//		listaConsumisionesMenu.add(milanesa);
//		listaConsumisionesMenu.add(pureDePapa);
//		System.out.println(listaConsumisionesMenu);

//		Menu miMenu = new Menu("R.E.H Servicio Tecnico", listaConsumisionesMenu);
//		System.out.println(miMenu);

		Set<Item> listaConsumisiones = new HashSet<Item>();
		listaConsumisiones.add(new Item(cocaCola, 2));
		listaConsumisiones.add(new Item(milanesa, 1));
		listaConsumisiones.add(new Item(pureDePapa, 2));
//		System.out.println(listaConsumisiones);

		Pedido miPedido = new Pedido(1, listaConsumisiones);
//		System.out.println(miPedido);

		try {

			// COPIA REGISTROS EN .TXT

//			Mesa miMesa = new Mesa(1, new DiscoGuardaDato(
//					"C:\\Users\\ezehu\\git\\TP1-OO2-Punto2-CalcularCostoMesaDeRestaurat\\salida.txt"));

			// COPIA REGISTROS EN .DATABASE

			DataBaseAlmacenamiento properties = new DataBaseAlmacenamiento(
					"C:\\Users\\ezehu\\git\\TP1-OO2-Punto2-CalcularCostoMesaDeRestaurat\\TP1-OO2-Punto2-CalcularCostoMesaDeRestaurat\\src\\main\\java\\properties\\database.properties");

			Mesa miMesa = new Mesa(1,
					new BaseDeDatoGuardaDato(properties, "INSERT INTO registro (fecha, monto)" + "VALUES (?, ?);"));

			miMesa.nuevoPedido(miPedido);
//			System.out.println(miMesa);

			MedioDePago medioDePago = new TarjetaMedioDePago();

			System.out.println(miMesa.calcularCostoDeMesa(medioDePago, 5));

		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (PropertiesExceptions e) {
			System.out.println(e.getMessage());
		} catch (MesaExceptions e) {
			System.out.println(e.getMessage());
		}
	}
}
