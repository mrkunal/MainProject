package array;

import java.util.*;

class MinStack {

    LinkedList<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int val) {
        stack.add(val);
    }

    public void pop() {
        stack.removeLast();
    }

    public int top() {
        Integer val = stack.getLast();
        stack.removeLast();
        return val.intValue();
    }




    public int getMin() {
        Optional<Integer>  optionalInteger = stack.stream().sorted().findFirst();

        return optionalInteger.isPresent()?optionalInteger.get().intValue():0;

    }
}

