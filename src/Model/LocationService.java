package Model;
import Model.*;

import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import Model.DatabaseConnection;
import javafx.scene.control.Label;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static Controller.MainController.database;

public class LocationService {

    public static void saveLocation(Location itemToSave, DatabaseConnection database) {

        try {
            PreparedStatement statement = database.newStatement("INSERT INTO Location(lakeName, street, town, county, postcode) VALUES (?, ?, ?, ? , ?)");

            statement.setString(1, itemToSave.getLakeName());
            statement.setString(2, itemToSave.getStreet());
            statement.setString(3, itemToSave.getTown());
            statement.setString(4, itemToSave.getCounty());
            statement.setString(5, itemToSave.getPostcode());

            database.executeUpdate(statement);

        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }

    }


}
