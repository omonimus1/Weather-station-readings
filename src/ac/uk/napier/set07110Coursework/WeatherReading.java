package ac.uk.napier.set07110Coursework;

/**
 *
 * @author Davide Pollicino
 * @summary : Weather Reading class:
 * 	Contains a many to 1 relationship with each weather station
 * 	Objects inherit the following variables and methods storing the weather readings of each station 
 */

public class WeatherReading {
	private WeatherStation weatherStation;
	private int year;
	private int month;
	private int date;
	private int hour;
	private int windSpeed;
	private double temperature;
	public WeatherReading(WeatherStation weatherStation, int year, int month, int date, int hour, int windSpeed, double temperature) {
		super();
		this.weatherStation = weatherStation;
		this.year = year;
		this.month = month;
		this.date = date;
		this.hour = hour;
		this.windSpeed = windSpeed;
		this.temperature = temperature;
	}
	public WeatherStation getWeatherStation() {
		return weatherStation;
	}
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDate() {
		return date;
	}
	public int getHour() {
		return hour;
	}
	public int getWindSpeed() {
		return windSpeed;
	}
	public double getTemperature() {
		return temperature;
	}
	@Override
	public String toString() {
		return "WeatherReading [year=" + year + ", month=" + month + ", date=" + date + ", hour=" + hour
				+ ", windSpeed=" + windSpeed + ", temperature=" + temperature + "]";
	}
}