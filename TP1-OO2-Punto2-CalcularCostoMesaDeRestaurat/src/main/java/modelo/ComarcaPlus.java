package modelo;

public class ComarcaPlus implements MedioDePago {

	public ComarcaPlus() {
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
