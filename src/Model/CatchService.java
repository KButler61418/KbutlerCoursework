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
    public static void JoinCatchSpecies (List <String> Species123List, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT Species.speciesType, Catch.weightLB, Catch.date FROM Species INNER JOIN Catch ON Catch.speciesID = Species.speciesID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);
                ResultSetMetaData rsmd = results.getMetaData();

                String PrintResults = results.toString();


                if (results != null) {
                    while (results.next()) {
                        Species123List.add(new String(results.getString("speciesType")));
                        Species123List.add(new String(results.getString("WeightLB")));
                        System.out.println(statement.toString());
                        System.out.println(rsmd.toString());
                        System.out.println(PrintResults);
                    }
                }

                ArrayList <String> SpeciesType = new ArrayList<String>();
                ArrayList<String> Weight = new ArrayList<String>();

                while (results.next()) {
                    SpeciesType.add(results.getString(1));
                    Weight.add(results.getString(2));
                }

                // finally turn the array lists into arrays - if really needed
                String[] nameArr = new String[SpeciesType.size()];
                nameArr = SpeciesType.toArray(nameArr);

                String[] subjectArr = new String[Weight.size()];
                subjectArr = Weight.toArray(subjectArr);

            }
        } catch (SQLException resultsException) {
            System.out.println("Database select Catch Species error: " + resultsException.getMessage());
        }
    }
}