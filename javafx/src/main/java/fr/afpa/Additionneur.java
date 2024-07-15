package fr.afpa;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App affichage d'un additionneur
 */
public class Additionneur extends Application {

    // sert pour le boutonCalcul
    private int currentSum = 0;
    private String accumulatedExpression = "";

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {

        // Instanciations
        Label labelTitle = new Label("Additionneur");
        Button buttonCalcul = new Button("Calculer");
        Button buttonClear = new Button("Vider");
        Button button0 = new Button("0");
        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button button4 = new Button("4");
        Button button5 = new Button("5");
        Button button6 = new Button("6");
        Button button7 = new Button("7");
        Button button8 = new Button("8");
        Button button9 = new Button("9");
        TextArea textArea = new TextArea();
        Double buttonWidth = 100.0;

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(textArea);

        GridPane gridPane = new GridPane();
        gridPane.add(button0, 0, 0);
        gridPane.add(button1, 1, 0);
        gridPane.add(button2, 2, 0);
        gridPane.add(button3, 3, 0);
        gridPane.add(button4, 4, 0);
        gridPane.add(button5, 0, 1);
        gridPane.add(button6, 1, 1);
        gridPane.add(button7, 2, 1);
        gridPane.add(button8, 3, 1);
        gridPane.add(button9, 4, 1);

        VBox vboxNumbers = new VBox(gridPane);
        HBox hboxButtons = new HBox(buttonCalcul, buttonClear);
        VBox vbox = new VBox(labelTitle, scrollPane, vboxNumbers, hboxButtons);
        VBox vboxDisplay = new VBox(vbox);

        // Settings
        stage.setMaxHeight(400);
        stage.setMaxWidth(450);

        labelTitle.setFont(new Font(18));
        labelTitle.setTextFill(Color.WHITE);
        labelTitle.setStyle("-fx-background-color : linear-gradient(to right, #155E83 0%, #0a78b1 50%, #155E83 100%);");
        labelTitle.setPadding(new Insets(5, 150, 5, 150));
        labelTitle.setMinWidth(400);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        scrollPane.setFitToWidth(true);
        scrollPane.setMaxWidth(250);
        scrollPane.setMaxHeight(100);

        hboxButtons.setAlignment(Pos.CENTER);
        hboxButtons.setSpacing(10);
        hboxButtons.setPadding(new Insets(0, 0, 20, 0));

        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: #34a4df;" +
                "-fx-background-color : #ede9e3");
        vbox.setMaxWidth(409);
        vbox.setSpacing(10);

        vboxNumbers.setAlignment(Pos.CENTER);

        vboxDisplay.setAlignment(Pos.CENTER);

        textArea.setText("Videz et saississez votre addition");

        button0.setOnAction(value -> {
            textArea.setText(textArea.getText() + "0 +");
        });
        button1.setOnAction(value -> {
            textArea.setText(textArea.getText() + "1 +");
        });
        button2.setOnAction(value -> {
            textArea.setText(textArea.getText() + "2 +");
        });
        button3.setOnAction(value -> {
            textArea.setText(textArea.getText() + "3 +");
        });
        button4.setOnAction(value -> {
            textArea.setText(textArea.getText() + "4 +");
        });
        button5.setOnAction(value -> {
            textArea.setText(textArea.getText() + "5 +");
        });
        button6.setOnAction(value -> {
            textArea.setText(textArea.getText() + "6 +");
        });
        button7.setOnAction(value -> {
            textArea.setText(textArea.getText() + "7 +");
        });
        button8.setOnAction(value -> {
            textArea.setText(textArea.getText() + "8 +");
        });
        button9.setOnAction(value -> {
            textArea.setText(textArea.getText() + "9 +");
        });

        buttonCalcul.setOnAction(value -> {
            String textValue = textArea.getText().trim();

            if (textValue.isEmpty()) {
                textArea.setText("Aucune valeur entrée !");
                return;
            }

            int lastEqualIndex = textValue.lastIndexOf('=');
            if (lastEqualIndex != -1) {
                textValue = textValue.substring(lastEqualIndex + 1).trim();
            }

            if (textValue.endsWith("+")) {
                textValue = textValue.substring(0, textValue.length() - 1);
            }

            String[] strValues = textValue.split("\\+");
            int sum = 0;
            for (String str : strValues) {
                try {
                    sum += Integer.parseInt(str.trim());
                } catch (NumberFormatException e) {
                    textArea.setText("Erreur : Entrée non valide");
                    return;
                }
            }

            accumulatedExpression += textValue + "+";
            currentSum = sum;
            textArea.setText(accumulatedExpression + "= " + currentSum + " +");
        });
        buttonCalcul.setPrefWidth(buttonWidth);

        buttonClear.setOnAction(value -> {
            textArea.clear();
            accumulatedExpression = "";
            currentSum = 0;
        });
        buttonClear.setPrefWidth(buttonWidth);

        // Assemblage
        Scene scene = new Scene(vboxDisplay, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
}