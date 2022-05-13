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
        modifiers.add(modifier);
    }

    // MaxHp - 0
    // Attack - 1
    // MeleeDefence - 2
    // RangeDefence - 3
    public void addModifier(int modifier_number, int value){
        switch (modifier_number){
            case 0:
                MaxHp += value;
                CurrHp += value;
                break;
            case 1:
                Attack += value;
                break;
            case 2:
                MeleeDefence += value;
                break;
            case 3:
                RangeDefence += value;
                break;
        }
    }

    Soldier chooseTarget(List<Soldier> enemies){
        for(int i = 0; i < enemies.size(); i++){
            for(int j = 0; j < enemies.get(i).getModifiers().size(); j++){
                if()
            }
        }
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

    public List<IModifier> getModifiers() {
        return modifiers;
    }

    public Vector<String> getTags() {
        return tags;
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

