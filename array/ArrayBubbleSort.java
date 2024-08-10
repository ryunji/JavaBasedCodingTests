package array;

import java.util.Arrays;

//24.08.10.토
public class ArrayBubbleSort {
    
    public static void main(String[] args){

        //https://www.youtube.com/watch?v=FmONHDWJyLk
        //배열초기화
        //int num[] = → JDK 1.x 버전일때 사용했던 표기법.
        //int[] num = → JDK 2.0 이후 버전일때부터 사용되는 표기법.

        //또한 배열이 생성 시, 값을 미리 가지고 있는 상태로 만들 수 있게되어
        //[] 사이에 배열의 길이값을 지정하지 않고 생략할 수 있음.
        //int[] nums = new int[]{1, 2, 3, 4, 5, 6 , 7}

        //그리고 1.4/5 버전 이후부터는 아예 new int[]까지 생략해서 사용할 수 있게 됨.
        //int[] nums = {1, 2, 3, 4, 5, 6 , 7}

        int[] arr    = new int[100000];
        long start   = System.currentTimeMillis();              //1초는 1000밀리초
        int[] bubble = bubbleSort(arr);
        long end     = System.currentTimeMillis();

        // Bubble 정렬에 걸리는 시간 측정
        // 1.008초 : 2.305초
        System.out.println((end - start) / 1000.0 + "초");
        start      = System.currentTimeMillis();
        int[] sort = useSortMethod(arr);
        end        = System.currentTimeMillis();

        // 정렬 API 코드 시간 측정
        // 0.001초 : 0.003초
        System.out.println((end - start) / 1000.0 + "초");

        // 두 배열의 값의 정렬이 같은지 확인한다.
        System.out.println(Arrays.equals(bubble, sort)); //true
    }

    private static int[] bubbleSort(int[] org){

        int[] arr = org.clone();                        //원본 배열 복제
        int n     = arr.length;                         //배열의 길이
        
        //참고영상 : https://www.youtube.com/watch?v=PvSsodJWuc4&list=PLq8wAnVUcTFVumZtWpBeZgK3iDEXmiMA1&index=100

        //for문을 한번만 쓰면, 한번만 순회해서 전체가 오름차순으로
        //정렬되는 것이 아님.
        //즉 한번만 정렬하는 것임.
        for(int i = 0; i < n; i++){                     //index는 0부터

            for(int j = 0; j < n - i - 1; j++){         //이미 정렬을 처리한 횟수가 있기 때문에, 이를 제외하기 위해서 n에서 -i 처리, 
                                                        //(이미 정렬된 값들을 또 다시 비교하는 불필요한 작업은 하지 않아도 되니까)
                                                        //그리고 마지막은 이미 그 자리가 정해져서 비교할 필요가 없기 때문에 또 -1을 해주는 것임.

                //만약 배열의 앞에 값이 뒤에 값보다 크면
                if(arr[j] > arr[j+1]){
                    
                    //두 숫자의 위치를 바꾼다.
                    int temp = arr[j];                  //큰 값인, 앞의 배열값을 temp에 담아놓는다.
                    arr[j] = arr[j+1];                  //그리고 큰 값이 있던 자리엔 뒤의 값을 할당한다.
                    arr[j + 1]= temp;                   //temp에 담은 값은 뒷자리에 할당한다.
                }
            }
        }

        return arr;
    }

    private static int[] useSortMethod(int[] org){

        int[] arr = org.clone();
        Arrays.sort(arr);
        return arr;
    }
}
