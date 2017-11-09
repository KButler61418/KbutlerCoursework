package Model;

public class Album {
    private int photoID;
    private int albumID;
    private String albumName;


    public Album(int photoID, int albumID, String albumName) {
        this.photoID = photoID;
        this.albumID = albumID;
        this.albumName = albumName;
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

    public String getalbumName() {
        return albumName;
    }

    public void setalbumName(String albumName) {
        this.albumName = albumName;
    }

    @Override
    public String toString() {
        return "INSERT TEXT HERE!! PHOTO CLASS";


    }
}

