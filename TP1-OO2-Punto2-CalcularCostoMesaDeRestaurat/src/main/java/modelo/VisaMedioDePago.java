package modelo;

public class VisaMedioDePago implements MedioDePago {

	public VisaMedioDePago() {
		super();
	}

	@Override
	public void pagar() {

	}

	@Override
	public float calcularCosto(Item item) {
		return item.pagarConVisa();
	}
}
