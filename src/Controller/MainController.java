package Controller;

import Model.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.stage.WindowEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.ArrayList;
import java.util.Optional;



public class MainController extends Application {

    public static DatabaseConnection database;
    private static ListView<Catch> CatchList = new ListView<>();
    private static TableView table = new TableView<>();
    public static TextField txtFieldWeight;
    public static TextField txtFieldLake;
    public static TextField txtFieldSwim;
    public static TextField txtFieldSpecies;
    public static TextField txtFieldRig;
    public static TextField txtFieldBait;
    public static TextField txtFieldDate;
    public static TextField txtFieldTime;
    public static TextField txtFieldDistance;
    public static TextField txtFieldDepth;
    public static TextField txtFieldTemperature;
    public static TextField txtFieldWindDirection;
    public static TextField txtFieldAirPressure;
    public static TextField txtFieldWindSpeed;

    @Override
    public void start(Stage stage) throws Exception {

        try {
            //create the images
            Image Peck = new Image("Gui/20170911_232450.jpg", 400, 300, false, true);  //filename, requestedWidth, requestedHeight, preserveRatio, smooth
            Image Ali = new Image("Gui/20170912_132539.jpg", 400, 300, false, true);
            Image Dove = new Image("Gui/20170912_134249.jpg", 400, 300, false, true);


            ScrollPane scrollPane = new ScrollPane();
            scrollPane.setFitToWidth(true);
            scrollPane.setLayoutY(30);
            scrollPane.setVmax(440);
            scrollPane.setPrefSize(1360, 700);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

            GridPane root = new GridPane();
            root.setHgap(20);
            root.setVgap(20);
            root.prefWidthProperty().bind(root.widthProperty());
            root.prefHeightProperty().bind(root.heightProperty());
            root.setPadding(new Insets(20));

            Button home = new Button("Home");
            home.setContentDisplay(ContentDisplay.TOP);
            home.setLayoutX(20);

            Button album = new Button("Album");
            album.setContentDisplay(ContentDisplay.TOP);
            album.setLayoutX(70);

            Button table = new Button("Table");
            table.setContentDisplay(ContentDisplay.TOP);
            table.setLayoutX(123);

            Button addPhoto = new Button("Add Photo");
            addPhoto.setContentDisplay(ContentDisplay.TOP);
            addPhoto.setLayoutX(170);

            Button addAlbum = new Button("Add Album");
            addAlbum.setContentDisplay(ContentDisplay.TOP);
            addAlbum.setLayoutX(245);

            home.setOnAction((ActionEvent ae) -> Home());
            album.setOnAction((ActionEvent ae) -> Album());
            table.setOnAction((ActionEvent ae) -> Table());
            addAlbum.setOnAction((ActionEvent ae) -> AddAlbum());
            addPhoto.setOnAction((ActionEvent ae) -> AddPhoto());

            Button button1 = new Button("Daryll Peck", new ImageView(Peck));
            button1.setContentDisplay(ContentDisplay.TOP);

            Button button2 = new Button("Ali Hamidi", new ImageView(Ali));
            button2.setContentDisplay(ContentDisplay.TOP);

            Button button3 = new Button("Tom Dove", new ImageView(Dove));
            button3.setContentDisplay(ContentDisplay.TOP);

            Button button4 = new Button("Daryll Peck", new ImageView(Peck));
            button4.setContentDisplay(ContentDisplay.TOP);

            Button button5 = new Button("Ali Hamidi", new ImageView(Ali));
            button5.setContentDisplay(ContentDisplay.TOP);

            Button button6 = new Button("Tom Dove", new ImageView(Dove));
            button6.setContentDisplay(ContentDisplay.TOP);

            Button button7 = new Button("Tom Dove", new ImageView(Ali));
            button7.setContentDisplay(ContentDisplay.TOP);

            Button button8 = new Button("Daryll Peck", new ImageView(Peck));
            button8.setContentDisplay(ContentDisplay.TOP);

            Button button9 = new Button("Ali Hamidi", new ImageView(Ali));
            button9.setContentDisplay(ContentDisplay.TOP);

            Button button10 = new Button("Tom Dove", new ImageView(Dove));
            button10.setContentDisplay(ContentDisplay.TOP);

            Button button11 = new Button("Daryll Peck", new ImageView(Peck));
            button11.setContentDisplay(ContentDisplay.TOP);

            Button button12 = new Button("Ali Hamidi", new ImageView(Ali));
            button12.setContentDisplay(ContentDisplay.TOP);

            Button button13 = new Button("Tom Dove", new ImageView(Dove));
            button13.setContentDisplay(ContentDisplay.TOP);

            Button button14 = new Button("Tom Dove", new ImageView(Ali));
            button14.setContentDisplay(ContentDisplay.TOP);

            Button button15 = new Button("Daryll Peck", new ImageView(Peck));
            button15.setContentDisplay(ContentDisplay.TOP);


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
            rootPane.getStylesheets().add("Gui/simple.css");
            rootPane.getChildren().addAll(root, scrollPane, home, addAlbum, addPhoto, table, album);
            stage.show();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void Home() {

    }


    public static void Album() {
        Image Peck = new Image("Gui/20170911_232450.jpg", 400, 300, false, true);  //filename, requestedWidth, requestedHeight, preserveRatio, smooth
        Image Ali = new Image("Gui/20170912_132539.jpg", 400, 300, false, true);
        Image Dove = new Image("Gui/20170912_134249.jpg", 400, 300, false, true);


        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setLayoutY(30);
        scrollPane.setVmax(440);
        scrollPane.setPrefSize(1360, 700);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        GridPane root = new GridPane();
        root.setHgap(20);
        root.setVgap(20);
        root.prefWidthProperty().bind(root.widthProperty());
        root.prefHeightProperty().bind(root.heightProperty());
        root.setPadding(new Insets(20));

        Button home = new Button("Home");
        home.setContentDisplay(ContentDisplay.TOP);
        home.setLayoutX(20);

        Button album = new Button("Album");
        album.setContentDisplay(ContentDisplay.TOP);
        album.setLayoutX(70);

        Button table = new Button("Table");
        table.setContentDisplay(ContentDisplay.TOP);
        table.setLayoutX(123);

        Button addPhoto = new Button("Add Photo");
        addPhoto.setContentDisplay(ContentDisplay.TOP);
        addPhoto.setLayoutX(170);

        Button addAlbum = new Button("Add Album");
        addAlbum.setContentDisplay(ContentDisplay.TOP);
        addAlbum.setLayoutX(245);


        Button button1 = new Button("Album 1", new ImageView(Peck));
        button1.setContentDisplay(ContentDisplay.TOP);
        button1.setOnAction((ActionEvent ae) -> Peck());
        root.add(button1, 0, 0);

        Button button2 = new Button("Album 2", new ImageView(Ali));
        button2.setContentDisplay(ContentDisplay.TOP);

        Button button3 = new Button("Album 3", new ImageView(Dove));
        button3.setContentDisplay(ContentDisplay.TOP);

        Button button4 = new Button("Album 4", new ImageView(Peck));
        button4.setContentDisplay(ContentDisplay.TOP);

        Button button5 = new Button("Album 5", new ImageView(Ali));
        button5.setContentDisplay(ContentDisplay.TOP);

        Button button6 = new Button("Album 6", new ImageView(Dove));
        button6.setContentDisplay(ContentDisplay.TOP);

        Button button7 = new Button("Album 7", new ImageView(Ali));
        button7.setContentDisplay(ContentDisplay.TOP);

        Button button8 = new Button("Album 8", new ImageView(Peck));
        button8.setContentDisplay(ContentDisplay.TOP);

        Button button9 = new Button("Album 9", new ImageView(Ali));
        button9.setContentDisplay(ContentDisplay.TOP);

        Button button10 = new Button("Album 10", new ImageView(Dove));
        button10.setContentDisplay(ContentDisplay.TOP);

        Button button11 = new Button("Album 11", new ImageView(Peck));
        button11.setContentDisplay(ContentDisplay.TOP);

        Button button12 = new Button("Album 12", new ImageView(Ali));
        button12.setContentDisplay(ContentDisplay.TOP);

        Button button13 = new Button("Album 13", new ImageView(Dove));
        button13.setContentDisplay(ContentDisplay.TOP);

        Button button14 = new Button("Album 14", new ImageView(Ali));
        button14.setContentDisplay(ContentDisplay.TOP);

        Button button15 = new Button("Album 15", new ImageView(Peck));
        button15.setContentDisplay(ContentDisplay.TOP);

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

        home.setOnAction((ActionEvent ae) -> Home());
        album.setOnAction((ActionEvent ae) -> Album());
        table.setOnAction((ActionEvent ae) -> Table());
        addAlbum.setOnAction((ActionEvent ae) -> AddAlbum());
        addPhoto.setOnAction((ActionEvent ae) -> AddPhoto());


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
        rootPane.getStylesheets().add("Gui/simple.css");
        stage.show();


        System.out.println("You have reached the Albums");
    }


    public static void AddAlbum() {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setVmax(700);
        scrollPane.setPrefSize(1360, 700);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);


        VBox AddAlbumView = new VBox(20);
        AddAlbumView.setLayoutX(650);
        AddAlbumView.setLayoutY(20);

        TextField[] AddAlbumInfo = new TextField[7];

        txtFieldDistance = new TextField();
        txtFieldDistance.setPromptText("Album Name: ");
        AddAlbumInfo[0] = txtFieldDistance;

        txtFieldDate = new TextField();
        txtFieldDate.setPromptText("Enter Date: ");
        AddAlbumInfo[1] = txtFieldDate;

        txtFieldWindDirection = new TextField();
        txtFieldWindDirection.setPromptText("Photo 1: ");
        AddAlbumInfo[2] = txtFieldWindDirection;

        txtFieldWindSpeed= new TextField();
        txtFieldWindSpeed.setPromptText("Photo 2:  ");
        AddAlbumInfo[3] = txtFieldWindSpeed;

        txtFieldTime= new TextField();
        txtFieldTime.setPromptText("Photo 3: ");
        AddAlbumInfo[4] = txtFieldTime;

        txtFieldTemperature = new TextField();
        txtFieldTemperature.setPromptText("Photo 4: ");
        AddAlbumInfo[5] = txtFieldTemperature;

        txtFieldAirPressure = new TextField();
        txtFieldAirPressure.setPromptText("Photo 5: ");
        AddAlbumInfo[6] = txtFieldAirPressure;

        AddAlbumView.getChildren().addAll(AddAlbumInfo);


        Button buttonSubmit = new Button("Add Album");
        buttonSubmit.setLayoutX(815);
        buttonSubmit.setLayoutY(380);

        Stage stage = new Stage();
        stage.setTitle("Add Album");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1420);
        stage.setHeight(600);
        rootPane.getStylesheets().add("Gui/simple.css");
        rootPane.getChildren().addAll(scrollPane, AddAlbumView, buttonSubmit);
        stage.show();
    }

