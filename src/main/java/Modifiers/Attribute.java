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
        switch (this.attr_name){
            case "MaxHp":
                soldier.addModifier(0, this.value);
                break;
            case "Attack":
                soldier.addModifier(1, this.value);
                break;
            case "MeleeDefence":
                soldier.addModifier(2, this.value);
                break;
            case "RangeDefence":
                soldier.addModifier(3, this.value);
                break;
            default:
                System.out.println("Invalid attribute name");
                return;
        }
        Attribute curr = new Attribute(attr_name, value);
        soldier.addModifier(curr);
    }

    @Override
    public int calculate(Soldier soldier, Soldier enemy) { return 0;}
}
