package StreamAPI;

import data.ENUMS.HeroClass;
import data.Hero;

import java.util.*;

import static data.HeroFakerProvider.generateHeroes;
import static java.util.stream.Collectors.*;

public class GroupHeroToSet {
    public static void main(String[] args) {

        final Map<String, Set<Hero>> strings = generateHeroes().stream()
                .collect(groupingBy(Hero::getName, toSet()));
        final Collection<Set<Hero>> values = strings.values();
        values.forEach(System.out::println);

        final Map<Integer, List<String>> collect = generateHeroes().stream()
                .collect(groupingBy(Hero::getLevel, mapping(Hero::getName, toList())));
        collect.forEach((k, v) -> System.out.println(k + " and " + v));

        final List<Integer> collect1 = generateHeroes().stream()
                .collect(groupingBy(Hero::getHeroId, HashMap::new, counting()))
                .entrySet()
                .stream()
                .filter(elem -> elem.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(toList());

        System.out.println("Extracting id where is more then one : " + collect1);

        // most popular Hero class
        final HeroClass key = generateHeroes().stream()
                .collect(groupingBy(Hero::getVocationClass, counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(NoSuchElementException::new)
                .getKey();
        System.out.println(key);
    }
}