    public static void AddPhoto() {

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setVmax(700);
        scrollPane.setPrefSize(1360, 700);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        VBox AddPhotoViewLeft = new VBox(20);
        AddPhotoViewLeft.setLayoutX(650);
        AddPhotoViewLeft.setLayoutY(20);

        VBox AddPhotoViewRight = new VBox(20);
        AddPhotoViewRight.setLayoutX(900);
        AddPhotoViewRight.setLayoutY(20);

        TextField[] AddTagsL = new TextField[7];
        TextField[] AddTagsR = new TextField[7];

        txtFieldWeight = new TextField();
        txtFieldWeight.setPromptText("Enter Weight: ");
        AddTagsL[0] = txtFieldWeight;

        txtFieldLake = new TextField();
        txtFieldLake.setPromptText("Enter Lake: ");
        AddTagsL[1] = txtFieldLake;

        txtFieldSwim = new TextField();
        txtFieldSwim.setPromptText("Enter Weight: ");
        AddTagsL[2] = txtFieldSwim;

        txtFieldSpecies = new TextField();
        txtFieldSpecies.setPromptText("Enter Species: ");
        AddTagsL[3] = txtFieldSpecies;

        txtFieldRig = new TextField();
        txtFieldRig.setPromptText("Enter Rig: ");
        AddTagsL[4] = txtFieldRig;

        txtFieldBait = new TextField();
        txtFieldBait.setPromptText("Enter Bait: ");
        AddTagsL[5] = txtFieldBait;

        txtFieldDepth = new TextField();
        txtFieldDepth.setPromptText("Enter Depth: ");
        AddTagsL[6] = txtFieldDepth;

        txtFieldDistance = new TextField();
        txtFieldDistance.setPromptText("Enter Distance: ");
        AddTagsR[0] = txtFieldDistance;

        txtFieldDate = new TextField();
        txtFieldDate.setPromptText("Enter Date: ");
        AddTagsR[1] = txtFieldDate;

        txtFieldWindDirection = new TextField();
        txtFieldWindDirection.setPromptText("Enter Wind Direction: ");
        AddTagsR[2] = txtFieldWindDirection;

        txtFieldWindSpeed= new TextField();
        txtFieldWindSpeed.setPromptText("Enter Wind Speed; ");
        AddTagsR[3] = txtFieldWindSpeed;

        txtFieldTime= new TextField();
        txtFieldTime.setPromptText("Enter Time: ");
        AddTagsR[4] = txtFieldTime;

        txtFieldTemperature = new TextField();
        txtFieldTemperature.setPromptText("Enter Temperature: ");
        AddTagsR[5] = txtFieldTemperature;

        txtFieldAirPressure = new TextField();
        txtFieldAirPressure.setPromptText("Enter Air Pressure: ");
        AddTagsR[6] = txtFieldAirPressure;

        AddPhotoViewLeft.getChildren().addAll(AddTagsL);
        AddPhotoViewRight.getChildren().addAll(AddTagsR);

        Text locationLabel = new Text("Species: ");
        locationLabel.setLayoutX(760);
        locationLabel.setLayoutY(350);
        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.setLayoutX(815);
        choiceBox.setLayoutY(335);
        choiceBox.getItems().addAll("Mirror Carp", "Common Carp", "Leather Carp", "Koi Carp", "Ghost Carp", "Tench", "Catfish", "Sturgeon", "Bream", "Rudd", "Roach", "Pike", "Perch");

        Button buttonSubmit = new Button("Register");
        buttonSubmit.setLayoutX(815);
        buttonSubmit.setLayoutY(380);

        Stage stage = new Stage();
        stage.setTitle("Add Photo");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1420);
        stage.setHeight(600);
        rootPane.getStylesheets().add("Gui/simple.css");
        rootPane.getChildren().addAll(scrollPane, AddPhotoViewLeft, AddPhotoViewRight, locationLabel, choiceBox, buttonSubmit);
        stage.show();


    }


    public static void Table() {

        table.setPrefSize(900, 450);
        table.setLayoutY(30);

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
        home.setLayoutX(20);
        Button album = new Button("Album");
        album.setContentDisplay(ContentDisplay.TOP);
        album.setLayoutX(70);
        Button tableview = new Button("Table");
        tableview.setContentDisplay(ContentDisplay.TOP);
        tableview.setLayoutX(123);
        Button addPhoto = new Button("Add Photo");
        addPhoto.setContentDisplay(ContentDisplay.TOP);
        addPhoto.setLayoutX(170);
        Button addAlbum = new Button("Add Album");
        addAlbum.setContentDisplay(ContentDisplay.TOP);
        addAlbum.setLayoutX(245);

        home.setOnAction((ActionEvent ae) -> Home());
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
        rootPane.getChildren().addAll(table, home, tableview, addAlbum, addPhoto, album);
        stage.show();
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

        Stage stage = new Stage();
        stage.setTitle("Photo Test!");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1420);
        stage.setHeight(750);
        stage.setOnCloseRequest((WindowEvent we) -> terminate(we));
        rootPane.getChildren().addAll(Image1, boxOfButtons);
        rootPane.getStylesheets().add("Gui/simple.css");
        stage.show();
    }


    public static void Dove() {

        Image image1 = new Image("Gui/20170912_132539.jpg", 650, 525, false, true);
        ImageView Image1 = new ImageView(image1);

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

        Stage stage = new Stage();
        stage.setTitle("Photo Test!");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1420);
        stage.setHeight(750);
        stage.setOnCloseRequest((WindowEvent we) -> terminate(we));
        rootPane.getChildren().addAll(Image1, boxOfButtons);
        rootPane.getStylesheets().add("Gui/simple.css");
        stage.show();
    }

    public static void Ali() {
        Image image1 = new Image("Gui/20170912_134249.jpg", 650, 525, false, true);
        ImageView Image1 = new ImageView(image1);

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

        Stage stage = new Stage();
        stage.setTitle("Photo Test!");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1420);
        stage.setHeight(750);
        rootPane.getChildren().addAll(Image1, boxOfButtons);
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