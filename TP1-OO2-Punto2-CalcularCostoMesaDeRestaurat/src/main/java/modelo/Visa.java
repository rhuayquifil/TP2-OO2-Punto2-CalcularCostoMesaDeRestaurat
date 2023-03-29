package modelo;

public class Visa implements MedioDePago {

	public Visa() {
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
