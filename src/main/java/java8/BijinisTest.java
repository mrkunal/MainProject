package java8;

import java.util.*;
import java.util.stream.Stream;

public class BijinisTest {



    // shared Redis distributed  the number of Users with mapping of count #treemap

    // txId + firstNameUser

    // distributed lock
    // multipleServices -> A Type (A1,A2,A3..n) ---> push info of user in cache update the #treemap (async queue)

    //dashboardService -> which will read from the redis state and does processing on k number of users and provide the limit from treemap




    //Twitter
    // Systems  Ready where users are tweeting with #value

    // CountrySpecific -> limited ranking of topics per country


    // when the user is tweeting we need the segreate the tweet onto country,
    // the extracted #hashtag to be in a queue which is regionally divided, regions based  (geographically)

//    #SSR 100, 120 -> 120   -> limited   // #earthquake -> 121

    //#PMInUS 1000 , #IPLCSKVSRC 1000  (24hours 20 , per 15min count 30, per 5 min count 50)
//                                (1000(24h),(40), (30))   #Earthquake(24hours 300, per 15 Min count (250),  200 (5min))

    // TTL for all messages, we only definite hours


    // trending/topics   GET   - list

    // RequestHEADER:
        // geographical-regionId:
        // userToken:

    //Response:
//    Body:{
//
//          {"id":
//            "topicTag":
    //        "ranking":
      //       "numberOfTweets":
    //          "retweets"
//
//    }
//    }



    // trending/topics/${topicID} GET   -single






    public static void main(String[] args) {

        String inputString = "My name is My age Blah Blah and Blah";


        HashMap<String, Integer> hashMap = new HashMap<>();

        Arrays.asList(inputString.split(" "))
                .stream()
                .forEach(i -> {
                    Integer value = hashMap.get(i);

                    if (value == null) {
                        hashMap.put(i, 1);
                    } else {
                        hashMap.put(i, value + 1);
                    }
                });

        Map.Entry<String, Integer> entry = hashMap.entrySet().stream()
                .sorted(new Comparator<Map.Entry<String, Integer>>() {
                            @Override
                            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                                return o1.getValue() < o2.getValue() ? 0 : -1;
                            }
                        }

                ).findFirst().orElseThrow(RuntimeException::new);


        System.out.println(entry.getKey());

        long k = 2;

        Stream<Map.Entry<String, Integer>> entryList = hashMap.entrySet().stream()
                .sorted(new Comparator<Map.Entry<String, Integer>>() {
                            @Override
                            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                                return o1.getValue() < o2.getValue() ? 0 : -1;
                            }
                        }

                ).limit(k);

        entryList.forEach(p -> {
            System.out.println(p.getKey() + "  " + p.getValue());
        });

    }


}
