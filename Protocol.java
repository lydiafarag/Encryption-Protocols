import java.util.ArrayList;

public abstract class Protocol {
    protected ArrayList<ArrayList<Integer>> keys= new ArrayList<ArrayList<Integer>>();

    public abstract String encryption(int type, String notification);
    public abstract String decryption(int type, String notification);
}
