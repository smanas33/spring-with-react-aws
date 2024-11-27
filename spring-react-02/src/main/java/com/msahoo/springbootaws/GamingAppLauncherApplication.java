package com.msahoo.springbootaws;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.msahoo.springbootaws.game.GameRunner;
import com.msahoo.springbootaws.game.GamingConsole;

@Configuration
@ComponentScan("com.msahoo.springbootaws.game")
public class GamingAppLauncherApplication {

    public static void main(String[] args) {
       try(var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {
           context.getBean(GamingConsole.class).up();
           context.getBean(GameRunner.class).run();
       }
    }
}
