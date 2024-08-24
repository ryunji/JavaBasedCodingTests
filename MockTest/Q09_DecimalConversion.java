package MockTest;

import java.util.Stack;

public class Q09_DecimalConversion {
    
    private static String solution(int number){

        Stack<Integer> stack = new Stack<>();
        while (number > 0) {
            
            int remainder = number % 2;
            stack.push(remainder);
            number /= 2;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        
        String binary = sb.toString();
        return binary;
    }

    public static void main(String[] args){

        int number = 10;
        String binary = solution(number);
        System.out.println(binary);
    }
}
