package BeanScopesLauncherApp;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


// scope of default classes created are singleton
// same instant returned whenever reffered
@Component
class NormalClass {

}


// scope of class is prototype here
// new instance is created each time reffered
@Component
@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeClass {

}


@Configuration
@ComponentScan
public class BeanScopesLauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(BeanScopesLauncher.class)) {
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));

            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));

            // As we can see everytime the hashcode and understand scopes
//            BeanScopesLauncherApp.NormalClass@37f1104d
//            BeanScopesLauncherApp.NormalClass@37f1104d
//            BeanScopesLauncherApp.PrototypeClass@55740540
//            BeanScopesLauncherApp.PrototypeClass@60015ef5
//            BeanScopesLauncherApp.PrototypeClass@2f54a33d

        }
    }
}
