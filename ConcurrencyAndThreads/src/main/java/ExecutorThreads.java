import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class ExecutorThreads {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executorService = Executors.newFixedThreadPool(25);
        final ExecutorService executorService1 = OwnExecutorProvider.provideExecutor(3);

        for (int i = 0; i < 100_000 / 25; i++) {
            final Future<?> submit = executorService.submit(
                    () -> System.out.println("Rand: " + LocalDate.now() + "  Thread " + Thread.currentThread()));
            System.out.println("Done? : " + submit.isDone());
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("True");

        for (int i = 0; i < 100_000 / 25; i++) {
            final Future<Object> submit = executorService.submit(() -> {
                System.out.println("Terminated but not get ");
                return new Random().nextGaussian();
            });
        }
    }

    static class OwnExecutorProvider {

        public static ExecutorService provideExecutor(int numbThreads) {
            return new ThreadPoolExecutor(numbThreads, numbThreads * 2, 500, MILLISECONDS, new LinkedBlockingDeque<>());
        }

        public static ExecutorService provideExecutorWithFactory(int numbThreads, ThreadFactory threadFactory) {
            return new ThreadPoolExecutor(numbThreads, numbThreads * 2, 500, MILLISECONDS,
                    new LinkedBlockingDeque<>(), threadFactory);
        }
    }
}


