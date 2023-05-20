package modelo;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import exceptions.MesaExceptions;

public class Mesa {

	private int id;
	private Set<Pedido> listaPedido;

	public Mesa(int id) {
		super();
		this.id = id;
		this.listaPedido = new HashSet<Pedido>();
	}

	public void nuevoPedido(Pedido nuevoPedido) {
		this.listaPedido = new HashSet<Pedido>(); // esta esto aca porque la mesa trabaja con un solo pedido por ahora
		listaPedido.add(nuevoPedido);
	}

	public float calcularCostoDeMesa(MedioDePago medioDePago, int propina) throws IOException, MesaExceptions {

		float costoDeTodosLosPedidos = 0;

		for (Pedido pedido : listaPedido) {
			costoDeTodosLosPedidos += pedido.calcularCosto(medioDePago);
		}

		return (float) (costoDeTodosLosPedidos * (1.0 + Float.valueOf("0.0" + propina)));
	}
}
