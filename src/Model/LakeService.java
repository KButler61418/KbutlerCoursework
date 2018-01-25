package Model;
import Model.DatabaseConnection;
import Model.Lake;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LakeService {

    public static void saveLake(Lake LakeToSave, DatabaseConnection database) {

        try {
            PreparedStatement statement = database.newStatement("INSERT INTO Lake(lakeName, locationID, lakeID) VALUES (?, ?, ?)");

            statement.setString(1, LakeToSave.getLakeName());
            statement.setInt(2, LakeToSave.getLocationID());
            statement.setInt(3, LakeToSave.getLakeID());

            database.executeUpdate(statement);

        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }

    }
}
