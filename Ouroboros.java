import java.util.ArrayList;

public class Ouroboros extends Protocol {
    public Ouroboros() {
        ArrayList<Integer> key_1 = new ArrayList<>();
        ArrayList<Integer> key_2 = new ArrayList<>();

        key_1.add(3);
        key_1.add(1);
        key_1.add(0);
        key_1.add(2);

        key_2.add(2);
        key_2.add(5);
        key_2.add(4);
        key_2.add(1);
        key_2.add(3);
        key_2.add(0);

        keys.add(key_1);
        keys.add(key_2);

    }

    @Override
    public String encryption(int type, String notification) {
        ArrayList<Integer> key = keys.get(type);
        //had to look up wtf StringBuilder is but bet, this is cool
        StringBuilder out = new StringBuilder();
        String use = notification + new String(new char[key.size() - (notification.length() % key.size())]).replace("\0", "");
        for (int i = 0; i < use.length(); i = i + key.size()) {
            char[] next = new char[key.size()];
            for (int j = 0; j < key.size(); j++) {
                next[j] = use.charAt(i + key.get(j));
            }
            out.append(new String(next));
        }
        return out.toString();
    }

    @Override
    public String decryption(int type, String notification) {
        ArrayList<Integer> key = keys.get(type);
        StringBuilder out = new StringBuilder();
        String use = notification + "";
        for (int i = 0; i < use.length(); i += key.size()) {
            char[] next = new char[key.size()];
            for (int j = 0; j < key.size(); j++) {
                next[key.get(j)] = use.charAt(i + j);
            }
            out.append(new String(next));
        }
        return out.toString();
    }
}
