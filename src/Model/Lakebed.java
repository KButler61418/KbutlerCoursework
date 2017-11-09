package Model;

public class Lakebed {

    private String lakebedType;
    private int lakebedID;

    public Lakebed(String lakebedType, int lakebedID) {
        this.lakebedType = lakebedType;
        this.lakebedID = lakebedID;
    }

    public String getLakebedType() {
        return lakebedType;
    }

    public void setLakebedType(String lakebedType) {
        this.lakebedType = lakebedType;
    }

    public int getLakebedID() {
        return lakebedID;
    }

    public void setLakebedID(int lakebedID) {
        this.lakebedID = lakebedID;
    }

    @Override
    public String toString() {
        return lakebedType;
    }
}
