package MockTest;

import java.util.Stack;

public class Q11_PairRemover {
    
    private static int solution(String param){

        Stack<Character> stack = new Stack<>();                 // 전제조건이 문자열을 모두 stack에 쌓을 것인데, 이어지는 문자열이 있으면 바로 제거하는 것임.
        for(int i = 0; i < param.length(); i++){                // 그래서 stack에 아무것도 남아있지 않으면 짝을 지어 모두 삭제가 된 것을 의미.

            char c = param.charAt(i);
            if(!stack.isEmpty() && stack.peek() == c)           // stack이 비어있으면 이 구문은 못 탄다. 그리고 stack.peek() → stack의 최상위 요소를 의미함.
                stack.pop();                                    // 스택의 맨 위 문자 제거
            else
                stack.push(c);                                  // i가 0이면 여길 타게 되고 무조건 stack에 값을 push하게 된다. 
        }                                                       // stack에 현재 문자를 추가.

        int isEmpty = stack.isEmpty() ? 1 : 0;                  // 스택이 비어 있으면 1, 그렇지 않으면 0 반환
        return isEmpty;
    }

    public static void main(String[] args){

        String param = "baabaa";                                // 입력값1.
        int result = solution(param);
        System.out.println("모두 제거 가능 여부1 : " + result);

        param = "cdcd";                                         // 입력값2.
        result = solution(param);
        System.out.println("모두 제거 가능 여부2 : " + result);
    }
}
