package Model;
import Model.*;

import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import Model.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
                    while (results.next() && results2.next() && results3.next()&& results4.next()&& results5.next()&& results6.next()&& results7.next()) {
                        targetList.add(new Catch(results.getInt("catchID"), results.getInt("photoID"), results2.getString("speciesType"), results3.getString("lakeName"), results5.getString("weatherType"), results6.getString("lakebedType"), results4.getString("swimName"), results7.getString("rigType"), results.getString("bait"), results.getString("date"), results.getInt("weightLB"), results.getInt("weightOZ"), results.getString("time"), results.getFloat("depth"), results.getFloat("distance")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }
    public static Catch selectByID(int CatchID, DatabaseConnection database) {

        Catch result = null;

        PreparedStatement statement = database.newStatement("SELECT catchID,photoID,speciesID,lakeID,weatherType,lakebedType,swim,rig,bait,date,weightLB,weightOZ,time,depth,distance FROM catch WHERE CatchID = ?");
        PreparedStatement statement2 = database.newStatement("SELECT Species.speciesType, Catch.weightLB, Catch.date FROM Species INNER JOIN Catch ON Catch.speciesID = Species.speciesID WHERE CatchID = ?");
        PreparedStatement statement3 = database.newStatement("SELECT Lake.lakeName, Catch.weightLB FROM Lake INNER JOIN Catch ON Catch.lakeID =  Lake.lakeID WHERE CatchID = ?");
        PreparedStatement statement4 = database.newStatement("SELECT Swim.swimName, Catch.weightLB FROM Swim INNER JOIN Catch ON Swim.swimID = Catch.swim WHERE CatchID = ?");
        PreparedStatement statement5 = database.newStatement("SELECT Weather.weatherType, Catch.weatherType FROM Weather INNER JOIN Catch ON Weather.weatherID = Catch.weatherType WHERE CatchID = ?");
        PreparedStatement statement6 = database.newStatement("SELECT Lakebed.LakebedType FROM Lakebed INNER JOIN Catch ON Lakebed.lakebedID = Catch.lakebedType WHERE CatchID = ?");
        PreparedStatement statement7 = database.newStatement("SELECT Rig.rigType FROM Rig INNER JOIN Catch ON Rig.rigID = Catch.rig WHERE CatchID = ?");

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
                        result = new Catch(results.getInt("catchID"), results.getInt("photoID"), results2.getString("speciesType"), results3.getString("lakeName"), results5.getString("weatherType"), results6.getString("lakebedType"), results4.getString("swimName"), results7.getString("rigType"), results.getString("bait"), results.getString("date"), results.getInt("weightLB"), results.getInt("weightOZ"), results.getString("time"), results.getFloat("depth"), results.getFloat("distance"));
                    }
                }
            } catch (SQLException resultsException) {
                System.out.println("Database select by id error: " + resultsException.getMessage());
            }

            return result;
        }
    /* public static void save(Catch itemToSave, DatabaseConnection database) {

        Catch existingItem = null;
        if (itemToSave.getCatchID() != 0) existingItem = selectById(itemToSave.getCatchID(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Pizzas (name) VALUES (?)");
                statement.setString(1, itemToSave.getName());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Pizzas SET name = ? WHERE id = ?");
                statement.setString(1, itemToSave.getName());
                statement.setInt(2, itemToSave.getId());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    } */
}