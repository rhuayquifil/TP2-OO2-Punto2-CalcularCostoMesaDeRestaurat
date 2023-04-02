package modelo;

public class ComarcaPlusMedioDePago implements MedioDePago {

	public ComarcaPlusMedioDePago() {
		super();
	}

	@Override
	public float calcularCosto(Item item) {
		return item.pagarConComarcaPlus();
	}

	@Override
	public void pagar() {
		// TODO Auto-generated method stub

	}
}
