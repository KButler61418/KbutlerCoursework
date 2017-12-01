package Scenes;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static Controller.MainController.Table;
import static Scenes.AddAlbumsScene.AddAlbum;
import static Scenes.AddLakesScene.AddLake;

public class AlbumScene {

    public static void Album(){

        Image Peck = new Image("Gui/20170911_232450.jpg", 400, 300, false, true);  //filename, requestedWidth, requestedHeight, preserveRatio, smooth
        Image Ali = new Image("Gui/20170912_132539.jpg", 400, 300, false, true);
        Image Dove = new Image("Gui/20170912_134249.jpg", 400, 300, false, true);


        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setLayoutY(30);
        scrollPane.setVmax(440);
        scrollPane.setPrefSize(1360, 700);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.getStyleClass().add("Pane");

        GridPane root = new GridPane();
        root.setHgap(20);
        root.setVgap(20);
        root.prefWidthProperty().bind(root.widthProperty());
        root.prefHeightProperty().bind(root.heightProperty());
        root.setPadding(new Insets(20));
        root.getStyleClass().add("Pane");

        Button home = new Button("Home");
        home.setContentDisplay(ContentDisplay.TOP);
        home.setLayoutX(19);
        home.getStyleClass().add("MenuButton");

        Button album = new Button("Album");
        album.setContentDisplay(ContentDisplay.TOP);
        album.setLayoutX(80);
        album.getStyleClass().add("MenuButton");

        Button table = new Button("Table");
        table.setContentDisplay(ContentDisplay.TOP);
        table.setLayoutX(145);
        table.getStyleClass().add("MenuButton");

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

        Button button1 = new Button("Album 1", new ImageView(Peck));
        button1.setContentDisplay(ContentDisplay.TOP);
        root.add(button1, 0, 0);
        button1.getStyleClass().add("FishButton");

        Button button2 = new Button("Album 2", new ImageView(Ali));
        button2.setContentDisplay(ContentDisplay.TOP);
        button2.getStyleClass().add("FishButton");

        Button button3 = new Button("Album 3", new ImageView(Dove));
        button3.setContentDisplay(ContentDisplay.TOP);
        button3.getStyleClass().add("FishButton");

        Button button4 = new Button("Album 4", new ImageView(Peck));
        button4.setContentDisplay(ContentDisplay.TOP);
        button4.getStyleClass().add("FishButton");

        Button button5 = new Button("Album 5", new ImageView(Ali));
        button5.setContentDisplay(ContentDisplay.TOP);
        button5.getStyleClass().add("FishButton");

        Button button6 = new Button("Album 6", new ImageView(Dove));
        button6.setContentDisplay(ContentDisplay.TOP);
        button6.getStyleClass().add("FishButton");

        Button button7 = new Button("Album 7", new ImageView(Ali));
        button7.setContentDisplay(ContentDisplay.TOP);
        button7.getStyleClass().add("FishButton");

        Button button8 = new Button("Album 8", new ImageView(Peck));
        button8.setContentDisplay(ContentDisplay.TOP);
        button8.getStyleClass().add("FishButton");

        Button button9 = new Button("Album 9", new ImageView(Ali));
        button9.setContentDisplay(ContentDisplay.TOP);
        button9.getStyleClass().add("FishButton");

        Button button10 = new Button("Album 10", new ImageView(Dove));
        button10.setContentDisplay(ContentDisplay.TOP);
        button10.getStyleClass().add("FishButton");

        Button button11 = new Button("Album 11", new ImageView(Peck));
        button11.setContentDisplay(ContentDisplay.TOP);
        button11.getStyleClass().add("FishButton");

        Button button12 = new Button("Album 12", new ImageView(Ali));
        button12.setContentDisplay(ContentDisplay.TOP);
        button12.getStyleClass().add("FishButton");

        Button button13 = new Button("Album 13", new ImageView(Dove));
        button13.setContentDisplay(ContentDisplay.TOP);
        button13.getStyleClass().add("FishButton");

        Button button14 = new Button("Album 14", new ImageView(Ali));
        button14.setContentDisplay(ContentDisplay.TOP);
        button14.getStyleClass().add("FishButton");

        Button button15 = new Button("Album 15", new ImageView(Peck));
        button15.setContentDisplay(ContentDisplay.TOP);
        button15.getStyleClass().add("FishButton");

        /*button2.setOnAction((ActionEvent ae) -> Dove());
        button3.setOnAction((ActionEvent ae) -> Ali());
        button4.setOnAction((ActionEvent ae) -> Peck());
        button5.setOnAction((ActionEvent ae) -> Dove());
        button6.setOnAction((ActionEvent ae) -> Ali());
        button7.setOnAction((ActionEvent ae) -> Peck());
        button8.setOnAction((ActionEvent ae) -> Peck());
        button9.setOnAction((ActionEvent ae) -> Dove());
        button10.setOnAction((ActionEvent ae) -> Ali());
        button11.setOnAction((ActionEvent ae) -> Peck());
        button12.setOnAction((ActionEvent ae) -> Dove());
        button13.setOnAction((ActionEvent ae) -> Ali());
        button14.setOnAction((ActionEvent ae) -> Peck());
        button15.setOnAction((ActionEvent ae) -> Peck());
        */

        album.setOnAction((ActionEvent ae) -> Album());
        table.setOnAction((ActionEvent ae) -> Table());
        addAlbum.setOnAction((ActionEvent ae) -> AddAlbum());
        addPhoto.setOnAction((ActionEvent ae) -> AddPhotosScene.AddPhoto());
        addLake.setOnAction((ActionEvent ae) -> AddLake());

        root.add(button2, 1, 0);
        root.add(button3, 2, 0);
        root.add(button4, 0, 1);
        root.add(button5, 1, 1);
        root.add(button6, 2, 1);
        root.add(button7, 0, 2);
        root.add(button8, 1, 2);
        root.add(button9, 2, 2);
        root.add(button10, 0, 3);
        root.add(button11, 1, 3);
        root.add(button12, 2, 3);
        root.add(button13, 0, 4);
        root.add(button14, 1, 4);
        root.add(button15, 2, 4);

        scrollPane.setContent(root);
        Stage stage = new Stage();
        stage.setTitle("Albums");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1420);
        stage.setHeight(750);
        rootPane.getChildren().addAll(root, scrollPane, home, album, addAlbum, addPhoto, table);
        rootPane.getStylesheets().add("Controller/simple.css");
        rootPane.getStyleClass().add("Pane");
        stage.show();


        System.out.println("You have reached the Albums");
    }
}
