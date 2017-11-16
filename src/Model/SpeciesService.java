package Model;
import Model.*;
import java.util.ArrayList;
import Model.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SpeciesService {

    public static void selectAll(List<Species> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT speciesType,speciesID FROM Species ORDER BY speciesID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Species(results.getString("speciesType"), results.getInt("speciesID")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }

}