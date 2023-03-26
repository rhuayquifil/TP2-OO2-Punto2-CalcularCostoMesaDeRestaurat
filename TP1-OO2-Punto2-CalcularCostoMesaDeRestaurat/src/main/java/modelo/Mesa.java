package modelo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Mesa {

	private int id;
	private Set<Pedido> listaPedido;
	private GuardaDato copiador;

	public Mesa(int id, GuardaDato copiador) {
		super();
		this.id = id;
		this.listaPedido = new HashSet<Pedido>();
		this.copiador = copiador;
	}

	public void nuevoPedido(Pedido nuevoPedido) {
		listaPedido.add(nuevoPedido);
	}

	@Override
	public String toString() {
		return "Mesa [id=" + id + ", listaPedido=" + listaPedido + "]";
	}

	public float calcularCostoDeMesa(Tarjeta tarjeta, int propina) throws IOException {
		float costoDeTodosLosPedidos = 0;

		for (Pedido pedido : listaPedido) {

			costoDeTodosLosPedidos += pedido.calcularCosto(tarjeta);
		}

		copiador.copiar(LocalDateTime.now() + " || " + (costoDeTodosLosPedidos * (1.0 + Float.valueOf("0.0" + propina)))
				+ '\n');

		return (float) (costoDeTodosLosPedidos * (1.0 + Float.valueOf("0.0" + propina)));
//		return costoDeTodosLosPedidos;
	}
}
