package designPatterns.factory;

import java.util.ArrayList;
import java.util.LinkedList;

public class AbstractFactoryPattern {
    public static void main(String[] args) {

        getProduct("One");
        getProduct("One2");


        ArrayList a;

    }

    static ProductFactory getProduct(String name) {
        if (name.equals("One")) {
            ProductOneAFactory.getProduct().disp();
        } else {
            ProductTwoAFactory.getProduct().disp();

        }
        return null;
    }
}


interface AbstractFactory {
    //  ProductFactory getProduct();
}

interface ProductFactory {
    void disp();
}

class ProductOneA implements ProductFactory {
    @Override
    public void disp() {
        System.out.println("Product One Disp");
    }
}

class ProductTwoA implements ProductFactory {
    @Override
    public void disp() {
        System.out.println("Product Two Disp");
    }
}

class ProductOneAFactory implements AbstractFactory {

    public static ProductFactory getProduct() {

        return new ProductOneA();
    }
}

class ProductTwoAFactory implements AbstractFactory {

    public static ProductFactory getProduct() {

        return new ProductTwoA();
    }
}
