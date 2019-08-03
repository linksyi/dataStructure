package structure.stack;

import structure.stack.demo.StackQueue;

/**
 * @author My.ZuoY
 * @date 2019-08-02 21:09
 */
public class main {
    public static void main(String[] args) {
        StackQueue<Integer> stack = new StackQueue<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        System.out.println(stack.size());

    }
}
