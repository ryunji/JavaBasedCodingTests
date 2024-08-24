package MockTest;

import java.util.Arrays;
import java.util.HashMap;

public class CharacterPosition {
    
    private static int width;
    private static int height;

    // 보드에서 경계좌표를 벗어나는지 확인하는 메서드(메소드는 일본어에서 유래된 표기법, 공식적인 문서나 코드에서는 매서드가 바람직함)
    private static boolean isInBounds(int x ,int y, int dx, int dy){

        //Math.abs는 절대값을 반환하는 기능.
        boolean isInBounds  = Math.abs(x + dx) <= width && Math.abs(y + dy) <= height;
        return isInBounds ;
    } 

    public static int[] solution(String[] keyInput, int[] board){

        // 캐릭터 초기 위치값 설정
        int x = 0;
        int y = 0;

        // key - value
        // 각 4개의 방향 즉 위, 아래, 좌, 우에 대한 x, y 움직임 좌표값을 -1 ~ 1 사이값으로 표현.
        HashMap<String, int[]> moves = new HashMap<>();
        moves.put("up",    new int[]{0,  1});                                               // x 좌표에 대한 이동이 없었기 때문에 0
        moves.put("down",  new int[]{0, -1});
        moves.put("left",  new int[]{-1, 0});                                               // y 좌표에 대한 이동이 없었기 때문에 0
        moves.put("right", new int[]{1,  0});

        // 게임 경계좌표, board의 가로 크기와 세로크기가 홀수이기 때문에 2로 나누는 듯,
        // 이렇게 하면 모자르지만 넘어가지 않기 때문에.
        width  = board[0] / 2;  //board의 가로 크기
        height = board[1] / 2;  //board의 세로 크기

        // 향상된 for문 : 배열이나 컬렉션 요소를 반복(iterate)할 때 사용.
        // String key → ex) "up"
        for(String key : keyInput){

            //지역변수, d는 delta(Δ(델타)) 또는 difference 변화량을 의미.
            int dx = moves.get(key)[0];                                                         // 만약 key가 "up"이면 0
            int dy = moves.get(key)[1];                                                         // 만약 key가 "up"이면 1

            // 캐릭터가 게임 맵 경계밖에 위치하는지 체크
            if(isInBounds(x, y, dx, dy)){
                x += dx;
                y += dy;
            }
        }

        int[] characterPosition = {x, y};
        
        //캐릭터의 최종 위치를 반환한다.
        return characterPosition;
    }

    public static void main(String[] args){

        String[] keyInput = {"left", "right", "up", "right", "right"};
        int[]    board    = {11, 11};
        int[] characterPosition1 = solution(keyInput, board);
        System.out.println("캐릭터의 최종 위치1 : " + Arrays.toString(characterPosition1));

        keyInput = new String[]{"down", "down", "down", "down"};
        board = new int[]{7, 9};
        int[] characterPosition2 = solution(keyInput, board);
        System.out.println("캐릭터의 최종 위치2 : " + Arrays.toString(characterPosition2));
    }
}
