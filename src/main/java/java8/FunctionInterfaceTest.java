package java8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionInterfaceTest {


    //Runnable
    // Function
    // UnaryOperator
    // BinaryOperator
    // Predicate
    // Consumer
    // BiConsumer

    static void existingFunctionalInterfaces() {

        Runnable shalika = () -> {
            System.out.println("[Runnable:] Only method block with no Parameters and arguments");
        };




        List<String> l =new ArrayList<>();

        for(String k:l){

        }
        shalika.run();

        Function<String, Character> function = (c) -> {
            System.out.println("[Function:] Accept one argument" + c + " and return another at position 2 ==>" + c.charAt(2));
            return new Character(c.charAt(2));
        };

        assertEquals('N', function.apply("KUNAL"));

        UnaryOperator<String> unaryOperator = (c) -> {
            c = "Hello, " + c;
            System.out.println("[UnaryOperator]: Accepts same type and return the same type ==>" + c);
            return c;
        };

        assertEquals("Hello, Kunal", unaryOperator.apply("Kunal"));


        BinaryOperator<Integer> binaryOperator = (num1, num2) -> {
            System.out.println("[BinaryOperator]: Take two arguments of the same type and return same type ==>" + (num1 + num2));
            return num1 + num2;
        };

        binaryOperator.apply(10, 20);

        Predicate<Integer> predicate = (num) -> {
            System.out.println("[Predicate]: Take one argument and return type is boolean , to check even ==>" + (num % 2 == 0));
            return num % 2 == 0;
        };

        Predicate<Integer> predicateOne = (num) -> {
            return num < 10;
        };


        assertTrue(predicate.test(4));
        assertFalse(predicate.negate().test(4));
        assertFalse(predicate.or(predicateOne).test(11));
        assertTrue(predicate.or(predicateOne).test(8));
        assertTrue(predicate.and(predicateOne).test(2));
        assertFalse(predicate.and(predicateOne).test(14));

    }

    public static void main(String[] args) {
        existingFunctionalInterfaces();
    }


}
