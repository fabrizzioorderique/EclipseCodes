package SocialSecurityProject;

public class NameRecord1 {
	private String name;
	private int[] ranks = new int[11];
	
	public NameRecord1(String line) {
		int firstSpace = line.indexOf(" ");
		String ranksAsString = line.substring(firstSpace+1);
		name = line.substring(0,firstSpace);
		ranks = toIntArray(ranksAsString);
	}
	
	public int[] toIntArray(String s) {
		String[] r = s.split(" ");
		int[] answer = new int[r.length];
		for(int i = 0; i < r.length; i++) {
			answer[i] = Integer.parseInt(r[i]);
		}
		return answer;
	}
	
	public String getName() {
		return name;
	}
	
	public int getRank(int decade) {
		int index;
		if(decade >= 1900 && decade <= 2000) {
			index = (decade - 1900)/10;
		}else if(decade >= 0 && decade < 11){
			index = decade;
		}else {
			return -1;
		}
		return ranks[index];
	}
	
	public int bestYear() {
		int min = ranks[0];
		int index = 0;
		for(int n : ranks) {
			if(n < min) min = n;
		}
		for(int i = 0; i < ranks.length; i++) {
			if(ranks[i] == min) return i;
		}
		return -1;
	}
	
	public void printRanks() {
		for(int n : ranks) System.out.print(n+" ");
	}
}
