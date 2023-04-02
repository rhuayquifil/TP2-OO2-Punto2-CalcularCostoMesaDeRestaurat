package modelo;

public class MastercardMedioDePago implements MedioDePago {

	public MastercardMedioDePago() {
		super();
	}

	@Override
	public float calcularCosto(Item item) {
		return item.pagarConMastercard();
	}

	@Override
	public void pagar() {

	}
}
