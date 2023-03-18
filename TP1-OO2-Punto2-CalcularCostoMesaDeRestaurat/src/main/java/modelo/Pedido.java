package modelo;

import java.util.Set;

public class Pedido {
	private int id;
	private Set<Item> listaPedido;
	private boolean pedidoPago;

	public Pedido(int id, Set<Item> listaPedido) {
		super();
		this.id = id;
		this.listaPedido = listaPedido;
		this.pedidoPago = false;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", listaPedido=" + listaPedido + ", pedidoPago=" + pedidoPago + "]";
	}

	public float calcularCosto(Tarjeta tarjeta) {
		float costoPedido = 0;
		for (Item item : listaPedido) {
//			costoPedido += item.calcularCosto(tarjeta);
			costoPedido += tarjeta.calcularCosto(item);
		}
		return costoPedido;
	}
}
