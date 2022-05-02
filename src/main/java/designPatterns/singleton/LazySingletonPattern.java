package designPatterns.singleton;

public class LazySingletonPattern {

    private static LazySingletonPattern instance;

    private LazySingletonPattern() {
    }

    // Not Thread safe
    public static LazySingletonPattern getInstance() {
        if (instance == null) {
            instance = new LazySingletonPattern();
        }
        return instance;
    }


    public static   synchronized LazySingletonPattern getThreadSafeInstance() {
        if (instance == null) {
            instance = new LazySingletonPattern();
        }
        return instance;
    }

    public static LazySingletonPattern getInstanceInSyncronizedBlock() {

        if (instance == null) {
            synchronized (LazySingletonPattern.class) {
                if (instance == null) {
                    instance = new LazySingletonPattern();
                }
            }
        }
        return instance;
    }

}
