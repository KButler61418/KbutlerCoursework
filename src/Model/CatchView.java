package Model;

import javafx.beans.property.SimpleStringProperty;

public class CatchView {
    private final SimpleStringProperty weightLB;
    private final SimpleStringProperty weightOZ;
    private final SimpleStringProperty species;

    public CatchView(String weightLB, String weightOZ, String species) {
        this.weightLB = new SimpleStringProperty(weightLB);
        this.weightOZ = new SimpleStringProperty(weightOZ);
        this.species = new SimpleStringProperty(species);
    }

    public String getWeightLB() { return weightLB.get(); }
    public void setWeightLB(String weightLB) { this.weightLB.set(weightLB); }

    public String getWeightOZ() { return weightOZ.get(); }
    public void setweightOZ(String weightOZ) { this.weightOZ.set(weightOZ); }

    public String getSpecies() { return species.get(); }
    public void setspecies(String species) { this.species.set(species); }
}