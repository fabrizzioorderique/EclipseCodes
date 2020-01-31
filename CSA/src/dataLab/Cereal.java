package dataLab;
import java.util.*;
public class Cereal{
	private String name, type;
	private int calories, protein, fat, sodium, sugar, potassium, vitamins, shelf;
	private double carbs, fiber, weight, cups, rating;
	
	public Cereal(){
		name = "Generic";
		type = "A";
		calories=protein=fat=sodium=sugar=potassium=vitamins=shelf=1;
		carbs = weight = cups = rating = 1.0;
	}
	public Cereal(String n,String t,int c,int pro,int f,int sod,int s,int pot,
				  int v,int she, double car,double fib,double w,double cup, double rat){
		name = n;
		type = t;
		calories = c;
		protein = pro;
		fat = f;
		sodium = sod;
		carbs = car;
		fiber = fib;
		sugar = s;
		potassium = pot; 
		vitamins  = v;
		shelf = she;
		weight  = w;
		cups = cup;
		rating = rat;
	}
	//toString method
	public String toString() {
		return name+" has "+calories+" calories and a has a rating of "+rating;
	}
	
	//getters
	public String getName() {return name;}
	public String getType() {return type;}
	public int getCalories() {return calories;}
	public int getProtein() {return protein;}
	public int getFat() {return fat;}
	public int getSodium() {return sodium;}
	public int getSugar() {return sugar;}
	public int getPotassium() {return potassium;}
	public int getVitamins() {return vitamins;}
	public int getShelf() {return shelf;}
	public double getCarbs() {return carbs;}
	public double getFiber() {return fiber;}
	public double getWeight() {return weight;}
	public double getCups() {return cups;}
	public double getRating() {return rating;}
	//setters
	public void setName(String n) {name = n;}
	public void setType(String n) {type = n;}
	public void setCalories(int c) {calories=c;}
	public void setProtein(int p) {protein=p;}
	public void setFat(int f) {fat=f;}
	public void setSodium(int s) {sodium=s;}
	public void setSugar(int s) {sugar=s;}
	public void setPotassium(int p) {potassium=p;}
	public void setVitamins(int v) {vitamins=v;}
	public void setShelf(int s) {shelf=s;}
	public void setCarbs(double c) {carbs=c;}
	public void setFiber(double f) {fiber=f;}
	public void setWeight(double w) {weight=w;}
	public void setCups(double c) {cups=c;}
	public void setRating(double r) {rating=r;}
	
	//main method to test cereal class
	public static void main(String[] args) {
		//arrayList was imported above*
		ArrayList<Cereal> cereals = new ArrayList<>();
		for (int i = 0; i < 10; i++) {cereals.add(new Cereal());}
		Cereal myFav = new Cereal("Cheerios","C",110,6,2,290,2,17,1,105,25,
				   1,1,1.25,50.764999);
		//print statements for testing
		System.out.println(cereals.get(6).getCalories());
		cereals.get(0).setFiber(7);
		System.out.println(myFav);
		System.out.println(cereals.get(0).getFiber());
	}
}
