package Stack;

import java.util.*;

public class Q12_PriceRetentionTime{

    // 가격이 떨어지지 않은 기간이 몇 초인지를 반환하는 메서드.
    private static int[] priceRetentionTime(int[] prices){

        int len = prices.length;                                                                    // 배열의 길이.
        int[] answer = new int[len];                                                                // 반환할 데이터들이 담길 배열

        Stack<Integer> stack = new Stack<>();
        // 초기값을 넣는 이유는 첫 번째 while 문에서 stack.isEmpty() 조건을 만족하지 않게 하기 위함
        stack.push(0);                                                                          // stack에 0을 push한 이유는 처음 while문을 탈 수 있게(!stack.isEmpty()) 하기 위해서 인 듯하다.

        for(int i = 1; i < len; i++){
            
            // int i = 1일때 stack.peek()는 0이므로
            // price[1] < price(0)인 조건이 된다.
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {                          // while문은 이 조건이 안 맞을때 빠져 나간다, stack.peek()는 하나씩 위에서 값을 제거하기 때문에 if문으로 바꿀 수 없다.

                //가격이 떨어졌으므로 이전 가격의 기간 계산
                int p = stack.pop();                                                                // 이전 가격의 인덱스, 얘는 주식가격이 유지된 초를 의미함. 가격이 떨어진 것으로 확정 된 값.
                answer[p] = i - p;                                                                  // 현재 시점(i)에서 이전 시점(p)을 빼서 유지된 시간을 구함
            }
            
            stack.push(i);                                                                          // 0, 1, 2 .. → stack은 배열내 이전 주식 값을 찾는 인덱스를 저장하는 용도로 사용되고 있음.
        }

        // 스택에 남아 있는 가격들은 가격이 떨어지지 않은 경우
        while (!stack.isEmpty()) {
            
            int j = stack.pop();                                                                    // j는 인덱스
            answer[j] = len -1 -j;                                                                  // len - 1 → 배열의 마지막 가격은 더 이상 비교할 대상이 없기 때문.
        }

        return answer;
    }

    public static void main(String[] args){

        int[] prices = {1, 2, 3, 2, 3};                                                             // 1. input : 가격 정보가 들어간 배열
        int[] result = priceRetentionTime(prices);
        System.out.println("주식 가격이 유지된 시간 : " + Arrays.toString(result));
    }
}