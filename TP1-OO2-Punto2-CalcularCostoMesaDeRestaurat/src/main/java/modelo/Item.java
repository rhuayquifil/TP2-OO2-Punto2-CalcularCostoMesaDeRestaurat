package modelo;

public class Item {

	private Consumicion consumision;
	private int cantidad;

	public Item(Consumicion consumision, int cantidad) {
		super();
		this.consumision = consumision;
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Item [consumision=" + consumision + ", cantidad=" + cantidad + "]";
	}

	public float pagarConVisa() {
		return consumision.pagarConTarjetaVisa(cantidad);
	}

	public float pagarConMastercard() {
		return consumision.pagarConTarjetaMastercard(cantidad);
	}

	public float pagarConComarcaPlus() {
		return consumision.pagarConTarjetaComarcaPlus(cantidad);
	}

	public float pagarConTarjeta() {
		return consumision.pagarConTarjeta(cantidad);
	}
}
