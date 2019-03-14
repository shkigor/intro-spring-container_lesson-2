package lessons.services;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BeanWithDependency {
    private static final Logger logger = LogManager.getLogger(BeanWithDependency.class);

    public BeanWithDependency() {
        logger.info("?????????????? - Default Constructor");
    }

    public BeanWithDependency(GreetingService greetingService) {
        /* что-то делаем*/
        logger.info("))))))))))))))) - " + greetingService.sayGreeting());
    }

    public String printText() { return "Some text";}
}
