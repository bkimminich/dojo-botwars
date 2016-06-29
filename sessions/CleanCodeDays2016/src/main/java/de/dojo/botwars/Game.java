package de.dojo.botwars;

public class Game {

    private Bot[] bots;

    public Game(Bot... bots) {

        this.bots = bots;
    }

    public void turn() {

        for (Bot bot: bots) {
           bot.turn();
           if (bot.readyForAttack())
           {
               Bot opponent = bots[1];
               bot.attack(opponent);
           }
        }
    }
}
