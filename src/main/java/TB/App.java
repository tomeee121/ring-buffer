package TB;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        CircullarBuffer<Item> buffer = new CircullarBuffer<Item>();
        executorService.submit(new Thread(new Producer<Item>(buffer)));
        executorService.submit(new Thread(new Consumer<Item>(buffer)));
    }
}
