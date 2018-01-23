package Controller;

import Model.*;
import Scenes.AddPhotosScene;
import Scenes.CatchScene;
import Views.LakebedView;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.WindowEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.ArrayList;
import java.util.Optional;

import static Model.CatchService.selectByID2;
import static Scenes.AddAlbumsScene.AddAlbum;
import static Scenes.AddLakesScene.AddLake;
import static Scenes.AlbumScene.Album;
import static Scenes.CatchScene.*;
import static java.lang.Integer.parseInt;


public class MainController extends Application {
    public static DatabaseConnection database;
    private static ListView<Catch> CatchList = new ListView<>();
    private static javafx.scene.control.TableView table = new javafx.scene.control.TableView<>();


    public static void Table() {

        table.setPrefSize(1200, 500);
        table.setLayoutY(80);
        table.setLayoutX(50);

        TableColumn catchIDColumn = new TableColumn<>("CatchID");
        catchIDColumn.setCellValueFactory(new PropertyValueFactory<>("catchID"));
        table.getColumns().add(catchIDColumn);

        TableColumn photoIDColumn = new TableColumn<>("PhotoID");
        photoIDColumn.setCellValueFactory(new PropertyValueFactory<>("photoID"));
        table.getColumns().add(photoIDColumn);

        TableColumn speciesTypeColumn = new TableColumn<>("Species");
        speciesTypeColumn.setCellValueFactory(new PropertyValueFactory<>("speciesType"));
        table.getColumns().add(speciesTypeColumn);

        TableColumn lakeNameColumn = new TableColumn<>("Lake Name");
        lakeNameColumn.setCellValueFactory(new PropertyValueFactory<>("lakeName"));
        table.getColumns().add(lakeNameColumn);

        TableColumn weatherTypeColumn = new TableColumn<>("Weather");
        weatherTypeColumn.setCellValueFactory(new PropertyValueFactory<>("weatherType"));
        table.getColumns().add(weatherTypeColumn);

        TableColumn lakebedTypeColumn = new TableColumn<>("Lakebed");
        lakebedTypeColumn.setCellValueFactory(new PropertyValueFactory<>("lakebedType"));
        table.getColumns().add(lakebedTypeColumn);

        TableColumn swimColumn = new TableColumn<>("Swim");
        swimColumn.setCellValueFactory(new PropertyValueFactory<>("swim"));
        table.getColumns().add(swimColumn);

        TableColumn rigColumn = new TableColumn<>("Rig");
        rigColumn.setCellValueFactory(new PropertyValueFactory<>("rig"));
        table.getColumns().add(rigColumn);

        TableColumn baitColumn = new TableColumn<>("Bait");
        baitColumn.setCellValueFactory(new PropertyValueFactory<>("bait"));
        table.getColumns().add(baitColumn);

        TableColumn weightLBColumn = new TableColumn<>("Weight(lb)");
        weightLBColumn.setCellValueFactory(new PropertyValueFactory<>("weightLB"));
        table.getColumns().add(weightLBColumn);

        TableColumn weightOZColumn = new TableColumn<>("Weight(oz)");
        weightOZColumn.setCellValueFactory(new PropertyValueFactory<>("weightOZ"));
        table.getColumns().add(weightOZColumn);

        TableColumn timeColumn = new TableColumn<>("Time");
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        table.getColumns().add(timeColumn);

        TableColumn depthColumn = new TableColumn<>("Depth");
        depthColumn.setCellValueFactory(new PropertyValueFactory<>("depth"));
        table.getColumns().add(depthColumn);

        TableColumn distanceColumn = new TableColumn<>("Distance");
        distanceColumn.setCellValueFactory(new PropertyValueFactory<>("distance"));
        table.getColumns().add(distanceColumn);

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

        album.setOnAction((ActionEvent ae) -> Album());
        tableview.setOnAction((ActionEvent ae) -> Table());
        addAlbum.setOnAction((ActionEvent ae) -> AddAlbum());
        addPhoto.setOnAction((ActionEvent ae) -> AddPhotosScene.AddPhoto());
        addLake.setOnAction((ActionEvent ae) -> AddLake());

        Stage stage = new Stage();
        stage.setTitle("Table");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1300);
        stage.setHeight(500);
        rootPane.getChildren().addAll(table, tableview, home, addAlbum, addPhoto, album, addLake);
        rootPane.getStyleClass().add("Pane");
        table.getStyleClass().add("Table");
        rootPane.getStylesheets().add("Controller/simple.css");
        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {

        try {

            //create the images
            Image Fish1 = new Image( CatchService.selectPhotoUrl(1, database).toString(), 400, 300, false, true);
            Image Fish2 = new Image(CatchService.selectPhotoUrl(2, database).toString(), 400, 300, false, true);
            Image Fish3= new Image(CatchService.selectPhotoUrl(3, database).toString(), 400, 300, false, true);
            Image Fish4 = new Image(CatchService.selectPhotoUrl(4 , database).toString(), 400, 300, false, true);
            Image Fish5 = new Image(CatchService.selectPhotoUrl(5 , database).toString(), 400, 300, false, true);
            Image Fish6 = new Image(CatchService.selectPhotoUrl(6 , database).toString(), 400, 300, false, true);
            Image Fish7 = new Image(CatchService.selectPhotoUrl(7 , database).toString(), 400, 300, false, true);
            Image Fish8 = new Image(CatchService.selectPhotoUrl(8, database).toString(), 400, 300, false, true);
            Image Fish9 = new Image(CatchService.selectPhotoUrl(9 , database).toString(), 400, 300, false, true);
            Image Fish10 = new Image(CatchService.selectPhotoUrl(10 , database).toString(), 400, 300, false, true);
            Image Fish11 = new Image(CatchService.selectPhotoUrl(11, database).toString(), 400, 300, false, true);
            Image Fish12 = new Image(CatchService.selectPhotoUrl(12, database).toString(), 400, 300, false, true);
            Image Fish13 = new Image(CatchService.selectPhotoUrl(13, database).toString(), 400, 300, false, true);
            Image Fish14 = new Image(CatchService.selectPhotoUrl(14, database).toString(), 400, 300, false, true);
            Image Fish15 = new Image(CatchService.selectPhotoUrl(15, database).toString(), 400, 300, false, true);


            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setFitToWidth(true);
            scrollPane.setLayoutY(30);
            scrollPane.setVmax(700);
            scrollPane.setPrefSize(1400, 900);
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

            album.setOnAction((ActionEvent ae) -> Album());
            table.setOnAction((ActionEvent ae) -> Table());
            addAlbum.setOnAction((ActionEvent ae) -> AddAlbum());
            addPhoto.setOnAction((ActionEvent ae) -> AddPhotosScene.AddPhoto());
            addLake.setOnAction((ActionEvent ae) -> AddLake());

            String[] parts = (selectByID2(1,  database).toString().split(","));
            String[] parts2 = (selectByID2(2,  database).toString().split(","));
            String[] parts3= (selectByID2(3,  database).toString().split(","));
            String[] parts4 = (selectByID2(4,  database).toString().split(","));
            String[] parts5 = (selectByID2(5,  database).toString().split(","));
            String[] parts6 = (selectByID2(6,  database).toString().split(","));
            String[] parts7 = (selectByID2(7,  database).toString().split(","));
            String[] parts8 = (selectByID2(8,  database).toString().split(","));
            String[] parts9 = (selectByID2(9,  database).toString().split(","));
            String[] parts10 = (selectByID2(10,  database).toString().split(","));
            String[] parts11 = (selectByID2(11,  database).toString().split(","));
            String[] parts12 = (selectByID2(12,  database).toString().split(","));
            String[] parts13 = (selectByID2(13,  database).toString().split(","));
            String[] parts14 = (selectByID2(14,  database).toString().split(","));
            String[] parts15 = (selectByID2(15,  database).toString().split(","));

            Button button1 = new Button(parts[8]+ " " + parts[9], new ImageView(Fish1));
            button1.setContentDisplay(ContentDisplay.TOP);
            button1.getStyleClass().add("FishButton");

            Button button2 = new Button(parts2[8]+ " " + parts2[9], new ImageView(Fish2));
            button2.setContentDisplay(ContentDisplay.TOP);
            button2.getStyleClass().add("FishButton");

            Button button3 = new Button(parts3[8]+ " " + parts3[9], new ImageView(Fish3));
            button3.setContentDisplay(ContentDisplay.TOP);
            button3.getStyleClass().add("FishButton");

            Button button4 = new Button(parts4[8]+ " " + parts4[9], new ImageView(Fish4));
            button4.setContentDisplay(ContentDisplay.TOP);
            button4.getStyleClass().add("FishButton");

            Button button5 = new Button(parts5[8]+ " " + parts5[9], new ImageView(Fish5));
            button5.setContentDisplay(ContentDisplay.TOP);
            button5.getStyleClass().add("FishButton");

            Button button6 = new Button(parts6[8]+ " " + parts6[9], new ImageView(Fish6));
            button6.setContentDisplay(ContentDisplay.TOP);
            button6.getStyleClass().add("FishButton");

            Button button7 = new Button(parts7[8]+ " " + parts7[9], new ImageView(Fish7));
            button7.setContentDisplay(ContentDisplay.TOP);
            button7.getStyleClass().add("FishButton");

            Button button8 = new Button(parts8[8]+ " " + parts8[9], new ImageView(Fish8));
            button8.setContentDisplay(ContentDisplay.TOP);
            button8.getStyleClass().add("FishButton");

            Button button9 = new Button(parts9[8]+ " " + parts9[9], new ImageView(Fish9));
            button9.setContentDisplay(ContentDisplay.TOP);
            button9.getStyleClass().add("FishButton");

            Button button10 = new Button(parts10[8]+ " " + parts10[9], new ImageView(Fish10));
            button10.setContentDisplay(ContentDisplay.TOP);
            button10.getStyleClass().add("FishButton");

            Button button11 = new Button(parts11[8]+ " " + parts11[9], new ImageView(Fish11));
            button11.setContentDisplay(ContentDisplay.TOP);
            button11.getStyleClass().add("FishButton");

            Button button12 = new Button(parts12[8]+ " " + parts12[9], new ImageView(Fish12));
            button12.setContentDisplay(ContentDisplay.TOP);
            button12.getStyleClass().add("FishButton");

            Button button13 = new Button(parts13[8]+ " " + parts13[9], new ImageView(Fish13));
            button13.setContentDisplay(ContentDisplay.TOP);
            button13.getStyleClass().add("FishButton");

            Button button14 = new Button(parts14[8]+ " " + parts14[9], new ImageView(Fish14));
            button14.setContentDisplay(ContentDisplay.TOP);
            button14.getStyleClass().add("FishButton");

            Button button15 = new Button(parts15[8]+ " " + parts15[9], new ImageView(Fish15));
            button15.setContentDisplay(ContentDisplay.TOP);
            button15.getStyleClass().add("FishButton");


            button1.setOnAction((ActionEvent ae) -> DisplayCatch1());
            button2.setOnAction((ActionEvent ae) -> DisplayCatch2());
            button3.setOnAction((ActionEvent ae) -> DisplayCatch3());
            button4.setOnAction((ActionEvent ae) -> DisplayCatch4());
            button5.setOnAction((ActionEvent ae) -> DisplayCatch5());
            button6.setOnAction((ActionEvent ae) -> DisplayCatch6());
            button7.setOnAction((ActionEvent ae) -> DisplayCatch7());
            button8.setOnAction((ActionEvent ae) -> DisplayCatch8());
            button9.setOnAction((ActionEvent ae) -> DisplayCatch9());
            button10.setOnAction((ActionEvent ae) -> DisplayCatch10());
            button11.setOnAction((ActionEvent ae) -> DisplayCatch11());
            button12.setOnAction((ActionEvent ae) -> DisplayCatch12());
            button13.setOnAction((ActionEvent ae) -> DisplayCatch13());
            button14.setOnAction((ActionEvent ae) -> DisplayCatch14());
            button15.setOnAction((ActionEvent ae) -> DisplayCatch15());

            root.add(button1, 0, 0);
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

            stage.setTitle("Photo Organiser");
            Pane rootPane = new Pane();
            stage.setScene(new Scene(rootPane));
            stage.setWidth(1300);
            stage.setHeight(500);
            stage.setOnCloseRequest((WindowEvent we) -> terminate(we));
            rootPane.getStylesheets().add("Controller/simple.css");
            rootPane.getChildren().addAll(root, scrollPane, home, addAlbum, addPhoto, addLake, table, album);
            rootPane.getStyleClass().add("Pane");
            stage.show();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
       System.out.println(CatchService.selectPhotoUrl(1,  database));
    }


    private ListView<Catch> CatchPhotoList;


    public static void main(String[] args) {

        database = new DatabaseConnection("src/CourseworkDatabase.db");

        ArrayList<Catch> Catches = new ArrayList<>();
        Catches.clear();
        CatchService.selectAll(Catches, database);
        CatchList.setItems(FXCollections.observableArrayList(Catches));
        table.setItems(FXCollections.observableArrayList(Catches));


       launch(args);

    }

    public static void terminate(WindowEvent we) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("Are you sure you want to quit?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.out.println("Closing application");
            System.exit(0);

        } else {
            we.consume();
        }
    }
}