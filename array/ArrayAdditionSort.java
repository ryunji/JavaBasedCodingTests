package array;

import java.util.Arrays;
import java.util.HashSet;

//24.08.13.화요일
public class ArrayAdditionSort{

    public static void main(String[] args){

        int[] numbers = {2, 1, 3, 4, 1};                                        // numbers = {5,0,2,7};
        int result[]  = solution(numbers);
        System.out.println("결과 : " + Arrays.toString(result));
    }

    private static int[] solution(int[] numbers){

        //Set은 인터페이스
        //HashSet은 Set 인터페이스를 구현한 클래스 중 하나.

        // 두 수를 선택하는 모든 경우의 수를 반복문으로 구함
        HashSet<Integer> set = new HashSet<>();                                 // 중복 데이터 제외를 위해 HashSet 사용.
        // 각 수에서 자신보다 뒤에 있는 수를 선택하면 됨.
        // 마지막은 다음 수가 없기 때문에 for문은 배열의
        // 길이보다 -1, 즉 하나 적게 돌면 된다.
        for(int i = 0; i < numbers.length-1; i++)
            // j는 i번째 수보다 항상 뒤에 있는 수이어야 하므로
            // j = i + 1 이 되어야 한다.
            for(int j = i + 1; j < numbers.length; j++)
                // 두 수를 더한 결과를 새로운 배열에 추가    
                set.add(numbers[i] + numbers[j]);

        // 여기서의 map은 mapping의 의미
        // HashSet의 값을 오름차순 정렬하고 int[] 형태의 배열로 변환하여 반환
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}