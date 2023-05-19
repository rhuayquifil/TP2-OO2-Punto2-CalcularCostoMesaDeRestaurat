package modelo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import exceptions.BaseDeDatosExceptions;
import exceptions.GuardaDatoExceptions;
import exceptions.MesaExceptions;

public class Mesa extends Observable {

	private int id;
	private Set<Pedido> listaPedido;
	private GuardaDato guardaDato;

	public Mesa(int id, GuardaDato guardaDato, List<Observer> subscriptores) {
		super();
		this.id = id;
		this.listaPedido = new HashSet<Pedido>();
		this.guardaDato = guardaDato;

		for (Observer observer : subscriptores) {
			this.subscribir(observer);
		}
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

		float preciofinal = (float) (costoDeTodosLosPedidos * (1.0 + Float.valueOf("0.0" + propina)));

		try {

			guardaDato.copiar(LocalDateTime.now().toString() + " | " + preciofinal);
			this.notificar(String.valueOf(preciofinal));

		} catch (GuardaDatoExceptions | BaseDeDatosExceptions e) {
			throw new MesaExceptions("Error al cargar registro");
		}

		return preciofinal;
//		return costoDeTodosLosPedidos;
	}
}
