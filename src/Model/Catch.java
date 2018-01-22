package Model;

public class Catch {

    public int catchID;
    public String photoID;
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
    public int depth;
    public int distance;


    public Catch(int catchID, String photoID, String speciesType, String lakeName, String weatherType, String lakebedType, String swim, String rig, String bait, String date, int weightLB, int weightOZ, String time, int depth, int distance) {
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
        this.Time = time;
        this.depth = depth;
        this.distance = distance;
    }

    public int getCatchID() {
        return catchID;
    }

    public void setCatchID(int catchID) {
        this.catchID = catchID;
    }

    public String getPhotoID() {
        return photoID;
    }

    public void setPhotoID(String photoID) {
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

    public int getWeightLB() { return weightLB; }
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

    public int getDepth() {
        return depth;
    }
    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return  photoID + ",Species: " + speciesType+ ",Lake: " + lakeName +  ",Weather: " + weatherType + ",Lakebed: " + lakebedType +  ",Swim: " + swim + ",Rig: " + rig  + ",Bait: " + bait + ",Weight: " + weightLB + "(lb) "
                + "," + weightOZ + "(oz)"+ ",Time: " + Time  + ",Depth: " + depth + ",Distance: " + distance + ",Date: " + date;
    }
}
