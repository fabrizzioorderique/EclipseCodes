package PigGame;
/**
 * Die characteristics
 */
import java.util.*;
public class Die
{
    private int numOfFaces;
    public Die()
    {
       numOfFaces = 6;
    }
    public int roll(){
        return (int)(Math.random()*numOfFaces) + 1;
    }
}

