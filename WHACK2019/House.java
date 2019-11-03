import java.util.Hashtable;
import javafx.util.Pair;

/**
 * Creates a new house block plus blocks of updated information
 * Each house block contains it's current value and various other key details
 * @author Hannah Whellan,Olivia Grace Reblando, Lian Bourret
 */
public class House
{
    private String name;
    private float value;
    private Person owner;
    private int tokensLeft;
    private final int TOKENTOTAL;
    private Block genesisBlock;
    private float percentOwnership;

    /**
     * Constructor for objects of class House being initially created.
     */
    public House(String nm, float intialValue, Person ogOwner, int totalShares)
    {
        name = nm;
        this.value = intialValue;
        this.owner = ogOwner;
        owner.setTokens(totalShares);
        TOKENTOTAL = totalShares;
        owner.getWallet().put(this,new Pair (totalShares,this.findPercentOwnership()));
        tokensLeft = totalShares;
        genesisBlock = new Block ("Property " +nm+ " Created", "000", this);
        percentOwnership = findPercentOwnership();
    }
    
    /**
     * Scaling factor to calculate token's value in property
     */
    public float findPercentOwnership(){
        return ((float)(100/TOKENTOTAL))/100;
    }
    
    
    /**
     * When the value of the house increases a block is created and 
     * variables are updated
     */
    public Block increaseValue(double increase, String previousHash)
    {
        if (increase < 0){
            System.out.println("Negative input");
            return null;
        }
        
        value += increase;
        String msg = "The new house value is " + String.valueOf(value);
        Block houseBlock = new Block(msg, previousHash, this);
        
        return houseBlock;
    }

    /**
     * When the value of the house decreases a block is 
     * created and variables are updated
     */
    public Block decreaseValue(double decrease, String previousHash)
    {
        if (decrease < 0){
            System.out.println("Negative input");
            return null;
        }
        
        value -= decrease;
        String msg = "The new house value is " + String.valueOf(value);
        Block houseBlock = new Block(msg, previousHash, this);
        return houseBlock;
    }

    public double getValue(){
        return value;
    }

    public Person getOwner(){
        return owner;
    }
    
    public Block getGenesis(){
        return genesisBlock;
    }
    
    public String getName(){
        return name;
    }
}
