package fr.afpa;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

/**
 * JavaFX App affichage d'un Hello World
 */
public class Formulaire extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        String javaVersion = SystemInfo.javaVersion();
        String javafxVersion = SystemInfo.javafxVersion();

        // Instanciations
        Label labelForm = new Label("Formulaire");
        Label labelInput = new Label("Entrée utilisateur :");
        Label labelCopy = new Label("Copie de l'entrée :");
        Button buttonCopy = new Button("Recopier");
        Button buttonClear = new Button("Effacer");
        Button buttonQuit = new Button("Quitter");
        TextField textInput = new TextField();
        TextField textLocked = new TextField();
        Double buttonWidth = 100.0;
        Double textFieldWidth = 250.0;

        GridPane gridPane = new GridPane();
        gridPane.add(labelInput, 0, 0);
        gridPane.add(textInput, 1, 0);
        gridPane.add(buttonCopy, 2, 0);
        gridPane.add(buttonClear, 2, 1);
        gridPane.add(labelCopy, 0, 2);
        gridPane.add(textLocked, 1, 2);
        gridPane.add(buttonQuit, 2, 2);

        VBox vbox = new VBox(labelForm, gridPane);
        VBox vboxDisplay = new VBox(vbox);

        // Settings
        stage.setMaxHeight(260);
        stage.setMaxWidth(600);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: #34a4df;"+
                "-fx-background-color : #ede9e3"+
                "-fx-effect: dropshadow: (gaussian, black, 7, 6, 0, -1 ;");
        vbox.setMaxWidth(539);

        vboxDisplay.setAlignment(Pos.CENTER);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(30, 5, 20, 5));
        gridPane.setStyle("-fx-background-color : #ede9e3");

        labelForm.setFont(new Font(18));
        labelForm.setTextFill(Color.WHITE);
        labelForm.setStyle("-fx-background-color : linear-gradient(to right, #155E83 0%, #0a78b1 50%, #155E83 100%);");
        labelForm.setPadding(new Insets(5, 220, 5, 220));

        textInput.setText("Saississez un texte");
        textInput.setPrefWidth(textFieldWidth);
        textLocked.setText(textInput.getText());
        textLocked.setDisable(true);
        textLocked.setPrefWidth(textFieldWidth);
        

        buttonCopy.setOnAction(value -> {
            textLocked.setText(textInput.getText());
        });
        buttonCopy.setPrefWidth(buttonWidth);

        buttonClear.setOnAction(value -> {
            textLocked.clear();
        });
        buttonClear.setPrefWidth(buttonWidth);

        buttonQuit.setOnAction(value -> {
            textInput.setText("GoodBye World !");
            textLocked.setText(textInput.getText());
            // créer une PauseTransition de 1 secondes
            PauseTransition delay = new PauseTransition(Duration.seconds(1));
            // définition de l'action suite à la pause
            delay.setOnFinished(e -> stage.close());
            // démarrer la pause
            delay.play();
        });
        buttonQuit.setPrefWidth(buttonWidth);


        // Assemblage
        Scene scene = new Scene(vboxDisplay, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

}