package Scenes;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

import static Controller.MainController.Table;
import static Scenes.AddAlbumsScene.AddAlbum;
import static Scenes.AlbumScene.Album;


public class AddPhotosScene {
    public static TextField txtFieldWeight;
    public static TextField txtFieldWeather;
    public static TextField txtFieldLake;
    public static TextField txtFieldSwim;
    public static TextField txtFieldSpecies;
    public static TextField txtFieldBait;
    public static TextField txtFieldTime;
    public static TextField txtFieldDistance;
    public static TextField txtFieldDepth;

    public static void AddPhoto() {

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setVmax(700);
        scrollPane.setPrefSize(1360, 700);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.getStyleClass().add("Pane");

        VBox AddPhotoViewLeft = new VBox(20);
        AddPhotoViewLeft.setLayoutX(650);
        AddPhotoViewLeft.setLayoutY(20);

        VBox AddPhotoViewRight = new VBox(20);
        AddPhotoViewRight.setLayoutX(900);
        AddPhotoViewRight.setLayoutY(20);

        TextField[] AddTagsL = new TextField[6];
        TextField[] AddTagsR = new TextField[3];

        txtFieldWeight = new TextField();
        txtFieldWeight.setPromptText("Enter Weight: ");
        AddTagsL[0] = txtFieldWeight;
        txtFieldWeight.getStyleClass().add("TextField");


        txtFieldLake = new TextField();
        txtFieldLake.setPromptText("Enter Lake: ");
        AddTagsL[1] = txtFieldLake;
        txtFieldLake.getStyleClass().add("TextField");

        txtFieldSwim = new TextField();
        txtFieldSwim.setPromptText("Enter Swim: ");
        AddTagsL[2] = txtFieldSwim;
        txtFieldSwim.getStyleClass().add("TextField");

        txtFieldSpecies = new TextField();
        txtFieldSpecies.setPromptText("Enter Species: ");
        AddTagsL[3] = txtFieldSpecies;
        txtFieldSpecies.getStyleClass().add("TextField");

        txtFieldBait = new TextField();
        txtFieldBait.setPromptText("Enter Bait: ");
        AddTagsL[4] = txtFieldBait;
        txtFieldBait.getStyleClass().add("TextField");

        txtFieldDepth = new TextField();
        txtFieldDepth.setPromptText("Enter Depth: ");
        AddTagsL[5] = txtFieldDepth;
        txtFieldDepth.getStyleClass().add("TextField");

        txtFieldDistance = new TextField();
        txtFieldDistance.setPromptText("Enter Distance: ");
        AddTagsR[0] = txtFieldDistance;
        txtFieldDistance.getStyleClass().add("TextField");

        txtFieldTime= new TextField();
        txtFieldTime.setPromptText("Enter Time: ");
        AddTagsR[1] = txtFieldTime;
        txtFieldTime.getStyleClass().add("TextField");

        txtFieldWeather = new TextField();
        txtFieldWeather.setPromptText("Enter Weather: ");
        AddTagsR[2] = txtFieldWeather;
        txtFieldWeather.getStyleClass().add("TextField");

        AddPhotoViewLeft.getChildren().addAll(AddTagsL);
        AddPhotoViewRight.getChildren().addAll(AddTagsR);

        DatePicker datePicker = new DatePicker();
        datePicker.setLayoutX(900);
        datePicker.setLayoutY(156);
        datePicker.getStyleClass().add("DatePicker");
        datePicker.setOnAction(event -> {
            LocalDate date = datePicker.getValue();
            System.out.println("Selected date: " + date);
        });


        ComboBox RigComboBox = new ComboBox();
        RigComboBox.setLayoutX(900);
        RigComboBox.setLayoutY(200);
        RigComboBox.setPromptText("Enter Rig: ");
        RigComboBox.getItems().addAll("Hair Rig", "Blowback Rig", "Chod Rig", "Hinge Stiff Rig", "Supple Hinge Rig", "Combi Rig", "Zig Rig", "Floater Rig", "Other");
        RigComboBox.getStyleClass().add("ComboBox");

        ComboBox comboBox = new ComboBox();
        comboBox.setLayoutX(900);
        comboBox.setLayoutY(246);
        comboBox.setPromptText("Enter Species: ");
        comboBox.getItems().addAll("Mirror Carp", "Common Carp", "Leather Carp", "Koi Carp", "Ghost Carp", "Tench", "Catfish", "Sturgeon", "Bream", "Rudd", "Roach", "Pike", "Perch");
        comboBox.getStyleClass().add("ComboBox");


        Button buttonSubmit = new Button("Add Catch");
        buttonSubmit.setLayoutX(815);
        buttonSubmit.setLayoutY(380);

        Button home = new Button("Home");
        home.setContentDisplay(ContentDisplay.TOP);
        home.setLayoutX(19);
        home.getStyleClass().add("MenuButton");

        Button album = new Button("Album");
        album.setContentDisplay(ContentDisplay.TOP);
        album.setLayoutX(80);
        album.getStyleClass().add("MenuButton");

        Button tableview = new Button("Table");
        tableview.setContentDisplay(ContentDisplay.TOP);
        tableview.setLayoutX(145);
        tableview.getStyleClass().add("MenuButton");

        Button addPhoto = new Button("Add Photo");
        addPhoto.setContentDisplay(ContentDisplay.TOP);
        addPhoto.setLayoutX(205);
        addPhoto.getStyleClass().add("MenuButton");

        Button addAlbum = new Button("Add Album");
        addAlbum.setContentDisplay(ContentDisplay.TOP);
        addAlbum.setLayoutX(295);
        addAlbum.getStyleClass().add("MenuButton");

        Button addLake = new Button("Add Lake");
        addLake.setContentDisplay(ContentDisplay.TOP);
        addLake.setLayoutX(390);
        addLake.getStyleClass().add("MenuButton");

        //home.setOnAction((ActionEvent ae) -> HomeScene());
        album.setOnAction((ActionEvent ae) -> Album());
        tableview.setOnAction((ActionEvent ae) -> Table());
        addAlbum.setOnAction((ActionEvent ae) -> AddAlbum());
        addPhoto.setOnAction((ActionEvent ae) -> AddPhoto());
        buttonSubmit.setOnAction((ActionEvent ae) -> SubmitPhoto());

        Stage stage = new Stage();
        stage.setTitle("Add Photo");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1420);
        stage.setHeight(600);
        rootPane.getStylesheets().add("Controller/simple.css");
        rootPane.getChildren().addAll(scrollPane, AddPhotoViewLeft, AddPhotoViewRight, comboBox, RigComboBox, buttonSubmit,
                home, album, addAlbum, addPhoto, tableview, datePicker, addLake);
        rootPane.getStyleClass().add("Pane");
        stage.show();

    }
    private static void SubmitPhoto() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("This feature is currently unavailable!!");

        alert.showAndWait();
    }

}
