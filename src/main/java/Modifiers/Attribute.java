package Modifiers;

import Soldier.Soldier;

public class Attribute implements IModifier{
    String attr_name;
    int value;

    public Attribute(String attr_name, int value) {
        this.attr_name = attr_name;
        this.value = value;
    }

    @Override
    public void addModifierToSoldier(Soldier soldier){
        switch (this.attr_name) {
            case "MaxHp" -> soldier.addModifier(0, this.value);
            case "Attack" -> soldier.addModifier(1, this.value);
            case "MeleeDefence" -> soldier.addModifier(2, this.value);
            case "RangeDefence" -> soldier.addModifier(3, this.value);
            default -> {
                System.out.println("Invalid attribute name");
            }
        }
    }

    public String getAttr_name() {
        return attr_name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int calculate(Soldier soldier, Soldier enemy) { return 0;}
}
