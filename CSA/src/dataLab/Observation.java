package dataLab;

class Observation {
	float temp;	//in F
	int windDir;   // in degrees
	String description;
	
	Observation(String description, float temp, int windDir) {
      this.description = description;
      this.temp = temp;
      this.windDir = windDir;
	}
	/* determine if the temperature of this observation is colder than 'that's */
	public boolean colderThan(Observation that) {
      return this.temp < that.temp;
    } 
	
	public String toString() {	      
		return (temp + " degrees; " + description + " (wind: " + windDir + " degrees)");
	}
}