
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.*;

public class FrameInThreads {

    // single thread main.
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(4);
        final Worker worker = new Worker();
        final Thread thread1 = new Thread(worker, "Thread1");
        final Thread thread2 = new Thread(worker, "Thread2");
        thread1.start();
        thread2.start();
    }


    static class Worker implements Runnable {

        private int counter; // this will be shared if we pass same Worker instance
        @Override
        public void run() {
            Object obj = new Object(); // object will be different for each thread with same worker
            System.out.println(obj);
            for (int i = 0; i < 1_000_000; i++) {
                counter++;
            }
            System.out.println(Thread.currentThread()
                    .getName() + " : " + this.counter);
        }
    }

    class VisitsCounter {
        private final ConcurrentHashMap<String, Long> visits = new ConcurrentHashMap<>();

        public void markVisit(String subpage) {
            visits.compute(subpage, (key, currentValue) -> currentValue != null ? currentValue + 1 : 1);
        }
    }
}

