package hello.core.singleton;

public class SingletonService {

    private static final SingletonService singletonService = new SingletonService();

    private SingletonService() {

    }

    public static SingletonService getInstance() {
        return singletonService;
    }

}
