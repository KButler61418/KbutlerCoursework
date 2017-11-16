package Model;

public class Album {
    private int photoID;
    private int albumID;
    private String albumName;


    public Album(int albumID, String albumName) {
        this.albumID = albumID;
        this.albumName = albumName;
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
        return "albumID=" + albumID +
                ", albumName='" + albumName + '\'';
    }
}

