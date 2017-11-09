package Model;

public class Weather {

    private int weatherID;
    private String weatherType;

    public Weather(String weatherType) {
        this.weatherType = weatherType;
    }

    public Weather(int weatherID) {
        this.weatherID = weatherID;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }

    public int getWeatherID() {
        return weatherID;
    }

    public void setWeatherID(int weatherID) {
        this.weatherID = weatherID;
    }

    @Override
    public String toString() {
        return weatherType;
    }
}


