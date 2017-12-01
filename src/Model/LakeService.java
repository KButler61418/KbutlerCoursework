/* package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LakeService {

     public static void save(Lake itemToSave, DatabaseConnection database) {

        Lake existingItem = null;
        if (itemToSave.getId() != 0) existingItem = selectById(itemToSave.getId(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Toppings (name, toppingtypeid) VALUES (?, ?)");
                statement.setString(1, itemToSave.getName());
                statement.setInt(2, itemToSave.getToppingTypeId());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Toppings SET name = ?, toppingtypeid = ? WHERE id = ?");
                statement.setString(1, itemToSave.getName());
                statement.setInt(2, itemToSave.getToppingTypeId());
                statement.setInt(3, itemToSave.getId());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }

    }

}

*/