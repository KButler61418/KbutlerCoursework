package Model;
import Model.*;

import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import Model.DatabaseConnection;
import javafx.scene.control.Label;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static Controller.MainController.database;

public class CatchService {

    public static void selectAll(List<Catch> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT catchID,photoID,speciesID,lakeID,weatherType,lakebedType,swim,rig,bait,date,weightLB,weightOZ,time,depth,distance FROM catch ORDER BY catchID");
        PreparedStatement statement2 = database.newStatement("SELECT Species.speciesType, Catch.weightLB, Catch.date FROM Species INNER JOIN Catch ON Catch.speciesID = Species.speciesID");
        PreparedStatement statement3 = database.newStatement("SELECT Lake.lakeName, Catch.weightLB FROM Lake INNER JOIN Catch ON Catch.lakeID =  Lake.lakeID;");
        PreparedStatement statement4 = database.newStatement("SELECT Swim.swimName, Catch.weightLB FROM Swim INNER JOIN Catch ON Swim.swimID = Catch.swim;");
        PreparedStatement statement5 = database.newStatement("SELECT Weather.weatherType, Catch.weatherType FROM Weather INNER JOIN Catch ON Weather.weatherID = Catch.weatherType");
        PreparedStatement statement6 = database.newStatement("SELECT Lakebed.LakebedType FROM Lakebed INNER JOIN Catch ON Lakebed.lakebedID = Catch.lakebedType");
        PreparedStatement statement7 = database.newStatement("SELECT Rig.rigType FROM Rig INNER JOIN Catch ON Rig.rigID = Catch.rig");


        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);
                ResultSet results2 = database.executeQuery(statement2);
                ResultSet results3 = database.executeQuery(statement3);
                ResultSet results4 = database.executeQuery(statement4);
                ResultSet results5 = database.executeQuery(statement5);
                ResultSet results6 = database.executeQuery(statement6);
                ResultSet results7 = database.executeQuery(statement7);

                if (results != null) {
                    while (results.next() && results2.next() && results3.next() && results4.next() && results5.next() && results6.next() && results7.next()) {
                        targetList.add(new Catch(results.getInt("catchID"), results.getString("photoID"), results2.getString("speciesType"), results3.getString("lakeName"), results5.getString("weatherType"), results6.getString("lakebedType"), results4.getString("swimName"), results7.getString("rigType"), results.getString("bait"), results.getString("date"), results.getInt("weightLB"), results.getInt("weightOZ"), results.getString("time"), results.getInt("depth"), results.getInt("distance")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }


    public static Photo selectPhotoUrl(int CatchID, DatabaseConnection database) {


        PreparedStatement statement = database.newStatement("SELECT catchID,photoID,speciesID,lakeID,weatherType,lakebedType,swim,rig,bait,date,weightLB,weightOZ,time,depth,distance FROM catch WHERE CatchID = ?");
        PreparedStatement statement2 = database.newStatement("SELECT Photo.photoLocation FROM Photo INNER JOIN Catch ON Catch.photoID = Photo.photoID");
        Photo result = null;
        String Url = null;
        try {

            if (statement != null && statement2 != null) {

                statement.setInt(1, CatchID);

                ResultSet results = database.executeQuery(statement);
                ResultSet results2 = database.executeQuery(statement2);

                if (results != null && results2 != null) {
                    result = new Photo(results2.getString("photoLocation"), results.getInt("photoID"));
                    System.out.println ("Photo Url: " + results2.getString("photoLocation"));
                    Url = results2.getString("photoLocation");
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;

    }

    public static Catch selectByID(int CatchID, DatabaseConnection database) {

        Catch result = null;
        Label[] Tags = new Label[11];

        PreparedStatement statement = database.newStatement("SELECT catchID,photoID,speciesID,lakeID,weatherType,lakebedType,swim,rig,bait,date,weightLB,weightOZ,time,depth,distance FROM catch WHERE CatchID = ?");

        try {
            if (statement != null) {


                statement.setInt(1, CatchID);

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    result = new Catch(results.getInt("catchID"), results.getString("photoID"), results.getString("speciesID"), results.getString("lakeID"), results.getString("weatherType"), results.getString("lakebedType"), results.getString("swim"), results.getString("rig"), results.getString("bait"), results.getString("date"), results.getInt("weightLB"), results.getInt("weightOZ"), results.getString("time"), results.getInt("depth"), results.getInt("distance"));
                    Tags[0] = new Label(" Weight: " + results.getInt("weightLB"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }


    public static void save(Catch itemToSave, DatabaseConnection database) {

        try {
                PreparedStatement statement = database.newStatement("INSERT INTO Catch(photoID, speciesID, lakeID, weatherType, lakebedType, swim, rig, bait, date, weightLB, weightOZ, time, depth, distance) VALUES (?, ?, ? , ? ,?, ?, ?, ? , ? ,?, ?, ?, ? , ?)");

                statement.setString(1, itemToSave.getPhotoID());
                statement.setString(2, itemToSave.getSpeciesType());
                statement.setString(3, itemToSave.getLakeName());
                statement.setString(4, itemToSave.getWeatherType());
                statement.setString(5, itemToSave.getLakebedType());
                statement.setString(6, itemToSave.getSwim());
                statement.setString(7, itemToSave.getRig());
                statement.setString(8, itemToSave.getBait());
                statement.setString(9, itemToSave.getDate());
                statement.setInt(10, itemToSave.getWeightLB());
                statement.setInt(11, itemToSave.getWeightOZ());
                statement.setString(12, itemToSave.getTime());
                statement.setFloat(13, itemToSave.getDepth());
                statement.setFloat(14, itemToSave.getDistance());

                database.executeUpdate(statement);

        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }

    public static void EditPhoto(Catch itemToSave, DatabaseConnection database) {

        Catch existingItem = null;
        if (itemToSave.getCatchID() != 0) {
            existingItem = selectByID(itemToSave.getCatchID(), database);
        }


        try {

            PreparedStatement statement = database.newStatement("UPDATE Catch SET photoID, speciesID, lakeID, weatherType, lakebedType, swim, rig, bait, date, weightLB, weightOZ, time, depth, distance =?  WHERE CatchID = ?");
            statement.setInt(1, itemToSave.getCatchID());
            statement.setString(2, itemToSave.getPhotoID());
            statement.setString(3, itemToSave.getSpeciesType());
            statement.setString(4, itemToSave.getLakeName());
            statement.setString(5, itemToSave.getWeatherType());
            statement.setString(6, itemToSave.getLakebedType());
            statement.setString(7, itemToSave.getSwim());
            statement.setString(8, itemToSave.getRig());
            statement.setString(9, itemToSave.getBait());
            statement.setString(10, itemToSave.getDate());
            statement.setInt(11, itemToSave.getWeightLB());
            statement.setInt(12, itemToSave.getWeightOZ());
            statement.setString(13, itemToSave.getTime());
            statement.setFloat(14, itemToSave.getDepth());
            statement.setFloat(15, itemToSave.getDistance());
            database.executeUpdate(statement);

        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }
}
