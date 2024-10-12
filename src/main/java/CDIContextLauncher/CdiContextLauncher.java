package CDIContextLauncher;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
@Named
class BusinessService {
    private DataService dataService;

//    @Autowired
    @Inject
    public void setDataService(DataService dataService) {
        System.out.println("Setter Injection Performed");
        this.dataService = dataService;
    }

    public DataService getDataService() {
        return dataService;
    }

}
//@Component
@Named
class DataService{

}


@Configuration
@ComponentScan
public class CdiContextLauncher {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(CdiContextLauncher.class)){
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(BusinessService.class).getDataService());
        }
    }

}
//CDI is just an alternative for Spring but we need to know them