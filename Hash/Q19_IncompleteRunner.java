package Hash;

import java.util.HashMap;
// 2024년 09월 03일 화요일 : 완주하지 못한 선수★
public class Q19_IncompleteRunner {
    
    private static String getNonFinishers(String[] participant, String[] completion){

        // 완주한 선수들의 이름(동명이인 포함)을 저장할 해시맵 생성
        HashMap<String, Integer> runners = new HashMap<>();
        for(String runner : completion)
            runners.put(runner, runners.getOrDefault(runner, 0) + 1);       // getOrDefault는 Java의 HashMap에서 제공하는 메소드로, 특정 키에 대한 값을 가져오는 기능을 한다.
                                                                                         // 동명이인이 있는 경우를 감안하여 만약 2명 이상이라면 + 1하기 위함인듯 하다.

        // 완주한 선수들의 이름을 해시맵에 저장한다.
        for(String runner : participant){

            // 완주하지 못한 선수를 찾으면
            if(runners.getOrDefault(runner, 0) == 0)                        // 위에서 runners.getOrDefault(runner, 0) + 1 이렇게 값을 저장했기 때문에 이름이 있으면 무조건 1 이상의 값이 나와야 하지만
                return runner;  // 완주하지 못한 선수의 이름 반환                          // 완주하지 못한 선수는 해시맵에 키가 존재하지 않아 0을 반환할 것이다.     

            runners.put(runner, runners.get(runner) - 1);                                // 동명이인이 있을 수 있기 때문에 -1 처리 하는 듯.    
        }

        return null;
    }

    public static void main(String[] args){

        String[] participant = {"leo", "kiki", "eden"};
        String[] completion  = {"kiki", "eden"};
        String name = getNonFinishers(participant, completion);
        System.out.println("result : " + name);
    }
}
