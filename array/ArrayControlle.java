package array;

import java.util.Arrays;
import java.util.Collections;

public class ArrayControlle {
    
    // 참고 영상 : https://www.youtube.com/watch?v=mUJGw_b6DfI
    // Java 8(2014년)에 추가 된 Steam API
    // Steam API를 활용하면 다양한 데이터 소스를 표준화된 방법으로 다룰 수 있다.
    // 이 스트림이라는 개념은 자바에서 두 가지 형태로 쓰이는데,
    // 기존에 I/O에 관련 된, 예를 들면 파일을 통해서 데이터를 읽고 쓰는 그런 작업들을 진행할 때
    // 사용하는 스트림 API 들이 있다.
    // 파일 인풋과 아웃풋, 키보드로 입력을 받는 System.in 그리고 System.out도 이 스트림의 하나이다.
    
    // 그리고 우리가 어떤 데이터들을 집합적으로 가지고 있을 때
    // 예를 들어서 특정 리스트에 데이터들을 가지고 있거나, 맵에 데이터를 가지고 있을 때.
    // 즉, 컬렉션 프레임워크를 이용해서 다량의 데이터들을 우리가 관리할 때
    // 가령 이 데이터들을 조작할 때 조금 더 편리하고 가독성있게 처리할 수 있도록 도와주는 역할을 한다.
    
    // * 스트림(Stream)은 문자열화(Stringification)와는 다르다. 
    //   스트림은 데이터를 일련의 연산을 통해 처리할 수 있도록 순차적으로 흐르게 하는 개념
    
    public static void mian(String[] args){

        System.out.println(Arrays.toString(new int[]{4, 2, 2, 1, 3, 4}));
    }

    private static int[] solution(int[] arr){

        // 개념 : 메서드 체이닝
        // 장점 :  
        //       1) 연속적인 연산: 데이터를 처리하는 여러 단계를 한 줄에 연속적으로 표현할 수 있습니다.
        //       2) 불변성 유지: 각 단계에서 새로운 객체를 반환하는 경우, 원본 데이터의 불변성을 유지하면서 데이터 처리 작업을 수행할 수 있습니다.

        //distinct() : 스트림에서 중복된 요소를 제거하는 메서드. 이 메서드를 사용하면 배열의 중복 값을 제거할 수 있다.
        //배열중 Set은 중복을 허용하지 않는 컬렉션.
        Integer[] uniqueArr = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new); //중복값 제거
        
        // 코드해석
        // 1) Arrays.stream(arr).boxed()
        //    - Arrays.stream(arr) : 주어진 정수 배열 arr을 스트림으로 변환한다.
        //    - .boxed()           : 기본형 int 배열을 참조형 Integer 객체 배열로 변환한다.
        //                           이는 기본형 배열에서는 사용할 수 없는 메서드(ex : distinct(), sort())를 사용하기 위해 필요하다.
        //                           즉, int 타입의 배열을 Integer 타입으로 변환하여 스트림의 메서드를 사용할 수 있게 해준다. 
        
        Arrays.sort(uniqueArr, Collections.reverseOrder());                                  //내림차순 정렬 
        
        // mapToInt(Integer::intValue): Integer 객체를 기본형 int로 매핑합니다. 이 메서드는 각 Integer 객체를 int로 변환합니다.
        // toArray(): 최종적으로 스트림의 결과를 int 배열로 변환하여 반환합니다.
        int [] result = Arrays.stream(uniqueArr).mapToInt(Integer::intValue).toArray();      //int형 배열로 변경 후 반환할 결과 값.
        return result;

