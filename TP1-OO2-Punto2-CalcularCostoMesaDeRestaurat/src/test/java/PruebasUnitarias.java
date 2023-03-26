class PruebasUnitarias {

//	@Test
//	void CalculoDeCostoConTarjetaVisa() {
//		Bebida cocaCola = new Bebida("Coca Cola", 400);
//		Plato milanesa = new Plato("Milanesa de Carne", 900);
//
//		Set<Item> listaConsumisionesPedido = new HashSet<Item>();
//		listaConsumisionesPedido.add(new Item(cocaCola, 2));
////		listaConsumisionesPedido.add(new Item(milanesa, 1));
//
//		Pedido miPedido = new Pedido(1, listaConsumisionesPedido);
//
//		Mesa miMesa = new Mesa(1);
//		miMesa.nuevoPedido(miPedido);
//
//		Visa miTarjeta = new Visa();
//
//		try {
//			assertEquals(814.8, miMesa.calcularCostoDeMesa(miTarjeta, 5), 0.001); // solo con bebidas
//
////			assertEquals(1759.8, miMesa.calcularCostoDeMesa(miTarjeta, 5));  // con bebidas y plato
//		} catch (NumberFormatException e) {
//			fail("exceptions NumberFormatException");
//		}
//	}

//	@Test
//	void CalculoDeCostoConTarjetaMastercard() {
//		Bebida cocaCola = new Bebida("Coca Cola", 400);
//		Plato milanesa = new Plato("Milanesa de Carne", 900);
//
//		Set<Item> listaConsumisionesPedido = new HashSet<Item>();
////		listaConsumisionesPedido.add(new Item(cocaCola, 2));
//		listaConsumisionesPedido.add(new Item(milanesa, 1));
//
//		Pedido miPedido = new Pedido(1, listaConsumisionesPedido);
//
//		Mesa miMesa = new Mesa(1);
//		miMesa.nuevoPedido(miPedido);
//
//		Mastercard miTarjeta = new Mastercard();
//
//		try {
//			assertEquals(908.46, miMesa.calcularCostoDeMesa(miTarjeta, 3), 0.001); // solo con plato
//
////			assertEquals(1732.46, miMesa.calcularCostoDeMesa(miTarjeta, 3)); // con bebidas y plato
//		} catch (NumberFormatException e) {
//			fail("exceptions NumberFormatException");
//		}
//	}

//	@Test
//	void CalculoDeCostoConTarjetaComarcaPlus() {
//		Bebida cocaCola = new Bebida("Coca Cola", 400);
//		Plato milanesa = new Plato("Milanesa de Carne", 900);
//
//		Set<Item> listaConsumisionesPedido = new HashSet<Item>();
//		listaConsumisionesPedido.add(new Item(cocaCola, 2));
//		listaConsumisionesPedido.add(new Item(milanesa, 1));
//
//		Pedido miPedido = new Pedido(1, listaConsumisionesPedido);
//
//		Mesa miMesa = new Mesa(1);
//		miMesa.nuevoPedido(miPedido);
//
//		ComarcaPlus miTarjeta = new ComarcaPlus();
//
//		try {
//			assertEquals(1699.32, miMesa.calcularCostoDeMesa(miTarjeta, 2), 0.001); // con bebidas y plato
//		} catch (NumberFormatException e) {
//			fail("exceptions NumberFormatException");
//		}
//	}

//	@Test
//	void CalculoDeCostoConTarjetaViedma() {
//		Bebida cocaCola = new Bebida("Coca Cola", 400);
//		Plato milanesa = new Plato("Milanesa de Carne", 900);
//
//		Set<Item> listaConsumisionesPedido = new HashSet<Item>();
//		listaConsumisionesPedido.add(new Item(cocaCola, 2));
//		listaConsumisionesPedido.add(new Item(milanesa, 1));
//
//		Pedido miPedido = new Pedido(1, listaConsumisionesPedido);
//
//		Mesa miMesa = new Mesa(1);
//		miMesa.nuevoPedido(miPedido);
//
//		Tarjeta miTarjeta = new Tarjeta();
//
//		try {
//			assertEquals(1785, miMesa.calcularCostoDeMesa(miTarjeta, 5)); // con bebidas y plato
//		} catch (NumberFormatException e) {
//			fail("exceptions NumberFormatException");
//		}
//	}

}
