package br.com.andersonajx.math;

import java.math.BigInteger;

public final class MultiplicacaoCommand implements Command<BigInteger> {

	private final BigInteger primeiroValor;
	private final BigInteger segundoValor;

	public MultiplicacaoCommand(BigInteger primeiroValor, BigInteger segundoValor) {
		this.primeiroValor = primeiroValor;
		this.segundoValor = segundoValor;
	}

	@Override
	public BigInteger execute() {
		return primeiroValor.multiply(segundoValor);
	}

}
