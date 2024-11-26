package com.msahoo.springbootaws;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalClass {

}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {

}

@Configuration
@ComponentScan("com.msahoo.springbootaws")
public class BeanScopesLauncherApplication {

    public static void main(String[] args) {
       try(var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)) {
           System.out.println(context.getBean(NormalClass.class));
           System.out.println(context.getBean(NormalClass.class));

           System.out.println(context.getBean(PrototypeClass.class));
           System.out.println(context.getBean(PrototypeClass.class));
           System.out.println(context.getBean(PrototypeClass.class));
       }
    }
}
