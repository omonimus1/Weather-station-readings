package ac.uk.napier.set07110Coursework;

import java.util.ArrayList;

import org.openstreetmap.gui.jmapviewer.Coordinate;

import mapgui.MapGui;
import weather.WeatherData;

/**
 * Davide Pollicino
 * @author 40401270
 */
/**
 * QUESTION 15

 * Requirements:  add -Xmx1024m to the VM arguments using menu run --> run configurations in eclipse
 */
public class Answer15 {
	public static void main(String[] args) {
		System.out.println("Question 15");
		ArrayList<Gla> postcodes = Gla.getGPostcodes();
		int amountOfNeighbours = 0;
		Gla mostPopulated = null;
		for(Gla pc : postcodes) {
			int counter = 0;
			for(Gla pc2 : postcodes) {
				if(WeatherData.getDistanceBetweenPoints(pc.getLat(), pc.getLon(), pc2.getLat(), pc2.getLon()) <= 0.3 && pc != pc2)
					counter++;
			}
			if(counter > amountOfNeighbours) {
				amountOfNeighbours = counter;
				mostPopulated = pc;
			}
		}
		Coordinate coord = new Coordinate(mostPopulated.getLat(), mostPopulated.getLon());
		MapGui.showMap(coord);
		System.out.println("The most densely populated postcode is " + mostPopulated.getName() + " with " + amountOfNeighbours + " neighbouring postcodes");
	}	
}