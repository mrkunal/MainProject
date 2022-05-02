package java8;

import java.util.*;
import java.util.stream.Collectors;

public class ZeeMediaTest {


    public static void main(String[] args) {
        List<Map<Integer, String>> list = new ArrayList<Map<Integer, String>>();

        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        Map<Integer, String> map3 = new HashMap<>();
        map.put(1, "Hp Laptop");
        map2.put(3, "Keyboard");
        map3.put(2, "Dell Mouse");
        list.add(map);
        list.add(map2);
        list.add(map3);


       List<Map<Integer, String>>  mapList = list.stream()
                .sorted(new Comparator<Map<Integer, String>>() {
                    @Override
                    public int compare(Map<Integer, String> o1, Map<Integer, String> o2) {

                        Integer key1 = o1.keySet().stream().findFirst().orElseThrow(RuntimeException::new);
                        Integer key2 = o2.keySet().stream().findFirst().orElseThrow(RuntimeException::new);

                        return o1.get(key1).compareTo(o2.get(key2));
                    }
                })

                .collect(Collectors.toList());


       mapList.forEach(System.out::println);

       List<String> val=new ArrayList<>();
       val.add("A");
       val.add("B");

        System.out.println(Arrays.asList(val));
    }




}
