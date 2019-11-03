
/**
 * Write a description of class Driver here.
 *@author Hannah Whellan,Olivia Grace Reblando, Lian Bourret
 */
public class Driver
{
    public static void main(String[] args) {
        PropertyChain bc1 = new PropertyChain();
        //create owner
        Person owner = new Person("Julia", "hello");
        //create house
        House Wellesley = new House("Wellesley", 400, owner, 4);
        //add house to blockchain
        Block a = Wellesley.getGenesis(); 
        bc1.getBC().add(a);
        //mine block
        System.out.println("Trying to Mine block 1... ");
        bc1.getBC().get(0).mineBlock(bc1.getDifficulty());
        //create person
        Person lian = new Person("Lian", "hi");
        //person buys tokens, add to bc
        Block b = lian.buyTokens(2, owner, bc1.getBC().get(bc1.getBC().size()-1).hash, Wellesley);
        bc1.getBC().add(b);
        //mine block
        System.out.println("Trying to Mine block 2... ");
        bc1.getBC().get(1).mineBlock(bc1.getDifficulty());
        //create another person
        Person olivia = new Person("Olivia", "world");
        //person buy from other person
        Block c = olivia.buyTokens(1, lian, bc1.getBC().get(bc1.getBC().size()-1).hash, Wellesley);
        bc1.getBC().add(c);
        System.out.println("Trying to Mine block 3... ");
        bc1.getBC().get(2).mineBlock(bc1.getDifficulty());
        
        //increase value of house
        
        
        
        
        //valid bc
        System.out.println("\nBlockchain is Valid: " + bc1.isChainValid());
        
        //print blockchain
        System.out.println(bc1.toString(bc1.getBC()));
        
        /**NEW PROPERTY*/
        
        PropertyChain bc2 = new PropertyChain();
        //create owner
        Person owner2 = new Person("Julia", "hello");
        //create house
        House Babson = new House("Babson", 10000, owner2, 58888);
        //add house to blockchain
        Block one = Babson.getGenesis(); 
        bc2.getBC().add(one);
        //mine block
        System.out.println("Trying to Mine block 1... ");
        bc2.getBC().get(0).mineBlock(bc2.getDifficulty());
        //create person
        Person hannah = new Person("Hannah", "hi");
        //person buys tokens, add to bc
        Block two = hannah.buyTokens(100, owner2, bc2.getBC().get(bc2.getBC().size()-1).hash, Babson);
        bc2.getBC().add(two);
        System.out.println(hannah.walletToString());
        //mine block
        System.out.println("Trying to Mine block 2... ");
        bc2.getBC().get(1).mineBlock(bc2.getDifficulty());
        //create another person
        Person anne = new Person("Anne", "world");
        //person buy from other person
        Block three = anne.buyTokens(99, hannah, bc2.getBC().get(bc2.getBC().size()-1).hash, Babson);
        bc2.getBC().add(three);
        System.out.println("Trying to Mine block 3... ");
        bc2.getBC().get(2).mineBlock(bc2.getDifficulty());
        System.out.println(hannah.walletToString());
        //valid bc
        System.out.println("\nBlockchain is Valid: " + bc2.isChainValid());
        
  
        //print blockchain
        System.out.println(bc2.toString(bc2.getBC()));
        
        
        //json
        // String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        // System.out.println("\nThe block chain: ");
        // System.out.println(blockchainJson);
        

        

        //add our blocks to the blockchain ArrayList:
        
        /*
        Person owner = new Person("Julia", "hello");
        House W = new House("Wellesley", 400, owner, 4);
        blockchain.add(new Block("Hi im the first block", "0",W));
        System.out.println("Trying to Mine block 1... ");
        blockchain.get(0).mineBlock(difficulty);

        blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash,W));
        System.out.println("Trying to Mine block 2... ");
        blockchain.get(1).mineBlock(difficulty);

        blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash,W));
        System.out.println("Trying to Mine block 3... ");
        blockchain.get(2).mineBlock(difficulty); 

        System.out.println("\nBlockchain is Valid: " + isChainValid());

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);
        */
    }

}
