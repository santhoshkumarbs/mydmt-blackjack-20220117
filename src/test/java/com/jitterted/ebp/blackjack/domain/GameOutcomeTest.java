package com.jitterted.ebp.blackjack.domain;

import com.jitterted.ebp.blackjack.StubDeck;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameOutcomeTest {

    @Test
    public void playerBeatsDealer() {
        Deck stubDeck = new StubDeck(Rank.TEN,   Rank.EIGHT,
                                     Rank.QUEEN, Rank.JACK);
        Game game = new Game(stubDeck);
        game.initialDeal();

        game.playerStands(); // make sure the player stands
        game.dealerTurn(); // dealer needs to take its turn

        String outcome = game.determineOutcome();
        assertThat(outcome)
                .isEqualTo("You beat the Dealer! 💵");
    }


    @Test
    public void playerHitsAndGoesBustAndLoses() throws Exception {
        Deck stubDeck = new StubDeck(Rank.TEN,   Rank.EIGHT,
                                     Rank.QUEEN, Rank.JACK,
                                     Rank.THREE);
        Game game = new Game(stubDeck);
        game.initialDeal();

        game.playerHits();

        assertThat(game.determineOutcome())
                .isEqualTo("You Busted, so you lose.  💸");
    }

}