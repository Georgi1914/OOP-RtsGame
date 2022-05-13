package Modifiers;

import Soldier.Soldier;

public interface IModifier {
    void addModifierToSoldier(Soldier soldier);
    int calculate(Soldier soldier, Soldier enemy);
}
