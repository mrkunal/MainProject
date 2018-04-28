package problems;

import java.util.ArrayList;
import java.util.ListIterator;

public class PetroPump {


    public static void main(String[] args) {
        ArrayList<Pump> pumps = new ArrayList<>();
        pumps.add(new Pump(41, 21));
        pumps.add(new Pump(6, 7));
        pumps.add(new Pump(7, 3));
        pumps.add(new Pump(4, 0));

        int rear = 0, start = -1, petrolQuantity = 0;


        while (rear != start) {
            Pump pump = pumps.get(rear);
            petrolQuantity += pump.getQuantity();
            if (petrolQuantity < pump.getDistance()) {
                rear = getNextIdx(rear);
                petrolQuantity = 0;
                start = -1;
                if(rear==0)
                    break;
            } else {
                if (start < 0) {
                    start = rear;
                }

                rear = getNextIdx(rear);
                petrolQuantity -= pump.getDistance();
            }
        }
        System.out.println(">>" + start);


    }

    static int getNextIdx(int i) {
        if (i > 2) {
            return 0;
        } else {
            return ++i;
        }
    }

    static class Pump {
        private int quantity;
        private int distance;

        public Pump(int quantity, int distance) {
            this.quantity = quantity;
            this.distance = distance;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }
}
