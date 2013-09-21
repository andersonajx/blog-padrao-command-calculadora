package br.com.andersonajx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.math.BigDecimal;

public class CalculadoraView extends Application {

	private CalculadoraController controller = new CalculadoraController();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		final Label resultado = new Label("0");

		stage.setTitle("Calculadora Command");
		stage.resizableProperty().setValue(false);

		BorderPane borderPane = new BorderPane();

		VBox top = new VBox();
		top.setPadding(new Insets(15, 12, 15, 12));
		top.setSpacing(10);
		top.setStyle("-fx-background-color: silver;");

		final TextField primeiroValor = new TextField();
		primeiroValor.setPromptText("Informe um número");
		primeiroValor.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {
				if (!keyEvent.getCharacter().matches("\\d")) {
					keyEvent.consume();
				}
			}
		});

		final TextField segundoValor = new TextField();
		segundoValor.setPromptText("Informe um número");
		segundoValor.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {
				if (!keyEvent.getCharacter().matches("\\d")) {
					keyEvent.consume();
				}
			}
		});

		top.getChildren().addAll(primeiroValor, segundoValor);

		Button somar = new Button("+");
		somar.setPrefWidth(100);
		somar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				resultado.setText(controller.somar(new BigDecimal(primeiroValor.getText()), new BigDecimal(segundoValor.getText())).toPlainString());
			}
		});

		Button subtrair = new Button("-");
		subtrair.setPrefWidth(100);
		subtrair.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				resultado.setText(controller.subtrair(new BigDecimal(primeiroValor.getText()), new BigDecimal(segundoValor.getText())).toPlainString());
			}
		});

		Button multiplicar = new Button("*");
		multiplicar.setPrefWidth(100);
		multiplicar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				resultado.setText(controller.multiplicar(new BigDecimal(primeiroValor.getText()), new BigDecimal(segundoValor.getText())).toPlainString());
			}
		});

		Button dividir = new Button("/");
		dividir.setPrefWidth(100);
		dividir.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				resultado.setText(controller.dividir(new BigDecimal(primeiroValor.getText()), new BigDecimal(segundoValor.getText())).toPlainString());
			}
		});

		HBox center = new HBox();
		center.setPadding(new Insets(15, 12, 15, 12));
		center.setSpacing(10);
		center.setStyle("-fx-background-color: #E8E8E8;");
		center.setAlignment(Pos.CENTER);
		center.getChildren().addAll(somar, subtrair, multiplicar, dividir);

		Label total = new Label("Total: ");

		HBox bottom = new HBox();
		bottom.setPadding(new Insets(15, 12, 15, 12));
		bottom.setSpacing(10);
		bottom.setStyle("-fx-background-color: #F0F0F0;");
		bottom.getChildren().addAll(total, resultado);

		borderPane.setTop(top);
		borderPane.setCenter(center);
		borderPane.setBottom(bottom);

		Scene form = new Scene(borderPane, 300, 200);

		stage.setScene(form);
		stage.show();
	}
}
