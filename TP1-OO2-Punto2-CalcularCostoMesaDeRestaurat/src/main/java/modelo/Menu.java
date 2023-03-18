package modelo;

import java.util.Set;

public class Menu {

	private String nombre;
	private Set<Consumicion> listaItemsMenu;

	public Menu(String nombre, Set<Consumicion> listaItemsMenu) {
		super();
		this.nombre = nombre;
		this.listaItemsMenu = listaItemsMenu;
	}

	@Override
	public String toString() {
		return "Menu [nombre=" + nombre + ", listaItemsMenu=" + listaItemsMenu + "]";
	}
}
