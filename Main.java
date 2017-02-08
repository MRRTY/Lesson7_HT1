/**
 * Created by Greg on 07.02.2017.
 */
public class Main {
    public static void main(String args[]){
        Port port = new Port(2);
        Ship sOne = new Ship(10);
        Ship sTwo = new Ship(10);
        Ship sThree = new Ship(10);
        Ship sFour = new Ship(10);
        Ship sFive = new Ship(10);
        Ship sSix = new Ship(10);
        Ship sSeven = new Ship(10);
        port.addShip(sOne);
        port.addShip(sTwo);
        port.addShip(sThree);
        port.addShip(sFour);
        port.addShip(sFive);
        port.addShip(sSix);
        port.addShip(sSeven);
        Thread t = new Thread(port);
        t.start();
    }
}
