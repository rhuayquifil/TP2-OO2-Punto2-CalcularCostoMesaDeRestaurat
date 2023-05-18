package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import modelo.Consumicion;
import modelo.Observable;

public class SeleccionDePlatosFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;
	private List<Consumicion> platosYBebidas;
	private Observable venta;

	public SeleccionDePlatosFrame(List<Consumicion> platosYBebidas, Observable venta) {

		this.platosYBebidas = platosYBebidas;
		this.venta = venta;

		setTitle("Seleccion De Platos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		iniciarComponentes();

	}

	private void iniciarComponentes() {

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 219);
		contentPane.add(scrollPane);

		table = new JTable();

		modelo = new DefaultTableModel();

		modelo.addColumn("Seleccion");
		modelo.addColumn("Consumicion");
		modelo.addColumn("Precio");

		table.setModel(modelo);
		addCheckBox(0, table);
		actualizarTabla(scrollPane);

		scrollPane.setViewportView(table);

		JButton btnPagarTotal = new JButton("Pagar Total");
		btnPagarTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// TENES QUE ARMAR EL PEDIDO, PASARSELO A VENTA Y CALCULAR EL PRECIO
//				venta.
			}
		});
		btnPagarTotal.setBounds(125, 227, 180, 25);
		contentPane.add(btnPagarTotal);
	}

	private void actualizarTabla(JScrollPane scrollPane) {

		limpiarTabla(table);

		Object[] fila = new Object[3];

		for (Consumicion consumicion : platosYBebidas) {
			fila[1] = consumicion.nombre();
			fila[2] = consumicion.precio();
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

	private void addCheckBox(int columna, JTable table) {
		TableColumn tableColumn = table.getColumnModel().getColumn(columna);
		tableColumn.setCellEditor(table.getDefaultEditor(Boolean.class));
		tableColumn.setCellRenderer(table.getDefaultRenderer(Boolean.class));
	}
}
