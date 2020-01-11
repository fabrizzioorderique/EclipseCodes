package SocialSecurityProject;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//"C:\\Users\\3223027017\\Documents\\PieroBio.txt"
//"C:\\Users\\3223027017\\Documents\\namedata.txt"
//"C:\\Users\\fabri\\OneDrive\\Documents\\DasText\\familydata.txt"
//"C:\\Users\\fabri\\OneDrive\\Documents\\DasText\\namedata.txt"

public class NameSurfer1 {
	static ArrayList<NameRecord1> nameData = new ArrayList<>(11);
	public static void main(String[] args) throws Exception{
		File file = new File("C:\\Users\\fabri\\OneDrive\\Documents\\DasText\\namedata.txt");
		createData(file);
	}
	public static void createData(File f) throws Exception {
		String currentLine;
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine()){ 
			currentLine = sc.nextLine();
            nameData.add(new NameRecord1(currentLine));
        }
		//testArrayData(nameData);
	}
	public static void testArrayData(ArrayList<NameRecord1> arr) {
		for(NameRecord1 n : arr) {
			System.out.print(n.getName()+" ");
			n.printRanks();
			System.out.println();
		}
	}
			
}
