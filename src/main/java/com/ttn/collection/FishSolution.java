/*

package com.ttn.collection;

import java.util.HashMap;
import java.util.Map;

public class FishSolution {

    public int solution(String S) {

        Map<String, String> foodChainMap = constructFoodChain();

        char arr[] = S.toCharArray();


        StringBuilder stb = new StringBuilder();
        for (int j = arr.length - 1; j > 0; j--) {

            String s = foodChainMap.get(arr[j - 1] + arr[j]);
            String bigFish = foodChainMap.get(s);

            if (bigFish != null) {
                stb.append(bigFish);
            } else {

            }

        }

    }

    private Map<String, String> constructFoodChain() {
        Map<String, String> foodChainMap = new HashMap<>();

//            foodChainMap.put("B",new HashSet<>(Arrays.asList({"A"})));
//            foodChainMap.put("C",new HashSet<>(Arrays.asList({"B","A"})));
//            foodChainMap.put("D",new HashSet<>(Arrays.asList({"C","B"})));
//            foodChainMap.put("A",new HashSet<>(Arrays.asList({"C","B"})));

        foodChainMap.put("AB", "A");
        foodChainMap.put("AC", "A");
        foodChainMap.put("BC", "B");
        foodChainMap.put("CD", "C");
        foodChainMap.put("BD", "B");

        return foodChainMap;
    }
}



*/
