package br.com.andersonajx;

import br.com.andersonajx.math.AdicaoCommand;
import br.com.andersonajx.math.DivisaoCommand;
import br.com.andersonajx.math.MultiplicacaoCommand;
import br.com.andersonajx.math.SubtracaoCommand;
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
import java.math.BigInteger;

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
		primeiroValor.addEventFilter(KeyEvent.KEY_TYPED, new SomenteNumeroKeyEvent());

		final TextField segundoValor = new TextField();
		segundoValor.setPromptText("Informe um número");
		segundoValor.addEventFilter(KeyEvent.KEY_TYPED, new SomenteNumeroKeyEvent());

		top.getChildren().addAll(primeiroValor, segundoValor);

		Button somar = new Button("+");
		somar.setPrefWidth(100);
		somar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				AdicaoCommand command = new AdicaoCommand(new BigInteger(primeiroValor.getText()), new BigInteger(segundoValor.getText()));
				resultado.setText(controller.calcular(command).toString());
			}
		});

		Button subtrair = new Button("-");
		subtrair.setPrefWidth(100);
		subtrair.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				SubtracaoCommand command = new SubtracaoCommand(new BigInteger(primeiroValor.getText()), new BigInteger(segundoValor.getText()));
				resultado.setText(controller.calcular(command).toString());
			}
		});

		Button multiplicar = new Button("*");
		multiplicar.setPrefWidth(100);
		multiplicar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				MultiplicacaoCommand command = new MultiplicacaoCommand(new BigInteger(primeiroValor.getText()), new BigInteger(segundoValor.getText()));
				resultado.setText(controller.calcular(command).toString());
			}
		});

		Button dividir = new Button("/");
		dividir.setPrefWidth(100);
		dividir.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				DivisaoCommand command = new DivisaoCommand(new BigDecimal(primeiroValor.getText()), new BigDecimal(segundoValor.getText()));
				resultado.setText(controller.calcular(command).toString());
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
