package java8;

import java.util.*;

public class GraphPayPayQuestion {

    int solution(String beginWord, String endWord, String[] wordList) {
        Set<String> stringSet= new HashSet<>();
        Queue<String> queue=new LinkedList<>();
        int step=1;
        List<String> stringList=new ArrayList<>(Arrays.asList(wordList));
        Set<String> wordsSet = new HashSet<>(stringList);
        if(!wordsSet.contains(endWord))
        {
            return 0;
        }
        stringList.add(beginWord);

        stringSet.add(beginWord);
        queue.offer(beginWord);
        Map<String,List<String>> bfsGraph=findRoute(stringList);
        while(!queue.isEmpty())
        {
            int queueSize=queue.size();
            while(queueSize-- > 0)
            {
                String elem=queue.poll();
                if(elem.equals(endWord)){
                    return step;
                }
                if(!bfsGraph.containsKey(elem)){
                    continue;
                }
                for(String str:bfsGraph.get(elem)){
                    if(stringSet.contains(str)){
                        continue;
                    }if(!wordsSet.contains(str)){
                        continue;
                    }
                    queue.offer(str);
                    stringSet.add(str);
                }

            }
            step++;

        }

        return 0;

    }

    public Map<String,List<String>> findRoute(List<String> list){

        Map<String,List<String>> bfsGraph = new HashMap<>();
        for(String str:list){
            List<String> charList =new ArrayList<>();
            char[] charArray = str.toCharArray();
            for(int j=0;j<charArray.length;j++){
                char tempStr=  charArray[j];
                for(char ch ='a'; ch<='z'; ch++){
                    if(ch==tempStr){
                        continue;
                    }
                    charArray[j]=ch;
                    charList.add(new String(charArray));
                }
                charArray[j]=tempStr;
            }
            bfsGraph.put(str,charList);
        }
        return bfsGraph;
    }


}
