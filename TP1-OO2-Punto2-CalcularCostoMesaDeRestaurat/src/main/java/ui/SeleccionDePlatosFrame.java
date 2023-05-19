package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import exceptions.MesaExceptions;
import modelo.ComarcaPlusMedioDePago;
import modelo.Consumicion;
import modelo.Item;
import modelo.JTextFieldTableCellEditor;
import modelo.MastercardMedioDePago;
import modelo.MedioDePago;
import modelo.Mesa;
import modelo.Pedido;
import modelo.TarjetaMedioDePago;
import modelo.VisaMedioDePago;

public class SeleccionDePlatosFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;
	private List<Consumicion> platosYBebidas;
	private Mesa mesa;
	private JRadioButton rdbtnPagarConVisa;
	private JRadioButton rdbtnPagarConMastercard;
	private JRadioButton rdbtnPagarConComarcaPlus;
	private JRadioButton rdbtnPagarConOtraTarjeta;
	private JRadioButton rdbtnPropina2Porciento;
	private JRadioButton rdbtnPropina3Porciento;
	private JRadioButton rdbtnPropina5Porciento;

	public SeleccionDePlatosFrame(List<Consumicion> platosYBebidas, Mesa mesa) {

		this.platosYBebidas = platosYBebidas;
		this.mesa = mesa;

		setTitle("Seleccion De Platos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		iniciarComponentes();

	}

	private void iniciarComponentes() {

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 353, 219);
		contentPane.add(scrollPane);

		table = new JTable();

		modelo = new DefaultTableModel();

//		modelo.addColumn("Seleccion");
		modelo.addColumn("Consumicion");
		modelo.addColumn("Precio");
		modelo.addColumn("Cantidad");

		table.setModel(modelo);

		// añado check box a la tabla
//		addCheckBox(0, table);

		addJTextField();

		actualizarTabla(scrollPane);

		scrollPane.setViewportView(table);

		JButton btnPagarTotal = new JButton("Pagar Total");
		btnPagarTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Set<Item> listaConsumisiones = new HashSet<Item>();

				for (int i = 0; i < table.getRowCount(); i++) {
					if (validations(i)) {
						listaConsumisiones
								.add(new Item(platosYBebidas.get(i), Integer.valueOf((String) table.getValueAt(i, 2))));
					}
				}

				if (listaConsumisiones.size() != 0) {
					crearPedidoParaMesa(listaConsumisiones);
					calcularCostoMesa();
				}
				actualizarTabla(scrollPane);
			}

			private void calcularCostoMesa() {
				try {
					float costoMesa = mesa.calcularCostoDeMesa(medioDePagoSeleccionado(), propina());
				} catch (IOException | MesaExceptions e1) {
					JOptionPane.showMessageDialog(null, "Error al calcular el costo de la mesa.");
				}
			}

			private void crearPedidoParaMesa(Set<Item> listaConsumisiones) {
				Pedido pedidoMesa = new Pedido(1, listaConsumisiones);

				mesa.nuevoPedido(pedidoMesa);
			}

			private boolean validations(int i) {
				if (table.getValueAt(i, 2) == null) {
					return false;
				}
				if (table.getValueAt(i, 2).equals("")) {
					return false;
				}
				return true;
			}

			private int propina() {
				if (rdbtnPropina2Porciento.isSelected()) {
					return 2;
				}
				if (rdbtnPropina3Porciento.isSelected()) {
					return 3;
				}
				if (rdbtnPropina5Porciento.isSelected()) {
					return 5;
				}
				throw new RuntimeException();
			}

			private MedioDePago medioDePagoSeleccionado() {
				if (rdbtnPagarConVisa.isSelected()) {
					return new VisaMedioDePago();
				}
				if (rdbtnPagarConMastercard.isSelected()) {
					return new MastercardMedioDePago();
				}
				if (rdbtnPagarConComarcaPlus.isSelected()) {
					return new ComarcaPlusMedioDePago();
				}
				if (rdbtnPagarConOtraTarjeta.isSelected()) {
					return new TarjetaMedioDePago();
				}
				throw new RuntimeException();
			}
		});
		btnPagarTotal.setBounds(80, 295, 180, 25);
		contentPane.add(btnPagarTotal);

		rdbtnPagarConVisa = new JRadioButton("Visa");
		rdbtnPagarConVisa.setSelected(true);
		rdbtnPagarConVisa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnPagarConVisa.isSelected()) {
					rdbtnPagarConMastercard.setSelected(false);
					rdbtnPagarConComarcaPlus.setSelected(false);
					rdbtnPagarConOtraTarjeta.setSelected(false);
				}

			}
		});
		rdbtnPagarConVisa.setBounds(10, 230, 68, 23);
		contentPane.add(rdbtnPagarConVisa);

		rdbtnPagarConMastercard = new JRadioButton("Mastercard");
		rdbtnPagarConMastercard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnPagarConMastercard.isSelected()) {
					rdbtnPagarConVisa.setSelected(false);
					rdbtnPagarConComarcaPlus.setSelected(false);
					rdbtnPagarConOtraTarjeta.setSelected(false);
				}

			}
		});
		rdbtnPagarConMastercard.setBounds(80, 230, 96, 23);
		contentPane.add(rdbtnPagarConMastercard);

		rdbtnPagarConComarcaPlus = new JRadioButton("Comarca Plus");
		rdbtnPagarConComarcaPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnPagarConComarcaPlus.isSelected()) {
					rdbtnPagarConVisa.setSelected(false);
					rdbtnPagarConMastercard.setSelected(false);
					rdbtnPagarConOtraTarjeta.setSelected(false);
				}

			}
		});
		rdbtnPagarConComarcaPlus.setBounds(175, 230, 109, 23);
		contentPane.add(rdbtnPagarConComarcaPlus);

		rdbtnPagarConOtraTarjeta = new JRadioButton("Otra");
		rdbtnPagarConOtraTarjeta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnPagarConOtraTarjeta.isSelected()) {
					rdbtnPagarConVisa.setSelected(false);
					rdbtnPagarConMastercard.setSelected(false);
					rdbtnPagarConComarcaPlus.setSelected(false);
				}

			}
		});
		rdbtnPagarConOtraTarjeta.setBounds(280, 230, 73, 23);
		contentPane.add(rdbtnPagarConOtraTarjeta);

		JLabel lblPropina = new JLabel("Propina:");
		lblPropina.setBounds(60, 265, 60, 14);
		contentPane.add(lblPropina);

		rdbtnPropina2Porciento = new JRadioButton("2%");
		rdbtnPropina2Porciento.setSelected(true);
		rdbtnPropina2Porciento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnPropina2Porciento.isSelected()) {
					rdbtnPropina3Porciento.setSelected(false);
					rdbtnPropina5Porciento.setSelected(false);
				}

			}
		});
		rdbtnPropina2Porciento.setBounds(124, 260, 52, 23);
		contentPane.add(rdbtnPropina2Porciento);

		rdbtnPropina3Porciento = new JRadioButton("3%");
		rdbtnPropina3Porciento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnPropina3Porciento.isSelected()) {
					rdbtnPropina2Porciento.setSelected(false);
					rdbtnPropina5Porciento.setSelected(false);
				}

			}
		});
		rdbtnPropina3Porciento.setBounds(178, 260, 52, 23);
		contentPane.add(rdbtnPropina3Porciento);

		rdbtnPropina5Porciento = new JRadioButton("5%");
		rdbtnPropina5Porciento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnPropina5Porciento.isSelected()) {
					rdbtnPropina2Porciento.setSelected(false);
					rdbtnPropina3Porciento.setSelected(false);
				}

			}
		});
		rdbtnPropina5Porciento.setBounds(232, 260, 52, 23);
		contentPane.add(rdbtnPropina5Porciento);
	}

	private void addJTextField() {
		// un jtextlfield a la tabla
		JTextFieldTableCellEditor editor = new JTextFieldTableCellEditor();

		TableColumn column = table.getColumnModel().getColumn(2);
		column.setCellEditor(editor);
	}

	private void actualizarTabla(JScrollPane scrollPane) {

		limpiarTabla(table);

		Object[] fila = new Object[3];

		for (Consumicion consumicion : platosYBebidas) {
			fila[0] = consumicion.nombre();
			fila[1] = consumicion.precio();
			modelo.addRow(fila);
		}
		table.setModel(modelo);
		scrollPane.setViewportView(table);
	}

	private void limpiarTabla(JTable tabla) {
		try {
			DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
			int filas = tabla.getRowCount();
			for (int i = 0; filas > i; i++) {
				modelo.removeRow(0);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
		}
	}
}
