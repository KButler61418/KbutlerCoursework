package Model;
import Model.*;
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

import java.util.ArrayList;

public class CatchTableView extends Application {

    public static DatabaseConnection database;

    public static void main (String[] Args) {

        launch(Args);

        database = new DatabaseConnection("src/CourseworkDatabase.db");

        ArrayList<Catch> testList = new ArrayList<>();

        CatchService.selectAll(testList, database);
        for (Catch c : testList) {
            System.out.println(c);
        }
    }

    @Override
    public void start(Stage stage) {
        /*
        TableView table = new TableView<>();
        table.setPrefSize(850, 450);
        table.setItems(CatchView);

        TableColumn catchIDColumn = new TableColumn<>("CatchID");
        catchIDColumn.setCellValueFactory(new PropertyValueFactory<>("catchID"));
        table.getColumns().add(catchIDColumn);

        TableColumn photoIDColumn = new TableColumn<>("PhotoID");
        photoIDColumn.setCellValueFactory(new PropertyValueFactory<>("photoID"));
        table.getColumns().add(photoIDColumn);

        TableColumn speciesTypeColumn = new TableColumn<>("Species");
        speciesTypeColumn.setCellValueFactory(new PropertyValueFactory<>("species"));
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
        */

        stage.setTitle("Photo Organiser");
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth(1300);
        stage.setHeight(500);
        rootPane.getChildren().addAll();
        stage.show();

    }

}
