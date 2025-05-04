package stack;

import java.util.Stack;

public class stackdemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("America");
        stack.push("Germany");
        stack.push("India");
        stack.push("United States");
        stack.push("United States of America");
        stack.push("United States of Germany");
        stack.push("United States of India");
        stack.push("United States of United States");
        stack.push("United States of Hungary States");
        System.out.println(stack.get(0));
        System.out.println(stack);
        String poppedelement = stack.pop();
        System.out.println(poppedelement);
        System.out.println(stack);
        String topelementString = stack.peek();
        System.out.println(topelementString);
        System.out.println(stack);
    }
}
