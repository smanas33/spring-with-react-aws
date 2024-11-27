package com.msahoo.springbootaws;

import com.msahoo.springbootaws.game.GameRunner;
import com.msahoo.springbootaws.game.GamingConsole;
import com.msahoo.springbootaws.config.GamingConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {
    public static void main(String[] args) {
       try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
           context.getBean(GamingConsole.class).up();
           context.getBean(GameRunner.class).run();
       }
    }
}
