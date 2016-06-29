package de.dojo.botwars;

import org.junit.Test;
import org.mockito.internal.matchers.GreaterOrEqual;

import java.util.HashSet;
import java.util.Set;

import static de.dojo.botwars.BotBuilder.aBot;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BotTest {

    private Bot bot;

    @Test
    public void testReceiveTwoDamageWithNoArmor(){
        bot = aBot().withArmor(0).build();

        int receivedDamage = bot.applyDamage(2);

        assertThat(receivedDamage, is(2));
    }

    @Test
    public void testReceiveTwoDamageWithOneArmor() {
        bot = aBot().withArmor(1).build();

        int receivedDamage = bot.applyDamage(2);

        assertThat(receivedDamage, is(1));
    }

    @Test
    public void testDealtDamageIsWithinCorrectRange() {
        bot = aBot().withPower(10).build();

        int damage = bot.calculateAttackDamage();

        assertThat(damage, is(greaterThanOrEqualTo(5)));
        assertThat(damage, is(lessThanOrEqualTo(10)));
    }

    @Test
    public void testDamageHasOccurredAtLeastOnceWithinRange() {
        bot = aBot().withPower(12).build();
        Set<Integer> occurredDamages = new HashSet<>();

        for (int i = 0; i < 100; i++) {
            int damage = bot.calculateAttackDamage();
            occurredDamages.add(damage);
        }

        assertThat(occurredDamages, hasItems(6, 7, 8, 9, 10, 11, 12));
    }

    @Test
    public void testIntegrityIsLoweredByAttackersDamage() {
        bot = aBot().withArmor(0).withIntegrity(10).build();

        bot.applyDamage(5);

        assertThat(bot.getIntegrity(), is(equalTo(5)));
    }

    @Test
    public void testBotDestroyed() {
        bot = aBot().withIntegrity(10).build();

        bot.applyDamage(10);

        assertTrue(bot.isDestroyed());
    }

    @Test
    public void testNewBotIsNotDestroyed() {
        bot = aBot().withIntegrity(10).build();

        assertFalse(bot.isDestroyed());
    }

    @Test
    public void testDestroyedBotHasZeroIntegrity() {
        bot = aBot().withIntegrity(5).withArmor(1).build();

        bot.applyDamage(10);

        assertThat(bot.getIntegrity(), is(0));
    }

    @Test
    public void testTurnMeterInitsWithZero() {
        bot = aBot().build();

        assertThat(bot.getTurnMeter(), is(0));
    }

    @Test
    public void testTurnMeterIncreasesBySpeed() {
        bot = aBot().withSpeed(5).build();

        bot.turn();

        assertThat(bot.getTurnMeter(), is(5));
    }

    @Test
    public void testAttack() {
        bot = aBot().withSpeed(1000).build();
        Bot opponent = aBot().build();
        //bot.turn(opponent);

    }
}
