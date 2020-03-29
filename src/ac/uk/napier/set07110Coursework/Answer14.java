package ac.uk.napier.set07110Coursework;


import weather.WeatherData;
import java.util.ArrayList;
import org.openstreetmap.gui.jmapviewer.Coordinate;

import mapgui.MapGui;
/**
 * Davide Pollicino
 * @author 40401270
 */
/**
 * QUESTION 14
 *
 * Requirements:  add -Xmx1024m to the VM arguments using menu run --> run configurations in eclipse
 */
public class Answer14 {
	public static void main(String[] args) {
		System.out.println("Question 14");
		ArrayList<Double> closestNeighbour = new ArrayList<>();
		ArrayList<Gla> postcodes = Gla.getGPostcodes();
		int ind = 0;
		double mostIsolatedDistance = 0;
		for(Gla pc : postcodes) {
			double distanceToClosest = 9999999;
			for(Gla pc2 : postcodes) {
				if(WeatherData.getDistanceBetweenPoints(pc.getLat(), pc.getLon(), pc2.getLat(), pc2.getLon()) < distanceToClosest && pc != pc2) {
					distanceToClosest = WeatherData.getDistanceBetweenPoints(pc.getLat(), pc.getLon(), pc2.getLat(), pc2.getLon());
				}
			}
			closestNeighbour.add(distanceToClosest);
		}
		Gla mostIsolated = null;
		for(Gla pc : postcodes) {
			if(closestNeighbour.get(ind) > mostIsolatedDistance) {
				mostIsolatedDistance = closestNeighbour.get(ind);
				mostIsolated = pc;
			}
			ind++;
		}
		Coordinate coord = new Coordinate(mostIsolated.getLat(), mostIsolated.getLon());
		MapGui.showMap(coord);
		System.out.println("The most isolated postcode is " + mostIsolated.getName() + " at " + mostIsolated.getLat() + ", " + mostIsolated.getLon());
	}
}