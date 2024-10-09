import java.util.Date;

public class Block {
    private int index;
    private long timestamp;
    private String data;
    private String previousHash;
    private String hash;
    private int nonce;

    public Block(int index, String data) {
        this.index = index;
        this.timestamp = new Date().getTime();
        this.data = data;
        this.previousHash = index == 0 ? "0" : "hash_of_previous_block";
        this.hash = calculateHash();
    }

    public String calculateHash() {
        return Integer.toHexString((index + Long.toString(timestamp) + data + previousHash + nonce).hashCode());
    }

    public void mineBlock() {
        while (!hash.startsWith("0000")) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block mined: " + hash);
    }

    @Override
    public String toString() {
        return "Block{" +
                "index=" + index +
                ", timestamp=" + timestamp +
                ", data='" + data + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }
}

