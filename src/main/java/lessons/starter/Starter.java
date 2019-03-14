package lessons.starter;

import lessons.LessonsConfiguration;
import lessons.services.GreetingService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Starter {

    private static AbstractApplicationContext ctx;
    private static final Logger logger = LogManager.getLogger(Starter.class);

    public static void main(String[] args) {
        logger.info("Starting configuration...");

        ctx = new AnnotationConfigApplicationContext(LessonsConfiguration.class);
        ctx.registerShutdownHook();

        displayAllBeans();

        GreetingService greetingService = ctx.getBean(GreetingService.class);
        logger.info(greetingService.sayGreeting());
    }

    public static void displayAllBeans() {
        String[] allBeanNames = ctx.getBeanDefinitionNames();
        for(String beanName : allBeanNames) {
            System.out.println("BEAN -- " + beanName);
        }
    }

}
