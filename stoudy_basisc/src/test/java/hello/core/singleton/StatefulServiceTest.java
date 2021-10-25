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

        //싱글톤일 경우에는 사용자가 값을 변경할 수 있게 만들면 안된다.
        //유저가 구매를 했을 때, 그 가격을 저장하게 하면, 다른 유저에게도 영향을 주기 때문이다.
        // 그래서 싱글톤으로 개발을 할 때에는, 값을 읽어올 수 있게만 하는 것이 좋다.
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