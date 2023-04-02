package modelo;

public class PlatoConsumicion extends Consumicion implements MetodosDePago {

	private String nombre;
	private float precio;

	public PlatoConsumicion(String nombre, float precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Plato [nombre=" + nombre + ", precio=" + precio + "]";
	}

	public float pagarConTarjetaVisa(int cantidad) {
		return this.precio * cantidad;
	}

	public float pagarConTarjetaMastercard(int cantidad) {
		return (float) ((this.precio * cantidad) * (1.0 - 0.02));
	}

	public float pagarConTarjetaComarcaPlus(int cantidad) {
		return (float) ((this.precio * cantidad) * (1.0 - 0.02));
	}

	public float pagarConTarjeta(int cantidad) {
		return this.precio * cantidad;
	}
}
