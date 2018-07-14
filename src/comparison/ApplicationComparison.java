package comparison;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

public class ApplicationComparison {

    public static void main(String[] args) {

        Letter letter=new Letter();
        letter.setStringValue("awo");

        Letter letter2=new Letter();
        letter2.setStringValue("awo");

        Letter lette3=new Letter();
        lette3.setStringValue("chree");

        LinkedList<Letter>  list=new LinkedList<>();
        list.add(letter);
        list.add(letter2);
        list.add(lette3);


list.clear();
        LetterComparator letterComparator=new LetterComparator();
        Collections.sort(list,letterComparator);
        list.forEach(i->System.out.println(i.getStringValue()));

        Collections.sort(list, new Comparator<Letter>() {
            @Override
            public int compare(Letter o1, Letter o2) {
                return 0;
            }
        });


        TreeSet<Letter> treeSet=new TreeSet<>();
        treeSet.add(letter);
        treeSet.add(letter2);
        treeSet.add(lette3);

        treeSet.forEach(i-> System.out.println(i.getStringValue()));
    }

}

 class Letter implements Comparable<Letter>{

   private int value;
   private String stringValue;

     @Override
     public int compareTo(Letter o) {
         return this.getStringValue().compareTo(o.getStringValue()) !=0 ? this.getStringValue().compareTo(o.getStringValue()):-1 ;
     }

     public int getValue() {
         return value;
     }

     public void setValue(int value) {
         this.value = value;
     }

     public String getStringValue() {
         return stringValue;
     }

     public void setStringValue(String stringValue) {
         this.stringValue = stringValue;
     }
 }

 class LetterComparator implements Comparator<Letter>{
     @Override
     public int compare(Letter o1, Letter o2) {
         return o1.getStringValue().compareTo(o2.getStringValue());
     }
}
