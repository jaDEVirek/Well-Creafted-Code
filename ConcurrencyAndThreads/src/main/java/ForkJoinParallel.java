import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForkJoinParallel {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        runWithParallelEx1();
        new ForkJoinPool(40).submit(ForkJoinParallel::runWithParallelEx1)
                .get();
    }

    public static void runWithParallelEx1() {
        final List<String> each = List.of("Each", "Person", "Likes", "JavaCoding");
        final List<Integer> sorted = each.stream()
                .parallel()
                .map(String::length)
                .sorted().collect(Collectors.toList());
                System.out.println(sorted);
//                .forEach(System.out::println);
//                .forEachOrdered(System.out::println);
    }
}
