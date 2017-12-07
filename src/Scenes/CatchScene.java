package Scenes;

import Model.Catch;
import Model.CatchService;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static Controller.MainController.Table;
import static Controller.MainController.database;
import static Model.CatchService.selectByID;
import static Scenes.AddAlbumsScene.AddAlbum;
import static Scenes.AddLakesScene.AddLake;
import static Scenes.AlbumScene.Album;

public class CatchScene {

    public static void CatchDisplay() {

        Image image1 = new Image("Gui/20170912_132539.jpg", 650, 525, false, true);
        ImageView Image1 = new ImageView(image1);

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

        VBox boxOfButtons = new VBox(20);
        boxOfButtons.setLayoutX(700);
        boxOfButtons.setLayoutY(20);

        Label[] Tags = new Label[11];

        System.out.println("Photo!!");

        System.out.println(selectByID(1,  database));

        Tags[0] = new Label(" Weight: " + selectByID(1,database));
        Tags[1] = new Label(" Lake: Yateley South Lake");
        Tags[2] = new Label(" Swim: Car Park 1");
        Tags[3] = new Label(" Species: Mirror Carp");
        Tags[4] = new Label(" Rig: Chod Rig");
        Tags[5] = new Label(" Bait: 12mm Squid Supreme");
        Tags[6] = new Label(" Date: 21/09/17");
        Tags[7] = new Label(" Time: 12:09");
        Tags[8] = new Label(" Lake bed: Gravel");
        Tags[9] = new Label(" Depth: 6 ft ");
        Tags[10] = new Label(" Weather: Rainy");

        boxOfButtons.getChildren().addAll(Tags);

        album.setOnAction((ActionEvent ae) -> Album());
        table.setOnAction((ActionEvent ae) -> Table());
        addAlbum.setOnAction((ActionEvent ae) -> AddAlbum());
        addPhoto.setOnAction((ActionEvent ae) -> AddPhotosScene.AddPhoto());
        addLake.setOnAction((ActionEvent ae) -> AddLake());


        Stage stage = new Stage();
        stage.setTitle("Photo Test!");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1420);
        stage.setHeight(750);
        rootPane.getChildren().addAll(Image1, boxOfButtons, home, album, addPhoto, addAlbum, addLake, table);
        rootPane.getStylesheets().add("Controller/simple.css");
        stage.show();
    }
}


