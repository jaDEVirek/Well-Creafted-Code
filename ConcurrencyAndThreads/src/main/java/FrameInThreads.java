
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrameInThreads {

    // single thread main.
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(4);
        final Worker worker = new Worker("sync");
        final Thread thread1 = new Thread(worker, "Thread1");
        final Thread thread2 = new Thread(worker, "Thread2");
        thread1.start();
        thread2.start();
        VisitsCounter.runParallelStream();

        final Worker atomic = new Worker("atomic");
        final Thread thread3 = new Thread(atomic, "Thread 3");
        final Thread thread4 = new Thread(atomic, "Thread 4");
        thread3.start();
        thread4.start();
    }


    static class Worker implements Runnable {

        private String operation;
        private  int counter; // this will be shared if we pass same Worker instance
        private AtomicInteger atomicCounter = new AtomicInteger(0);

        public Worker(String operation) {
            this.operation = operation;
        }

        @Override
        public void run() {
            switch(operation){
                case "sync" -> receiveCounterUsingSynch();
                case "atomic" -> receiveCounterUsingAtomic();
            }
        }

        private void receiveCounterUsingSynch(){
            Object obj = new Object(); // object will be different for each thread with same worker
//            synchronized (this){ // it helps to synchronizing threads
                System.out.println(obj);

                for (int i = 0; i < 1_000_000/2; i++) {
          synchronized (this){
                    counter++;
                }
            }
            System.out.println(Thread.currentThread()
                    .getName() + " : " + this.counter);
        }
        private void receiveCounterUsingAtomic(){
            for (int i = 0; i < 1_000_000/2; i++) {
                atomicCounter.incrementAndGet();
            }
            System.out.println(Thread.currentThread()
                    .getName() + " : " + atomicCounter.get());
        }
    }

    static class VisitsCounter {
        private final ConcurrentHashMap<String, Long> visits = new ConcurrentHashMap<>();

        public void markVisit(String subpage) {
            visits.compute(subpage, (key, currentValue) -> currentValue != null ? currentValue + 1 : 1);
        }

        public static void runParallelStream() {
            List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,9);
            list.stream().forEach(System.out::print);
            System.out.println();
            list.parallelStream().forEach(System.out::print);
            System.out.println();

            final List<Integer> collect = list.stream()
                    .filter(x-> IntStream.rangeClosed(2, (int) Math.sqrt(x))
                            .noneMatch(i -> x % i == 0) && x >= 2)
                    .collect(Collectors.toList()
                    );
            System.out.println(collect);
        }
    }
}

