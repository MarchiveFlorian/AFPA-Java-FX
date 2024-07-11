package fr.afpa;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
        Label labelInput = new Label("Entrée utilisateur :");
        Label labelCopy = new Label("Copie de l'entrée :");
        Button buttonCopy = new Button("Recopier");
        Button buttonClear = new Button("Effacer");
        Button buttonQuit = new Button("Quitter");
        TextField textInput = new TextField();
        TextField textLocked = new TextField();
        // VBox vboxButtons = new VBox(buttonCopy, buttonClear, buttonQuit);

        GridPane gridPane = new GridPane();
        gridPane.add(labelInput, 0, 0);
        gridPane.add(textInput, 1, 0);
        gridPane.add(buttonCopy, 2, 0);
        gridPane.add(buttonClear, 2, 1);
        gridPane.add(labelCopy, 0, 2);
        gridPane.add(textLocked, 1, 2);
        gridPane.add(buttonQuit, 2, 2);
        // gridPane.add(vboxButtons, 2, 0);

        VBox vbox = new VBox(gridPane);

        // Settings
        vbox.setAlignment(Pos.CENTER);
        textInput.setText("Saississez un texte");
        textLocked.setText(textInput.getText());

        buttonCopy.setOnAction(value -> {
            textLocked.setText(textInput.getText());
        });

        buttonClear.setOnAction(value -> {
            textLocked.clear();
        });

        buttonQuit.setOnAction(value -> {
            textInput.setText("GoodBye World !");
            textLocked.setText(textInput.getText());
            //créer une PauseTransition de 3 secondes
            PauseTransition delay = new PauseTransition(Duration.seconds(1));
            //définition de l'action suite à la pause
            delay.setOnFinished(e -> stage.close());
            //démarrer la pause
            delay.play();
        });

        

        // Assemblage
        Scene scene = new Scene(vbox, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

}