package br.com.andersonajx.math;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertTrue;

public class SubtracaoCommandTest {

	@Test
	public void execute() {
		Command<BigInteger> subtracaoCommand1 = new SubtracaoCommand(BigInteger.TEN, BigInteger.ONE);

		assertTrue(subtracaoCommand1.execute().compareTo(new BigInteger("9")) == 0);

		Command<BigInteger> subtracaoCommand2 = new SubtracaoCommand(new BigInteger("100"), new BigInteger("5"));

		assertTrue(subtracaoCommand2.execute().compareTo(new BigInteger("95")) == 0);
	}

}
