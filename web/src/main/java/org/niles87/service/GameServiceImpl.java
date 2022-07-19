package org.niles87.service;

import lombok.extern.slf4j.Slf4j;
import org.niles87.Game;
import org.niles87.MessageGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService {

    private final Game game;
    private final MessageGenerator mg;

    // Constructors
    @Autowired
    public GameServiceImpl(Game game, MessageGenerator mg) {
        this.game = game;
        this.mg = mg;
    }

    @PostConstruct
    void init() {
        log.info(getMainMessage());
    }

    // Public methods
    @Override
    public boolean isGameOver() {
        return game.isGameWon() || game.isGameLost();
    }

    @Override
    public String getMainMessage() {
        return mg.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return mg.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
        game.setGuess(guess);
        game.check();
    }

    @Override
    public void reset() {
        game.reset();
    }
}
