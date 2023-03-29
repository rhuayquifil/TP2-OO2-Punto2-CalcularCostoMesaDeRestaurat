package modelo;

public class Mastercard implements MedioDePago {

	public Mastercard() {
		super();
	}

	@Override
	public float calcularCosto(Item item) {
		return item.pagarConMastercard();
	}

	@Override
	public void pagar() {

	}
}
