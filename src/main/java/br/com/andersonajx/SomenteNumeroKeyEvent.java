package br.com.andersonajx;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public final class SomenteNumeroKeyEvent implements EventHandler<KeyEvent> {

	@Override
	public void handle(KeyEvent keyEvent) {
		if (!keyEvent.getCharacter().matches("\\d")) {
			keyEvent.consume();
		}
	}

}
