package Views;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static Views.AddAlbums.AddAlbum;
import static Views.AddPhotos.AddPhoto;
import static Views.AlbumView.Album;
import static Views.TableView.Table;

public class AddLakes {

    public static TextField txtFieldPostcode;
    public static TextField txtFieldLakeName;
    public static TextField txtFieldStreet;
    public static TextField txtFieldTown;
    public static TextField txtFieldCounty;

    public static void AddLake() {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setVmax(700);
        scrollPane.setPrefSize(1360, 700);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.getStyleClass().add("Pane");


        VBox AddAlbumView = new VBox(20);
        AddAlbumView.setLayoutX(650);
        AddAlbumView.setLayoutY(20);


        TextField[] AddAlbumInfo = new TextField[5];

        txtFieldLakeName = new TextField();
        txtFieldLakeName.setPromptText("Lake Name: ");
        AddAlbumInfo[0] = txtFieldLakeName;
        txtFieldLakeName.getStyleClass().add("TextField");

        txtFieldStreet = new TextField();
        txtFieldStreet.setPromptText("Street: ");
        AddAlbumInfo[1] = txtFieldStreet;
        txtFieldStreet.getStyleClass().add("TextField");

        txtFieldTown = new TextField();
        txtFieldTown.setPromptText("Town: ");
        AddAlbumInfo[2] = txtFieldTown;
        txtFieldTown.getStyleClass().add("TextField");

        txtFieldCounty = new TextField();
        txtFieldCounty.setPromptText("County:  ");
        AddAlbumInfo[3] = txtFieldCounty;
        txtFieldCounty.getStyleClass().add("TextField");

        txtFieldPostcode = new TextField();
        txtFieldPostcode.setPromptText("Postcode : ");
        AddAlbumInfo[4] = txtFieldPostcode;
        txtFieldPostcode.getStyleClass().add("TextField");

        AddAlbumView.getChildren().addAll(AddAlbumInfo);

        Button buttonSubmit = new Button("Add Lake");
        buttonSubmit.setLayoutX(815);
        buttonSubmit.setLayoutY(250);
        buttonSubmit.getStyleClass().add("MenuButton");

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
        addPhoto.setOnAction((ActionEvent ae) -> AddLake());

        Stage stage = new Stage();
        stage.setTitle("Add Lake");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1420);
        stage.setHeight(600);
        rootPane.getStylesheets().add("Controller/simple.css");
        rootPane.getChildren().addAll(scrollPane, AddAlbumView, buttonSubmit, home, album, addAlbum, addPhoto, addLake, tableview);
        rootPane.getStyleClass().add("Pane");
        stage.show();
    }

}