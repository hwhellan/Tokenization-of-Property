import java.util.Date;
/**
 * @author cryptokass on Medium.com
 * @author Hannah Whellan,Olivia Grace Reblando, Lian Bourret
 */
public class Block {
	
	public String hash;
	public String previousHash; 
	private String data; //our data will be a simple message.
	private long timeStamp; //as number of milliseconds since 1/1/1970.
	private int nonce;
	private Person person;
	private House house;
	
	//Block Constructor.  
	public Block(String data,String previousHash, House h ) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.house = h; 
		this.hash = calculateHash(); //Making sure we do this after we set the other values.
	}

	public Block(String data,String previousHash, Person p ) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.person = p;
		this.hash = calculateHash(); //Making sure we do this after we set the other values.
	}
	
	 /**
     * Calculate new hash based on blocks contents
     */
	public String calculateHash() {
		String calculatedhash = StringUtil.applySha256( 
				previousHash +
				Long.toString(timeStamp) +
				Integer.toString(nonce) + 
				data 
				);
		return calculatedhash;
	}
	
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0" 
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
	}
	
	public String getData(){
	    return this.data;
	}
	
	public String getTime(){
	    return String.valueOf(this.timeStamp);
	}
	
	public String getHash(){
	    return this.hash;
	}
}