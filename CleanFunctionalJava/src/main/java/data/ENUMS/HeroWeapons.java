package data.ENUMS;

import java.util.List;

public enum HeroWeapons {

    MAGIC_WEAPONS(List.of("Wand","Rod","SpellBook","Stuff")),
    MELEE_WEAPON(List.of("Axe","Club","Hammer","Sword")),
    RANGE_WEAPON(List.of("Spear","Bow","Crossbow","Shuriken")),
    SUPPORT_WEAPON(List.of("Scepter","Healing Cross","Bell", "Fan"));

    private final List<String> weapons;

     HeroWeapons(List<String> weapons) {
        this.weapons = weapons;
    }


    public List<String> getWeapons() {
        return weapons;
    }
}

