package com.msahoo.helloworld.game;

public class GameRunner {
	private GamingConsole game;
	
	public GameRunner(GamingConsole superContraGame) {
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
