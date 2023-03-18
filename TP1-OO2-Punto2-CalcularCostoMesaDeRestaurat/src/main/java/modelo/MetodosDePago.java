package modelo;

public interface MetodosDePago {

	float pagarConTarjetaVisa(int cantidad);

	float pagarConTarjetaMastercard(int cantidad);

	float pagarConTarjetaComarcaPlus(int cantidad);

	float pagarConTarjeta(int cantidad);
}
