package ac.uk.napier.set07110Coursework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Davide Pollicino
 * @author 40401270
 * Requirements:  add -Xmx1024m to the VM arguments using menu run --> run configurations in eclipse

 */

public class Gla {
	private static ArrayList<Gla> gPostcodes;
	private String name;
	private double lat;
	private double lon;
	public Gla(String name, double lat, double lon) {
		super();
		this.name = name;
		this.lat = lat;
		this.lon = lon;
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

	public static ArrayList<Gla> getGPostcodes() {
		if(gPostcodes == null) {
			gPostcodes = new ArrayList<>();
			try {
				BufferedReader tempReader = new BufferedReader(new FileReader("g.csv"));
				String line = "";
				while((line = tempReader.readLine()) != null) {
					try {
						String[] fields = line.split(",");
						String name = fields[0];
						double lat = Double.parseDouble(fields[1]);
						double lon = Double.parseDouble(fields[2]);
						Gla gPostcode = new Gla(name, lat, lon);
						gPostcodes.add(gPostcode);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
				}				
				tempReader.close();
			} catch(FileNotFoundException e ) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		return gPostcodes;
	}
	
	@Override
	public String toString() {
		return "Glasgow [name=" + name + ", lat=" + lat + ", lon=" + lon + "]";
	}
}