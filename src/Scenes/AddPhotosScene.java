package Scenes;

import Model.Catch;
import Model.CatchService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Optional;

import static Controller.MainController.Table;
import static Controller.MainController.database;
import static Scenes.AddAlbumsScene.AddAlbum;
import static Scenes.AlbumScene.Album;
import static java.lang.Integer.parseInt;


public class AddPhotosScene {
    public static TextField txtFieldWeightlb;
    public static TextField txtFieldWeightoz;
    public static TextField txtFieldWeather;
    public static TextField txtFieldLake;
    public static TextField txtFieldSwim;
    public static TextField txtFieldSpecies;
    public static TextField txtFieldBait;
    public static TextField txtFieldTime;
    public static TextField txtFieldDistance;
    public static TextField txtFieldDepth;
    public static ChoiceBox cb;
    public static ChoiceBox rigcb;
    public static ChoiceBox lakebedcb;
    public static ChoiceBox weathercb;
    public static String ChoiceBoxNumber;
    public static String rigBoxNumber;
    public static String lakebedBoxNumber;
    public static String weatherNumber;
    public static String fileAsString;


    public static void AddPhoto() {

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setVmax(700);
        scrollPane.setPrefSize(1360, 700);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.getStyleClass().add("Pane");

        VBox AddPhotoViewLeft = new VBox(20);
        AddPhotoViewLeft.setLayoutX(650);
        AddPhotoViewLeft.setLayoutY(20);

        VBox AddPhotoViewRight = new VBox(20);
        AddPhotoViewRight.setLayoutX(900);
        AddPhotoViewRight.setLayoutY(20);

        TextField[] AddTagsL = new TextField[6];
        TextField[] AddTagsR = new TextField[2];

        txtFieldWeightlb = new TextField();
        txtFieldWeightlb.setPromptText("Enter Weight(lb): ");
        AddTagsL[0] = txtFieldWeightlb;
        txtFieldWeightlb.getStyleClass().add("TextField");

        txtFieldWeightoz = new TextField();
        txtFieldWeightoz.setPromptText("Enter Weight(oz): ");
        AddTagsL[1] = txtFieldWeightoz;
        txtFieldWeightoz.getStyleClass().add("TextField");

        txtFieldLake = new TextField();
        txtFieldLake.setPromptText("Enter Lake: ");
        AddTagsL[2] = txtFieldLake;
        txtFieldLake.getStyleClass().add("TextField");

        txtFieldSwim = new TextField();
        txtFieldSwim.setPromptText("Enter Swim: ");
        AddTagsL[3] = txtFieldSwim;
        txtFieldSwim.getStyleClass().add("TextField");

        txtFieldBait = new TextField();
        txtFieldBait.setPromptText("Enter Bait: ");
        AddTagsL[4] = txtFieldBait;
        txtFieldBait.getStyleClass().add("TextField");

        txtFieldDepth = new TextField();
        txtFieldDepth.setPromptText("Enter Depth: ");
        AddTagsL[5] = txtFieldDepth;
        txtFieldDepth.getStyleClass().add("TextField");

        txtFieldDistance = new TextField();
        txtFieldDistance.setPromptText("Enter Distance: ");
        AddTagsR[0] = txtFieldDistance;
        txtFieldDistance.getStyleClass().add("TextField");

        txtFieldTime = new TextField();
        txtFieldTime.setPromptText("Enter Time: ");
        AddTagsR[1] = txtFieldTime;
        txtFieldTime.getStyleClass().add("TextField");

        AddPhotoViewLeft.getChildren().addAll(AddTagsL);
        AddPhotoViewRight.getChildren().addAll(AddTagsR);

        DatePicker datePicker = new DatePicker();
        datePicker.setLayoutX(900);
        datePicker.setLayoutY(156);
        datePicker.getStyleClass().add("DatePicker");
        datePicker.setOnAction(event -> {
            LocalDate date = datePicker.getValue();
            System.out.println("Selected date: " + date);
        });

        String[] greetings = new String[]{"1", "2", "3","4", "5", "6","7", "8", "9","10", "11", "12"};
            cb = new ChoiceBox(FXCollections.observableArrayList("Mirror Carp", "Common Carp", "Leather Carp", "Koi Carp", "Ghost Carp", "Tench", "Catfish", "Sturgeon", "Bream", "Rudd", "Roach", "Pike", "Perch", "Other"));
            cb.setLayoutX(900);
            cb.setLayoutY(200);
            cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

                public void changed(ObservableValue ov, Number Value, Number new_value) {

                    System.out.println(greetings[new_value.intValue()]);
                    ChoiceBoxNumber = greetings[new_value.intValue()];
                }
            });

        rigcb = new ChoiceBox(FXCollections.observableArrayList("Hair Rig", "Blowback Rig", "Chod Rig", "Hinge Stiff Rig", "Supple Hinge Rig", "Combi Rig", "Zig Rig", "Floater Rig", "Other"));
        rigcb.setLayoutX(900);
        rigcb.setLayoutY(246);
        rigcb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            public void changed(ObservableValue ov, Number Value, Number new_value) {

                System.out.println(greetings[new_value.intValue()]);
                rigBoxNumber = greetings[new_value.intValue()];
            }
        });

        lakebedcb = new ChoiceBox(FXCollections.observableArrayList("Gravel" , "Silt", "Weed", "Clay", "Snags", "Other"));
        lakebedcb.setLayoutX(900);
        lakebedcb.setLayoutY(286);
        lakebedcb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            public void changed(ObservableValue ov, Number Value, Number new_value) {

                System.out.println(greetings[new_value.intValue()]);
                lakebedBoxNumber = greetings[new_value.intValue()];
            }
        });

        weathercb = new ChoiceBox(FXCollections.observableArrayList("Sunny", "Overcast", "Light Rain", "Heavy Rain", "Snowy", "Fog / Mist", "Other"));
        weathercb.setLayoutX(900);
        weathercb.setLayoutY(120);
        weathercb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            public void changed(ObservableValue ov, Number Value, Number new_value) {

                System.out.println(greetings[new_value.intValue()]);
                weatherNumber = greetings[new_value.intValue()];
            }
        });

        Button buttonSubmit = new Button("Add Catch");
        buttonSubmit.setLayoutX(815);
        buttonSubmit.setLayoutY(380);

        Button Addphotofile = new Button("Add Photo");
        Addphotofile.setLayoutX(815);
        Addphotofile.setLayoutY(420);

        Button home = new Button("Home");
        //home.setContentDisplay(ContentDisplay.TOP);
        home.setLayoutX(19);
        home.getStyleClass().add("MenuButton");

        Button album = new Button("Album");
        //album.setContentDisplay(ContentDisplay.TOP);
        album.setLayoutX(80);
        album.getStyleClass().add("MenuButton");

        Button tableview = new Button("Table");
        tableview.setContentDisplay(ContentDisplay.TOP);
        tableview.setLayoutX(145);
        tableview.getStyleClass().add("MenuButton");

        Button addPhoto = new Button("Add Photo");
        //addPhoto.setContentDisplay(ContentDisplay.TOP);
        addPhoto.setLayoutX(205);
        addPhoto.getStyleClass().add("MenuButton");

        Button addAlbum = new Button("Add Album");
        //addAlbum.setContentDisplay(ContentDisplay.TOP);
        addAlbum.setLayoutX(295);
        addAlbum.getStyleClass().add("MenuButton");

        Button addLake = new Button("Add Lake");
        addLake.setContentDisplay(ContentDisplay.TOP);
        addLake.setLayoutX(390);
        addLake.getStyleClass().add("MenuButton");

        //home.setOnAction((ActionEvent ae) -> HomeScene());
        album.setOnAction((ActionEvent ae) -> Album());
        tableview.setOnAction((ActionEvent ae) -> Table());
        addAlbum.setOnAction((ActionEvent ae) -> AddAlbum());
        addPhoto.setOnAction((ActionEvent ae) -> AddPhoto());
        buttonSubmit.setOnAction((ActionEvent ae) -> SubmitPhoto());
        Addphotofile.setOnAction((ActionEvent ae) -> AddPhotofile());

        Stage stage = new Stage();
        stage.setTitle("Add Photo");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1420);
        stage.setHeight(600);
        rootPane.getStylesheets().add("Controller/simple.css");
        rootPane.getChildren().addAll(scrollPane, AddPhotoViewLeft, AddPhotoViewRight, buttonSubmit,
                home, album, addAlbum, addPhoto, tableview, datePicker, addLake, Addphotofile,cb, rigcb, lakebedcb, weathercb);
        rootPane.getStyleClass().add("Pane");
        stage.show();
    }

    private static void SubmitPhoto() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        GetTextfieldEnteries();
        alert.setContentText("This feature is currently unavailable!!");

        alert.showAndWait();
        createNewPizza();
    }

    private static void AddPhotofile() {

        Stage stage = new Stage();

        FileChooser chooser = new FileChooser();
        chooser.setTitle("View Pictures");
        chooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        File file = chooser.showOpenDialog(stage);
        if (file != null) {
            fileAsString = file.toString();
            System.out.println(fileAsString);
        }
        //Use filepath to direct to .jar file

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        GetTextfieldEnteries();
        alert.setContentText("This feature is currently unavailable!!");

        alert.showAndWait();
    }

    private static void GetTextfieldEnteries() {

        System.out.println("Weight(lb)= " + txtFieldWeightlb.getText());
        System.out.println("Weight(oz) = " + txtFieldWeightoz.getText());
        System.out.println("Lake = " + txtFieldLake.getText());
        System.out.println("Swim = " + txtFieldSwim.getText());
        System.out.println("Bait = " + txtFieldBait.getText());
        System.out.println("Depth = " + txtFieldDepth.getText());
        System.out.println("Distance = " + txtFieldDistance.getText());
        System.out.println("Time = " + txtFieldTime.getText());
        System.out.println("Weather = " + weatherNumber);
        System.out.println("Species = " + ChoiceBoxNumber);
        System.out.println("Rig = " + rigBoxNumber);


    }

    public static void createNewPizza() {

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Create new pizza");
        dialog.setHeaderText(null);
        dialog.setContentText("Pizza's name:");
        Optional<String> result = dialog.showAndWait();

        if (result.isPresent() && !result.get().equals("")) {

            int weightLBINT = parseInt(txtFieldWeightlb.getText());
            int weightOZINT = parseInt(txtFieldWeightoz.getText());

            Catch newCatch = new Catch(8, "11", ChoiceBoxNumber,  txtFieldLake.getText(), weatherNumber, lakebedBoxNumber, txtFieldSwim.getText(),  rigBoxNumber,  txtFieldBait.getText(), "12/12/72", parseInt(txtFieldWeightlb.getText()), weightOZINT , "12:22", parseInt(txtFieldDepth.getText()), parseInt(txtFieldDistance.getText()));
            CatchService.save(newCatch, database);
        }

    }



}
