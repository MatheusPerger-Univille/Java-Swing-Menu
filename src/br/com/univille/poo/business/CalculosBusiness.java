package br.com.univille.poo.business;

public class CalculosBusiness {

	private static final Double REAL = 1.00;
	private static final Double DOLAR = 3.99;
	private static final Double EURO = 4.47;
	private static final Double METRO = 1000.00;
	private static final Double MILIMETRO = 1000.00;
	private static final Double CELCIUS = 273.15;
	private static final Double KELVIN = 273.15;
	
	public String calculoMoeda(String moedaDe, String moedaPara, String valorDe) {
		
		Double result = 0.0;
		
		Double valorUser = Double.parseDouble(valorDe);
		
		if(moedaPara == "Real")
			result = valorUser * REAL;
		else if(moedaPara == "Dólar")
			result = valorUser * DOLAR;
		else if(moedaPara == "Euro")
			result = valorUser * EURO;
		
		return result.toString();
	}
	
	public String calculoComprimento(String comprimentoDe, String comprimentoPara, String valorDe) {
		
		Double result = 0.0;
		
		Double valorUser = Double.parseDouble(valorDe);
		
		if(comprimentoPara == "Metro")
			result = valorUser / METRO;
		else if(comprimentoPara == "Milimetro")
			result = valorUser * MILIMETRO;
		
		return result.toString();
	}
	
	public String calculoTemperatura(String temperaturaDe, String temperaturaPara, String valorDe) {
		
		Double result = 0.0;
		
		Double valorUser = Double.parseDouble(valorDe);
		
		if(temperaturaPara == "Celsius")
			result = valorUser - CELCIUS;
		else if(temperaturaPara == "Kelvin")
			result = valorUser + KELVIN;
		
		return result.toString();
	}
}
