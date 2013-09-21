package br.com.andersonajx.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class DivisaoCommand implements Command<BigDecimal> {

	private final BigDecimal primeiroValor;
	private final BigDecimal segundoValor;

	public DivisaoCommand(BigDecimal primeiroValor, BigDecimal segundoValor) {
		this.primeiroValor = primeiroValor;
		this.segundoValor = segundoValor;
	}

	@Override
	public BigDecimal execute() {
		return primeiroValor.divide(segundoValor, 2, RoundingMode.HALF_EVEN);
	}

}
