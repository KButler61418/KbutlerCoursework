package Model;
public class Species{

    private int speciesID;
    private String speciesType;


    public Species(String speciesType, int speciesID) {
        this.speciesType = speciesType;
        this.speciesID = speciesID;
    }

    public String getSpeciesType() {
        return speciesType;
    }

    public void setSpeciesType(String speciesType) {
        this.speciesType = speciesType;
    }

    public int getSpeciesID() {
        return speciesID;
    }

    public void setSpeciesID(int speciesID) {
        this.speciesID = speciesID;
    }

    @Override
    public String toString() {
        return speciesType;
    }
}

