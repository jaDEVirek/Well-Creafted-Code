package data;



import com.github.javafaker.Faker;
import data.ENUMS.HeroClass;
import data.ENUMS.HeroWeapons;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static data.ENUMS.HeroWeapons.*;

final public class HeroFakerProvider {

    public static List<data.Hero> generateHeroes(){
        Faker faker = new Faker();
        return IntStream.range(0, 25)
                .mapToObj(t ->{
                    final HeroClass randomHeroClass = getRandomHeroClass();
                   return new data.Hero(faker.random()
                        .nextInt(1,99), faker.name().nameWithMiddle()
                        , faker.random()
                        .nextInt(100) + t, faker.animal(),getRandomWeapon(randomHeroClass),randomHeroClass);
                })
                .collect(Collectors.toList());
    }

    public  static String getRandomWeapon(HeroClass hero){
        String weapon;
        switch (hero){
            case ARCHER -> weapon = extractWeapon(RANGE_WEAPON);
            case WARRIOR -> weapon = extractWeapon(MELEE_WEAPON);
            case HEALER -> weapon = extractWeapon(SUPPORT_WEAPON);
            case WIZARD -> weapon = extractWeapon(MAGIC_WEAPONS);
            default -> weapon = NO_WEAPON.getWeapons().get(0);
        }
        return weapon;
    }

    private static String extractWeapon(HeroWeapons weapons) {
        return weapons.getWeapons().get(new Random().nextInt(4));
    }

    public static HeroClass getRandomHeroClass(){
            return HeroClass.values()[new Random().nextInt(5)];
    }

}
