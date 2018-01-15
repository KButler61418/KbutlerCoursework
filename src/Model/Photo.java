
package Model;

public class Photo {

    private String photoLocation;
    private int photoID;

    public Photo(String photoLocation, int photoID) {
        this.photoLocation = photoLocation;
        this.photoID = photoID;

    }

    public String getPhotoLocation() {
        return photoLocation;
    }
    public void setPhotoLocation(String photoLocation) {
        this.photoLocation = photoLocation;
    }
    public int getPhotoID() {
        return photoID;
    }
    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }
    @Override
    public String toString() {
        return photoLocation ;
    }
}
