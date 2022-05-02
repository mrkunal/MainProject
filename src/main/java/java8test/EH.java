package java8test;

/**
 * Created by kunal on 18/11/17.
 */
public class EH {

    public static void main(String[] args) {
        System.out.println("Line 0");

        try{
            System.out.println("Line 1");
            if(true)
            throw  new RuntimeException("Ex 1");
            System.out.println("Line 2");

        }
        catch (Exception e){
            System.out.println("Line 3");
            if(true)
                throw  new RuntimeException("Ex 2");
            System.out.println("Line 4");
        }
        finally {
            System.out.println("Line 5");
            if(true)
                throw  new RuntimeException("Ex 2");
            System.out.println("Line 7");
        }
    }
}
