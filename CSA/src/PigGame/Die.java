package PigGame;
/**
 * Die characteristics
 */
import java.util.*;
public class Die
{
    private int numOfFaces;
    private int value;
    public Die(){
       numOfFaces = 6;
    }
    public Die(int faces) {
    	numOfFaces = faces;
    }
    public int rollDie(){
        return (int)(Math.random()*numOfFaces) + 1;
    }
    public void roll() {
    	value = (int)(Math.random()*numOfFaces) + 1;
    }
    public int getVal() {
    	return value;
    }
    public void printRoll() {
    	System.out.println("The dice showed a "+value);
    }
}

