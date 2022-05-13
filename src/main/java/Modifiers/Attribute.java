package Modifiers;

import Soldier.Soldier;

public class Attribute {
    String attr_name;
    int value;

    public Attribute(String attr_name, int value) {
        this.attr_name = attr_name;
        this.value = value;
    }

    void addModifierToSoldier(Soldier soldier){
        switch (this.attr_name){
            case "MaxHp":

            case "Attack":
            case "MeleeDefence":
            case "RangeDefence":
        }
    }
}
