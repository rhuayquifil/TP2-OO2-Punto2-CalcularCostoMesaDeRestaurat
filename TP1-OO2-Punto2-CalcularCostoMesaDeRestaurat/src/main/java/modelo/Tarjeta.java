package modelo;

public class Tarjeta {

	public Tarjeta() {

	}

	public float calcularCosto(Item item) {
		return item.pagarConTarjeta();
	}
}