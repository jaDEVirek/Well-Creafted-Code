package StreamAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Stream.Builder;
import static java.util.stream.Stream.of;


public class FunWithStream {


    public static void main(String[] args) {
        final List<String> list = List.of("Jeden", "dwa", "TRZY");
        final Stream<List<String>> streamList = of(list);
        final Stream<String> stream = list.stream();
        Stream<String> stream3 = Stream.of("String1", "String2");

        // builder stream
        Stream.Builder<String> builder = Stream.builder();
        final Builder<String> add = builder.add("1");
        final Builder<String> add1 = builder.add("2");
        System.out.println(add.hashCode());
        System.out.println(add1.hashCode());
        final Builder<String> add2 = add1.add("3");
        //   builder.build().forEach(System.out::println);
        Stream<String> build = add2.build();
        //        Stream<String> build2 = add1.build();
        try {
            build = add1.build();
        } catch (IllegalStateException e) {
            System.out.println("Except" + e);
        } finally {
            System.out.println(build.hashCode());
        }

        Stream<Long> longStream = Stream.iterate(1L, liczba -> liczba + 1)
                .limit(10);
        //    longStream.forEach(System.out::println);
        Stream.generate(new Random()::nextInt)
                .limit(10)
                .forEach(System.out::println);
        try {
            final Stream<String> lines = Files.lines(Paths.get("CleanFunctionalJava\\src\\main\\resources\\someTxt"));
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
