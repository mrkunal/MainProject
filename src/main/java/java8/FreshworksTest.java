package java8;

import java.util.LinkedList;
import java.util.List;

public class FreshworksTest {
//    two positive integers stored in different linked list in reverse order. find sum of these two numbers and returned sum in form of linked list

//    e.g. 542 2->4->5 300 0->0->3

//    output	 842 2->4->8


    public static void main(String[] args) {

        List<Integer> listOne = new LinkedList<>();

        listOne.add(2); // unit   *power
        listOne.add(4);  // tens  *power*10
        listOne.add(5);  // hunder  *power*10


        List<Integer> listTwo = new LinkedList<>();

        listOne.add(0);
        listOne.add(0);
        listOne.add(3);
    }

    static List<Integer> sum(List<Integer> listOne, List<Integer> listTwo) {

        int sum = 0;
        int carry = 0;

        List<Integer> sumList = new LinkedList<>();

        while (!listOne.isEmpty() && !listTwo.isEmpty()) {

            Integer valueOne = listOne.get(0);
            Integer valueTwo = listTwo.get(0);

            sum = valueOne + valueTwo + carry;

            if (sum >= 10) {
                carry = 1;
                sum = sum % 10;
            }
            sumList.add(sum);

            listOne.remove(0);
            listTwo.remove(0);
        }

        if (!listOne.isEmpty()) {
            if (carry == 1) {
                addCarry(listOne);

            }
            sumList.addAll(listOne);
        }
        if (!listTwo.isEmpty()) {
            if (carry == 1) {
                addCarry(listTwo);
            }
            sumList.addAll(listTwo);
        }
        return sumList;
    }


    static List<Integer> addCarry(List<Integer> integerList) {

        Boolean carry = true;

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < integerList.size(); i++) {

            Integer value = integerList.get(i);
            if (value < 9 && carry) {
                value++;
                carry = false;
                list.add(value);
                break;
            } else if (value == 9 && carry) {
                list.add(0);
            }

        }
        if (carry) {
            list.add(1);
        }

        return list;
    }




}
