package fr.afpa;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App affichage d'un formulaire
 */
public class Combobox extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {

        // Instanciations
        Label labelForm = new Label("Liste Pays");
        Button addButton = new Button(">");
        Button addAllButton = new Button(">>");
        Button getButton = new Button("<");
        Button getAllButton = new Button("<<");
        Button upElement = new Button("Haut");
        Button downElement = new Button("Bas");
        Button quitButton = new Button("Quitter");
        String pays1 = "Belgique";
        String pays2 = "France";
        String pays3 = "Angleterre";
        Double buttonWidth = 100.0;
        Double textFieldWidth = 250.0;

        ComboBox comboBox = new ComboBox();
        comboBox.getItems().add(pays1);
        comboBox.getItems().add(pays2);
        comboBox.getItems().add(pays3);

        ListView listView = new ListView();

        VBox vbox = new VBox(labelForm);
        VBox vboxDisplay = new VBox(vbox);

        // Settings
        stage.setMaxHeight(260);
        stage.setMaxWidth(600);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: #34a4df;" +
                "-fx-background-color : #ede9e3;" +
                "-fx-effect: dropshadow(gaussian,  grey, 10, 0, 5, 5);");
        vbox.setMaxWidth(529);

        vboxDisplay.setAlignment(Pos.CENTER);

        labelForm.setFont(new Font(18));
        labelForm.setTextFill(Color.WHITE);
        labelForm.setStyle("-fx-background-color : linear-gradient(to right, #155E83 0%, #0a78b1 50%, #155E83 100%);");
        labelForm.setPadding(new Insets(5, 220, 5, 220));

        // Assemblage
        Scene scene = new Scene(vboxDisplay, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
}