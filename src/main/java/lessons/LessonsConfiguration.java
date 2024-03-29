package lessons;

import lessons.services.CommandManager;
import lessons.services.GreetingService;
import lessons.services.GreetingServiceImpl;
import org.springframework.context.annotation.*;

/**
 * Конфигурационный класс Spring IoC контейнера
 */
@Configuration
@ComponentScan
@Import(AnotherConfiguration.class)
public class LessonsConfiguration {

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