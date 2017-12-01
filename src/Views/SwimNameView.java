package Views;

import javafx.beans.property.SimpleStringProperty;

public class SwimNameView {

    private int swimID;
    private final SimpleStringProperty swimName;
    private final SimpleStringProperty lakeName;

    public SwimNameView(int swimID, String swimName, String lakeName) {
        this.swimID= swimID;
        this.swimName = new SimpleStringProperty(swimName);
        this.lakeName = new SimpleStringProperty(lakeName);
    }

    public int getSwimID() {
        return swimID;
    }

    public void setSwimID(int lakebedID) {
        this.swimID = swimID;
    }

    public String getSwimName() { return swimName.get(); }

    public void setSwimName(String swimName) { this.swimName.set(swimName); }

    public String getLakeName() { return lakeName.get(); }

    public void setLakeName(String lakeName) { this.lakeName.set(lakeName); }
}


