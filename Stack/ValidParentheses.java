package Stack;

import java.util.ArrayDeque;
import java.util.Stack;

public class ValidParentheses {
    
    private static boolean validParentheses(String params){

        //ArrayDeque<Character> stack = new ArrayDeque<>();
        Stack<Character> stack = new Stack<>();
        char[] pt = params.toCharArray();
        for(char c : pt){
            //System.out.println("c : " + c);
            if(c == '(')
                stack.push(c);
            else
                if(stack.isEmpty() || stack.pop() == c)         // 1. c가 '('가 아니면 else 문에서 stack이 비어있는지 체크하거나 stack.pop()을 해주어야 한다.
                    return false;                               // 2. else 부분을 타는 경우는 현재 c의 값이 ')'인데, stack.isEmpty()이면 ')'과 짝지을 '('이게 없는 것.
        }                                                       // stack.pop() == c, 이 경우는 있을 수 없지만 pop()을 하기 위한 목적으로
                                                                // else문에는 비교문이 들어가야 하기 때문에 == c를 통해 이를 충족한 것이다. 
        boolean isEmpty = stack.isEmpty();
        return isEmpty;                                         // true or false 반환.
    }

    public static void main(String[] args){

        String parenthesesString = "()()";                      // 입력값은 String 문자열
        boolean isEmpty = validParentheses(parenthesesString);
        System.out.println("올바른 괄호 여부1 : " + isEmpty);

        parenthesesString = "(())()";
        boolean isEmpty2 = validParentheses(parenthesesString);
        System.out.println("올바른 괄호 여부2 : " + isEmpty2);

        parenthesesString = ")()(";
        boolean isEmpty3 = validParentheses(parenthesesString);
        System.out.println("올바른 괄호 여부3 : " + isEmpty3);

        parenthesesString = "(()(";
        boolean isEmpty4 = validParentheses(parenthesesString);
        System.out.println("올바른 괄호 여부3 : " + isEmpty4);
    }
}
