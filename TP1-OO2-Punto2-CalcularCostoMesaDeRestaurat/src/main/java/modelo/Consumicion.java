package modelo;

public abstract class Consumicion implements MetodosDePago {

	private String nombre;
	private float precio;

	public Consumicion(String nombre, float precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	public String nombre() {
		return nombre;
	}

	public float precio() {
		return precio;
	}
}
