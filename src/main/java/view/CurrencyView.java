package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import controller.CurrencyController;
import model.Currency;

import java.util.ArrayList;

public class CurrencyView extends Application {

    private CurrencyController controller;
    private final ArrayList<Currency> currencies = new ArrayList<>();
    private ChoiceBox<String> choiceBox1 = new ChoiceBox<>();
    private ChoiceBox<String> choiceBox2 = new ChoiceBox<>();

    private TextField inputField = new TextField("Input amount: 1.5");
    private TextField outputField = new TextField("Output amount: 2.4");
    @java.lang.Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Currency Controller");
        VBox layoutMain = new VBox();


        Label nameOfTheProgram = new Label("Currency Controller");
        nameOfTheProgram.getStyleClass().add("title");
        nameOfTheProgram.setPadding(new javafx.geometry.Insets(10, 0, 10, 0));
        Label choiceBoxLabel1 = new Label("ChoiceBox");
        Label choiceBoxLabel2 = new Label("ChoiceBox");


        choiceBox1.getItems().addAll("USD", "EUR", "GBP", "JPY", "AUD", "CAD", "CHF", "CNY", "SEK", "NZD", "NOK");
        choiceBox1.setValue("EUR");

        choiceBox2.getItems().addAll("USD", "EUR", "GBP", "JPY", "AUD", "CAD", "CHF", "CNY", "SEK", "NZD", "NOK");
        choiceBox2.setValue("USD");


        Button convertButton = new Button("Convert");

        Button howToUseButton = new Button("How to use");

        HBox name = new HBox(nameOfTheProgram);
        name.setAlignment(Pos.CENTER);

        HBox choiceBoxes = new HBox(choiceBox1, choiceBox2);
        choiceBoxes.setAlignment(Pos.CENTER);
        choiceBoxes.setSpacing(10);

        HBox textFields = new HBox(inputField, outputField);
        textFields.setAlignment(Pos.CENTER);
        textFields.setSpacing(10);

        inputField.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, e -> inputField.setText(""));
        outputField.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, e -> outputField.setText(""));
        HBox buttonBox = new HBox();
        buttonBox.setPadding(new javafx.geometry.Insets(10, 0, 0, 0));
        HBox buttonBox2 = new HBox();
        buttonBox.getChildren().add(convertButton);


        convertButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, e -> {
            System.out.println(inputField.getText());
            if (inputField.getText().matches("\\d*(\\.\\d*)?") && !inputField.getText().equals("") ) {
                inputField.getStyleClass().add("valid-input");
                inputField.getStyleClass().remove("invalid-input");
                controller.convert();
            } else {
                inputField.getStyleClass().add("invalid-input");
                inputField.getStyleClass().remove("valid-input");
            }
        });


        buttonBox2.getChildren().add(howToUseButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox2.setAlignment(Pos.CENTER);
        layoutMain.getChildren().addAll(name, choiceBoxes, textFields);
        layoutMain.getChildren().add(buttonBox);
        layoutMain.getChildren().add(buttonBox2);

        Scene scene = new Scene(layoutMain, 400, 400);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();


        howToUseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                VBox layout = new VBox();
                layout.setAlignment(Pos.CENTER);
                Label howToUse = new Label("How to use");
                howToUse.getStyleClass().add("title");
                howToUse.setPadding(new javafx.geometry.Insets(10, 0, 10, 0));
                Image image = new Image("howToUse.png");
                ImageView imageView = new ImageView(image);
                layout.getChildren().addAll(howToUse, imageView);
                Scene scene = new Scene(layout, 1000, 700);
                scene.getStylesheets().add("style.css");
                stage.setScene(scene);
                stage.show();
            }
        });
    }

    public void init() {
        controller = new CurrencyController(this);
        //18 February 2024 21.18 UTC - 21.22 UTC
        Currency usd = new Currency("USD", "United States Dollar", 1.0);
        Currency eur = new Currency("EUR", "Euro", 1.08);
        Currency gbp = new Currency("GBP", "British Pound", 1.26);
        Currency jpy = new Currency("JPY", "Japanese Yen", 0.0067);
        Currency aud = new Currency("AUD", "Australian Dollar", 0.65);
        Currency cad = new Currency("CAD", "Canadian Dollar", 0.74);
        Currency chf = new Currency("CHF", "Swiss Franc", 1.14);
        Currency cny = new Currency("CNY", "Chinese Yuan", 0.14);
        Currency sek = new Currency("SEK", "Swedish Krona", 0.096);
        Currency nzd = new Currency("NZD", "New Zealand Dollar", 0.61);
        Currency nok = new Currency("NOK", "Norwegian Krone", 0.095);

        currencies.add(usd);
        currencies.add(eur);
        currencies.add(gbp);
        currencies.add(jpy);
        currencies.add(aud);
        currencies.add(cad);
        currencies.add(chf);
        currencies.add(cny);
        currencies.add(sek);
        currencies.add(nzd);
        currencies.add(nok);
    }

    public String getChoiceBoxes() {
        return choiceBox1.getValue() + " " + choiceBox2.getValue();
    }
    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }
    public double getRate(String choiceBoxValue) {
        for (Currency currency : currencies) {
            if (currency.getAbbreviation().equals(choiceBoxValue)){
                return currency.getRateToUSD();
            }
        }
        return 0;
        }
    public String getInputValue() {
        return inputField.getText();
    }
    public void setResult(String result) {
        outputField.setText(result);
    }
}