package designPatterns.factory;

public class FactoryPattern {
    public static void main(String[] args) {

        Factory.getFactoryProduct("One").disp();
        Factory.getFactoryProduct("Two").disp();

    }
}

class Factory {

    static FactoryName getFactoryProduct(String name) {
        if (name.equals("One")) {
            return new ProductOne();
        } else if (name.equals("Two")) {
            return new ProductTwo();
        }
        return null;
    }
}


interface FactoryName {
    void disp();
}

class ProductOne implements FactoryName {
    @Override
    public void disp() {
        System.out.println("Product One Display");
    }
}

class ProductTwo implements FactoryName {
    @Override
    public void disp() {
        System.out.println("Product Two Display");
    }
}
