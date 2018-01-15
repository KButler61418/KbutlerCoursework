package Model;

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


    /*public static void selectAll(List<Album> targetList, DatabaseConnection database) {

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
    */

    public static void saveAlbum(Album itemToSave, DatabaseConnection database) {

        try {
            PreparedStatement statement = database.newStatement("INSERT INTO Album(albumName, photo1ID, photo2ID, photo3ID, photo4ID, photo5ID ) VALUES (?, ?, ? , ? ,?, ?)");

            statement.setString(1, itemToSave.getalbumName());
            statement.setInt(2, itemToSave.getPhoto1ID());
            statement.setInt(3, itemToSave.getPhoto2ID());
            statement.setInt(4, itemToSave.getPhoto3ID());
            statement.setInt(5, itemToSave.getPhoto4ID());
            statement.setInt(6, itemToSave.getPhoto5ID());


            database.executeUpdate(statement);

        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }
}