        // a :: b : 메서드 참조(Method Reference)를 사용하는 표현
    }
}

    // 정리하고 가기!
    // 가) 배열과 컬렉션의 차이
    //    1) 크기
    //       - 배열   : 배열의 크기는 고정되어 있으며, 생성 시 크기를 지정해야 한다. 이후 크기 변경이 불가.0 
    //       - 컬렉션 : 컬렉션은 동적 크기를 가지며, 요소를 추가하거나 삭제할 때 자동으로 크기가 조정된다.
    
    //    2) 데이터 타입
    //       - 배열   : 배열은 기본형 데이터 타입(ex : int, char, double)과 객체 타입 모두를 저장할 수 있다.
    //                 단, 같은 배열 내에서는 동일한 데이터 타입만 저장할 수 있다.
    //       - 컬렉션 : 컬렉션은 객체를 저장하는 데 사용되며, 제네릭을 통해 다양한 타입을 다룰 수 있다. 
    
    //    3) 기능
    //       - 배열   : 배열은 기본적인 데이터 구조로, 인덱스를 사용하여 요소에 접근한다.
    //                  그 외에 특별한 메서드는 제공되지 않는다.
    //       - 컬렉션 : 컬렉션은 다양한 메서드(예 : 추가, 삭제, 검색 등)를 제공하여 데이터를 보다 쉽게 관리할 수 있다.
    //                 ex) 예를 들어, ArrayList는 add(), remove(), contains()등의 메서드를 지공한다.
    
    //    4) 성능
    //       - 배열   : 배열은메모리에서 연속적으로 저장되기 때문에 성능이 좋고, 인덱스를 통해 빠른 접근이 가능.
    //       - 컬렉션 : 컬렉션은 내부적으로 배열을 사용하여 구현되지만, 크기 조정 및 요소 관리에 추가적인 오버헤드가 발생할 수 있다. 
    //                 그러나 대부분의 경우, 성능 차이는 미미.
    
    //    5) 사용 예
    //       - 배열   : 고정된 크기의 데이터 집합을 다룰 때 유용. 예를 들어 학생의 점수, 주간 일정 기록 등.
    //       - 컬렉션 : 데이터의 추가, 삭제, 검색이 빈번하게 발생하는 경우에 적합
    //                 예를 들어, 사용자 목록, 상품 카탈로그 등 관리시

    //    같이 수업을 듣던 사람 중에 하나가 무조건 배열말고 ArrayList를 쓰면된다고 말하는걸 들었는데
    //    컬렉션이 배열의 단점을 보완하고자 나왔음에도 배열이 계속 쓰이는 이유는 특별하게 정렬이나 다른 기능을 쓰지않으면
    //    성능차이도 미미하니까 기존걸 그냥 쓰는게 아닐까... 란 생각을 해봄;;;

    // 배열 예제
    //int[] numbers = new int[5]; // 크기가 5인 배열 생성
    //numbers[0] = 1;
    //numbers[1] = 2;

    // 컬렉션 예제
    // 아무것도 import 하지 않아도 되는 배열에 반해, 컬렉션은 컬렉션 프레임워크 import가 필요하군.
    //import java.util.ArrayList;

    //ArrayList<Integer> numberList = new ArrayList<>();                                        // ArrayList 생성
    //numberList.add(1);                                                                        // 요소 추가
    //numberList.add(2);

    // -------------------------------------------------------------------------------------------------------------------------------------------

    // 자바 컬렉션
    // 1) 정의 : 자바에서 데이터를 저장하고 관리하는 객체의 그룹을 의미.
    //           컬렉션은 여러 개의 객체를 한 곳에 모아 처리할 수 있게 해주는 데이터 구조이다.
    //           (다수의 요소를 하나의 그룹으로 묶어 효율적으로 저장하고, 관리할 수 있는 기능을 제공하는 일종의 컨테이너)
    // 2) 종류 : 자바 컬렉션에는 리스트, 세트, 맵, 등이 포함된다.

    // 자바 컬렉션 프레임워크
    // 1) 정의 : 자바 컬렉션 프레임워크는 자바에서 컬렉션을 다루기 위한 표준화된 아키텍처.
    //          이 프레임워크는 다양한 컬렉션 클래스와 인터페이스를 포함하여, 컬렉션을 보다 쉽게 사용할 수 있도록 돕니다.

    // * 요약하자면 1) 컬렉션은           : 데이터의 집합으로, 여러 객체를 모아 처리할 수 있는 구조를 의미하고
    //             2) 컬렉션 프레임워크는 : 컬렉션을 다루기 위한 표준화된 클래스와 인터페이스의 집합으로, 컬렉션을 보다 쉽게 사용할 수 있도록 돕는 아키텍처.
    //   결론적으로, 자바 컬렉션은 컬렉션 프레임워크의 일부이며, 자바 컬렉션 프레임워크는 컬렉션을 관리하고 사욯알 수 있는 더 넓은 구조를 제공.

    // -------------------------------------------------------------------------------------------------------------------------------------------

    // * 자바 컬렉션 프레임워크는 자바 표준 라이브러리의 일부로(포함되어 있어), 자바를 설치하면 기본적으로 제공된다.
    //   즉, 별도로 설치할 필요 없이 자바 개발 환경에서 (import 하면)바로 사용할 수 있다. 
    //   ex) import java.util.ArrayList;
    //   개발자가 쉽고 효율적으로, 데이터를 저장하고 관리할 수 있도록 다양한 기능을 제공한다.