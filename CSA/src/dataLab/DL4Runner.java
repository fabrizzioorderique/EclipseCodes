package dataLab;
import core.data.*;
import java.util.ArrayList;

//link excel address -- https://www.fueleconomy.gov/feg/EPAGreenGuide/xls/all_alpha_20.xlsx
//link txt address -- https://www.fueleconomy.gov/feg/EPAGreenGuide/txt/all_alpha_20.txt
//file location -- C:\\Users\\fabri\\OneDrive\\Desktop\\Orderique\\SENIOR YEAR\\AP CSA\\datalab4\\FuelEconomyData.xlsx
public class DL4Runner {
	public static void main(String[] args) {
		String link = "https://www.fueleconomy.gov/feg/EPAGreenGuide/txt/all_alpha_20.txt";
		DataSource ds = DataSource.connectAs("csv",link).load();
		ArrayList<Vehicle> allcars = ds.fetchList(Vehicle.class,"Model","Cmb MPG");
		//ds.printUsageString();
		
		
		//prints out ERROR!
	}	
}
