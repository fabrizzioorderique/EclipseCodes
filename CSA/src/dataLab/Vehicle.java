package dataLab;

public class Vehicle {
	private String make,model,displ,cyl,trans,drive,fuel,certReg,
	stnd,stndDes,underhood,vehClass,airPoll,cityMPG,
	hwyMPG,cmbMPG,smartWay;
	//displ and cyl are actually numbers there are N/A in data 
	private float gGasScore;
	private float combE;
	
	//most generic constructor
	Vehicle(String ma, String m, String d, String c, String t, String dr,
			String f, String ce,String s, String sD, String u,
			String v, String a, String ci, String h, String cm,
			float g,float com,String sm){
		make=ma;model=m;displ=d;cyl=c;trans=t;drive=dr;fuel=f;certReg=ce;
		stnd=s;stndDes=sD;underhood=u;vehClass=v;airPoll=a;cityMPG=ci;
		hwyMPG=h;cmbMPG=cm;gGasScore=g;smartWay=sm;combE=com;
	}
	//specific constructor to only deal with the model + cmbMPG
	public Vehicle(String make, String model, float combE){
		this.make = make;
		this.model = model;
		this.combE = combE;
	}
	
	public String toString() {
		return model+" has "+combE+" combined electricity consumption in kw-hrs/100 miles";
	}
	
	public String getMake() {return make;}
	public String getModel() {return model;}
	public float getCombE() {return combE;}
	
}
