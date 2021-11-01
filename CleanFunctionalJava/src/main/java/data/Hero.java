package main.java.data;



final public class Hero implements Comparable<Hero> {

    private Integer heroId;
    private String name;
    private Integer level;
    private Animal animal;

     Hero(Integer heroId, String name, Integer level, Animal animal) {
        this.heroId = heroId;
        this.name = name;
        this.level = level;
        this.animal = animal;
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

    @Override public String toString() {
        final StringBuffer sb = new StringBuffer("Hero{");
        sb.append("heroId=")
                .append(heroId);
        sb.append(", name='")
                .append(name.toString())
                .append('\'');
        sb.append(", level=")
                .append(level);
        sb.append(", animal=")
                .append(animal.name());
        sb.append('}');
        return sb.toString();
    }

    @Override public int compareTo(Hero o) {
        return 0;
    }
}

