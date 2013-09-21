package br.com.andersonajx.math;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

public class DivisaoCommandTest {

	@Test
	public void execute() {
		Command<BigDecimal> divisaoCommand1 = new DivisaoCommand(BigDecimal.TEN, BigDecimal.TEN);

		assertTrue(divisaoCommand1.execute().compareTo(BigDecimal.ONE) == 0);

		Command<BigDecimal> divisaoCommand2 = new DivisaoCommand(new BigDecimal("150"), new BigDecimal("3"));

		assertTrue(divisaoCommand2.execute().compareTo(new BigDecimal("50")) == 0);
	}

}
