package Soldier;

import Modifiers.Attack;
import Modifiers.Attribute;
import Modifiers.Defence;
import Modifiers.IModifier;

import java.util.ArrayList;
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
        tags = new Vector<>();
        modifiers = new ArrayList<>();
    }

    public void addModifier(IModifier modifier){
        if(modifier instanceof Attribute){
            modifier.addModifierToSoldier(this);
        }
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

    public Soldier chooseTarget(List<Soldier> enemies){
        int max = getDamageAgainst(enemies.get(0));
        for (Soldier enemy : enemies) {
            if (max < getDamageAgainst(enemy)) {
                max = getDamageAgainst(enemy);
            }
        }
        int i = 0;
        while (getDamageAgainst(enemies.get(i)) != max){
            i++;
        }
        return enemies.get(i);
    }

    public int getDamageAgainst(Soldier enemy){
        int result = Attack;
        for (IModifier modifier : modifiers) {
            if (modifier instanceof Attack) {
                result += modifier.calculate(this, enemy);
            }
        }
        return result;
    }

    public int getDamageFrom(Soldier enemy, int value, String type){
        int result = value;
        for (IModifier modifier : modifiers) {
            if (modifier instanceof Defence) {
                result -= ((Defence)modifier).calculate(this, enemy);
            }
        }
        if(type == "melee"){
            result -= this.MeleeDefence;
        }else{
            result -= this.RangeDefence;
        }
        if(result >= 1){
            return result;
        }
        return 1;
    }

    public void receiveAttack(Soldier enemy, int value, String type){
        if(getDamageFrom(enemy, value, type) >= CurrHp) {
            CurrHp = 0;
            return;
        }
        CurrHp -= getDamageFrom(enemy, value, type);
    }

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

    public void addTag(String tag){
        tags.add(tag);
    }

    @Override
    public String toString() {
        StringBuilder return_value = new StringBuilder(name + "\n\tHp:" + CurrHp + "/" + MaxHp + "\n\tATK:");
        ArrayList<Integer> help_melee = new ArrayList<Integer>();
        ArrayList<Integer> help_ranged = new ArrayList<Integer>();
        int starting_attack = Attack;
        int starting_MeleeDefence = MeleeDefence;
        int starting_RangeDefence = RangeDefence;

        for (IModifier modifier : modifiers) {
            if (modifier instanceof Attribute) {
                if (((Attribute) modifier).getAttr_name().equals("Attack")) {
                    return_value.append(((Attribute) modifier).getValue() + " + ");
                    starting_attack -= ((Attribute) modifier).getValue();
                } else if (((Attribute) modifier).getAttr_name().equals("MeleeDefence")) {
                    help_melee.add(((Attribute) modifier).getValue());
                    starting_MeleeDefence -= ((Attribute) modifier).getValue();
                } else if (((Attribute) modifier).getAttr_name().equals("RangeDefence")) {
                    help_ranged.add(((Attribute) modifier).getValue());
                    starting_RangeDefence -= ((Attribute) modifier).getValue();
                }
            }
        }
        return_value.append(starting_attack);

        return_value.append("\n\tDEF:" + starting_MeleeDefence);
        for (int j : help_melee) {
            return_value.append(" + " + j);
        }
        return_value.append("/" + starting_RangeDefence);
        for (int j : help_ranged) {
            return_value.append(" + " + j);
        }

        return_value.append("\nModifiers:");
        for (IModifier modifier : modifiers) {
            return_value.append("\nExtra ");
            if (modifier instanceof Attribute) {
                return_value.append(((Attribute) modifier).getAttr_name() + " +" + ((Attribute) modifier).getValue());
            } else if (modifier instanceof Attack) {
                return_value.append("attack against " + ((Attack) modifier).getEnemy_tag() + " +" + ((Attack) modifier).getValue());
            } else if (modifier instanceof Defence) {
                return_value.append("defence against " + ((Defence) modifier).getEnemy_tag() + " +" + ((Defence) modifier).getValue());
            }
        }


        return return_value.toString();
    }
}

