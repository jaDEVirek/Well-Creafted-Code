package src.main.java.data;



import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

final public class HeroFakerProvider {

    public static List<data.Hero> generateHeroes(){
        Faker faker = new Faker();
        return IntStream.range(0, 25)
                .mapToObj(t -> new data.Hero(faker.random()
                        .nextInt(1,99), faker.name().nameWithMiddle()
                        , faker.random()
                        .nextInt(100) + t, faker.animal()))
                .collect(Collectors.toList());
    }

}
