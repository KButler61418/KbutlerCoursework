package Views;

import javafx.beans.property.SimpleStringProperty;

public class LakeNameView {

    private int lakeID;
    private int locationID;
    private final SimpleStringProperty lakeName;

    public LakeNameView(int lakeID,int locationID,String lakeName) {
        this.lakeID= lakeID;
        this.locationID= locationID;
        this.lakeName = new SimpleStringProperty(lakeName);
    }

    public int getLakeID() {
        return lakeID;
    }

    public void setLakeID(int lakeID) {
        this.lakeID = lakeID;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getLakeName() { return lakeName.get(); }

    public void setLakeName(String lakeName) { this.lakeName.set(lakeName); }
}


