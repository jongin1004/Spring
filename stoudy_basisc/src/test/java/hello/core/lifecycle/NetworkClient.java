package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//javax 공식 패키지이기 때문에, spring이 아닌 곳에서도 사용 가능
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient{

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + ", message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    //@PostConstruct와 @PreDestroy를 사용하는 것이 가장 좋다.
    //하지만, 코드 수정이 불가능한 라이브러리를 사용할 때에는 사용이 불가능 ( 그때는 @Bean(initMethod = "init", destroyMethod = "close"))
    @PostConstruct
    public void init() {
        System.out.println("init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() {
        System.out.println("close");
        disconnect();
    }
}
