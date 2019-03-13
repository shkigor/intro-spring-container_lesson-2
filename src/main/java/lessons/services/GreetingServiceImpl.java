package lessons.services;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class GreetingServiceImpl implements GreetingService, InitializingBean, DisposableBean {

    private static final Logger logger = LogManager.getLogger(GreetingServiceImpl.class);

    @Override
    public String sayGreeting() {
        return "Greeting, user!";
    }

    /**
     * Метод в интерфейсе InitializingBean.
     * Позволяет выполнять какие-либо действия после инициализации всех свойств бина контейнером
     * afterPropertiesSet() and destroy() не рекомендуется использовать, поскольку они дублируют код Spring.
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("******* INVOKE afterPropertiesSet() METHOD");
    }

    /**
     * Метод в интерфейсе DisposableBean.
     * Позволяет выполнять какие-либо действия при уничтожении бина контейнером
     * afterPropertiesSet() and destroy() не рекомендуется использовать, поскольку они дублируют код Spring.
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        logger.info("******* INVOKE destroy() METHOD");
    }
}
