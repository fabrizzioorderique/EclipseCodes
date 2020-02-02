package dataLab;
import core.data.*;
import java.util.Scanner;

public class Welcome03 {
   public static void main(String[] args) {
      DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/index.xml").load();
      WeatherStation[] allstns = ds.fetchArray(WeatherStation.class, "station/station_name", 
                                               "station/station_id", "station/state",
                                               "station/latitude", "station/longitude");
      System.out.println("Total stations: " + allstns.length);
      
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter a state abbreviation: ");
      String state = sc.next();
      System.out.println("Stations in " + state);
      double min = allstns[0].getLongitude();
      for (WeatherStation ws : allstns) {
          if (ws.getLongitude() < min) {
             min = ws.getLongitude();
          }
       }
      for (WeatherStation ws : allstns) {
         if (ws.getLongitude() == min) {
            System.out.println(ws.getName()+" is farthest south.");
            break;
         }
      }
   }
}