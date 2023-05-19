package modelo;

public class MonitorObserver implements Observer {

	private PantallaGerente pantalla;

	public MonitorObserver() {
		super();
		this.pantalla = new PantallaGerente();
		pantalla.setVisible(true);
	}

	@Override
	public void actualizar(String valor) {
		pantalla.actualizarValorMesa(valor);

	}

}
