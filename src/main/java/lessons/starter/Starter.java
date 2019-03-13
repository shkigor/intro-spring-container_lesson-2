package lessons.starter;

import lessons.LessonsConfiguration;
import lessons.services.GreetingService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Starter {

    private static ApplicationContext applicationContext;
    private static final Logger logger = LogManager.getLogger(Starter.class);

    public static void main(String[] args) {
        logger.info("Starting configuration...");

//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//        applicationContext.register(LessonsConfiguration.class);
//        applicationContext.refresh();
        applicationContext = new AnnotationConfigApplicationContext(LessonsConfiguration.class);

        displayAllBeans();

//        GreetingService greetingService = context.getBean(GreetingService.class);
        GreetingService greetingService = applicationContext.getBean("gServiceAnotherNamed", GreetingService.class);
        logger.info(greetingService.sayGreeting());  // "Greeting, user!
    }

    public static void displayAllBeans() {
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        for(String beanName : allBeanNames) {
            System.out.println("BEAN -- " + beanName);
        }
    }

}
