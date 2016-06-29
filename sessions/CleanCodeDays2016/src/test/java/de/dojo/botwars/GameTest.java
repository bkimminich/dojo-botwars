package de.dojo.botwars;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;

import static de.dojo.botwars.BotBuilder.aBot;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

public class GameTest {

    @Test
    public void testBotAttacksWhenTurnmeterIsFull() {
        Bot bot1 = BotBuilder.aBot().withSpeed(1000).build();
        Bot bot2 = BotBuilder.aBot().withIntegrity(5).withSpeed(1).build();
        Game game = new Game(bot1, bot2);
        game.turn();
        Assert.assertThat(bot2.getIntegrity(), is(lessThan(5)));

    }
    @Test
    public void testBotAttacksResetsTurnmeter() {
        Bot bot1 = BotBuilder.aBot().withSpeed(1000).build();
        Bot bot2 = BotBuilder.aBot().build();
        Game game = new Game(bot1, bot2);
        game.turn();
        Assert.assertThat(bot1.getTurnMeter() , is(0));
    }

}
