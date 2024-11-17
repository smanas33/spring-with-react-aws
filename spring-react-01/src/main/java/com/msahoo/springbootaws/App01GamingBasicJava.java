package com.msahoo.springbootaws;

import com.msahoo.springbootaws.game.GameRunner;
import com.msahoo.springbootaws.game.MarioGame;
import com.msahoo.springbootaws.game.PacManGame;
import com.msahoo.springbootaws.game.SuperContraGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
		var marioGame = new MarioGame();
//		var supercontraGame = new SuperContraGame();
//		var pacmanGame = new PacManGame();
		var gameRunner = new GameRunner(marioGame);

		gameRunner.run();
	}

}
