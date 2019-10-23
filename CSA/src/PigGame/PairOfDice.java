package PigGame;
/**
 * hold characteristics of a pair of dice
 */
public class PairOfDice
{
    private Die d1;
    private Die d2;
    private int d1Val, d2Val;
    public PairOfDice()
    {
        d1 = new Die();
        d2 = new Die();
    }
    public PairOfDice(int faces1, int faces2)
    {
        d1 = new Die(faces1);
        d2 = new Die(faces2);
    }
    public PairOfDice(Die d, Die D)
    {
        d1 = d;
        d2 = D;
    }
    public int rollPair(){
    	d1.roll();
    	d2.roll();
        d1Val = d1.getVal();
        d2Val = d2.getVal();
        return d1Val + d2Val;
    }
    public void roll() {
    	d1Val = d1.rollDie();
        d2Val = d2.rollDie();
    }
    public void printRoll() {
    	System.out.println("The dice showed a " + d1Val + " and a " + d2Val);
    }
    public int getVal(Die d) {
    	return d.getVal();
    }
    public Die getDie1() {
    	return d1;
    }
    public Die getDie2() {
    	return d2;
    }
}