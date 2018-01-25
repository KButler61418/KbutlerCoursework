package Model;

public class Album {
    private int albumID;
    private String albumName;

    private String photo1ID;
    private String photo2ID;
    private String photo3ID;
    private String photo4ID;
    private String photo5ID;


    public Album(int albumID, String albumName, String photo1ID, String photo2ID, String photo3ID, String photo4ID, String photo5ID) {
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

    public String getPhoto1ID() { return photo1ID; }

    public void setPhoto1ID(String photo1ID) { this.photo1ID = photo1ID;}

    public String getPhoto2ID() { return photo2ID; }

    public void setPhoto2ID(String photo2ID) { this.photo2ID = photo2ID; }

    public String getPhoto3ID() { return photo3ID; }

    public void setPhoto3ID(String photo3ID) { this.photo3ID = photo3ID; }

    public String getPhoto4ID() { return photo4ID; }

    public void setPhoto4ID(String photo4ID) { this.photo4ID = photo4ID; }

    public String getPhoto5ID() { return photo5ID; }

    public void setPhoto5ID(String photo5ID) { this.photo5ID = photo5ID; }

    @Override
    public String toString() {
        return albumID + "," + albumName  + "," + photo1ID + "," + photo2ID + "," + photo3ID + "," + photo4ID + "," + photo5ID;
    }
}

