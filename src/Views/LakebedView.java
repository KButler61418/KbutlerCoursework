package Views;

import javafx.beans.property.SimpleStringProperty;

public class LakebedView {

    private int lakebedID;
    private final SimpleStringProperty lakebedType;

    public LakebedView(int lakebedID, String lakebedType) {
        this.lakebedID= lakebedID;
        this.lakebedType = new SimpleStringProperty(lakebedType);
    }

    public int getLakebedID() {
        return lakebedID;
    }

    public void setLakebedID(int lakebedID) {
        this.lakebedID = lakebedID;
    }

    public String getLakebedType() { return lakebedType.get(); }

    public void setLakebedType(String lakebedType) { this.lakebedType.set(lakebedType); }
}


