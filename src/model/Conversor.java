package model;

import java.util.HashMap;
import java.util.Map;

public class Conversor {
	
	private Map<String, Double> tasaPeso = new HashMap<String, Double>();
	
	public Conversor() {
		this.inicializarTasaPeso();
	}
	
	private void inicializarTasaPeso() {
		this.tasaPeso.put("Peso", 1d);
		this.tasaPeso.put("Dolar", 195.30);
		this.tasaPeso.put("Euro", 207.04);
		this.tasaPeso.put("Libra Esterlina", 234.81);
		this.tasaPeso.put("Yen Japones", 1.45);
		this.tasaPeso.put("Won Sul-Coreano", 0.15);
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
