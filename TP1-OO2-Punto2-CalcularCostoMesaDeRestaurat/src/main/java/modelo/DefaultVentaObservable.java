package modelo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import exceptions.BaseDeDatosExceptions;
import exceptions.GuardaDatoExceptions;
import exceptions.MesaExceptions;

public class DefaultVentaObservable extends Observable {

	private GuardaDato guardaDato;
	private Mesa mesa;

	public DefaultVentaObservable(GuardaDato guardaDato, List<Observer> subscriptores) {
		super();
		this.guardaDato = guardaDato;

		for (Observer observer : subscriptores) {
			this.subscribir(observer);
		}
	}

	public void registrar(Set<Item> listaConsumisiones, LocalDate fecha, MedioDePago medioDePago, int propina)
			throws VentasExceptions {
		mesa = new Mesa(1);
		crearPedidoParaMesa(listaConsumisiones);

		try {

			float precioFinal = mesa.calcularCostoDeMesa(medioDePago, propina);

			HashMap<String, String> datosAGuardar = new HashMap<String, String>();
			datosAGuardar.put("fecha", fecha.toString());
			datosAGuardar.put("precioFinal", String.valueOf(precioFinal));

			guardaDato.copiar(datosAGuardar);

			this.notificar(String.valueOf(precioFinal));

		} catch (GuardaDatoExceptions | BaseDeDatosExceptions | IOException | MesaExceptions e) {
			throw new VentasExceptions("Error al cargar registro");
		}
	}

	private void crearPedidoParaMesa(Set<Item> listaConsumisiones) {
		Pedido pedidoMesa = new Pedido(1, listaConsumisiones);

		mesa.nuevoPedido(pedidoMesa);
	}
}
