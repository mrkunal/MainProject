package java8;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class PayPayQuestionMaxSum {

    int[] solution(int[] a) {

        IntStream stream = Arrays.stream(a);
        java.util.concurrent.atomic.AtomicInteger maxCount= new java.util.concurrent.atomic.AtomicInteger(0);
        ConcurrentHashMap<Integer,Integer> map=new ConcurrentHashMap<>();


        stream.forEach(val->{
            int mod=val%10;
            while(val>=0){
                Integer mapValue = map.get(mod);
                if(mapValue!=null){
                    map.put(mod,mapValue+1);
                    mapValue=mapValue+1;
                    if(maxCount.get() < mapValue){
                        maxCount.set(mapValue);
                    }
                }else{
                    map.put(mod,1);
                    if(maxCount.get() < 1){
                        maxCount.set(1);
                    }
                }
                val=val/10;
                if(val==0)
                { break; }
                mod=val%10;
            }
        });

        return map.entrySet().stream()
                .filter(k-> {return k.getValue().equals(maxCount.get()); })
                .map(Map.Entry::getKey)
                .sorted()
                .mapToInt(i->i)
                .toArray();

    }

}
