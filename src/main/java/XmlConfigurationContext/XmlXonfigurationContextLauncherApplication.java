package XmlConfigurationContext;

import Game.GameRunnner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// we dont need @ComponentScan and @Configuration here as Spring is managing beans by XML
//
public class XmlXonfigurationContextLauncherApplication {
    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("conetxtConfiguration.xml")) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            context.getBean(GameRunnner.class).run();// we defined a bean of pacman in xml
            // xml files are not used frequently these days but it is very important
            // beacause a lot of projects still used xml files
        }
    }
}
