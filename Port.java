import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Greg on 08.02.2017.
 */
public class Port implements Runnable{
    private ArrayList<Doc> docs = new ArrayList<>();
    private ArrayBlockingQueue<Ship> ships = new ArrayBlockingQueue<Ship>(100);

    public Port() {
    }

    public Port(int docsNumber) {
        for (int i = 0; i < docsNumber;i++){
            docs.add(new Doc(500,this));
        }
    }
    public void addShip(Ship ship){
        ships.add(ship);
    }
    @Override
    public  void run(){
        while (!ships.isEmpty()) {
            for (Doc doc : docs) {
                if(doc.isFree()){
                    doc.setShip(ships.poll());
                    (new Thread(doc)).start();
                }
            }
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public synchronized void wakeUp(){
        notify();
    }
}
