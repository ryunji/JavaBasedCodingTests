package MockTest;

import java.util.ArrayDeque;
import java.util.HashMap;

public class Q10_ParenthesisRotator {

   private static int solution(String param){

        // 매칭되는 괄호 정보를 저장. key는 닫히는 괄호로 함.
        // 제네릭스 사용을 통해 타입 안정성을 보장.
        // 닫는 괄호를 map에 저장하는 것은 우리가 코드를 왼쪽에서 순서대로 읽기 때문에 stack에서 여는 코드를 넣는게 더 효율적이기 때문인 듯.
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        int len = param.length();       //원본 문자열의 길이값 저장.
        param += param;                 //원본 문자열 뒤에 원본 문자열을 이어 붙여서 두번 나올 수 있도록 만들어줌. → 회전하는 효과와 같게 하기 위해서인 듯.

        int answer = 0;
        
        // 확인할 문자열의 시작 인덱스를 0 부터 n 까지 이동 → 그냥 몇번 확인할지를 위한 for문
        // ex) param이 [](){} 일때 부터 생각해볼 것 → len = 6.
        A:for (int i = 0; i < len; i++) {
            
            ArrayDeque<Character> stack = new ArrayDeque<>();

            // i(시작 위치)부터 원본 문자열의 길이인 n개까지 올바른 괄호 문자열인지 확인
            // 여기서 j < i + len은 회전 때문에 늘어난 길이를 뜻함.
            // ex) i가 0일때는 길이 기존과 동일 함. 늘어나지 않음.
            for (int j = i; j < i + len; j++) {
                
                char c = param.charAt(j);                                       // j가 0이면 c는 [
                // HashMap 안에 해당 key 가 없다면 열리는 괄호임                   → 이 말인 즉슨, 현재 map에는 닫히는 괄호( ), }, ] ) 이거 3개만 들어가 있음.
                if (!map.containsKey(c)) {
                    stack.push(c);                                              //여는 태그 저장.
                }else {
                    // 여기는 닫히는 괄호일때 탄다.
                    // 닫히는 괄호라면, 올바른 괄호를 만들기 위해 
                    // 무조건 스택에서 가장 최근에 추가한 괄호가 여는 괄호여야 한다.
                    // 짝이 맞지 않으면 내부 for문은 종료하고 for문 A로 이동
                    if(stack.isEmpty() || !stack.pop().equals(map.get(c)))      // map.get(c)은 여는 태그인데(왜냐면 값은 여는 태그만 들어가 있음).
                        continue A;                                             // else문을 탄다는 것은 닫는 키이기 때문에 여기는 여는 키를 주어야 함. 근데 empty면 짝 안 맞는 것임.
                                                                                // stack.pop().equals(map.get(c)), 이 부분은 여는 태그가 다를 수 있다는 것. ex) '(' 랑 '}'는 다름.
                }
            }

            // 3에서 continue 되지 않았고, 스택이 비어있으면 올바른 괄호 문자열임
            if (stack.isEmpty())
                answer++;
        }
        
        return answer;
   }
    
    public static void main(String[] args){

        //String literal = "[](){}";
        String literal = "}]()[{";
        int matchingCnt = solution(literal);
        System.out.println("올바른 문자열 회전 :" + matchingCnt);
    }
}
