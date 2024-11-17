package com.msahoo.springbootaws.config;

import com.msahoo.springbootaws.game.GameRunner;
import com.msahoo.springbootaws.game.GamingConsole;
import com.msahoo.springbootaws.game.PacManGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game() {
        return new PacManGame();
    }

    @Bean
    public GameRunner runner(GamingConsole game) {
        return new GameRunner(game);
    }
}
