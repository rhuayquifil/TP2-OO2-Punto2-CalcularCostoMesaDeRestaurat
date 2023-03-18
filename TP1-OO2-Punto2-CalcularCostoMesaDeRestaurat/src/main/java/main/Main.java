package main;

import java.util.HashSet;
import java.util.Set;

import modelo.Bebida;
import modelo.Consumicion;
import modelo.Item;
import modelo.Menu;
import modelo.Mesa;
import modelo.Pedido;
import modelo.Plato;
import modelo.Tarjeta;

public class Main {

	public static void main(String[] args) {
		Bebida cocaCola = new Bebida("Coca Cola", 400);
		Bebida cerveza = new Bebida("Cerveza", 440);
		Plato milanesa = new Plato("Milanesa de Carne", 900);
		Plato pureDePapa = new Plato("Pure de Papa", 500);

		Set<Consumicion> listaConsumisionesMenu = new HashSet<Consumicion>();
		listaConsumisionesMenu.add(cocaCola);
		listaConsumisionesMenu.add(cerveza);
		listaConsumisionesMenu.add(milanesa);
		listaConsumisionesMenu.add(pureDePapa);
//		System.out.println(listaConsumisionesMenu);

		Menu miMenu = new Menu("R.E.H Servicio Tecnico", listaConsumisionesMenu);
//		System.out.println(miMenu);

		Set<Item> listaConsumisiones = new HashSet<Item>();
		listaConsumisiones.add(new Item(cocaCola, 2));
		listaConsumisiones.add(new Item(milanesa, 1));
//		listaConsumisiones.add(new Item(pureDePapa, 2));
//		System.out.println(listaConsumisiones);

		Pedido miPedido = new Pedido(1, listaConsumisiones);
//		System.out.println(miPedido);

		Mesa miMesa = new Mesa(1);
		miMesa.nuevoPedido(miPedido);
//		System.out.println(miMesa);

//		Visa miTarjeta = new Visa();
//		Mastercard miTarjeta = new Mastercard();
//		ComarcaPlus miTarjeta = new ComarcaPlus();
		Tarjeta miTarjeta = new Tarjeta();

		try {
			System.out.println(miMesa.calcularCostoDeMesa(miTarjeta, 5));
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}
}
