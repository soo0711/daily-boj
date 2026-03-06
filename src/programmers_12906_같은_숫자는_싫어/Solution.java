package programmers_12906_같은_숫자는_싫어;

/**
 문제 이해
 - 연속 숫자 제거해서 출력하기

 제한 사항
 - 배열의 크기 1,000,000
 - 순서를 유지해야함

 풀이과정
 - 스택과 큐 모두 구현할 수 있는 덱을 사용해서
 - 덱이 비어있거나 먼저 가장 뒤에 있는 것이 입력과가 다르면
 - add 해주고
 - 배열에 덱을 remove해준 뒤
 - 배열 출력
 **/
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {


        Deque<Integer> deq = new ArrayDeque<>();

        for (int num : arr) {
            if (deq.isEmpty() || deq.peekLast() != num) {
                deq.add(num);
            }
        }
        int[] answer = new int[deq.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = deq.remove();
        }

        return answer;
    }
}
