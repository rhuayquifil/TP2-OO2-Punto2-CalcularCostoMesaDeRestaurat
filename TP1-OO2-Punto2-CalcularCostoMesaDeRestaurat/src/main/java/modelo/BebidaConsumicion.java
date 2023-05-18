package modelo;

public class BebidaConsumicion extends Consumicion implements MetodosDePago {

	public BebidaConsumicion(String nombre, float precio) {
		super(nombre, precio);
	}

	@Override
	public String toString() {
		return "Bebida [nombre=" + super.nombre() + ", precio=" + super.precio() + "]";
	}

	public float pagarConTarjetaVisa(int cantidad) {
		return (float) ((super.precio() * cantidad) * (1.0 - 0.03));
	}

	public float pagarConTarjetaMastercard(int cantidad) {
		return super.precio() * cantidad;
	}

	public float pagarConTarjetaComarcaPlus(int cantidad) {
		return (float) ((super.precio() * cantidad) * (1.0 - 0.02));
	}

	public float pagarConTarjeta(int cantidad) {
		return super.precio() * cantidad;
	}
}
