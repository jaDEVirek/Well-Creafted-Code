package StreamAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

        String str = "5 osób miało po 3 zł o 6 godzinie";
        str.chars().filter(litera -> !Character.isDigit((char)litera) && !Character.isWhitespace((char)litera))
           .forEach(litera -> System.out.print((char)litera+ " "));
        System.out.println("\n___________________________________");
        final Stream<String> sequence = Pattern.compile(" ")
                .splitAsStream("se qu en ce");
        final String collect = sequence.map(st -> st.concat("-"))
                .collect(Collectors.joining());
        System.out.println(collect);
        showEffectOfStream();
    }

    public static void showEffectOfStream(){
        IntStream numbersStream = IntStream.range(0, 81);
        System.out.println("Przed");
        numbersStream = numbersStream.filter(n -> n % 2 == 0);
        System.out.println("W trakcie 1");
        numbersStream = numbersStream.map(n -> {
            System.out.println("> " + n);
            return n;
        });
        System.out.println("W trakcie 2");
        numbersStream = numbersStream.limit(20);
        System.out.println("W trakcie 3");
        numbersStream= numbersStream.takeWhile(n -> n % 2 == 0);
        numbersStream.forEach(System.out::println);
        System.out.println("Po");
    }

}
