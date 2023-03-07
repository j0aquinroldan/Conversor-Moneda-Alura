package model;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame implements ActionListener{

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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		conversor = new Conversor();
		String monedas[] = new String[]{"Peso", "Euro","Dolar", "Libra Esterlina", "Yen Japones","Won Sul-Coreano"};
		lblMoneda1 = new JLabel();
		lblMoneda2 = new JLabel();
		lblMonto = new JLabel();
		monto = new JTextField();
		btnConvertir =new JButton();
		
		valorFinal = new JLabel();
		
		lblMonto.setBounds(29,30,180,20);
		lblMonto.setText("ingrese el monto a convertir");
		monto.setBounds(29,50, 100,20);
		
		lblMoneda1.setBounds(200,10,180,20);
		lblMoneda1.setText("ingrese moneda inicial:");
		
		lblMoneda2.setBounds(200,60,180,20);
		lblMoneda2.setText("ingrese moneda final:");
		
		btnConvertir.setBounds(130,130,150,30);
		btnConvertir.setText("Convertir");
		btnConvertir.addActionListener(this);
		
		valorFinal.setBounds(200,190,180,20);
		//valorFinal.setText("valor");
		
		moneda1 = new JComboBox<String>();
		moneda1.setBounds(200,35,90,20);
		moneda1.setModel(new DefaultComboBoxModel<>(monedas) );
		moneda1.addActionListener(this);
		
		moneda2 = new JComboBox<String>();
		moneda2.setBounds(200,80,90,20);
		moneda2.setModel(new DefaultComboBoxModel<>(monedas) );
		moneda2.addActionListener(this);
		
		
		
		add(moneda1);
		add(moneda2);
		add(lblMoneda1);
		add(lblMoneda2);
		add(lblMonto);
		add(monto);
		add(valorFinal);
		add(btnConvertir);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==moneda1) {
			monedaInicial  = moneda1.getSelectedItem().toString();
		}
		if (e.getSource()==moneda2) {
			monedaFinal  = moneda2.getSelectedItem().toString();
		}
		
		if (e.getSource()==btnConvertir) {
			double montoInicial = Double.parseDouble(monto.getText());
			double montoConvertido = this.conversor.convertirA(monedaInicial, monedaFinal, montoInicial);
			valorFinal.setText("El valor es " + montoConvertido);
		}
	}

}
