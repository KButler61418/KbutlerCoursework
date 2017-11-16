package Model;
import Model.*;
import java.util.ArrayList;
import Model.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CatchService {

    public static void selectAll(List<Catch> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT catchID,photoID,speciesType,lakeName,weatherType,lakebedType,swim,rig,bait,date,weightLB,weightOZ,time,depth,distance FROM catch ORDER BY catchID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Catch(results.getInt("catchID"), results.getInt("photoID"), results.getString("speciesType"), results.getString("lakeName"),results.getString("weatherType"), results.getString("lakebedType"), results.getString("swim"),results.getString("rig"),results.getString("bait"),results.getString("date"),results.getInt("weightLB"), results.getInt("weightOZ"),results.getString("time"),results.getFloat("depth"), results.getFloat("distance")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }

}