package practice;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NGramDemo {

    public static void main(String[] args) {


        IntStream stream = "12345_abcdefg".chars();

//        stream.forEach(p -> System.out.print((char)p));

//        stream1();
        stream2();
    }


    private static void stream1() {
        Map<String, String> map =
                Stream.of("a", "b", "err1", "c", "d", "err2", "e", "f", "g", "h", "err3", "i", "j")
                        .collect(MappingErrors.collector());
        System.out.println(map);
    }

    private static void stream2() {

        String inputData = "mouse";
        List<String> ngrams;

        Stream<Character> characterStream = inputData.chars().mapToObj(c->(char) (c));

        characterStream.collect(NgramMapper.collector()).forEach(System.out::println);

    }

    private static final class NgramMapper {
        private Set<String> ngrams = new HashSet<>();
        private Character first, second;
        public void accept(Character str) {
            first = second;
            second = str;
            if (first != null) {
                String gram = String.format("%s%s", first, second);
                ngrams.add(gram);
            }
            System.out.println("callled>>>"+str);
        }
        public NgramMapper combine(NgramMapper other) {
            throw new UnsupportedOperationException("Parallel Stream not supported");
        }
        public Set<String> finish() {
            return ngrams;
        }
        public static Collector<Character, ?, Set<String>> collector() {
            return Collector.of(NgramMapper::new, NgramMapper::accept, NgramMapper::combine, NgramMapper::finish);
        }
    }


    private static final class MappingErrors {

        private Map<String, String> map = new HashMap<>();

        private String first, second;

        public void accept(String str) {
            System.out.println("First " + first + " Second " + second);

            System.out.println("##First " + first + " Second " + second);

            if (first != null && first.startsWith("err")) {
                map.put(first, second);
            }
        }

        public MappingErrors combine(MappingErrors other) {
            throw new UnsupportedOperationException("Parallel Stream not supported");
        }

        public Map<String, String> finish() {
            return map;
        }

        public static Collector<String, ?, Map<String, String>> collector() {
            return Collector.of(MappingErrors::new, MappingErrors::accept, MappingErrors::combine, MappingErrors::finish);
        }
    }


}
