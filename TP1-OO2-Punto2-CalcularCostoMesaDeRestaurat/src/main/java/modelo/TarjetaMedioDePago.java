package modelo;

public class TarjetaMedioDePago implements MedioDePago {

	public TarjetaMedioDePago() {
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
