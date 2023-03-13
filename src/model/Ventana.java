package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class Ventana extends JFrame implements ActionListener {

	private JPanel contentPane;
	JComboBox<String> moneda1;
	JComboBox<String> moneda2;
	JLabel lblMoneda1;
	JLabel lblMoneda2;
	JLabel lblMonto;
	JTextField monto;
	JButton btnConvertir;

	JLabel valorFinal;

	private Conversor conversor;

	String monedaInicial;
	String monedaFinal;

	

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setTitle("Conversor de moneda");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		conversor = new Conversor();

		String monedas[] = new String[] { "Peso", "Euro", "Dolar", "Libra Esterlina", "Yen Japones",
				"Won Sul-Coreano" };

		this.getRootPane().setDefaultButton(btnConvertir);

		lblMoneda1 = new JLabel();
		lblMoneda1.setBounds(29, 80, 138, 20);
		lblMoneda1.setText("Ingrese moneda inicial:");

		moneda1 = new JComboBox<String>();
		lblMoneda1.setLabelFor(moneda1);
		moneda1.setBounds(29, 104, 123, 20);
		moneda1.setModel(new DefaultComboBoxModel<>(monedas));
		moneda1.addActionListener(this);

		lblMoneda2 = new JLabel();
		lblMoneda2.setBounds(281, 80, 123, 20);
		lblMoneda2.setText("Ingrese moneda final:");

		moneda2 = new JComboBox<String>();
		lblMoneda2.setLabelFor(moneda2);
		moneda2.setBounds(281, 104, 123, 20);
		moneda2.setModel(new DefaultComboBoxModel<>(monedas));
		moneda2.addActionListener(this);

		lblMonto = new JLabel();
		lblMonto.setBounds(140, 28, 178, 20);
		lblMonto.setText("Ingrese el monto a convertir");

		monto = new JTextField();
		monto.setBackground(new Color(255, 255, 255));
		lblMonto.setLabelFor(monto);
		monto.setBounds(150, 49, 138, 20);
		monto.setAlignmentX(CENTER_ALIGNMENT);

		btnConvertir = new JButton("CONVERTIR");
		btnConvertir.setBounds(140, 150, 150, 30);
		btnConvertir.setAlignmentX(CENTER_ALIGNMENT);
		btnConvertir.addActionListener(this);

		monedaInicial = moneda1.getSelectedItem().toString();
		monedaFinal = moneda2.getSelectedItem().toString();

		valorFinal = new JLabel();
		valorFinal.setForeground(new Color(255, 0, 0));
		valorFinal.setFont(new Font("Tahoma", Font.BOLD, 12));
		valorFinal.setBounds(29, 191, 375, 39);
		valorFinal.setAlignmentX(CENTER_ALIGNMENT);

		getContentPane().add(moneda1);
		getContentPane().add(moneda2);
		getContentPane().add(lblMoneda1);
		getContentPane().add(lblMoneda2);
		getContentPane().add(lblMonto);
		getContentPane().add(monto);
		getContentPane().add(valorFinal);
		getContentPane().add(btnConvertir);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == moneda1) {
			monedaInicial = moneda1.getSelectedItem().toString();
		}
		if (e.getSource() == moneda2) {
			monedaFinal = moneda2.getSelectedItem().toString();
		}

		if (e.getSource() == btnConvertir) {
			if (monto.getText().equals("")) {
				valorFinal.setText("INGRESE UN MONTO!");
			} else {
				double montoInicial = Double.parseDouble(monto.getText());
				double montoConvertido = this.conversor.convertirA(monedaInicial, monedaFinal, montoInicial);
				valorFinal.setForeground(new Color(0, 0, 0));
				valorFinal.setText("El monto equivale a " + montoConvertido + " " + monedaFinal);
			}
		}
	}

}
