package Controller;

import Model.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static Views.AddAlbums.AddAlbum;
import static Views.AddLakes.AddLake;
import static Views.AddPhotos.AddPhoto;
import static Views.AlbumView.Album;
import static Views.TableView.Table;


public class MainController extends Application {
    public static DatabaseConnection database;
    private static ListView<Catch> CatchList = new ListView<>();
    private static javafx.scene.control.TableView table = new javafx.scene.control.TableView<>();

    public static void Table() {


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

    @Override
    public void start(Stage stage) throws Exception {

        try {
            //create the images
            Image Peck = new Image("Gui/20170911_232450.jpg", 400, 300, false, true);  //filename, requestedWidth, requestedHeight, preserveRatio, smooth
            Image Ali = new Image("Gui/20170912_132539.jpg", 400, 300, false, true);
            Image Dove = new Image("Gui/20170912_134249.jpg", 400, 300, false, true);
            Image Fish4 = new Image("Gui/20170414_102301 (2).jpg", 400, 300, false, true);
            Image Fish5 = new Image("Gui/20170416_113607 (2).jpg", 400, 300, false, true);
            Image Fish6= new Image("Gui/20170529_000705.jpg", 400, 300, false, true);
            Image Fish7 = new Image("Gui/20170806_081318.jpg", 400, 300, false, true);
            Image Fish8 = new Image("Gui/20170910_021927.jpg", 400, 300, false, true);
            Image Fish9 = new Image("Gui/20170911_193052.jpg", 400, 300, false, true);
            Image Fish10 = new Image("Gui/20170913_165904.jpg", 400, 300, false, true);


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

            home.setOnAction((ActionEvent ae) -> Home());
            album.setOnAction((ActionEvent ae) -> Album());
            table.setOnAction((ActionEvent ae) -> Table());
            addLake.setOnAction((ActionEvent ae) -> AddLake());
            addAlbum.setOnAction((ActionEvent ae) -> AddAlbum());
            addPhoto.setOnAction((ActionEvent ae) -> AddPhoto());

            Button button1 = new Button("35lb 1oz", new ImageView(Peck));
            button1.setContentDisplay(ContentDisplay.TOP);
            button1.getStyleClass().add("FishButton");

            Button button2 = new Button("Fish 2", new ImageView(Ali));
            button2.setContentDisplay(ContentDisplay.TOP);
            button2.getStyleClass().add("FishButton");

            Button button3 = new Button("Fish 3", new ImageView(Dove));
            button3.setContentDisplay(ContentDisplay.TOP);
            button3.getStyleClass().add("FishButton");

            Button button4 = new Button("Fish 4", new ImageView(Fish4));
            button4.setContentDisplay(ContentDisplay.TOP);
            button4.getStyleClass().add("FishButton");

            Button button5 = new Button("Fish 5", new ImageView(Fish5));
            button5.setContentDisplay(ContentDisplay.TOP);
            button5.getStyleClass().add("FishButton");

            Button button6 = new Button("Fish 6", new ImageView(Fish6));
            button6.setContentDisplay(ContentDisplay.TOP);
            button6.getStyleClass().add("FishButton");

            Button button7 = new Button("Fish 7", new ImageView(Fish7));
            button7.setContentDisplay(ContentDisplay.TOP);
            button7.getStyleClass().add("FishButton");

            Button button8 = new Button("Fish 8", new ImageView(Fish8));
            button8.setContentDisplay(ContentDisplay.TOP);
            button8.getStyleClass().add("FishButton");

            Button button9 = new Button("Fish 9", new ImageView(Fish9));
            button9.setContentDisplay(ContentDisplay.TOP);
            button9.getStyleClass().add("FishButton");

            Button button10 = new Button("Fish 10", new ImageView(Fish10));
            button10.setContentDisplay(ContentDisplay.TOP);
            button10.getStyleClass().add("FishButton");

            Button button11 = new Button("Fish 11", new ImageView(Peck));
            button11.setContentDisplay(ContentDisplay.TOP);
            button11.getStyleClass().add("FishButton");

            Button button12 = new Button("Fish 12", new ImageView(Ali));
            button12.setContentDisplay(ContentDisplay.TOP);
            button12.getStyleClass().add("FishButton");

            Button button13 = new Button("Fish 13", new ImageView(Dove));
            button13.setContentDisplay(ContentDisplay.TOP);
            button13.getStyleClass().add("FishButton");

            Button button14 = new Button("Fish 14", new ImageView(Fish4));
            button14.setContentDisplay(ContentDisplay.TOP);
            button14.getStyleClass().add("FishButton");

            Button button15 = new Button("Fish 15", new ImageView(Fish7));
            button15.setContentDisplay(ContentDisplay.TOP);
            button15.getStyleClass().add("FishButton");


            button1.setOnAction((ActionEvent ae) -> Peck());
            button2.setOnAction((ActionEvent ae) -> Dove());
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
            rootPane.getChildren().addAll(root, scrollPane, home, addAlbum, addPhoto,addLake, table, album);
            rootPane.getStyleClass().add("Pane");
            stage.show();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void Home() {

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


    public static void Peck() {

        Image image1 = new Image("Gui/20170911_232450.jpg", 650, 525, false, true);
        ImageView Image1 = new ImageView(image1);

        VBox boxOfButtons = new VBox(20);
        boxOfButtons.setLayoutX(300);
        boxOfButtons.setLayoutY(500);

        Label[] Tags = new Label[11];

        Tags[0] = new Label("Weight: 35lb 0oz");
        Tags[1] = new Label("Lake: Yateley South Lake");
        Tags[2] = new Label("Swim: Car Park 1");
        Tags[3] = new Label("Species: Mirror Carp");
        Tags[4] = new Label("Rig: Chod Rig");
        Tags[5] = new Label("Bait: 12mm Squid Supreme");
        Tags[6] = new Label("Date: 21/09/17");
        Tags[7] = new Label("Time: 12:09");
        Tags[8] = new Label("Lake bed: Gravel");
        Tags[9] = new Label("Depth: 6 ft ");
        Tags[10] = new Label("Weather: Rainy");

        boxOfButtons.getChildren().addAll(Tags);
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

        home.setOnAction((ActionEvent ae) -> Home());
        album.setOnAction((ActionEvent ae) -> Album());
        table.setOnAction((ActionEvent ae) -> Table());
        addLake.setOnAction((ActionEvent ae) -> AddLake());
        addAlbum.setOnAction((ActionEvent ae) -> AddAlbum());
        addPhoto.setOnAction((ActionEvent ae) -> AddPhoto());

        Stage stage = new Stage();
        stage.setTitle("Photo Test!");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1420);
        stage.setHeight(750);
        rootPane.getChildren().addAll(Image1, boxOfButtons, home, addAlbum, addLake, addPhoto, album, table);
        rootPane.getStylesheets().add("Controller/simple.css");
        stage.show();
    }


    public static void Dove() {

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

        Tags[0] = new Label(" Weight: 35lb 0oz");
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

        home.setOnAction((ActionEvent ae) -> Home());
        album.setOnAction((ActionEvent ae) -> Album());
        table.setOnAction((ActionEvent ae) -> Table());
        addLake.setOnAction((ActionEvent ae) -> AddLake());
        addAlbum.setOnAction((ActionEvent ae) -> AddAlbum());
        addPhoto.setOnAction((ActionEvent ae) -> AddPhoto());


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

    public static void Ali() {
        Image image1 = new Image("Gui/20170912_134249.jpg", 650, 525, false, true);
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

        Tags[0] = new Label(" Weight: 35lb 0oz");
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

        home.setOnAction((ActionEvent ae) -> Home());
        album.setOnAction((ActionEvent ae) -> Album());
        table.setOnAction((ActionEvent ae) -> Table());
        addLake.setOnAction((ActionEvent ae) -> AddLake());
        addAlbum.setOnAction((ActionEvent ae) -> AddAlbum());
        addPhoto.setOnAction((ActionEvent ae) -> AddPhoto());

        Stage stage = new Stage();
        stage.setTitle("Photo Test!");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1420);
        stage.setHeight(750);
        rootPane.getChildren().addAll(Image1, boxOfButtons, home, album, addAlbum, addLake, addPhoto, table);
        rootPane.getStylesheets().add("Simple.css");
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