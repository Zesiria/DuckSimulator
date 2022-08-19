import java.util.ArrayList;

public class FlockWithLeader implements Quackable {
    ArrayList<Quackable> quackers = new ArrayList();

    public void add(Quackable quacker){
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        quackers.get(0).quack();
        quackers.get(0).quack();
        for (Quackable quacker:quackers) {
            quacker.quack();
        }
    }
}
