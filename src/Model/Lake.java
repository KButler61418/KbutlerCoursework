package Model;

public class Lake {
    private String lakeName;
    private int locationID;


    public Lake(String lakeName, int locationID) {
        this.lakeName = lakeName;
        this.locationID = locationID;

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
        return lakeName;
    }

}
