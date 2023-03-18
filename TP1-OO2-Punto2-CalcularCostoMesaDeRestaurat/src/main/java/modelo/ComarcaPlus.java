package modelo;

public class ComarcaPlus extends Tarjeta {

	public ComarcaPlus() {
		super();
	}

	public float calcularCosto(Item item) {
		return item.pagarConComarcaPlus();
	}
}
