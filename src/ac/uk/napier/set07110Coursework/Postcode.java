package ac.uk.napier.set07110Coursework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Davide Pollicino
 * @summary Postcode class:
 * 	Objects inherit the following variables and methods, storing the postcodes required
 * Requirements:  add -Xmx1024m to the VM arguments using menu run --> run configurations in eclipse
 */

public class Postcode {
	private static ArrayList<Postcode> postcodes; 
	private String name;
	private double lat;
	private double lon;
	public Postcode(String name, double lat, double lon) {
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
	@Override
	public String toString() {
		return "Postcode [name=" + name + ", latitude=" + lat + ", longitude=" + lon + "]";
	}
	public static ArrayList<Postcode> getPostcodes() {
		if(postcodes == null) {
			postcodes = new ArrayList<>();
			try {
				BufferedReader tempReader = new BufferedReader(new FileReader("postcodes.csv"));
				String line = "";
				while((line = tempReader.readLine()) != null) {
					try {
						String[] fields = line.split(",");
						String name = fields[0];
						double lat = Double.parseDouble(fields[1]);
						double lon = Double.parseDouble(fields[2]);
						Postcode postcode = new Postcode(name, lat, lon);
						postcodes.add(postcode);
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
		return postcodes;
	}
}