package Soldier;

import Modifiers.IModifier;

import java.util.List;
import java.util.Vector;

public class Soldier {
    String name;
    String attack_type; //0 - melee; 1 - ranged
    int CurrHp;
    int MaxHp;
    int Attack;
    int MeleeDefence;
    int RangeDefence;
    Vector<String> tags;
    List<IModifier> modifiers;

    public Soldier(String name, int CurrHp, int Attack, int MeleeDefence, int RangeDefence, String attack_type) {
        this.name = name;
        this.CurrHp = CurrHp;
        this.MaxHp = CurrHp;
        this.Attack = Attack;
        this.MeleeDefence = MeleeDefence;
        this.RangeDefence = RangeDefence;
        this.attack_type = attack_type;
    }

    public void addModifier(IModifier modifier){
        //TODO after adding Modifier class
    }

    Soldier chooseTarget(List<Soldier> enemies){
        return null; //TODO
    }

    int getDamageAgainst(Soldier enemy){
        return 0; //TODO
    }

    int getDamageFrom(Soldier enemy, int value, Boolean type){
        return 0; //TODO
    }

    void receiveAttack(Soldier enemy, int value, Boolean type){
        //TODO
    }

    //TODO after adding Modifier fix getters
    public int getCurrHp() {
        return CurrHp;
    }

    public int getMaxHp() {
        return MaxHp;
    }

    public int getAttack() {
        return Attack;
    }

    public int getMeleeDefence() {
        return MeleeDefence;
    }

    public int getRangeDefence() {
        return RangeDefence;
    }


    @Override
    public String toString() {
        return name +
                "   Hp:" + CurrHp + "/" + MaxHp +
                "   ATK:" + Attack + //TODO add modifier attack
                "   DEF:" + MeleeDefence + "/" + RangeDefence + //TODO add modifier Defences
                "Modifiers:"; // TODO add modifier stats
    }
}

