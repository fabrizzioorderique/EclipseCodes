package myAPQuestions;
import java.util.*;
public class WordList {
	private ArrayList myList;
	
	public int numWordsOfLength(int len) {
		int count = 0;
		for(int i = 0; i < myList.size(); i++) {
			String temp = (String) myList.get(i);
			if(temp.length() == len) {
				count++;
			}
		} 
		return count;
	}
	public void removeWordsOfLength(int len) {
		for(int i = 0; i < myList.size(); i++) {
			String temp = (String) myList.get(i);
			if(temp.length() == len) {
				myList.remove(i);
				i = 0;
			}
		} 
	}
}
