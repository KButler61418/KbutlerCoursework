package Gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
import java.util.Optional;


public class HomeGUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        {
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

                Button home = new Button("HomeScene");
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

                home.setOnAction((ActionEvent ae) -> Peck());
                album.setOnAction((ActionEvent ae) -> Dove());
                table.setOnAction((ActionEvent ae) -> Dove());
                addAlbum.setOnAction((ActionEvent ae) -> Peck());
                addPhoto.setOnAction((ActionEvent ae) -> Dove());

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
                button3.setOnAction((ActionEvent ae) -> Dove());
                button4.setOnAction((ActionEvent ae) -> Peck());
                button5.setOnAction((ActionEvent ae) -> Dove());
                button6.setOnAction((ActionEvent ae) -> Peck());
                button7.setOnAction((ActionEvent ae) -> Peck());
                button8.setOnAction((ActionEvent ae) -> Peck());
                button9.setOnAction((ActionEvent ae) -> Dove());
                button10.setOnAction((ActionEvent ae) -> Dove());
                button11.setOnAction((ActionEvent ae) -> Peck());
                button12.setOnAction((ActionEvent ae) -> Dove());
                button13.setOnAction((ActionEvent ae) -> Peck());
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
                rootPane.getChildren().addAll(root, scrollPane, home, addAlbum, addPhoto, table, album);
                stage.show();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
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
        Tags[10]= new Label("Weather: Rainy");

        boxOfButtons.getChildren().addAll(Tags);

        Stage stage = new Stage();
        stage.setTitle("Photo Test!");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1420);
        stage.setHeight(750);
        stage.setOnCloseRequest((WindowEvent we) -> terminate(we));
        rootPane.getChildren().addAll(Image1, boxOfButtons);
        rootPane.getStylesheets().add("Controller/simple.css");
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
        rootPane.getStylesheets().add("Controller/simple.css");
        stage.show();
    }
}


