package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import modelo.Bebida;
import modelo.Copiador;
import modelo.Item;
import modelo.Mesa;
import modelo.Pedido;
import modelo.Plato;
import modelo.Visa;

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
			Mesa miMesa = new Mesa(1, new Copiador(System.in, new FileOutputStream(
					new File("C:\\Users\\ezehu\\git\\TP1-OO2-Punto2-CalcularCostoMesaDeRestaurat\\salida.txt"), true)));

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
		}
	}
}
