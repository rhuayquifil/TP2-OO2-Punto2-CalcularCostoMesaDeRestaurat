package test;

import modelo.Observer;

public class FakeMonitorObserver implements Observer {

	private String resultado;

	public FakeMonitorObserver() {
		super();
		this.resultado = "";
	}

	@Override
	public void actualizar(String valor) {
		this.resultado = valor;
	}

	String resultado() {
		return this.resultado;
	}
}
