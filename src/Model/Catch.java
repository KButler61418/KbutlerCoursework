package Model;

public class Catch {

    public int catchID;
    public int photoID;
    public String speciesType;
    public String lakeName;
    public String weatherType;
    public String lakebedType;
    public String swim;
    public String rig;
    public String bait;
    public String date;
    public int weightLB;
    public int weightOZ;
    public String Time;
    public float depth;
    public float distance;


    public Catch(int catchID, int photoID, String speciesType, String lakeName, String weatherType, String lakebedType, String swim, String rig, String bait, String date, int weightLB, int weightOZ, String time, float depth, float distance) {
        this.catchID = catchID;
        this.photoID = photoID;
        this.speciesType = speciesType;
        this.lakeName = lakeName;
        this.weatherType = weatherType;
        this.lakebedType = lakebedType;
        this.swim = swim;
        this.rig = rig;
        this.bait = bait;
        this.date = date;
        this.weightLB = weightLB;
        this.weightOZ = weightOZ;
        Time = time;
        this.depth = depth;
        this.distance = distance;
    }

    public int getCatchID() {
        return catchID;
    }

    public void setCatchID(int catchID) {
        this.catchID = catchID;
    }

    public int getPhotoID() {
        return photoID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

    public String getSpeciesType() {
        return speciesType;
    }

    public void setSpeciesType(String speciesType) {
        this.speciesType = speciesType;
    }

    public String getLakeName() {
        return lakeName;
    }

    public void setLakeName(String lakeName) {
        this.lakeName = lakeName;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }

    public String getLakebedType() {
        return lakebedType;
    }

    public void setLakebedType(String lakebedType) {
        this.lakebedType = lakebedType;
    }

    public String getSwim() {
        return swim;
    }

    public void setSwim(String swim) {
        this.swim = swim;
    }

    public String getRig() {
        return rig;
    }

    public void setRig(String rig) {
        this.rig = rig;
    }

    public String getBait() {
        return bait;
    }

    public void setBait(String bait) {
        this.bait = bait;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getWeightLB() {
        return weightLB;
    }

    public void setWeightLB(int weightLB) {
        this.weightLB = weightLB;
    }

    public int getWeightOZ() {
        return weightOZ;
    }

    public void setWeightOZ(int weightOZ) {
        this.weightOZ = weightOZ;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Catch{" + "catchID=" + catchID + ", photoID=" + photoID + ", speciesType='" + speciesType + '\'' + ", lakeName='" + lakeName + '\'' + ", weatherType='" + weatherType + '\'' + ", lakebedType='" + lakebedType + '\'' + ", swim='" + swim + '\'' + ", rig='" + rig + '\'' + ", bait='" + bait + '\'' + ", weightLB=" + weightLB +
                ", weightOZ=" + weightOZ + ", Time='" + Time + '\'' + ", depth=" + depth + ", distance=" + distance + '}';
    }
}
