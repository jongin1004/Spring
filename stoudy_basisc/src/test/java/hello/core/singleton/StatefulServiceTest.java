package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(StatefulConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        int UserA = statefulService1.order("item1", 10000);
        int UserB = statefulService1.order("item2", 20000);

        System.out.println("userA = " + UserA);
        Assertions.assertThat(UserA).isEqualTo(10000);
    }

    @Configuration
    static class StatefulConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}