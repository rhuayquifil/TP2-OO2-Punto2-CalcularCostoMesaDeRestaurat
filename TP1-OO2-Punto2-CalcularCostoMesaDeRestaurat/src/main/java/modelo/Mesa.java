package modelo;

import java.util.HashSet;
import java.util.Set;

public class Mesa {

	private int id;
	private int cantidadConmensales;
	private Set<Pedido> listaPedido;
	private boolean mesaPagada;

	public Mesa(int id) {
		super();
		this.id = id;
		this.cantidadConmensales = 4;
		this.listaPedido = new HashSet<Pedido>();
		this.mesaPagada = false;
	}

	public void nuevoPedido(Pedido nuevoPedido) {
		listaPedido.add(nuevoPedido);
	}

	@Override
	public String toString() {
		return "Mesa [id=" + id + ", cantidadConmensales=" + cantidadConmensales + ", listaPedido=" + listaPedido
				+ ", mesaPagada=" + mesaPagada + "]";
	}

	public float calcularCostoDeMesa(Tarjeta tarjeta, int propina) {
		float costoDeTodosLosPedidos = 0;

		for (Pedido pedido : listaPedido) {

			costoDeTodosLosPedidos += pedido.calcularCosto(tarjeta);
		}

		return (float) (costoDeTodosLosPedidos * (1.0 + Float.valueOf("0.0" + propina)));
//		return costoDeTodosLosPedidos;
	}
}
