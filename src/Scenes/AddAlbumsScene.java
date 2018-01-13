package Scenes;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;

import java.util.Optional;

import static Controller.MainController.Table;
import static Scenes.AddLakesScene.AddLake;
import static Scenes.AddPhotosScene.AddPhoto;
import static Scenes.AlbumScene.Album;



public class AddAlbumsScene {

    public static TextField txtFieldAlbumName;
    public static TextField txtFieldDate;
    public static TextField txtFieldPhoto1;
    public static TextField txtFieldPhoto2;
    public static TextField txtFieldPhoto3;
    public static TextField txtFieldPhoto4;
    public static TextField txtFieldPhoto5;

    public static void AddAlbum() {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setVmax(700);
        scrollPane.setPrefSize(1360, 700);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.getStyleClass().add("Pane");


        VBox AddAlbumView = new VBox(20);
        AddAlbumView.setLayoutX(650);
        AddAlbumView.setLayoutY(20);


        TextField[] AddAlbumInfo = new TextField[7];

        txtFieldAlbumName = new TextField();
        txtFieldAlbumName.setPromptText("Album Name: ");
        AddAlbumInfo[0] = txtFieldAlbumName;

        txtFieldDate = new TextField();
        txtFieldDate.setPromptText("Enter Date: ");
        AddAlbumInfo[1] = txtFieldDate;

        txtFieldPhoto1 = new TextField();
        txtFieldPhoto1.setPromptText("Photo 1: ");
        AddAlbumInfo[2] = txtFieldPhoto1;
        txtFieldPhoto1.getStyleClass().add("TextField");

        txtFieldPhoto2 = new TextField();
        txtFieldPhoto2.setPromptText("Photo 2: ");
        AddAlbumInfo[3] = txtFieldPhoto2;
        txtFieldPhoto2.getStyleClass().add("TextField");

        txtFieldPhoto3 = new TextField();
        txtFieldPhoto3.setPromptText("Photo 3: ");
        AddAlbumInfo[4] = txtFieldPhoto3;
        txtFieldPhoto3.getStyleClass().add("TextField");

        txtFieldPhoto4 = new TextField();
        txtFieldPhoto4.setPromptText("Photo 4: ");
        AddAlbumInfo[5] = txtFieldPhoto4;
        txtFieldPhoto4.getStyleClass().add("TextField");

        txtFieldPhoto5 = new TextField();
        txtFieldPhoto5.setPromptText("Photo 5: ");
        AddAlbumInfo[6] = txtFieldPhoto5;
        txtFieldPhoto5.getStyleClass().add("TextField");

        AddAlbumView.getChildren().addAll(AddAlbumInfo);

        Button buttonSubmit = new Button("Add Album");
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

        //home.setOnAction((ActionEvent ae) -> Home());
        album.setOnAction((ActionEvent ae) -> Album());
        tableview.setOnAction((ActionEvent ae) -> Table());
        addAlbum.setOnAction((ActionEvent ae) -> AddAlbum());
        addPhoto.setOnAction((ActionEvent ae) -> AddPhoto());
        addLake.setOnAction((ActionEvent ae) -> AddLake());
        buttonSubmit.setOnAction((ActionEvent ae) -> SubmitAlbum());

        Stage stage = new Stage();
        stage.setTitle("Add Album");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1420);
        stage.setHeight(600);
        rootPane.getStylesheets().add("Controller/simple.css");
        rootPane.getChildren().addAll(scrollPane, AddAlbumView, buttonSubmit, home, album, addLake, addAlbum, addPhoto, tableview);
        rootPane.getStyleClass().add("Pane");
        stage.show();
    }

    private static void SubmitAlbum() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        GetTextfieldAlbumEnteries();
        alert.setContentText("This feature is currently unavailable!!");

        alert.showAndWait();
    }

    private static void GetTextfieldAlbumEnteries() {

        System.out.println("Album Name= " + txtFieldAlbumName.getText());
        System.out.println("Date = " + txtFieldDate.getText());
        System.out.println("Photo 1 = " + txtFieldPhoto1.getText());
        System.out.println("Photo 2= " + txtFieldPhoto2.getText());
        System.out.println("Photo 3= " + txtFieldPhoto3.getText());
        System.out.println("Photo 4= " + txtFieldPhoto4.getText());
        System.out.println("Photo 5= " + txtFieldPhoto5.getText());

    }
}
