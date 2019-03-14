package lessons;

import lessons.services.BeanWithDependency;
import lessons.services.CommandManager;
import lessons.services.GreetingService;
import lessons.services.GreetingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Конфигурационный класс Spring IoC контейнера
 */
@Configuration
@ComponentScan
public class LessonsConfiguration {

    @Bean
    BeanWithDependency beanWithDependency() {
        return new BeanWithDependency(greetingService());
    }

    @Bean
    GreetingService greetingService() {
        return new GreetingServiceImpl();
    }

    @Bean
    @Scope("prototype")
    public Object asyncCommand() {
        return new Object();
    }

    @Bean
    public CommandManager commandManager() {
        // возвращаем новую анонимную реализацию CommandManager
        // с новым объектом
        return new CommandManager() {
            protected Object createCommand() {
                return asyncCommand();
            }
        };
    }
}