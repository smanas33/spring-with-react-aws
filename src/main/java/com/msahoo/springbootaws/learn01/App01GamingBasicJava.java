package com.msahoo.springbootaws.learn01;

import com.msahoo.springbootaws.learn01.game.GameRunner;
import com.msahoo.springbootaws.learn01.game.MarioGame;
import com.msahoo.springbootaws.learn01.game.PacManGame;
import com.msahoo.springbootaws.learn01.game.SuperContraGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
		var marioGame = new MarioGame();
		var supercontraGame = new SuperContraGame();
		var pacmanGame = new PacManGame();
		var gameRunner = new GameRunner(marioGame);
		
		gameRunner.run();
	}

}
