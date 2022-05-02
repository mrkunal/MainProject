package designPatterns.singleton;

/**
 * Created by kunal on 4/9/17.
 */
public class StaticSingletonPattern {

    private static StaticSingletonPattern instance;

    static {
        try {
            instance = new StaticSingletonPattern();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private StaticSingletonPattern() {
    }

    public static StaticSingletonPattern getInstance() {
        return instance;
    }
}
