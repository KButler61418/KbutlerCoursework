package Model;

public class Swim {

    private String lakeName;
    private String swimName;
    private int swimID;

    public Swim(String lakeName, String swimName, int swimID) {
        this.lakeName = lakeName;
        this.swimName = swimName;
        this.swimID = swimID;
    }

    public String getLakeName() {
        return lakeName;
    }

    public void setLakeName(String lakeName) {
        this.lakeName = lakeName;
    }

    public String getSwimName() {
        return swimName;
    }

    public void setSwimName(String swimName) {
        this.swimName = swimName;
    }

    public int getSwimID() {
        return swimID;
    }

    public void setSwimID(int swimID) {
        this.swimID = swimID;
    }

    @Override
    public String toString() {
        return swimName;
    }
}

