package modelo;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PantallaGerente extends JFrame {

	private JPanel contentPane;
	private JLabel lblValor;

	public PantallaGerente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblValorUltimaMesaFacturada = new JLabel("Valor Ultima Mesa Facturada");
		lblValorUltimaMesaFacturada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblValorUltimaMesaFacturada.setBounds(60, 60, 309, 25);
		contentPane.add(lblValorUltimaMesaFacturada);

		lblValor = new JLabel("...");
		lblValor.setHorizontalAlignment(SwingConstants.CENTER);
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblValor.setBounds(60, 114, 257, 31);
		contentPane.add(lblValor);
	}

	public void actualizarValorMesa(String valor) {
		lblValor.setForeground(null);
		if (Float.valueOf(valor) >= 300000) {
			lblValor.setForeground(Color.RED);
		}
		lblValor.setText(valor);
	}

}
