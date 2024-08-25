package Stack;

import java.util.*;
// 8월 25일 일요일.
public class Q13_DollCraneMachine {
    
    private static int dollCraneMachine(int[][] board, int[] moves){

        int len = board.length;

        //1.1.Integer 값을 저장하는 스택을 담을 배열을 생성한다. 
        Stack<Integer>[] lanes = new Stack[len];                        // 각 열에 대한 스택을 생성한다.
        for(int i = 0; i < lanes.length; i++)
            lanes[i] = new Stack<>();                                   // 위에서 생성한 배열에 스택을 만들어서 담는다. 위에서 lane은 Integer를 저장하는 스택을 담는 배열이라고 정보가 나와있다
            
        // 1.2.board를 역순으로 탐색하여 각 열에 인형을 lanes에 추가한다.
        // 역순으로 탐색하는 이유는 input을 보면 이해할 수 있다.
        for (int i = board.length - 1; i >= 0; i--) {                   // 첫번째 → i = 4, index가 0 부터이기 때문에 -1을 한듯.
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0)                                    // 0이면 push 하지 않음.
                    lanes[j].push(board[i][j]);
            }
        }

        // 데이터 확인
        for(int i = 0; i < lanes.length; i++)
            System.out.println(lanes[i]);

        /* 여기까지는 인형뽑기 기계를 세팅하는 작업 */
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        // 인형을 담을 바구니를 생성.
        Stack<Integer> bucket = new Stack<>();

        // 사라진 인형의 총 개수를 저장할 변수를 초기화 한다.
        int dollCnt = 0;
        
        //moves 배열을 순회하며, 각 열에서 인형을 뽑아 바구니에 추가한다.
        for(int peek : moves){

            //체크해야 할 경우만 즉, 해당 열에 인형이 있는 경우 
            if(!lanes[peek-1].isEmpty()){                                                       // lanes가 배열이기 때문에 index를 고려하여 무조건 -1 처리 함.

                int doll = lanes[peek -1].pop();                                                // lanes[peek -1] 자체가 stack이기 때문에 이는 stack.pop()과 동일함.
                //바구니가 비어있지 않고(= 인형이 담겨 있고), 가장 위에 있는 인형과 같은 인형일 경우
                if(!bucket.isEmpty() && bucket.peek() == doll){

                    bucket.pop();
                    dollCnt += 2;                                                               // += 2는 dollCnt = dollCnt + 2;와 같다.
                }else                                                                           // 바구니에 인형이 없거나, 가장 위에 있는 인형과 다른 경우.
                    bucket.push(doll);  
            }
        }
        
        return dollCnt;
    }

    public static void main(String[] args){

        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves   = {1, 5, 3, 5, 1, 2, 1, 4};

        int result = dollCraneMachine(board, moves);
        System.out.println("사라진 인형의 개수 : " + result);
    }
}
