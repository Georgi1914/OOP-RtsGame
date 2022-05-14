package Modifiers;

import Soldier.Soldier;

public class Defence implements IModifier {
    String enemy_tag;
    int value;

    public Defence(String enemy_tag, int value) {
        this.enemy_tag = enemy_tag;
        this.value = value;
    }

    @Override
    public void addModifierToSoldier(Soldier soldier) {
        IModifier curr = new Defence(enemy_tag, value);
        soldier.addModifier(curr);
    }

    public String getEnemy_tag() {
        return enemy_tag;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int calculate(Soldier soldier, Soldier enemy) {
        for(int i = 0; i < soldier.getModifiers().size(); i++){
            for(int j = 0; j < enemy.getTags().size(); j++) {
                if(soldier.getModifiers().get(i) instanceof Defence) {
                    if (((Defence) soldier.getModifiers().get(i)).getEnemy_tag().equals(enemy.getTags().get(j))) {
                        return this.value;
                    }
                }
            }
        }
        return 0;
    }
}
