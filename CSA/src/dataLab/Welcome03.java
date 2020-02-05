package dataLab;

import core.data.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Welcome03{
   public static void main(String[] args) {
      DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/index.xml").load();
      ArrayList<WeatherStation> allstns = ds.fetchList(WeatherStation.class, "station/station_name", 
						       "station/station_id", "station/state",
						       "station/latitude", "station/longitude");
      System.out.println("Total stations: " + allstns.size());
      
      /*for getting number of stations in a specific state"
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter a state abbreviation: ");
      String state = sc.next();
      System.out.println("Stations in " + state);
      */
      double minLat = allstns.get(0).getLatitude();
      WeatherStation southernmost = allstns.get(0);
      for (WeatherStation ws : allstns) {
         if (ws.getLatitude() < minLat) {
        	 minLat = ws.getLatitude();
        	 southernmost = ws;
         }
      }
      System.out.println("Furthest south is "+southernmost.getId()+": "+southernmost.getName());
   }
}