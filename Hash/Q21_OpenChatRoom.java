package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Q21_OpenChatRoom {
    
    private static String[] logChatEntry(String[] record){

        // 1. Enter과  Leave 메시지를 저장할 해시맵 생성.
        HashMap<String, String> converMap = new HashMap<>();
        converMap.put("Enter", "님이 들어왔습니다.");
        converMap.put("Leave", "님이 나갔습니다.");

        HashMap<String, String> uid = new HashMap<>();
        
        // 2. 한글로 변경 된 최종 출력 텍스트를 저장할 ArrayList;
        ArrayList<String> result = new ArrayList<>();
        
        // 3. record 각각의 데이터를 하나씩 분리하여 uid 맵에 저장.
        for(String text : record){

            String[] info = text.split(" ");
            if(info.length == 3)
                uid.put(info[1], info[2]);          // Enter와 Change일 경우에 uid, 닉네임 저장.
        }                                           // Leave는 왜 안 넣었을까? 떠난 사람은 최종 닉네임으로 출력해야해서?!
                                                    // 위 말은 닉네임은 유저의 상태가 Enter와 Change인 때에만 바뀔 수 있다는 책의 설명과 동일한 의미.
                                                    // * HashMap은 키가 중복되면 기존의 값을 덮어씌우기 때문에, Enter와 Change 상태에서만 닉네임을 업데이트하
        
        //여기는 최종 문장을 출력할 데이터 생성을 위한 for문.
        for(String text : record){
        
            String[] info = text.split(" ");
            if(converMap.containsKey(info[0]))
                result.add(uid.get(info[1]) + converMap.get(info[0]));
    }

        return result.toArray(new String[0]);   //소름돋는다, 이렇게도 할 수 있구나!
    }


    public static void main(String[] args){

        String[] record = {   "Enter uid1234 Muzi"
                            , "Enter uid4567 Prodo"
                            , "Leave uid1234 Muzi"
                            , "Enter uid1234 Prodo"
                            , "Change uid4567 Ryan"
                          };
        
        String[] result = logChatEntry(record);
        System.out.println("rersult : " + Arrays.toString(result));
    }
}
