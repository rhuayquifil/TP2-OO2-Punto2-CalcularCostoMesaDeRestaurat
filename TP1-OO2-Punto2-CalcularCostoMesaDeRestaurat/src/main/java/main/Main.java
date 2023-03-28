package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import exceptions.MesaExceptions;
import exceptions.PropertiesExceptions;
import modelo.Bebida;
import modelo.Item;
import modelo.Mesa;
import modelo.Pedido;
import modelo.Plato;
import modelo.Visa;
import modelo.almacenarRegistrosEnBase;
import properties.DataBase;

public class Main {

	public static void main(String[] args) {
		Bebida cocaCola = new Bebida("Coca Cola", 400);
		Bebida cerveza = new Bebida("Cerveza", 440);
		Plato milanesa = new Plato("Milanesa de Carne", 900);
		Plato pureDePapa = new Plato("Pure de Papa", 500);

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
//		listaConsumisiones.add(new Item(pureDePapa, 2));
//		System.out.println(listaConsumisiones);

		Pedido miPedido = new Pedido(1, listaConsumisiones);
//		System.out.println(miPedido);

		try {

			// COPIA REGISTROS EN .TXT

//			Mesa miMesa = new Mesa(1, new Copiador(System.in, new FileOutputStream(
//					new File("C:\\Users\\ezehu\\git\\TP1-OO2-Punto2-CalcularCostoMesaDeRestaurat\\salida.txt"), true)));

			// COPIA REGISTROS EN .DATABASE

			DataBase properties = new DataBase(
					"C:\\Users\\ezehu\\git\\TP1-OO2-Punto2-CalcularCostoMesaDeRestaurat\\TP1-OO2-Punto2-CalcularCostoMesaDeRestaurat\\src\\main\\java\\properties\\database.properties");

			Mesa miMesa = new Mesa(1,
					new almacenarRegistrosEnBase(properties, "INSERT INTO registro (fecha, monto)" + "VALUES (?, ?);"));

			miMesa.nuevoPedido(miPedido);
//			System.out.println(miMesa);

			Visa miTarjeta = new Visa();
//			Mastercard miTarjeta = new Mastercard();
//			ComarcaPlus miTarjeta = new ComarcaPlus();
//			Tarjeta miTarjeta = new Tarjeta();

			System.out.println(miMesa.calcularCostoDeMesa(miTarjeta, 5));

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
