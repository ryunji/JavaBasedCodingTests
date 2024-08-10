package array;

import java.util.Arrays;

//24.08.10.토
public class ArrayBubbleSort {
    
    public static void main(String[] args){

        int[] arr    = new int[100000];
        long start   = System.currentTimeMillis();
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
        for(int i = 0; i < n; i++){                     //index는 0부터

            for(int j = 0; j < n - i - 1; j++){

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
