package designPatterns.singleton;

public class HelperClassSingletonPattern {

// Thread Safe and fast in performance

    private static class HelperClass {

        private static final HelperClassSingletonPattern instance = new HelperClassSingletonPattern();
    }

    private HelperClassSingletonPattern() {
    }

    public HelperClassSingletonPattern getInstance() {
        return HelperClass.instance;
    }
}
