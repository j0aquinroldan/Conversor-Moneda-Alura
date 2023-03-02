package model;

import javax.swing.JOptionPane;

public class Aplicacion {

	private Conversor conversor;

	public Aplicacion() {
		
		this.conversor = new Conversor();
		launch();
	}

	public void launch() {
		double monto = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el monto", "Conversor de Moneda",
				JOptionPane.PLAIN_MESSAGE));

		String[] opciones = { "Peso", "Euro", "Dolar","Libra Esterlina", "Yen Japones", "Won Sul-Coreano" };
		String getMonedaInicial = (String) JOptionPane.showInputDialog(null, "Seleccione la moneda ",
				"Conversor de Moneda", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[1]);

		String getMonedaFinal = (String) JOptionPane.showInputDialog(null, "Seleccione la moneda ",
				"Conversor de Moneda", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[1]);

		double montoFinal = this.conversor.convertirA(getMonedaInicial, getMonedaFinal, monto);
		
		JOptionPane.showConfirmDialog(null, monto + " " + getMonedaInicial + " (s/es) equivalen a " + montoFinal + " " + getMonedaFinal + " (s/es)", "Conversor de Moneda", JOptionPane.OK_OPTION, 0);
	}
}
