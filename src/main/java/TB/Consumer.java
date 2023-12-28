package TB;

import java.util.Random;
import java.util.concurrent.Callable;

import static TB.Constants.DEFAULT_CAPACITY_BUFFER;

public class Consumer<E> extends Thread implements Callable {

    private CircullarBuffer<E> buffer;

    public Consumer(CircullarBuffer<E> buffer) {
        this.buffer = buffer;
    }

    public void run() {
        this.call();
    }

    @Override
    public E[] call() {
        E[] items = (E[]) new Object[DEFAULT_CAPACITY_BUFFER];
        for (int i = 0; i < items.length;) {
            E item = buffer.poll();
            if (item != null) {
                items[i++] = item;
                System.out.println("Consumed: " + item);
            }
        }
        return items;
    }
}
