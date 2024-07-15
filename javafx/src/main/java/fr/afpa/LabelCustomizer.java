package fr.afpa;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App affichage d'un outil de modification visuel d'un label
 */
public class LabelCustomizer extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {

        // Instanciations
        Label labelForm = new Label("Customizer");
        Label labelHidden = new Label("");
        Label labelTextInput = new Label("Saississez votre texte");
        TextField textInput = new TextField();
        Double textFieldWidth = 250.0;
        String color1 = "Rouge";
        String color2 = "Vert";
        String color3 = "Bleu";
        Label labelSlider1 = new Label(color1);
        Label labelSlider2 = new Label(color2);
        Label labelSlider3 = new Label(color3);

        CheckBox checkBoxBgColor = new CheckBox("Couleur de fond");
        CheckBox checkBoxChColor = new CheckBox("Couleur des caractères");
        CheckBox checkBoxChCase = new CheckBox("Minuscule | Majuscule");
        VBox vboxCheckbox = new VBox(checkBoxBgColor, checkBoxChColor, checkBoxChCase);

        RadioButton radioButtonBgColor1 = new RadioButton(color1);
        RadioButton radioButtonBgColor2 = new RadioButton(color2);
        RadioButton radioButtonBgColor3 = new RadioButton(color3);
        VBox radioButtonBgColor = new VBox(radioButtonBgColor1, radioButtonBgColor2, radioButtonBgColor3);

        Slider slider1 = new Slider(0, 255, 0);
        Slider slider2 = new Slider(0, 255, 0);
        Slider slider3 = new Slider(0, 255, 0);
        VBox sliders = new VBox(labelSlider1, slider1, labelSlider2, slider2, labelSlider3, slider3);

        RadioButton radioButtonUpperCase = new RadioButton("Majuscule");
        RadioButton radioButtonLowerCase = new RadioButton("Minuscule");
        VBox radioButtonChCase = new VBox(radioButtonUpperCase, radioButtonLowerCase);

        TitledPane titledPaneSettings = new TitledPane("Paramètres Label", vboxCheckbox);
        TitledPane titlePaneBgColor = new TitledPane("Fond", radioButtonBgColor);
        TitledPane titlePaneChColor = new TitledPane("Couleur des caractères", sliders);
        TitledPane titlePaneChCase = new TitledPane("Casse", radioButtonChCase);

        VBox vboxText = new VBox(labelTextInput, textInput, labelHidden);

        GridPane gridPane = new GridPane();
        gridPane.add(vboxText, 0, 0);
        gridPane.add(titledPaneSettings, 1, 0);

        VBox vbox = new VBox(labelForm, gridPane);
        HBox hbox = new HBox(titlePaneBgColor, titlePaneChColor, titlePaneChCase);
        VBox vboxCss = new VBox(vbox, hbox);
        VBox vboxDisplay = new VBox(vboxCss);

        // Settings
        stage.setMaxHeight(500);
        stage.setMaxWidth(600);
        vboxCss.setAlignment(Pos.CENTER);
        vboxCss.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: #34a4df;" +
                "-fx-background-color : #ede9e3;" +
                "-fx-effect: dropshadow(gaussian,  grey, 10, 0, 5, 5);");
        vboxCss.setMaxWidth(534);

        vboxDisplay.setAlignment(Pos.CENTER);

        vbox.setAlignment(Pos.CENTER);
        vbox.setFillWidth(true);

        vboxText.setSpacing(10);
        vboxText.setPadding(new Insets(20, 0, 20, 0));

        hbox.setAlignment(Pos.BASELINE_CENTER);
        hbox.setFillHeight(true);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(0, 0, 20, 0));

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        labelForm.setFont(new Font(18));
        labelForm.setTextFill(Color.WHITE);
        labelForm.setStyle("-fx-background-color : linear-gradient(to right, #155E83 0%, #0a78b1 50%, #155E83 100%);");
        labelForm.setPadding(new Insets(5, 220, 5, 220));

        textInput.setPrefWidth(textFieldWidth);

        // Gestion visibilité
        slider1.setShowTickLabels(true);
        slider2.setShowTickLabels(true);
        slider3.setShowTickLabels(true);

        titledPaneSettings.setExpanded(false);

        labelHidden.setVisible(false);
        titlePaneBgColor.setVisible(false);
        titlePaneChColor.setVisible(false);
        titlePaneChCase.setVisible(false);

        textInput.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.trim().isEmpty()) {
                labelHidden.setVisible(true);
                labelHidden.setText(newValue);
                titledPaneSettings.setExpanded(true);
            } else {
                labelHidden.setVisible(false);
                titledPaneSettings.setExpanded(false);
            }
        });

        checkBoxBgColor.selectedProperty().addListener((observable, oldValue, newValue) -> {
            titlePaneBgColor.setVisible(newValue);
        });

        checkBoxChColor.selectedProperty().addListener((observable, oldValue, newValue) -> {
            titlePaneChColor.setVisible(newValue);
        });

        checkBoxChCase.selectedProperty().addListener((observable, oldValue, newValue) -> {
            titlePaneChCase.setVisible(newValue);
        });

        // Gestion customisation du label
        String initialStyle = labelHidden.getStyle();

        radioButtonBgColor1.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                labelHidden.setStyle("-fx-background-color: Red");
            } else {
                labelHidden.setStyle(initialStyle);
            }
        });

        radioButtonBgColor2.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                labelHidden.setStyle("-fx-background-color: Green");
            } else {
                labelHidden.setStyle(initialStyle);
            }
        });

        radioButtonBgColor3.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                labelHidden.setStyle("-fx-background-color: Blue");
            } else {
                labelHidden.setStyle(initialStyle);
            }
        });

        radioButtonUpperCase.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                labelHidden.setText(labelHidden.getText().toUpperCase());
            } else {
                labelHidden.setText(textInput.getText());
            }
        });

        radioButtonLowerCase.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                labelHidden.setText(labelHidden.getText().toLowerCase());
            } else {
                labelHidden.setText(textInput.getText());
            }
        });

        slider1.valueProperty().addListener((observable, oldValue, newValue) -> {
            int red = newValue.intValue();
            int green = (int) slider2.getValue();
            int blue = (int) slider3.getValue();
            Color textColor = Color.rgb(red, green, blue);
            labelHidden.setTextFill(textColor);
        });

        slider2.valueProperty().addListener((observable, oldValue, newValue) -> {
            int red = (int) slider1.getValue();
            int green = newValue.intValue();
            int blue = (int) slider3.getValue();
            Color textColor = Color.rgb(red, green, blue);
            labelHidden.setTextFill(textColor);
        });

        slider3.valueProperty().addListener((observable, oldValue, newValue) -> {
            int red = (int) slider1.getValue();
            int green = (int) slider2.getValue();
            int blue = newValue.intValue();
            Color textColor = Color.rgb(red, green, blue);
            labelHidden.setTextFill(textColor);
        });

        // Assemblage
        Scene scene = new Scene(vboxDisplay, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
}