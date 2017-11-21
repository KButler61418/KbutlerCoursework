package Views;

import Model.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

import static Views.AddAlbums.AddAlbum;
import static Views.AddPhotos.AddPhoto;
import static Views.AlbumView.Album;
import static javafx.application.Application.launch;

public class TableView {

    public static DatabaseConnection database;
    public static ListView<Catch> CatchList = new ListView<>();
    private static javafx.scene.control.TableView table = new javafx.scene.control.TableView<>();



    public static void Table() {

        database = new DatabaseConnection("src/CourseworkDatabase.db");

        table.setPrefSize(1000, 500);
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

        //home.setOnAction((ActionEvent ae) -> Home());
        album.setOnAction((ActionEvent ae) -> Album());
        tableview.setOnAction((ActionEvent ae) -> Table());
        addAlbum.setOnAction((ActionEvent ae) -> AddAlbum());
        addPhoto.setOnAction((ActionEvent ae) -> AddPhoto());

        Stage stage = new Stage();
        stage.setTitle("Table");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1300);
        stage.setHeight(500);
        rootPane.getChildren().addAll(table, home, tableview, addAlbum, addPhoto, album, addLake);
        rootPane.getStyleClass().add("Pane");
        table.getStyleClass().add("Table");
        rootPane.getStylesheets().add("Controller/simple.css");
        stage.show();
    }

    public static void main(String[] args) {

        database = new DatabaseConnection("src/CourseworkDatabase.db");


        ArrayList<Catch> allToppings = new ArrayList<>();

        allToppings.clear();
        CatchService.selectAll(allToppings, database);
        CatchList.setItems(FXCollections.observableArrayList(allToppings));


        table.setItems(FXCollections.observableArrayList(allToppings));
        CatchService.selectAll(allToppings, database);

        ArrayList<Catch> testList = new ArrayList<>();
        for (Catch c : testList) {
            System.out.println(c);
        }

        ArrayList<Album> AlbumList = new ArrayList<>();

        AlbumService.selectAll(AlbumList, database);

        for (Album d : AlbumList) {
            System.out.println(d);
        }

        ArrayList<Species> SpeciesList = new ArrayList<>();

        SpeciesService.selectAll(SpeciesList, database);

        for (Species a : SpeciesList) {
            System.out.println(a);
        }

        launch(args);

    }
}