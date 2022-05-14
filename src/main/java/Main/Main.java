package Main;

import Modifiers.Attack;
import Modifiers.Attribute;
import Modifiers.Defence;
import Soldier.Soldier;

public class Main {
    public static void main(String[] args) {
        Soldier testSoldier = new Soldier("Warrior", 100, 5, 10, 5, "melee");
        testSoldier.addModifier(new Attack("Archer", 5));
        testSoldier.addModifier(new Defence("Archer", 5));
        testSoldier.addModifier(new Attribute("MaxHp", 5));
        System.out.println(testSoldier.toString());
    }
}
