package model;

import java.util.HashMap;
import java.util.Map;

public class Conversor {
	
	private Map<String, Double> tasaPeso = new HashMap<String, Double>();
	
	public Conversor() {
		this.inicializarTasaPeso();
	}
	
	private void inicializarTasaPeso() {
		this.tasaPeso.put("dolar", 195.30);
		this.tasaPeso.put("euro", 207.04);
		this.tasaPeso.put("libra esterlina", 234.81);
		this.tasaPeso.put("yen japones", 1.45);
		this.tasaPeso.put("won sul-coreano", 0.15);
	}
	
	public double convertirAPeso(String moneda, double valor) {
		double tasa = this.tasaPeso.get(moneda);
		return valor *tasa;
	}
	
	public double convertirA(String monedaInicial, String monedaFinal, double valor) {
		double valorEnPeso = this.convertirAPeso(monedaInicial, valor);
		double tasa = this.tasaPeso.get(monedaFinal);
		
		return Math.round((valorEnPeso/tasa)*10000.0)/10000.0;
	}

}
