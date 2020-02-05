package dataLab;

public class Vehicle {
	String model,displ,cyl,trans,drive,fuel,certReg,
	stnd,stndDes,underhood,vehClass,airPoll,cityMPG,
	hwyMPG,cmbMPG,smartWay;
	//displ and cyl are actually numbers there are N/A in data 
	int gGasScore;
	
	//most generic constructor
	Vehicle(String m, String d, String c, String t, String dr,
			String f, String ce,String s, String sD, String u,
			String v, String a, String ci, String h, String cm,
			int g,String sm){
		model=m;displ=d;cyl=c;trans=t;drive=dr;fuel=f;certReg=ce;
		stnd=s;stndDes=sD;underhood=u;vehClass=v;airPoll=a;
		cityMPG=ci;hwyMPG=h;cmbMPG=cm;gGasScore=g;smartWay=sm;
	}
	//specific constructor to only deal with the model + cmbMPG
	Vehicle(String model, String cmbMPG){
		this.model = model;
		this.cmbMPG = cmbMPG;
	}
	
	public String toString() {
		return model+" has "+cmbMPG+" combined miles per gallon";
	}
}
