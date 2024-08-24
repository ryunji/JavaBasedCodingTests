package Stack;

import java.util.ArrayDeque;
import java.util.Stack;

public class ValidParentheses {
    
    private static boolean validParentheses(String params){

        //ArrayDeque<Character> stack = new ArrayDeque<>();
        Stack<Character> stack = new Stack<>();
        char[] pt = params.toCharArray();
        for(char c : pt){

            if(c == '(')
                stack.push(c);
            else
                if(stack.isEmpty() || stack.pop() == c)         // c가 '('가 아니면 else 문에서 stack.pop()을 해주어야 한다.
                    return false;                               // 이 부분을 타는건 현재 c의 값이 ')'인데, stack.isEmpty()이면 ')'과 짝지을 '('이게 없는 것이고
        }                                                       // stack.pop() == c 이 경우는 있을 수가 없음. 그렇기 때문에 return false를 타지 않을 것임.
                                                                // stack.pop() == c는 stack이 비어있지 않음을 뜻함.
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
