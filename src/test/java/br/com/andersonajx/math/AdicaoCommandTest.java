package br.com.andersonajx.math;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertTrue;

public class AdicaoCommandTest {

	@Test
	public void execute() {
		Command<BigInteger> adicaoCommand1 = new AdicaoCommand(BigInteger.TEN, BigInteger.ONE);

		assertTrue(adicaoCommand1.execute().compareTo(new BigInteger("11")) == 0);

		Command<BigInteger> adicaoCommand2 = new AdicaoCommand(new BigInteger("52"), new BigInteger("87"));

		assertTrue(adicaoCommand2.execute().compareTo(new BigInteger("139")) == 0);
	}

}
