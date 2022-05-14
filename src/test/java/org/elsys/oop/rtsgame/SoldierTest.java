package org.elsys.oop.rtsgame;

import Modifiers.Attack;
import Modifiers.Attribute;
import Modifiers.Defence;
import Soldier.Soldier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SoldierTest {
    Soldier testSoldier;
    Soldier testEnemy1;
    Soldier testEnemy2;
    Soldier testEnemy3;

    @BeforeEach
    void setUp() {
        testSoldier = new Soldier("Warrior", 100, 25, 10, 5, "melee");
        testSoldier.addModifier(new Attack("Archer", 5));
        testSoldier.addModifier(new Defence("Archer", 5));
        testEnemy1 = new Soldier("Enemy1", 100, 10, 10, 10, "ranged");
        testEnemy2 = new Soldier("Enemy2", 100, 15, 10, 10, "ranged");
        testEnemy2.addTag("Archer");
        testEnemy3 = new Soldier("Enemy3", 100, 5, 10, 10, "ranged");

    }

    @AfterEach
    void tearDown() {
        testSoldier = null;
    }

    @Test
    void unmodifiedStats() {
        assertEquals(100, testSoldier.getMaxHp());
        assertEquals(100, testSoldier.getCurrHp());
        assertEquals(25, testSoldier.getAttack());
        assertEquals(10, testSoldier.getMeleeDefence());
        assertEquals(5, testSoldier.getRangeDefence());
    }

    @Test
    void modifiedStats() {
        testSoldier.addModifier(new Attribute("MaxHp", 5));
        assertEquals(105, testSoldier.getMaxHp());

        testSoldier.addModifier(new Attribute("Attack", 10));
        assertEquals(35, testSoldier.getAttack());

        testSoldier.addModifier(new Attribute("MeleeDefence", 15));
        assertEquals(25, testSoldier.getMeleeDefence());

        testSoldier.addModifier(new Attribute("RangeDefence", 20));
        assertEquals(25, testSoldier.getRangeDefence());
    }

    @Test
    void chooseTarget(){
        List<Soldier> enemies = new ArrayList<Soldier>();
        enemies.add(testEnemy1);
        enemies.add(testEnemy2);
        enemies.add(testEnemy3);
        assertEquals(testEnemy2, testSoldier.chooseTarget(enemies));
    }

    @Test
    void getDamageAgainst(){
        assertEquals(25, testSoldier.getDamageAgainst(testEnemy1));
        assertEquals(30, testSoldier.getDamageAgainst(testEnemy2));
    }

    @Test
    void getDamageFrom(){
        assertEquals(5, testSoldier.getDamageFrom(testEnemy1, testEnemy1.getAttack(), "ranged"));
        assertEquals(5, testSoldier.getDamageFrom(testEnemy2, testEnemy2.getAttack(), "ranged"));
    }

    @Test
    void receiveAttack(){
        testSoldier.receiveAttack(testEnemy1, testEnemy1.getAttack(), "ranged");
        assertEquals(95, testSoldier.getCurrHp());
        testSoldier.receiveAttack(testEnemy2, testEnemy2.getAttack(), "ranged");
        assertEquals(90, testSoldier.getCurrHp());
    }

}