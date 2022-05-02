package designPatterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by kunal on 4/9/17.
 */
public class ReflectionBreakSingletonPattern {

    public static void main(String[] args) {
        EagerSingletonPattern instanceOne=EagerSingletonPattern.getInstance();

        EagerSingletonPattern instanceTwo=null;

        Constructor[] constructors= EagerSingletonPattern.class.getDeclaredConstructors();

        try {
            for(Constructor constructor:constructors)
            {
                constructor.setAccessible(true);
                instanceTwo=(EagerSingletonPattern)constructor.newInstance();
            break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());


    }
}
