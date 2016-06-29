package de.dojo.botwars;

public class BotBuilder {
    private int armor = 0;
    private int power = 10;
    private int integrity = 100;
    private int speed;

    public BotBuilder withArmor(int armor) {
        this.armor = armor;
        return this;
    }

    public BotBuilder withPower(int power) {
        this.power = power;
        return this;
    }

    public BotBuilder withIntegrity(int integrity) {
        this.integrity = integrity;
        return this;
    }

    public Bot build() {
        return new Bot(armor, power, integrity, speed);
    }

    public static BotBuilder aBot() {
        return new BotBuilder();
    }

    public BotBuilder withSpeed(int speed) {
        this.speed = speed;
        return  this;
    }
}