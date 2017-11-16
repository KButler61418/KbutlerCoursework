import Model.Album;
import Model.DatabaseConnection;
import java.util.ArrayList;
import Model.Album;
import Model.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AlbumService {


    public static void selectAll(List<Album> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT albumID, albumName FROM Album ORDER BY albumID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Album(results.getInt("albumID"), results.getString("albumName")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }

}









