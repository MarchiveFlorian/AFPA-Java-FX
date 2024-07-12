package fr.afpa;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

/**
 * JavaFX App affichage d'un Hello World
 */
public class Additionneur extends Application {

    // sert pour le boutonCalcul
    private int currentSum = 0;

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
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefWidth(400);
        scrollPane.setPrefHeight(180);

        TilePane tilePane = new TilePane(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9);
        

        VBox vboxNumbers = new VBox(tilePane);
        HBox hboxButtons = new HBox(buttonCalcul, buttonClear);
        VBox vbox = new VBox(labelTitle, scrollPane, vboxNumbers, hboxButtons);
        VBox vboxDisplay = new VBox(vbox);

        // Settings
        stage.setMaxHeight(600);
        stage.setMaxWidth(600);

        tilePane.setTileAlignment(Pos.CENTER);
        tilePane.setHgap(10);
        tilePane.setVgap(10);

        hboxButtons.setSpacing(10);

        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: #34a4df;" +
                "-fx-background-color : #ede9e3");
        vbox.setMaxWidth(559);
        vbox.setSpacing(10);

        vboxDisplay.setAlignment(Pos.CENTER);

        labelTitle.setFont(new Font(18));
        labelTitle.setTextFill(Color.WHITE);
        labelTitle.setStyle("-fx-background-color : linear-gradient(to right, #155E83 0%, #0a78b1 50%, #155E83 100%);");
        labelTitle.setPadding(new Insets(5, 220, 5, 220));

        textArea.setText("Saississez votre addition");

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
            currentSum += sum;
            textArea.setText(textValue + " = " + currentSum + " +");
        });
        buttonCalcul.setPrefWidth(buttonWidth);

        buttonClear.setOnAction(value -> {
            textArea.clear();
        });
        buttonClear.setPrefWidth(buttonWidth);

        // Assemblage
        Scene scene = new Scene(vboxDisplay, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
}