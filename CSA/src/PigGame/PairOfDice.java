package PigGame;
/**
 * hold characteristics of a pair of dice
 */
public class PairOfDice
{
    public Die d1;
    public Die d2;
    public int d1Val, d2Val;
    public PairOfDice()
    {
        d1 = new Die();
        d2 = new Die();
    }
    public int rollPair(){
        d1Val = d1.roll();
        d2Val = d2.roll();
        return d1Val + d2Val;
    }
}

