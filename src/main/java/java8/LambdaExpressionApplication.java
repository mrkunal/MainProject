package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressionApplication {

    public static void main(String[] args) {
        System.out.println();

        List<String> list= Arrays.asList("Kunal","Kumar","Raj");

//        list.stream().flatMap()

        // Annonymous class
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return o1.compareTo(o2);
            }
        });

        list.forEach(str->System.out.println(str));

        list= Arrays.asList("A","C","B");
        Collections.sort(list,(String o1,String o2)->{ return o1.compareTo(o2);
        } );

        list.forEach(System.out::println);

        //Arrays.sort(


    }

}


