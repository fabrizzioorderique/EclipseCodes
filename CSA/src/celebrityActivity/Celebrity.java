package celebrityActivity;

public class Celebrity {
	String name;
	String nationality;	//where they are from
	String occupation;	//singer, writer, actor, etc.
	int netWorth;	//in millions 
	double height;	//in inches
	
	public Celebrity(String name,String nat,String occ,int worth,double h) {
		this.name = name;
		nationality = nat;
		occupation = occ;
		netWorth = worth;
		height = h; 
	}
	public Celebrity(String name) {
		this.name = name;
	}
}
