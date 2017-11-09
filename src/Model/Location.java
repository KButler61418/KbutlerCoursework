
package Model;

public class Location {

    private int locationID;
    private String lakeName;
    private String street;
    private String town;
    private String county;
    private String postcode;

    public Location(int locationID, String lakeName, String street, String town, String county, String postcode) {
        this.locationID = locationID;
        this.lakeName = lakeName;
        this.street = street;
        this.town = town;
        this.county = county;
        this.postcode = postcode;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getLakeName() {
        return lakeName;
    }

    public void setLakeName(String lakeName) {
        this.lakeName = lakeName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return lakeName;
    }
}
