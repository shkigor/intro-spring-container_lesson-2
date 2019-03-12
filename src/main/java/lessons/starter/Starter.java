package lessons.starter;

import lessons.LessonsConfiguration;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Starter {

    private static final Logger logger = LogManager.getLogger(Starter.class);

    public static void main(String[] args) {
        logger.info("Starting configuration...");

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(LessonsConfiguration.class);
//        context.refresh();

        ApplicationContext context = new AnnotationConfigApplicationContext(LessonsConfiguration.class);

        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println("BEAN -- " + beanName);
        }
    }

}
