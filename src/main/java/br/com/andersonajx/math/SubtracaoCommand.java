package br.com.andersonajx.math;

import java.math.BigInteger;

public final class SubtracaoCommand implements Command<BigInteger> {

	private final BigInteger primeiroValor;
	private final BigInteger segundoValor;

	public SubtracaoCommand(BigInteger primeiroValor, BigInteger segundoValor) {
		this.primeiroValor = primeiroValor;
		this.segundoValor = segundoValor;
	}

	@Override
	public BigInteger execute() {
		return primeiroValor.subtract(segundoValor);
	}

}
