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

    @Override
    public int calculate(Soldier soldier, Soldier enemy) {
        for(int i = 0; i < soldier.getModifiers().size(); i++){
            for(int j = 0; i < enemy.getTags().size(); j++) {
                if (((Defence) soldier.getModifiers().get(i)).getEnemy_tag() == enemy.getTags().get(j)){
                    return this.value;
                }
            }
        }
        return 0;
    }
}
