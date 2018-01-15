package Scenes;

import Model.Album;
import Model.AlbumService;
import Model.Catch;
import Model.CatchService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;

import java.io.File;
import java.util.List;
import java.util.Optional;

import static Controller.MainController.Table;
import static Controller.MainController.database;
import static Scenes.AddLakesScene.AddLake;
import static Scenes.AddPhotosScene.AddPhoto;
import static Scenes.AlbumScene.Album;
import static java.lang.Integer.parseInt;


public class AddAlbumsScene {

    public static TextField txtFieldAlbumName;
    public static TextField txtFieldDate;
    public static Label Photo1;
    public static Label Photo2;
    public static Label Photo3;
    public static Label Photo4;
    public static Label Photo5;
    public static Button Photo1button;
    public static Button Photo2button;
    public static Button Photo3button;
    public static Button Photo4button;
    public static Button Photo5button;
    public static String fileAsString;
    public static String Photo1URL;
    public static String Photo2URL;
    public static String Photo3URL;
    public static String Photo4URL;
    public static String Photo5URL;

    public static void AddAlbum() {

        Stage stage = new Stage();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setVmax(700);
        scrollPane.setPrefSize(1360, 700);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.getStyleClass().add("Pane");


        VBox AddAlbumView = new VBox(20);
        AddAlbumView.setLayoutX(650);
        AddAlbumView.setLayoutY(20);

        TextField[] AddAlbumInfo = new TextField[1];

        txtFieldAlbumName = new TextField();
        txtFieldAlbumName.setPromptText("Album Name: ");
        AddAlbumInfo[0] = txtFieldAlbumName;

        Photo1 = new Label();
        Photo1.setText(Photo1URL);
        Photo1.setLayoutX(750);
        Photo1.setLayoutY(100);
        Photo1button = new Button();
        Photo1button.setText("Add Photo 1");
        Photo1button.setLayoutX(650);
        Photo1button.setLayoutY(100);
        Photo1button.getStyleClass().add("TextField");


        Photo2 = new Label();
        Photo2.setText(Photo2URL);
        Photo2.setLayoutX(750);
        Photo2.setLayoutY(140);
        Photo2button = new Button();
        Photo2button.setText("Add Photo 2");
        Photo2button.setLayoutX(650);
        Photo2button.setLayoutY(140);
        Photo2.getStyleClass().add("TextField");

        Photo3 = new Label();
        Photo3.setText(Photo3URL);
        Photo3.setLayoutX(750);
        Photo3.setLayoutY(180);
        Photo3button = new Button();
        Photo3button.setText("Add Photo 3");
        Photo3button.setLayoutX(650);
        Photo3button.setLayoutY(180);
        Photo3.getStyleClass().add("TextField");

        Photo4 = new Label();
        Photo4.setText(Photo4URL);
        Photo4.setLayoutX(750);
        Photo4.setLayoutY(220);
        Photo4button = new Button();
        Photo4button.setText("Add Photo 4");
        Photo4button.setLayoutX(650);
        Photo4button.setLayoutY(220);
        Photo4.getStyleClass().add("TextField");

        Photo5 = new Label();
        Photo5.setText(Photo5URL);
        Photo5.setLayoutX(750);
        Photo5.setLayoutY(260);
        Photo5button = new Button();
        Photo5button.setText("Add Photo 5");
        Photo5button.setLayoutX(650);
        Photo5button.setLayoutY(260);
        Photo5.getStyleClass().add("TextField");


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
        Photo1button.setOnAction((ActionEvent ae) -> Photo1Chooser());
        Photo2button.setOnAction((ActionEvent ae) -> Photo2Chooser());
        Photo3button.setOnAction((ActionEvent ae) -> Photo3Chooser());
        Photo4button.setOnAction((ActionEvent ae) -> Photo4Chooser());
        Photo5button.setOnAction((ActionEvent ae) -> Photo5Chooser());
        buttonSubmit.setOnAction((ActionEvent ae) -> SubmitAlbum());

        final FileChooser fileChooser = new FileChooser();
        final Button openMultipleButton = new Button("Add Pictures");
        openMultipleButton.setLayoutX(815);
        openMultipleButton.setLayoutY(350);
        openMultipleButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        List<File> list =
                                fileChooser.showOpenMultipleDialog(stage);
                        fileAsString = list.toString();
                        System.out.println(fileAsString);

                    }
                });


        stage.setTitle("Add Album");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1420);
        stage.setHeight(600);
        rootPane.getStylesheets().add("Controller/simple.css");
        rootPane.getChildren().addAll(scrollPane, AddAlbumView, Photo1button, Photo2button, Photo3button, Photo4button, Photo5button,Photo1, Photo2,Photo3,Photo4,Photo5,buttonSubmit, home, album, addLake, addAlbum, addPhoto, tableview, openMultipleButton);
        rootPane.getStyleClass().add("Pane");
        stage.show();
        createNewPizza();
    }

    public static void createNewPizza() {

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Create new pizza");
        dialog.setHeaderText(null);
        dialog.setContentText("Pizza's name:");
        Optional<String> result = dialog.showAndWait();

        if (result.isPresent() && !result.get().equals("")) {

            Album newAlbum = new Album(1, txtFieldAlbumName.getText(), 1, 2, 3,4,5 );
            AlbumService.saveAlbum(newAlbum, database);

        }

    }

    private static void Photo1Chooser(){
        Stage stage = new Stage();

        FileChooser chooser = new FileChooser();
        chooser.setTitle("View Pictures");
        chooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        File file = chooser.showOpenDialog(stage);
        if (file != null) {
            Photo1URL = file.toString();
            System.out.println(Photo1URL);
        }
        System.out.println("You have reached the picture chooser!");
    }

    private static void Photo2Chooser(){
        Stage stage = new Stage();

        FileChooser chooser = new FileChooser();
        chooser.setTitle("View Pictures");
        chooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        File file = chooser.showOpenDialog(stage);
        if (file != null) {
            Photo2URL = file.toString();
            System.out.println(Photo2URL);
        }
        System.out.println("You have reached the picture chooser!");
    }
    private static void Photo3Chooser(){
        Stage stage = new Stage();

        FileChooser chooser = new FileChooser();
        chooser.setTitle("View Pictures");
        chooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        File file = chooser.showOpenDialog(stage);
        if (file != null) {
            Photo3URL = file.toString();
            System.out.println(Photo3URL);
        }
        System.out.println("You have reached the picture chooser!");
    }
    private static void Photo4Chooser(){
        Stage stage = new Stage();

        FileChooser chooser = new FileChooser();
        chooser.setTitle("View Pictures");
        chooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        File file = chooser.showOpenDialog(stage);
        if (file != null) {
            Photo4URL = file.toString();
            System.out.println(Photo4URL);
        }
        System.out.println("You have reached the picture chooser!");
    }
    private static void Photo5Chooser(){
        Stage stage = new Stage();

        FileChooser chooser = new FileChooser();
        chooser.setTitle("View Pictures");
        chooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        File file = chooser.showOpenDialog(stage);
        if (file != null) {
            Photo5URL = file.toString();
            System.out.println(Photo5URL);
        }
        System.out.println("You have reached the picture chooser!");
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

    }
}
