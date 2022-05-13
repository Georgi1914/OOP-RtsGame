package org.elsys.oop.rtsgame;

import Soldier.Soldier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoldierTest {
    Soldier testSoldier;

    @BeforeEach
    void setUp() {
        testSoldier = new Soldier("Warrior", 100, 5, 10, 5, "melee");
    }

    @AfterEach
    void tearDown() {
        testSoldier = null;
    }

    @Test
    void unmodifiedStats() {
        assertEquals(100, testSoldier.getMaxHp());
        assertEquals(100, testSoldier.getCurrHp());
        assertEquals(5, testSoldier.getAttack());
        assertEquals(5, testSoldier.getMeleeDefence());
        assertEquals(10, testSoldier.getRangeDefence());
    }

    @Test
    void modifiedStats() {
//        testSoldier.addModifier(/* add a modifier for +5 max Hp */);
        assertEquals(105, testSoldier.getMaxHp());

//        testSoldier.addModifier(/* add a modifier for +10 attack */);
        assertEquals(15, testSoldier.getAttack());

//        testSoldier.addModifier(/* add a modifier for +15 melee defence */);
        assertEquals(20, testSoldier.getMeleeDefence());

//        testSoldier.addModifier(/* add a modifier for +20 ranged defence */);
        assertEquals(30, testSoldier.getRangeDefence());
    }
}