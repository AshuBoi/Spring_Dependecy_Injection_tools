package LazyInitializationLauncherApplication;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA{

}

@Component
@Lazy
class ClassB{
    private ClassA classA;
    public ClassB(ClassA classA) {
        System.out.println("Some Initilization");
        this.classA = classA;
    }

    public void doSomething() {
        System.out.println("do Something");
    }
}



@Configuration
@ComponentScan
public class LazyInitilizerLauncherApplication {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(LazyInitilizerLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println("initilization of context is complete");
            // when a component is marked with lazy it is only loaded when needed
            context.getBean(ClassB.class).doSomething();
        }
    }
}
