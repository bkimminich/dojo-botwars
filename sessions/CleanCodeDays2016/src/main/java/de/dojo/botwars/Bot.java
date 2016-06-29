package de.dojo.botwars;


import java.util.Random;

public class Bot {

    private final int armor;
    private final int power;
    private int integrity;
    private final Random random;
    private int turnMeter;
    private int speed;

    public Bot(int armor, int power, int integrity, int speed) {
        this.armor = armor;
        this.power = power;
        this.integrity = integrity;
        this.random = new Random();
        this.turnMeter = 0;
        this.speed = speed;
    }

    public int applyDamage(int damage) {
        int actualDamage = damage - armor;
        integrity = Math.max(0, integrity - actualDamage);
        return actualDamage;
    }

    public int calculateAttackDamage() {
        return power - random.nextInt(this.power / 2 + 1);
    }

    public int getIntegrity() {
        return integrity;
    }

    public boolean isDestroyed() {
        return integrity <= 0;
    }

    public int getTurnMeter() {
        return turnMeter;
    }

    public void turn() {
        turnMeter += speed;
    }

    public boolean readyForAttack() {
        return turnMeter >= 1000;
    }

    public void attack(Bot opponent) {
        opponent.applyDamage(calculateAttackDamage());
        turnMeter -= 1000;
    }
}
