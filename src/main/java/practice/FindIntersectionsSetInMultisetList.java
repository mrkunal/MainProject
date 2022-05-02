package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindIntersectionsSetInMultisetList {


    public static void main(String[] args) {

        FindIntersectionsSetInMultisetList obj = new FindIntersectionsSetInMultisetList();
        obj.getRelativeHashSets(obj.getListOfHashSets()).forEach(i -> {
            System.out.println(i);
        });
    }


    List<HashSet<String>> getListOfHashSets() {

        List<HashSet<String>> hashSetList = new ArrayList<>();

        HashSet<String> stringHashSet1 = new HashSet<>();
        stringHashSet1.add("0");
        stringHashSet1.add("1");
        HashSet<String> stringHashSet2 = new HashSet<>();
        stringHashSet2.add("1");
        stringHashSet2.add("2");
        HashSet<String> stringHashSet3 = new HashSet<>();
        stringHashSet3.add("0");
        stringHashSet3.add("2");
        HashSet<String> stringHashSet4 = new HashSet<>();
        stringHashSet4.add("3");

        hashSetList.add(stringHashSet1);
        hashSetList.add(stringHashSet4);

        hashSetList.add(stringHashSet2);
        hashSetList.add(stringHashSet3);

        return hashSetList;

    }


    List<HashSet<String>> getRelativeHashSets(List<HashSet<String>> hashSetList) {

        List<HashSet<String>> hashSetList1 = new ArrayList<>();
        hashSetList1.add(hashSetList.get(0));

        hashSetList.forEach(i -> {
            boolean added = false;
            for (int j = 0; j < hashSetList1.size(); j++) {
                if (hashSetList1.get(j).stream().anyMatch(i::contains)) {
                    hashSetList1.get(j).addAll(i);
                    added = true;
                }
            }
            if (!added)
                hashSetList1.add(i);
        });

        return hashSetList1;
    }


}
