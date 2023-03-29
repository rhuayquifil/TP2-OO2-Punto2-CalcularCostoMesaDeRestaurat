package modelo;

public interface MedioDePago {

	void pagar();

	float calcularCosto(Item item);

}
