package fr.afpa;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
        Double buttonWidth = 100.0;
        Double textFieldWidth = 250.0;

        ObservableList<Country> comboBoxList = FXCollections.observableArrayList();
        comboBoxList.add(new Country("Belgique", "BEL"));
        comboBoxList.add(new Country("France", "FRA"));
        comboBoxList.add(new Country("Angleterre", "GBR"));
        comboBoxList.add(new Country("Allemagne", "DEU"));
        comboBoxList.add(new Country("Espagne", "ESP"));
        comboBoxList.add(new Country("Portugal", "PRT"));

        ComboBox<Country> comboBox = new ComboBox<>(comboBoxList);

        ListView<Country> listView = new ListView<>();

        VBox vbox = new VBox(labelForm, comboBox, addButton, addAllButton, getButton, getAllButton, upElement, downElement, listView, quitButton);
        VBox vboxDisplay = new VBox(vbox);

        // Settings
        stage.setMaxHeight(600);
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

        addButton.setOnAction(value -> {
            listView.getItems().add(comboBox.getValue());
            comboBox.getItems().remove(comboBox.getValue());
        });

        addAllButton.setOnAction(value -> {
            listView.getItems().addAll(comboBox.getItems());
            comboBox.getItems().clear();
        });

        getButton.setOnAction(value -> {
            comboBox.getItems().add(listView.getSelectionModel().getSelectedItem());
            listView.getItems().remove(listView.getSelectionModel().getSelectedItem());
        });

        getAllButton.setOnAction(value -> {
            comboBox.getItems().addAll(listView.getItems());
            listView.getItems().clear();
        });

        upElement.setOnAction(value -> {
            ListViewMoveManager.moveSelectedItemUp(listView);
        });

        downElement.setOnAction(value -> {
            ListViewMoveManager.moveSelectedItemDown(listView);
        });

        quitButton.setOnAction(value -> {
            Platform.exit();
        });

        // Assemblage
        Scene scene = new Scene(vboxDisplay, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
}