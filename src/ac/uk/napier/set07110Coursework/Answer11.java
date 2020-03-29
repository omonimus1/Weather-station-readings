package ac.uk.napier.set07110Coursework;

import weather.WeatherData;
import java.util.ArrayList;
import java.util.HashMap;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import mapgui.MapGui;
/**
 *  @author Davide Pollicino
 *
 * @summary
 * QUESTION 11
 * The class Answer 11 allows us to know how many postcodes there are within 10KM radius from AONARCH MOR.
 *
 * Requirements:  add -Xmx1024m to the VM arguments using menu run --> run configurations in eclipse
 */
public class Answer11 {
	public static void main(String[] args)  {
		System.out.println("Question 11");
		HashMap<Integer, WeatherStation> weatherStations = WeatherStationData.getWeatherStations();
		ArrayList<Coordinate> coordinates = new ArrayList<>();
        int count = 0;
        WeatherStation aonachMor = weatherStations.get(3041);
        ArrayList<Postcode> postcodes = Postcode.getPostcodes();
        for(Postcode pc : postcodes) {
    		double dist = WeatherData.getDistanceBetweenPoints(pc.getLat(), pc.getLon(), aonachMor.getLat(), aonachMor.getLon());
    		if(dist <= 10) {
    			count++;
    			//Actually I am getting the lat and lon of the postcodes inside the radius
    			Coordinate coord = new Coordinate(pc.getLat(), pc.getLon());
    			//We are going to add the coordinates of the postcodes within the radius inside the ArrayList "coordinates";
    			coordinates.add(coord);
    		}
        }
        //Print the Map that containes the position of all the postcodes within the Radius and the total number of postcodes that respects this condition
        MapGui.showMap(coordinates);
        System.out.println("There are " + count + " postcodes within the radius of Aonach Mor");
	}
}