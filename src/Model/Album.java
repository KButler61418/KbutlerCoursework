package Model;

public class Album {
    private int albumID;
    private String albumName;

    private int photo1ID;
    private int photo2ID;
    private int photo3ID;
    private int photo4ID;
    private int photo5ID;

    public Album(int albumID, String albumName, int photo1ID, int photo2ID, int photo3ID, int photo4ID, int photo5ID) {
        this.albumID = albumID;
        this.albumName = albumName;
        this.photo1ID = photo1ID;
        this.photo2ID = photo2ID;
        this.photo3ID = photo3ID;
        this.photo4ID = photo4ID;
        this.photo5ID = photo5ID;

    }

    public int getAlbumID() { return albumID; }

    public void setAlbumID(int albumID) { this.albumID = albumID; }

    public String getalbumName() { return albumName; }

    public void setalbumName(String albumName) { this.albumName = albumName; }

    public int getPhoto1ID() { return photo1ID; }

    public void setPhoto1ID(int photo1ID) { this.photo1ID = photo1ID;}

    public int getPhoto2ID() { return photo2ID; }

    public void setPhoto2ID(int photo2ID) { this.photo2ID = photo2ID; }

    public int getPhoto3ID() { return photo3ID; }

    public void setPhoto3ID(int photo3ID) { this.photo3ID = photo3ID; }

    public int getPhoto4ID() { return photo4ID; }

    public void setPhoto4ID(int photo4ID) { this.photo4ID = photo4ID; }

    public int getPhoto5ID() { return photo5ID; }

    public void setPhoto5ID(int photo5ID) { this.photo5ID = photo5ID; }


    @Override
    public String toString() {
        return "albumID=" + albumID + ", albumName='" + albumName + '\''; }
}

