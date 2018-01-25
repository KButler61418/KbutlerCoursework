package Model;

import Model.Album;
import Model.DatabaseConnection;
import java.util.ArrayList;
import Model.Album;
import Model.DatabaseConnection;
import javafx.scene.control.Label;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AlbumService {

    public static void saveAlbum(Album itemToSave, DatabaseConnection database) {

        try {
            PreparedStatement statement = database.newStatement("INSERT INTO Album(albumName, photo1ID, photo2ID, photo3ID, photo4ID, photo5ID ) VALUES (?, ?, ? , ? ,?, ?)");

            statement.setString(1, itemToSave.getalbumName());
            statement.setString(2, itemToSave.getPhoto1ID());
            statement.setString(3, itemToSave.getPhoto2ID());
            statement.setString(4, itemToSave.getPhoto3ID());
            statement.setString(5, itemToSave.getPhoto4ID());
            statement.setString(6, itemToSave.getPhoto5ID());


            database.executeUpdate(statement);

        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }

   public static Album selectByAlbumID(int AlbumID, DatabaseConnection database) {


        Album result = null;

        PreparedStatement statement = database.newStatement("SELECT albumID, albumName, photo1ID, photo2ID, photo3ID, photo4ID, photo5ID FROM Album WHERE AlbumID = ? ");
        PreparedStatement statement2 = database.newStatement("SELECT Photo.photoLocation FROM Photo INNER JOIN Album ON Album.photo1ID = Photo.photoID WHERE albumID = ?");
        PreparedStatement statement3 = database.newStatement("SELECT Photo.photoLocation FROM Photo INNER JOIN Album ON Album.photo2ID = Photo.photoID WHERE albumID = ?");
        PreparedStatement statement4 = database.newStatement("SELECT Photo.photoLocation FROM Photo INNER JOIN Album ON Album.photo3ID = Photo.photoID WHERE albumID = ?");
        PreparedStatement statement5 = database.newStatement("SELECT Photo.photoLocation FROM Photo INNER JOIN Album ON Album.photo4ID = Photo.photoID WHERE albumID = ?");
        PreparedStatement statement6 = database.newStatement("SELECT Photo.photoLocation FROM Photo INNER JOIN Album ON Album.photo5ID = Photo.photoID WHERE albumID = ?");

        try {
            if (statement != null) {


                statement.setInt(1, AlbumID);
                statement2.setInt(1, AlbumID);
                statement3.setInt(1, AlbumID);
                statement4.setInt(1, AlbumID);
                statement5.setInt(1, AlbumID);
                statement6.setInt(1, AlbumID);


                ResultSet results = database.executeQuery(statement);
                ResultSet results2 = database.executeQuery(statement2);
                ResultSet results3 = database.executeQuery(statement3);
                ResultSet results4 = database.executeQuery(statement4);
                ResultSet results5 = database.executeQuery(statement5);
                ResultSet results6 = database.executeQuery(statement6);


                if (results != null) {
                    result = new Album(results.getInt("albumID"), results.getString("albumName"), results2.getString("photoLocation"), results3.getString("photoLocation"), results4.getString("photoLocation"), results5.getString("photoLocation"),results6.getString("photoLocation"));
                }
            }

        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }

    public static Album selectByAlbumID2(int AlbumID, DatabaseConnection database) {


        Album result = null;

        PreparedStatement statement = database.newStatement("SELECT albumID, albumName, photo1ID, photo2ID, photo3ID, photo4ID, photo5ID FROM Album WHERE AlbumID = ? ");


        try {
            if (statement != null) {


                statement.setInt(1, AlbumID);

                ResultSet results = database.executeQuery(statement);


                if (results != null) {
                    result = new Album(results.getInt("albumID"), results.getString("albumName"), results.getString("photo1ID"), results.getString("photo2ID"), results.getString("photo3ID"), results.getString("photo4ID"),results.getString("photo5ID"));
                }
            }

        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }


}









