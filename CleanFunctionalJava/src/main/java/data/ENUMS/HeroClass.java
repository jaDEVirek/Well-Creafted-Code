package data.ENUMS;

public enum  HeroClass {
    WARRIOR("Melee"),
    ARCHER("Range"),
    HEALER("Light Magic"),
    WIZARD("Fire Magic"),
    NO_VOCATION("Fist");

    private final String attack;

    HeroClass(String attack) {
        this.attack = attack;
    }

    public String getAttack() {
        return attack;
    }
}
