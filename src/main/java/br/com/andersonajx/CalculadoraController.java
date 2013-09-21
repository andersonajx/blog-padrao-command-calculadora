package br.com.andersonajx;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraController {

	public BigDecimal somar(BigDecimal valor1, BigDecimal valor2) {
		return valor1.add(valor2);
	}

	public BigDecimal subtrair(BigDecimal valor1, BigDecimal valor2) {
		return valor1.subtract(valor2);
	}

	public BigDecimal multiplicar(BigDecimal valor1, BigDecimal valor2) {
		return valor1.multiply(valor2);
	}

	public BigDecimal dividir(BigDecimal valor1, BigDecimal valor2) {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("teste");
		return valor1.divide(valor2, 2, RoundingMode.HALF_EVEN);
	}

}
