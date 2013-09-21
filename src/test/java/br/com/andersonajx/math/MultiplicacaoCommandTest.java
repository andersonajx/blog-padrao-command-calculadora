package br.com.andersonajx.math;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertTrue;

public class MultiplicacaoCommandTest {

	@Test
	public void execute() {
		Command<BigInteger> multiplicacaoCommand1 = new MultiplicacaoCommand(BigInteger.TEN, BigInteger.TEN);

		assertTrue(multiplicacaoCommand1.execute().compareTo(new BigInteger("100")) == 0);

		Command<BigInteger> multiplicacaoCommand2 = new MultiplicacaoCommand(new BigInteger("765"), new BigInteger("987"));

		assertTrue(multiplicacaoCommand2.execute().compareTo(new BigInteger("755055")) == 0);
	}

}
