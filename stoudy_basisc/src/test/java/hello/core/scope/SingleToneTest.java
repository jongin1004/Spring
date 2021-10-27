package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class SingleToneTest {

    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

//        System.out.println("find singleton1");
        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
//        System.out.println("find singleton2");
        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);
        System.out.println("singletonBean1 : " + singletonBean1);
        System.out.println("singletonBean2 : " + singletonBean2);

        assertThat(singletonBean1).isSameAs(singletonBean2);

        ac.close();
    }


    @Scope("singleton")
    static class SingletonBean {
        @PostConstruct
        public void init() {
            System.out.println("Singleton.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("singleton.destroy");
        }
    }
}
