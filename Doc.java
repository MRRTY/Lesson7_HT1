/**
 * Created by Greg on 07.02.2017.
 */
public class Doc implements Runnable {
    private boolean free;
    private long speed;
    private Ship ship;
    private Port port;

    public Doc() {
    }

    public Doc(long speed, Port port) {
        this.speed = speed;
        this.port = port;
        free = true;
    }

    @Override
    public void run() {
        free = false;
        try {
            Thread.sleep(speed * ship.getBoxes());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ship was unloaded");
        free = true;
        port.wakeUp();

    }



    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
