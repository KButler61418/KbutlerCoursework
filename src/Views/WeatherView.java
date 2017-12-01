package Views;

import javafx.beans.property.SimpleStringProperty;

public class WeatherView {

    private int weatherID;
    private final SimpleStringProperty weatherType;

    public WeatherView(int weatherID, String weatherType) {
        this.weatherID= weatherID;
        this.weatherType = new SimpleStringProperty(weatherType);
    }

    public int getWeatherID() {
        return weatherID;
    }

    public void setWeatherID(int weatherID) {
        this.weatherID = weatherID;
    }

    public String getWeatherType() {
        return weatherType.get();
    }

    public void setWeatherType(String weatherType) { this.weatherType.set(weatherType); }
}
