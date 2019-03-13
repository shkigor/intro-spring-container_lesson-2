package lessons.services;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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

    @PostConstruct
    public void postConstructMethod() {
        logger.info("####### - INVOKE postConstructMethod() METHOD");
    }

    @PostConstruct
    public void anotherPostConstructMethod() {
        logger.info("####### - INVOKE anotherPostConstructMethod() METHOD");
    }

    @PreDestroy
    public void preDestroyMethod() {
        logger.info("####### - INVOKE preDestroyMethod() METHOD");
    }

    public void initMethod() {
        logger.info("@@@@@@@ - INVOKE initMethod() METHOD");
    }

    public void destroyMethod() {
        logger.info("@@@@@@@ - INVOKE destroyMethod() METHOD");
    }
}
