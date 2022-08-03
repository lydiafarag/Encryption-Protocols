import java.util.ArrayList;
import java.util.Random;

public abstract class Server {
    Random random = new Random();
    ArrayList<Spectator> spectators = new ArrayList<>();
    ArrayList<Protocol> protocols = new ArrayList<>();

    public void addSpec(Spectator spectator){
        spectators.add(spectator);
    }
    public void removeSpec(Spectator spectator) {
        spectators.remove(spectator);
    }

    public void addProt(Protocol protocol){
        protocols.add(protocol);
    }
    public void removeProt(Protocol protocol){
        protocols.remove(protocol);
    }
    protected void watch(Protocol protocol) {
        for (Spectator spectator : spectators) {
            spectator.update(protocol);
        }
    }
    public void setProtocol() {
        watch(protocols.get(random.nextInt(protocols.size())));
    }
}
