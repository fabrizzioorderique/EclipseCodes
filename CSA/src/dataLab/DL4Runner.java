package dataLab;
import core.data.*;
import java.util.ArrayList;

public class DL4Runner {
	public static void main(String[] args) {
		//data address gotten from www.fueleconomy.gov database
		String link = "https://www.fueleconomy.gov/feg/epadata/vehicles.xml.zip";
		//connects with the data source and loads it
		DataSource ds = DataSource.connect(link);
		ds.load();
		//creates an arrayList containing every single vehicle in the data...
		ArrayList<Tesla> allTeslas = ds.fetchList(Tesla.class,"vehicle/make","vehicle/model","vehicle/combE");
		//...and then filters it to only contain Tesla model cars
		for(int i = 0; i < allTeslas.size(); i++) {
			if(!allTeslas.get(i).getMake().equals("Tesla")) {
				allTeslas.remove(i);
				i--;
			}
		}
		//prints out the Tesla with the least combE
		float min = allTeslas.get(0).getCombE();
		Tesla bestTesla = allTeslas.get(0);
		for(Tesla t : allTeslas) {
			if(t.getCombE()<min) {
				min = t.getCombE();
				bestTesla = t;
			}
		}
		System.out.println("TESLA WITH THE LOWEST COMBINED ELECTRICITY COMBUSTION:");
		System.out.println(bestTesla);
		//prints out every Tesla in data set with its combE
		//for(Tesla t : allTesla) {System.out.println(t);}
		//ds.printUsageString();
	}	
}
x	