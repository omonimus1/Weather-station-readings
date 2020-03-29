package ac.uk.napier.set07110Coursework;

import java.util.HashMap;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import mapgui.MapGui;
/**
 * Davide Pollicino
 * @author 40401270
 *
 * @summary: QUESTION 12

	With this class we are going to know the location with the most consecutive readings of the wind speed  above 50MPH
 * Requirements:  add -Xmx1024m to the VM arguments using menu run --> run configurations in eclipse
 */
public class Answer12 {
	public static void main(String[] args) {
		System.out.println("Question 12");
		HashMap<Integer, WeatherStation> weatherStations = WeatherStationData.getWeatherStations();
		int mostReadings = 0, count;				
		WeatherStation mostConsecutive = null;
		for(WeatherStation tempStation : weatherStations.values()) {
			count = 0;
			for(WeatherReading wr : tempStation.getWeatherReadings()) {
				if(wr.getWindSpeed() > 50) {
					count++;
					if(count > mostReadings) {
						mostReadings = count;
						mostConsecutive = tempStation;
					}
				} else {
					count = 0;
				}
			}			
		}
		System.out.println(mostConsecutive + " has " + mostReadings + " wind speed readings over 50 MPH" );
		Coordinate coordinate = new Coordinate(mostConsecutive.getLat(), mostConsecutive.getLon());
		MapGui.showMap(coordinate);
	}	
}