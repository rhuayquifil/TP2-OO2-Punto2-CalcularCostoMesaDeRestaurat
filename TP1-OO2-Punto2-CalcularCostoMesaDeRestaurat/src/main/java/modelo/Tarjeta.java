package modelo;

public class Tarjeta implements MedioDePago {

	public Tarjeta() {
		super();
	}

	@Override
	public void pagar() {

	}

	@Override
	public float calcularCosto(Item item) {
		return item.pagarConTarjeta();
	}

}
