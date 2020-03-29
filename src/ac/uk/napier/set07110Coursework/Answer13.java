package ac.uk.napier.set07110Coursework;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import mapgui.MapGui;
/**
 * @author Davide Pollicino
 *
 * QUESTION 13
 * Requirements:  add -Xmx1024m to the VM arguments using menu run --> run configurations in eclipse
 */
public class Answer13 {
	public static void main(String[] args) {
		System.out.println("Question 13");
		HashMap<Integer, WeatherStation> weatherStations = WeatherStationData.getWeatherStations();
		HashMap<Integer, WeatherStation> stations = new HashMap<>();
		ArrayList<Coordinate> coordinates = new ArrayList<>();
		stations.put(0, weatherStations.get(3318));
		stations.put(1, weatherStations.get(3166));
		int index = 0;
		double[] meanTemp = new double[2];
		for(WeatherStation ws : stations.values()) {
			double sum = 0;
			int counter = 0;
			for(WeatherReading wr : ws.getWeatherReadings()) {
				if(wr.getMonth() == 1) {
					sum = sum + wr.getTemperature();
					counter++;
				}
			}
			meanTemp[index] = sum/counter;
			index++;
			Coordinate coord = new Coordinate(ws.getLat(), ws.getLon());
			coordinates.add(coord);
		}
		if(meanTemp[1] > meanTemp[0]) {
			double temp = meanTemp[0];
			meanTemp[0] = meanTemp[1];
			meanTemp[1] = temp;
		}
		MapGui.showMap(coordinates);
		DecimalFormat df = new DecimalFormat("#.#");
		df.setRoundingMode(RoundingMode.CEILING);
		System.out.println("The difference in mean temperature between " + weatherStations.get(3318).getName() + " and " + weatherStations.get(3166).getName() + " during January is " + df.format(meanTemp[0] - meanTemp[1]) + "�C");
	}	
}