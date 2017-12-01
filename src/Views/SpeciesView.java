package Views;

import javafx.beans.property.SimpleStringProperty;

public class SpeciesView {

    private int speciesID;
    private final SimpleStringProperty speciesType;

    public SpeciesView(int speciesID, String speciesType) {
        this.speciesID= speciesID;
        this.speciesType = new SimpleStringProperty(speciesType);
    }

    public int getSpeciesID() {
        return speciesID;
    }

    public void setSpeciesID(int speciesID) {
        this.speciesID = speciesID;
    }

    public String getSpeciesType() { return speciesType.get(); }

    public void setSpeciesType(String speciesType) { this.speciesType.set(speciesType); }
}



