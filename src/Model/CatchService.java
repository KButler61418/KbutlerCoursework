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


        PreparedStatement statements = database.newStatement("SELECT Photo.photoLocation, Photo.photoID FROM Photo INNER JOIN Catch ON Catch.photoID = Photo.photoID WHERE catchID = ?");
        Photo PhotoResult = null;
        String Url = null;

        try {
                statements.setInt(1, CatchID);

                ResultSet Photoresults = database.executeQuery(statements);

                if (Photoresults != null) {
                    PhotoResult = new Photo(Photoresults.getString("photoLocation"), Photoresults.getInt("photoID"));
                    System.out.println("Photo Url: " + Photoresults.getString("photoLocation"));
                    Url = Photoresults.getString("photoLocation");
                }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return PhotoResult;

    }


    public static Catch selectByID2(int CatchID, DatabaseConnection database) {

        Catch result = null;
        Label[] Tags = new Label[11];

        PreparedStatement statement = database.newStatement("SELECT catchID,photoID,speciesID,lakeID,weatherType,lakebedType,swim,rig,bait,date,weightLB,weightOZ,time,depth,distance FROM catch WHERE CatchID = ?");
        PreparedStatement statement2 = database.newStatement("SELECT Species.speciesType FROM Species INNER JOIN Catch ON Catch.speciesID = Species.speciesID WHERE catchID = ?");
        PreparedStatement statement3 = database.newStatement("SELECT Lake.lakeName FROM Lake INNER JOIN Catch ON Catch.lakeID =  Lake.lakeID WHERE catchID = ?");
        PreparedStatement statement4 = database.newStatement("SELECT Swim.swimName FROM Swim INNER JOIN Catch ON Swim.swimID = Catch.swim WHERE catchID = ?");
        PreparedStatement statement5 = database.newStatement("SELECT Weather.weatherType FROM Weather INNER JOIN Catch ON Weather.weatherID = Catch.weatherType WHERE catchID = ?");
        PreparedStatement statement6 = database.newStatement("SELECT Lakebed.LakebedType FROM Lakebed INNER JOIN Catch ON Lakebed.lakebedID = Catch.lakebedType WHERE catchID = ?");
        PreparedStatement statement7 = database.newStatement("SELECT Rig.rigType FROM Rig INNER JOIN Catch ON Rig.rigID = Catch.rig WHERE catchID = ?");
        try {
            if (statement != null) {


                statement.setInt(1, CatchID);
                statement2.setInt(1, CatchID);
                statement3.setInt(1, CatchID);
                statement4.setInt(1, CatchID);
                statement5.setInt(1, CatchID);
                statement6.setInt(1, CatchID);
                statement7.setInt(1, CatchID);


                ResultSet results = database.executeQuery(statement);
                ResultSet results2 = database.executeQuery(statement2);
                ResultSet results3 = database.executeQuery(statement3);
                ResultSet results4 = database.executeQuery(statement4);
                ResultSet results5 = database.executeQuery(statement5);
                ResultSet results6 = database.executeQuery(statement6);
                ResultSet results7 = database.executeQuery(statement7);

                if (results != null) {
                    result = new Catch(results.getInt("catchID"), results.getString("photoID"), results2.getString("speciesType"), results3.getString("lakeName"), results5.getString("weatherType"), results6.getString("lakebedType"), results4.getString("swimName"), results7.getString("rigType"), results.getString("bait"), results.getString("date"), results.getInt("weightLB"), results.getInt("weightOZ"), results.getString("time"), results.getInt("depth"), results.getInt("distance"));
                } else{
                    result = new Catch(0, "...", "...", "...", "...", "...", "...", "...", "...", "...", 0, 0, "...", 0, 0);
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

            PreparedStatement statement = database.newStatement("UPDATE Catch SET photoID=?, speciesID=?, lakeID=?, rig = ?  WHERE CatchID = ?");
            statement.setInt(5, itemToSave.getCatchID());
            statement.setString(1, itemToSave.getPhotoID());
            statement.setString(2, itemToSave.getSpeciesType());
            statement.setString(3, itemToSave.getLakeName());
            //statement.setString(5, itemToSave.getWeatherType());
            //statement.setString(6, itemToSave.getLakebedType());
            //statement.setString(7, itemToSave.getSwim());
            statement.setString(4, itemToSave.getRig());
            //statement.setString(9, itemToSave.getBait());
            //statement.setString(10, itemToSave.getDate());
            //statement.setInt(11, itemToSave.getWeightLB());
            //statement.setInt(12, itemToSave.getWeightOZ());
            //statement.setString(13, itemToSave.getTime());
            //statement.setFloat(14, itemToSave.getDepth());
            //statement.setFloat(15, itemToSave.getDistance());
            database.executeUpdate(statement);

        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }

    public static Catch selectByPhotoID(int PhotoID, DatabaseConnection database) {

        Catch result = null;
        Label[] Tags = new Label[11];

        PreparedStatement statement = database.newStatement("SELECT catchID,photoID,speciesID,lakeID,weatherType,lakebedType,swim,rig,bait,date,weightLB,weightOZ,time,depth,distance FROM catch WHERE PhotoID = ?");
        PreparedStatement statement2 = database.newStatement("SELECT Species.speciesType FROM Species INNER JOIN Catch ON Catch.speciesID = Species.speciesID WHERE photoID = ?");
        PreparedStatement statement3 = database.newStatement("SELECT Lake.lakeName FROM Lake INNER JOIN Catch ON Catch.lakeID =  Lake.lakeID WHERE photoID = ?");
        PreparedStatement statement4 = database.newStatement("SELECT Swim.swimName FROM Swim INNER JOIN Catch ON Swim.swimID = Catch.swim WHERE photoID = ?");
        PreparedStatement statement5 = database.newStatement("SELECT Weather.weatherType FROM Weather INNER JOIN Catch ON Weather.weatherID = Catch.weatherType WHERE photoID = ?");
        PreparedStatement statement6 = database.newStatement("SELECT Lakebed.LakebedType FROM Lakebed INNER JOIN Catch ON Lakebed.lakebedID = Catch.lakebedType WHERE photoID = ?");
        PreparedStatement statement7 = database.newStatement("SELECT Rig.rigType FROM Rig INNER JOIN Catch ON Rig.rigID = Catch.rig WHERE photoID = ?");
        try {
            if (statement != null) {


                statement.setInt(1, PhotoID);
                statement2.setInt(1, PhotoID);
                statement3.setInt(1, PhotoID);
                statement4.setInt(1, PhotoID);
                statement5.setInt(1, PhotoID);
                statement6.setInt(1, PhotoID);
                statement7.setInt(1, PhotoID);


                ResultSet results = database.executeQuery(statement);
                ResultSet results2 = database.executeQuery(statement2);
                ResultSet results3 = database.executeQuery(statement3);
                ResultSet results4 = database.executeQuery(statement4);
                ResultSet results5 = database.executeQuery(statement5);
                ResultSet results6 = database.executeQuery(statement6);
                ResultSet results7 = database.executeQuery(statement7);

                if (results != null) {
                    result = new Catch(results.getInt("catchID"), results.getString("photoID"), results2.getString("speciesType"), results3.getString("lakeName"), results5.getString("weatherType"), results6.getString("lakebedType"), results4.getString("swimName"), results7.getString("rigType"), results.getString("bait"), results.getString("date"), results.getInt("weightLB"), results.getInt("weightOZ"), results.getString("time"), results.getInt("depth"), results.getInt("distance"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }
}
