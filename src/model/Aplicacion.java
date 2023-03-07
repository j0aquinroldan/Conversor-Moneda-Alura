package model;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Aplicacion {

	private Conversor conversor;
	private String[] opciones = { "Peso", "Euro", "Dolar","Libra Esterlina", "Yen Japones", "Won Sul-Coreano" };
	private double monto;

	public Aplicacion() {
		
		this.conversor = new Conversor();
		launch();
	}

	public void launch() {
		
		
		try {
			 monto = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el monto", "Conversor de Moneda",
					JOptionPane.PLAIN_MESSAGE));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese un monto valido", "Conversor de Moneda", JOptionPane.ERROR_MESSAGE);
		}
		
		
		String getMonedaInicial = (String) JOptionPane.showInputDialog(null, "Seleccione la moneda ",
				"Conversor de Moneda", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[1]);

		String getMonedaFinal = (String) JOptionPane.showInputDialog(null, "Seleccione la moneda ",
				"Conversor de Moneda", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[1]);

		double montoFinal = this.conversor.convertirA(getMonedaInicial, getMonedaFinal, monto);
		
		JOptionPane.showConfirmDialog(null, monto + " " + getMonedaInicial + " (s/es) equivalen a " + montoFinal + " " + getMonedaFinal + " (s/es)", "Conversor de Moneda", JOptionPane.OK_OPTION, 0);
	}
	
	public void addMoneda(String moneda, double tasa) {
		opciones = Arrays.copyOf(opciones, opciones.length+1);
		opciones[opciones.length-1] = moneda;
		
	}
	
	public String[] getOpciones() {
		return this.opciones;
	}
}
