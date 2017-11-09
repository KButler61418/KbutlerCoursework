

package Model;

public class Rig {

    private String rigType;
    private int rigID;

    public Rig(String rigType, int rigID) {
        this.rigType = rigType;
        this.rigID = rigID;
    }

    public String getRigType() {
        return rigType;
    }

    public void setRigType(String rigType) {
        this.rigType = rigType;
    }

    public int getRigID() {
        return rigID;
    }

    public void setRigID(int rigID) {
        this.rigID = rigID;
    }

    @Override
    public String toString() {
        return rigType;
    }
}
