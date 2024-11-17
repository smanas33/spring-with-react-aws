package com.msahoo.springbootaws.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	private GamingConsole game;
	
	public GameRunner(@Qualifier("superContraGame") GamingConsole superContraGame) {
		this.game = superContraGame;
	}

	public void run() {
		System.out.println("Running Game: " + game);
		game.up();
		game.down();
		game.left();
		game.right();
	}
	
}
