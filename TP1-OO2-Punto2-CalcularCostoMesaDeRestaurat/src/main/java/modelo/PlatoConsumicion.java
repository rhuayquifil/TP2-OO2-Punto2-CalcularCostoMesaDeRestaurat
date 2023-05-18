package modelo;

public class PlatoConsumicion extends Consumicion implements MetodosDePago {

	public PlatoConsumicion(String nombre, float precio) {
		super(nombre, precio);
	}

	@Override
	public String toString() {
		return "Plato [nombre=" + super.nombre() + ", precio=" + super.precio() + "]";
	}

	public float pagarConTarjetaVisa(int cantidad) {
		return super.precio() * cantidad;
	}

	public float pagarConTarjetaMastercard(int cantidad) {
		return (float) ((super.precio() * cantidad) * (1.0 - 0.02));
	}

	public float pagarConTarjetaComarcaPlus(int cantidad) {
		return (float) ((super.precio() * cantidad) * (1.0 - 0.02));
	}

	public float pagarConTarjeta(int cantidad) {
		return super.precio() * cantidad;
	}
}
