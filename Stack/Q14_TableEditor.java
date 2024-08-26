package Stack;

import java.util.Arrays;
import java.util.Stack;

public class Q14_TableEditor{

    private static String tableEditor(int row, int sel, String[] cmd){

        int len = row;
        //int now = ++sel;
        //System.out.println("now : " + now);

        // 1.삭제된 행의 인덱스를 저장할 스택 생성.
        //   이 스택은 나중에 삭제된 행을 복원하게 되는 경우에 사용하기 위해 필요하다.
        Stack<Integer> deletedRow = new Stack<>();                                  // 스택은 배열처럼 길이를 초기에 설정할 필요 없다.
        
        // 2.각 행을 기준으로 연산에 따른 위치를 표시하기 위한 배열     
        // 배열의 길이를 len + 2 한 이유는 경계값 때문 임.
        int[] up   = new int[len + 2];                                              // int값이 들어갈 수 있는 배열을 선언했고, 그 배열은 표의 행 개수에서 + 2만큼 임.
        int[] down = new int[len + 2];
        
        // 이 작업은 각 행의 이전행이 뭔지, 다음행이 뭔지 미리
        // 정해둔 것 같다.
        for (int i = 0; i < len + 2; i++){
            
            //*i는 현재 행
            
            //현재행 - 1 이 up행
            up[i]   = i - 1;                                                        //up[i]는 행 i의 위쪽 행의 인덱스.     up[0]   = -1; up[1]   = 0; ... up[9]   = 8;
            //현재행 + 1 이 down행
            down[i] = i + 1;                                                        //down[i]는 행 i의 아래쪽 행의 인덱스. down[0] = 1;  down[1] = 2; ... down[9] = 10;
        }   
        
        System.out.println("up   배열 : " + Arrays.toString(up));                   //up[0] 첫번째 행의 위 행은 -1, 0이 첫번째 행.
        System.out.println("down 배열 : " + Arrays.toString(down));
        // 현재 위치를 나타내는 인덱스
        // index가 0부터 시작하기 때문에 sel도 ++ 한 것임.
        // 이해를 위해 이미지를 확인해보면 테이블의 첫번째 행은 0 으로 되어있음
        // ex) 현재 위치하고 있는 행이 1이면 index로는 0;
        // sel++를 하는 이유는 배열에서 사용하기 위함.
        
        // 지금 주어진 행번호는 2인데 인덱스로는 3임. 
        // 헷갈리는게 지문에 처음 선택한 행의 위치를 나타내는 정수라고 되어있는데
        // 행번호라고 생각할 것.
        sel++;
        
        System.out.println("sel의 index : " + sel);
        for(String c : cmd){

            // 현재 위치를 삭제하고 그 다음 위치로 이동
            if (c.startsWith("C")) {                                        // 삭제명령어
                
                deletedRow.push(sel);                                              // 현재 선택 된 행의 인덱스를 저장.
                
                //현재 행의 윗 행을 

                //현재행의 윗행은 현재행 아래행의 윗행이 되어야 하고
                up[down[sel]] = up[sel];                                           // ex) sel이 3이면, up[4] = 2;
                
                //현재 행의 아래행은 현재행 위의 바로 아래행이 되어야 한다.
                down[up[sel]] = down[sel];
                //System.out.println("1.down[up[sel]] : " + down[up[sel]]);
                
                // 선택된 행이 삭제되었기 때문에
                // 현재 행을 다시 설정해야 한다.
                // 기본은 삭제 시, 아래행을 선택 함.
                // 전체 길이가 작아? 아래 행이 
                //System.out.println("2.down[sel] : " + down[sel]);
                sel = len < down[sel] ? up[sel] : down[sel];
            }else if (c.startsWith("Z")) {                                  // 삭제한 행 복원
                
                int restore = deletedRow.pop();                                    // 삭제되었던 행의 인덱스
                down[up[restore]] = restore;                                       // down[up[restore]] → 이걸 한글말로 풀어보면, 복원 된 행은 복원된 행의 윗 행의 아래가 되어야 하고
                up[down[restore]] = restore;                                       // 복원 된 행은 복원된 행의 아래행의 윗 행이 되어야 한다.
            }else {                                                                // 선택한 행 위치 변경.
                
                String[] s = c.split(" ");                                   // ex) c가 "D 2"라면 s는 {"D", "2"}
                int x      = Integer.parseInt(s[1]);                               //     s[1] → 2  
                for (int i = 0; i < x; i++) {
                    sel = s[0].equals("U") ? up[sel] : down[sel];
                }
            }
        }

        //삭제된 행의 위치에 'X'를, 그렇지 않은 행 위치에는 'O'를 저장한 문자열 반환
        char[] answer = new char[len];
        Arrays.fill(answer, 'O');   // 모든 칸에 O을 세팅.
        for (int i : deletedRow)        // 여기서의 i는 deletedRow안에 들어있는 인덱스를 의미.
            answer[i - 1] = 'X';        // -1을 하는 이유는 위에서 인덱스와 행의 괴리를 없애기 위해서 +1을 하고 스택에 넣었기 때문에 index적 측면에서 넣으려면 다시 -을 해야함.

        return new String(answer);
    }

    public static void main(String[] args){

        int row = 8;                                                          // 1.표의 행 개수
        int sel = 2;                                                          // 2.처음 선택한 행의 위치
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}; // 3.수행한 명령어들이 담긴 문자열 배열.
        
        // 중요한 건 
        // 결과로 행 삭제 후의 테이블이 아닌 테이블에서 행이 삭제 된 모습을
        // String 문자열(O와 X)로 모양을 출력하는 것이다.
        System.out.println(tableEditor(row, sel, cmd));
    }
}