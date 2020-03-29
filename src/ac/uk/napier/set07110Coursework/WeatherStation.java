package ac.uk.napier.set07110Coursework;

import java.util.ArrayList;

/**
 *
 * @author Davide Pollicino
 * @summary
 * Weather Station class:
 * 	Contains a 1 to many relationship with the weather readings of each station
 * 	Objects inherit the following variables and methods storing the name, id and coordinates of each station 
 * 	The ArrayList objects store the weather readings of each station
 */

public class WeatherStation {
	private ArrayList<WeatherReading> weatherReadings = new ArrayList<>();
	private int id;
	private String name;
	private double lat;
	private double lon;
	public WeatherStation(int id, String name, double lat, double lon) {
		super();
		this.id = id;
		this.name = name;
		this.lat = lat;
		this.lon = lon;
	}
	public ArrayList<WeatherReading> getWeatherReadings() {
		return weatherReadings;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getLat() {
		return lat;
	}
	public double getLon() {
		return lon;
	}
	@Override
	public String toString() {
		return "WeatherStation [id=" + id + ", name=" + name + ", lat=" + lat + ", lon=" + lon 
				+ " has " + weatherReadings.size() + " readings]";
	}
}