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

        //이중 for문을 사용하는 이유
        //만약 바깥쪽 for문을 한 번만 실행한다면, 가장 큰 수를 맨 뒤로 보내는 작업만 수행되고 나머지 요소들은 정렬되지 않은 상태로 남게된다.
        //따라서 배열 전체를 정렬하기 위해서는 바깥쪽 for문을 여러 번 반복하여 모든 요소들이 적절한 위치에 자리 잡도록 해야 한다.
        //즉, 버블 정렬은 인접한 요소만 비교하기 때문에, 한 번의 반복으로는 모든 요소가 정렬될 수 없다. 따라서 배열의 크기만큼 반복하며 모든 요소를 비교해야 한다. 
        //이를 위해 이중 for문을 사용하는 것이다.
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
