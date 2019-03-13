package lessons;

import lessons.services.GreetingService;
import lessons.services.GreetingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурационный класс Spring IoC контейнера
 */
@Configuration
public class LessonsConfiguration {

    // Для того, чтобы объект с типом GreetingService был доступен для использования,
    // необходимо описать его в конфигурации следующим образом:
    @Bean
    GreetingService greetingService() {
        return new GreetingServiceImpl();
    }
}