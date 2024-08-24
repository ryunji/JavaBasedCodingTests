package Stack;

import java.util.Arrays;
import java.util.Stack;

public class BinaryConverter {
    
    private static String[] solution2(int[] numbers){

        String[] binaryNumbers = new String[numbers.length];
        int cnt = 0;
        for(int number : numbers){

            Stack<Integer> stack = new Stack<>();
            while (number > 0) {
                
                int remainder = number % 2;
                stack.push(remainder);
                number /=2;
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty())
                sb.append(stack.pop());
        
            binaryNumbers[cnt] = sb.toString();
            cnt++;    
        }

        return binaryNumbers;
    }

    private static String solution(int number){

        Stack<Integer> stack = new Stack<>();
        while(number > 0){

            int remainder = number % 2;             //나머지
            stack.push(remainder);
            number /= 2;                            //number를 2로 나누고 그 결과(몫)를 다시 number에 저장하는 연산
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
        System.out.println("변환 된 이진수 값 : " + binary);

        int[] numbers = {10, 27, 12345};
        String[] binaryNumbers =  solution2(numbers);
        System.out.println("변환 된 결과값들 :" + Arrays.toString(binaryNumbers));
    }
}
