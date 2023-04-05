package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import exceptions.AlmacenamientoExceptions;
import exceptions.MesaExceptions;
import modelo.BaseDeDatoGuardaDato;
import modelo.BebidaConsumicion;
import modelo.Item;
import modelo.MedioDePago;
import modelo.Mesa;
import modelo.Pedido;
import modelo.PlatoConsumicion;
import modelo.VisaMedioDePago;
import properties.DataBaseAlmacenamiento;

public class Main {

	public static void main(String[] args) {
		BebidaConsumicion cocaCola = new BebidaConsumicion("Coca Cola", 400);
		BebidaConsumicion cerveza = new BebidaConsumicion("Cerveza", 440);
		PlatoConsumicion milanesa = new PlatoConsumicion("Milanesa de Carne", 900);
		PlatoConsumicion pureDePapa = new PlatoConsumicion("Pure de Papa", 500);

		// PRIMER PEDIDO
		Set<Item> listaConsumisionesPrimerPedido = new HashSet<Item>();
		listaConsumisionesPrimerPedido.add(new Item(cocaCola, 2));
		listaConsumisionesPrimerPedido.add(new Item(milanesa, 1));

		Pedido primerPedido = new Pedido(1, listaConsumisionesPrimerPedido);

		// SEGUNDO PEDIDO
		Set<Item> listaConsumisionesSegundoPedido = new HashSet<Item>();
		listaConsumisionesSegundoPedido.add(new Item(cerveza, 2));
//		listaConsumisionesSegundoPedido.add(new Item(cocaCola, 1));

		Pedido segundoPedido = new Pedido(1, listaConsumisionesSegundoPedido);

		try {

			// COPIA REGISTROS EN .TXT

//			Mesa miMesa = new Mesa(1, new DiscoGuardaDato(
//					"C:\\Users\\ezehu\\git\\TP1-OO2-Punto2-CalcularCostoMesaDeRestaurat\\salida.txt"));

			// COPIA REGISTROS EN .DATABASE

			DataBaseAlmacenamiento properties = new DataBaseAlmacenamiento(
					"jdbc:mysql://127.0.0.1/costo_de_mesa_restaurant", "root", "");

			Mesa miMesa = new Mesa(1,
					new BaseDeDatoGuardaDato(properties, "INSERT INTO registro (fecha, monto)" + "VALUES (?, ?);"));

			miMesa.nuevoPedido(primerPedido);
			miMesa.nuevoPedido(segundoPedido);

			MedioDePago medioDePago = new VisaMedioDePago();

			float costoMesa = miMesa.calcularCostoDeMesa(medioDePago, 5);

		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (AlmacenamientoExceptions e) {
			System.out.println(e.getMessage());
		} catch (MesaExceptions e) {
			System.out.println(e.getMessage());
		}
	}
}
