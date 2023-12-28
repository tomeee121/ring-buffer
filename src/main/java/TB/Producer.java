package TB;

import java.util.Random;

public class Producer<T> implements Runnable{

    private CircullarBuffer buffer;

    public Producer(CircullarBuffer buffer) {
        this.buffer = buffer;
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            Item item = new Item((int) (10 * Math.random() + 1), "adidas");
            buffer.offer(item);
            System.out.println("Produced: " + item);
        }
    }
}

