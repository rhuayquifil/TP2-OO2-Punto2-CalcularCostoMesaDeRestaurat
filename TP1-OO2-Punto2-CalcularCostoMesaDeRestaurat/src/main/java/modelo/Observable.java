package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

	private List<Observer> listaSubscriptores;

	public Observable() {
		super();
		this.listaSubscriptores = new ArrayList<Observer>();
	}

	public void subscribir(Observer subscriptor) {
		this.listaSubscriptores.add(subscriptor);
	}

	protected void notificar(String valor) {
		for (Observer subscriptor : listaSubscriptores) {
			subscriptor.actualizar(valor);
		}
	}
}
