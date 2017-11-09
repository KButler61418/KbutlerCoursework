package Gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.util.Optional;


public class PhotoGUI extends Application {

    @Override
    public void start(Stage stage) {

        Image image1 = new Image("Gui/20170911_232450.jpg", 650, 525, false, true);
        ImageView Image1 = new ImageView(image1);

        VBox boxOfButtons = new VBox(20);
        boxOfButtons.setLayoutX(700);
        boxOfButtons.setLayoutY(20);

        Label[] Tags = new Label[11];

        Tags[0] = new Label ("Weight: 33lb 4oz");
        Tags[1] = new Label (" Lake: Yateley South Lake");
        Tags[2] = new Label (" Swim: Car Park 1");
        Tags[3] = new Label (" Species: Mirror Carp");
        Tags[4] = new Label (" Rig: Chod Rig");
        Tags[5] = new Label (" Bait: 12mm Squid Supreme");
        Tags[6] = new Label (" Date: 21/09/17");
        Tags[7] = new Label (" Time: 12:09");
        Tags[8] = new Label (" Lake bed: Gravel");
        Tags[9] = new Label (" Depth: 6 ft ");
        Tags[10] = new Label (" Weather: Rainy");

        boxOfButtons.getChildren().addAll(Tags);

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
    public static void terminate(WindowEvent we)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("Are you sure you want to quit?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            System.out.println("Closing application");
            System.exit(0);

        } else {
            we.consume();
        }
    }


}
