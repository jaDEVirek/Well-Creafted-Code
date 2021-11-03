package data;


import com.github.javafaker.Animal;
import data.ENUMS.HeroClass;
import data.ENUMS.HeroWeapons;

final public class Hero implements Comparable<Hero> {

    private Integer heroId;
    private String name;
    private Integer level;
    private Animal animal;
    private String weapons;
    private HeroClass vocationClass;

    public HeroClass getVocationClass() {
        return vocationClass;
    }

    public void setVocationClass(HeroClass vocationClass) {
        this.vocationClass = vocationClass;
    }

    Hero(Integer heroId, String name, Integer level, Animal animal,String weapons,HeroClass vocationClass) {
        this.heroId = heroId;
        this.name = name;
        this.level = level;
        this.animal = animal;
        this.weapons= weapons;
        this.vocationClass=vocationClass;
    }

    public Integer getHeroId() {
        return heroId;
    }

    public void setHeroId(Integer heroId) {
        this.heroId = heroId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getWeapons() {
        return weapons;
    }

    public void setWeapons(String weapons) {
        this.weapons = weapons;
    }


    @Override public String toString() {
        final StringBuffer sb = new StringBuffer("Hero{");
        sb.append("heroId=")
                .append(heroId);
        sb.append(", name='")
                .append(name)
                .append('\'');
        sb.append(", level=")
                .append(level);
        sb.append(", animal=")
                .append(animal.name());
        sb.append(", weapons='")
                .append(weapons)
                .append('\'');
        sb.append(", vocationClass=")
                .append(vocationClass);
        sb.append('}');
        return sb.toString();
    }

    @Override public int compareTo(Hero o) {
        return 0;
    }
}

