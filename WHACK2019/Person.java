import java.util.Hashtable;
import javafx.util.Pair;
/**
 * Creates a person with data on amount of tokens, if s/he has voting rights, and key
 * @author Hannah Whellan,Olivia Grace Reblando, Lian Bourret
 */
public class Person
{
    // instance variables
    int tokens; //you can buy half a token
    String name;
    String key;
    boolean votingRights;
    Hashtable<House, Pair<Integer,Float>> wallet;
    

    /**
     * Constructor for objects of class Person
     */
    public Person( String nm, String k)
    {
        // initialise instance variables
        this.tokens = 0;
        this.name = nm;
        this.key = k;
        this.votingRights = false;
        this.wallet = new Hashtable<House, Pair<Integer,Float>>();
    }
    
    public boolean getVotingRights(House h){
        int t = wallet.get(h).getKey();
        float p = wallet.get(h).getValue();
        
        if (t*p > 0.2){
            return true;
        }
        return false;
    }

    public int getTokens(){
        return this.tokens;
    }

    public String getName(){
        return this.name;
    }

     public void setTokens(int x){
        //x can't be negative
        if (x < 0){
            this.tokens = x;
            System.out.println("Negative tokens");
        } else {
            this.tokens = x;
        }
    }

    public void changeVotingRights(){
        votingRights = !votingRights;
    }
    
    public Hashtable<House, Pair<Integer,Float>> getWallet(){
        return wallet;
    }
    
    public String walletToString(){
        return wallet.toString();
    }
    
    /**
     * The person is buying tokens
     * This means someone else has sold their tokens to you
     * At the very beginning, all of the tokens are owned by the house owner
     */
    public Block buyTokens(int x, Person seller, String previousHash, House h)
    {
        if (x < 0) {
            System.out.println("Negative Token");
            return null;
        }
        tokens += x;
        seller.setTokens(seller.getTokens() - x);

        //you create a block because an action was taken
        String blockData = seller.getName()+" sells " + x + " tokens of property "+
                            h.getName()+" to " + this.name+ " Block";
        Block b = new Block(blockData, previousHash, this);
        
        //add to wallet
        if (!wallet.contains(h)){
            wallet.put(h,new Pair (x,h.findPercentOwnership()));
        } else{
            int t = wallet.get(h).getKey() + x;
            wallet.put(h,new Pair (t,h.findPercentOwnership()));
        }

        int t = seller.getWallet().get(h).getKey() - x;
        seller.getWallet().put(h,new Pair (t,h.findPercentOwnership()));
   
        return b;
    }
    
    
}
