
import Model.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;

public class main extends Application {

    public static DatabaseConnection database;
    private static ListView<Catch> CatchList= new ListView<>();
    private static TableView table = new TableView<>();


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

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1024, 768);
        scene.getStylesheets().add("Resources/stylesheet.css");
        stage.setTitle("Pizza Project");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        VBox rightPane = new VBox(20);
        rightPane.setPadding(new Insets(30));
        Label toppingHeading = new Label("Available Toppings:");
        toppingHeading.getStyleClass().add("heading");
        rightPane.getChildren().add(toppingHeading);
        CatchList.setPrefWidth(280);
        CatchList.setPrefHeight(500);
        rightPane.getChildren().add(CatchList);
        root.setRight(rightPane);
        rightPane.setAlignment(Pos.TOP_CENTER);
        BorderPane.setAlignment(rightPane, Pos.CENTER_RIGHT);

        table.setPrefSize(850, 450);
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


        stage.setTitle("Photo Organiser");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1300);
        stage.setHeight(500);
        rootPane.getChildren().addAll(table);
        stage.show();
    }
}


