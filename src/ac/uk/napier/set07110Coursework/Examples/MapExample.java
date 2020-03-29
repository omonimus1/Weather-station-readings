package ac.uk.napier.set07110Coursework.Examples;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import mapgui.MapGui;
import weather.WeatherData;
/**
 * Shows usage of MapGui and WeatherData 
 *
 */
public class MapExample {

	public static void main(String[] args) {

		//specify a latitude and longitude 
		double lat1 = 55.932932;
		double lon1 = -3.213520;		

		//Create an instance of the Coordinate class supplied in the JMapViewer library		
		Coordinate coord1 = new Coordinate(lat1, lon1);
		
		//We could view a single coordinate on a map but I have commented this out to plot more than one
		//MapGui.showMap(coord1);
		
		
		// If we wish to plot more than one coordinate on the map then an ArrayList of coordinates is required. 
		// Add the coordinate to a new ArrayList
		ArrayList<Coordinate> coordinates = new ArrayList<>();
		coordinates.add(coord1);
		
		
		//add another coordinate 
//		double lat2 = 55.918017;
//		double lon2 = -3.238892;
		double lat2 = 50.0850;
		double lon2 = -5.2570;
		Coordinate coord2 = new Coordinate(lat2, lon2);
				
		//add to the ArrayList 
		coordinates.add(coord2);		

		//use the method ShowMap which takes the list of coordinates as a parameter and shows them on a map
		MapGui.showMap(coordinates);		
		
		
		JOptionPane.showMessageDialog(null, "Clicking on the map will save a screenshot using the current system time as the filename");
		
		//You can get the the distance between two locations as follows
		double distance = WeatherData.getDistanceBetweenPoints(lat1, lon1, lat2, lon2);
		System.out.println("The distance between location 1 and location 2 is " + distance + "Km");
		
	}

}
