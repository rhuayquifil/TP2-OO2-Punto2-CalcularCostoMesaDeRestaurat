package modelo;

public class Mastercard extends Tarjeta {

	public Mastercard() {
		super();
	}

	public float calcularCosto(Item item) {
		return item.pagarConMastercard();
	}
}
