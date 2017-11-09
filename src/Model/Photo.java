
package Model;

public class Photo {

    private String photoLocation;
    private int photoID;
    private int albumID;

    public Photo(String photoLocation, int photoID, int albumID) {
        this.photoLocation = photoLocation;
        this.photoID = photoID;
        this.albumID = albumID;
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

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

}
