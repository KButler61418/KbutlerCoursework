package Gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.util.Optional;



public class AddPhotoInterface extends Application {
    public static TextField txtFieldWeight;
    public static TextField txtFieldLake;
    public static TextField txtFieldSwim;
    public static TextField txtFieldSpecies;
    public static TextField txtFieldRig;
    public static TextField txtFieldBait;
    public static TextField txtFieldDate;
    public static TextField txtFieldTime;
    public static TextField txtFieldDistance;
    public static TextField txtFieldDepth;
    public static TextField txtFieldTemperature;
    public static TextField txtFieldWindDirection;
    public static TextField txtFieldAirPressure;
    public static TextField txtFieldWindSpeed;

    @Override
    public void start(Stage stage) {


        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setVmax(440);
        scrollPane.setPrefSize(1360, 800);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

            /*Image image1 = new Image("20170911_232450.jpg", 650, 525, false, true);
            ImageView Image1 = new ImageView(image1); */

        VBox boxOfButtons = new VBox(20);
        boxOfButtons.setLayoutX(700);
        boxOfButtons.setLayoutY(20);


        TextField[] AddTags = new TextField[14];
        txtFieldWeight = new TextField();
        txtFieldWeight.setPromptText("Enter Weight: ");
        AddTags[0] = txtFieldWeight;

        txtFieldLake = new TextField();
        txtFieldLake.setPromptText("Enter Lake: ");
        AddTags[1] = txtFieldLake;

        txtFieldSwim = new TextField();
        txtFieldSwim.setPromptText("Enter Weight: ");
        AddTags[2] = txtFieldSwim;

        txtFieldSpecies = new TextField();
        txtFieldSpecies.setPromptText("Enter Species: ");
        AddTags[3] = txtFieldSpecies;

        txtFieldRig = new TextField();
        txtFieldRig.setPromptText("Enter Rig: ");
        AddTags[4] = txtFieldRig;

        txtFieldBait = new TextField();
        txtFieldBait.setPromptText("Enter Bait: ");
        AddTags[5] = txtFieldBait;

        txtFieldDepth = new TextField();
        txtFieldDepth.setPromptText("Enter Depth: ");
        AddTags[6] = txtFieldDepth;

        txtFieldDistance = new TextField();
        txtFieldDistance.setPromptText("Enter Distance: ");
        AddTags[7] = txtFieldDistance;

        txtFieldDate = new TextField();
        txtFieldDate.setPromptText("Enter Date: ");
        AddTags[8] = txtFieldDate;

        txtFieldWindDirection = new TextField();
        txtFieldWindDirection.setPromptText("Enter Wind Direction: ");
        AddTags[9] = txtFieldWindDirection;

        txtFieldWindSpeed= new TextField();
        txtFieldWindSpeed.setPromptText("Enter Wind Speed; ");
        AddTags[10] = txtFieldWindSpeed;

        txtFieldTime= new TextField();
        txtFieldTime.setPromptText("Enter Time: ");
        AddTags[11] = txtFieldTime;

        txtFieldTemperature = new TextField();
        txtFieldTemperature.setPromptText("Enter Temperature: ");
        AddTags[12] = txtFieldTemperature;

        txtFieldAirPressure = new TextField();
        txtFieldAirPressure.setPromptText("Enter Air Pressure: ");
        AddTags[13] = txtFieldAirPressure;

        boxOfButtons.getChildren().addAll(AddTags);


        Text locationLabel = new Text("Species: ");
        locationLabel.setLayoutX(50);
        locationLabel.setLayoutY(50);
        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.setLayoutX(600);
        choiceBox.setLayoutY(620);
        choiceBox.getItems().addAll("Mirror Carp", "Common Carp", "Leather Carp", "Koi Carp", "Ghost Carp", "Tench", "Catfish", "Sturgeon", "Bream", "Rudd", "Roach", "Pike", "Perch");
        Button buttonSubmit = new Button("Register");
        buttonSubmit.setLayoutX(600);
        buttonSubmit.setLayoutY(700);

        stage.setTitle("Photo Test!");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1420);
        stage.setHeight(600);
        stage.setOnCloseRequest((WindowEvent we) -> terminate(we));
        rootPane.getStylesheets().add("Controller/simple.css");
        rootPane.getChildren().addAll(scrollPane, boxOfButtons, locationLabel, choiceBox, buttonSubmit);
        stage.show();
    }

    public static void terminate(WindowEvent we) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("Are you sure you wanna quit?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.out.println("Closing application");
            System.exit(0);

        } else {
            we.consume();
        }
    }
}