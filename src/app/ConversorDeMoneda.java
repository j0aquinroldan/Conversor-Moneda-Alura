package app;

import model.Conversor;

public class ConversorDeMoneda {
	
	public static void main(String[] args) {
		
		Conversor conversor = new Conversor();
		
		double valorDolar = conversor.convertirAPeso("dolar", 1);
		double valorYen = conversor.convertirAPeso("yen japones", 1);
		double valorEuro = conversor.convertirAPeso("euro", 1);
		double valorWon = conversor.convertirAPeso("won sul-coreano", 1);
		double valorLibra = conversor.convertirAPeso("libra esterlina", 1);
		
		System.out.println("1 dolar equivale a " + valorDolar + " pesos");
		System.out.println("1 yen japones equivale a " + valorYen + " pesos");
		System.out.println("1 euro equivale a " + valorEuro + " pesos");
		System.out.println("1 won sul-coreano equivale a " + valorWon + " pesos");
		System.out.println("1 libra equivale a " + valorLibra + " pesos");
		
		double libraADolar = conversor.convertirA("dolar", "libra esterlina", 1);
		System.out.println("1 dolar equivale a " + libraADolar + " libras");
		
		double dolarAEuro = conversor.convertirA("dolar", "euro", 1);
		System.out.println("1 dolar equivale a " + dolarAEuro + " euros");
		
		double YenALibra = conversor.convertirA("yen japones", "libra esterlina", 1);
		System.out.println("1 yen japones equivale a " + YenALibra + " libras");
	}

}
