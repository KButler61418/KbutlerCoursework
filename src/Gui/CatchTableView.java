package Gui;

import Model.CatchView;
import javafx.application.Application;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class CatchTableView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ObservableList<CatchView> people = FXCollections.observableArrayList(
                new CatchView("22lb", "8oz", "Mirror"),
                new CatchView("27lb", "10oz", "Common"),
                new CatchView("45lb", "4oz", "Mirror"),
                new CatchView("19lb", "3oz", "Mirror"),
                new CatchView("20lb", "13oz", "Koi")
        );

        TableView table = new TableView<>();
        table.setPrefSize(400, 300);
        table.setItems(people);

        TableColumn weightLBColumn = new TableColumn<>("Weight(lb)");
        weightLBColumn.setCellValueFactory(new PropertyValueFactory<>("weightLB"));
        table.getColumns().add(weightLBColumn);

        TableColumn weightOZColumn = new TableColumn<>("Weight(oz)");
        weightOZColumn.setCellValueFactory(new PropertyValueFactory<>("weightOZ"));
        table.getColumns().add(weightOZColumn);

        TableColumn speciesColumn = new TableColumn<>("Species");
        speciesColumn.setCellValueFactory(new PropertyValueFactory<>("species"));
        table.getColumns().add(speciesColumn);

        stage.setTitle("Photo Organiser");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1300);
        stage.setHeight(500);
        rootPane.getChildren().addAll(table);
        stage.show();

    }
}