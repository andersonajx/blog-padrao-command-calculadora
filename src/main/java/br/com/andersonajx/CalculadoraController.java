package br.com.andersonajx;

import br.com.andersonajx.math.Command;

public class CalculadoraController {

	public Number calcular(Command<?> command) {
		return command.execute();
	}

}
