import java.util.ArrayList;
import com.google.gson.GsonBuilder;
/**
 * @author cryptokass on Medium.com
 * @author Hannah Whellan,Olivia Grace Reblando, Lian Bourret
 */
public class PropertyChain {
    public static ArrayList<Block> blockchain;
    public static int difficulty;
    
    public PropertyChain(){
        blockchain =  new ArrayList<Block>();
        difficulty = 5;
    }
    public ArrayList<Block> getBC(){
        return blockchain;
    }
    public int getDifficulty(){
        return difficulty;
    }
    public static Boolean isChainValid() {
        Block currentBlock; 
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        //loop through blockchain to check hashes:
        for(int i=1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            //compare registered hash and calculated hash:
            if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
                System.out.println("Current Hashes not equal");         
                return false;
            }
            //compare previous hash and registered previous hash
            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
            //check if hash is solved
            if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
                System.out.println("This block hasn't been mined");
                return false;
            }
        }
        return true;
    }
    
    public static String toString(ArrayList<Block> bchain){
        String result = "[\n";
        for(int i = 0; i < bchain.size(); i++) {
            result += "{\n";
            result += "data: " + bchain.get(i).getData() + "\n";
            result += "timestamp: " + bchain.get(i).getTime() + "\n";
            result += "hash: " + bchain.get(i).getHash() + "\n";
            result += "}\n";
        }
        result += "]";
        return result;
    }

    
}