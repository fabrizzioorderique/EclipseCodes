package dataLab;

import core.data.DataSource;

public class Welcome02_Object {
	public static String path = "http://weather.gov/xml/current_obs/";
	public static void main(String[] args) {
		String id1 = "KCSG";
		String id2 = "KDAB";
		String id3 = "KHVN";
		DataSource ds1 = DataSource.connect(path + id1 + ".xml"); 
		DataSource ds2 = DataSource.connect(path + id2 +".xml");
		DataSource ds3 = DataSource.connect(path + id3 + ".xml");
		ds1.setCacheTimeout(15); 
		ds2.setCacheTimeout(15);
		ds3.setCacheTimeout(15);
		ds1.load();
		ds2.load();
		ds3.load();
		//ds1.printUsageString();
		
		Observation ob1 = ds1.fetch(Observation.class, "weather", "temp_f", "wind_degrees");    
		System.out.println(id1 + ": " + ob1);
		
		Observation ob2 = ds2.fetch(Observation.class, "weather", "temp_f", "wind_degrees");    
		System.out.println(id2 + ": " + ob2);
		
		Observation ob3 = ds3.fetch(Observation.class, "weather", "temp_f", "wind_degrees");    
		System.out.println(id3 + ": " + ob3);
		
		String coldest = "";
		if(ob1.colderThan(ob2)&&ob1.colderThan(ob3)) {coldest = id1;}
		if(ob2.colderThan(ob1)&&ob2.colderThan(ob3)) {coldest = id2;}
		if(ob3.colderThan(ob1)&&ob3.colderThan(ob2)) {coldest = id3;}
		System.out.println("The coldest location is "+coldest);
	}
}
