package Hash;

import java.util.HashSet;

public class Q18_ExistenceChecker {

    private static boolean isExists(int[] numbers, int target){

        HashSet<Integer> cmpSet = new HashSet<>();
        for(int num : numbers){

            // 첫번째 값은 해당 부분을 타지 않고 무조건 cmpSet 안에 저장 됨.
            // 1. target에서 num(현재 원소) 값을 뺀 값이 cmpSet에 있는지 확인한다. 
            if(cmpSet.contains(target - num))
                return true;

            // 2. 앞서서 target에서 num 값을 뺀 값이 cmpSet에 없었다면
            //    현재의 num값을 cmpSet에 저장한다.
            cmpSet.add(num);
        }

        return false;
    }

    public static void main(String[] args){

        int[] numbers = {1, 2, 3, 4, 8};
        int target = 6;
        boolean result = isExists(numbers, target);
        System.out.println("결과 : " + result);
    }
}
