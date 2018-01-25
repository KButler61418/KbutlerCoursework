package Model;

public class Lake {
    private String lakeName;
    private int locationID;
    private int lakeID;

    public Lake(String lakeName, int locationID, int lakeID) {
        this.lakeName = lakeName;
        this.locationID = locationID;

    }

    public int getLakeID() {
        return lakeID;
    }

    public void setLakeID(int lakeID) {
        this.lakeID = lakeID;
    }

    public String getLakeName() {
        return lakeName;
    }

    public void setLakeName(String lakeName) {
        this.lakeName = lakeName;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    @Override
    public String toString() {
        return lakeName + locationID + lakeID;
    }
}

