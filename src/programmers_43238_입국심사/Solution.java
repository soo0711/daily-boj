package programmers_43238_입국심사;

/**
 ### 문제이해
 입국 심사를 받는데, 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 구해라

 ### 제한사항
 입국심사를 기다리는 사람은 1명 이상 1,000,000,000명 이하입니다.
 각 심사관이 한 명을 심사하는데 걸리는 시간은 1분 이상 1,000,000,000분 이하입니다.
 심사관은 1명 이상 100,000명 이하입니다.
 -> 시간 복잡도 조심
 -> long으로 쓰기

 ### 풀이과정1
 6
 7, 10
 1  1
 7 10 14 20 21 28 30


 1 10000000
 -> 6분

 123456

 7/10/

 가장짧은사람만 받으면
 42분

 max를 넘지 않는 한에서 list에 넣고
 줄 세우고
 n번째 시간을 추출

 -> 몇개 시간 초과 (당연함ㅜ)

 ### 풀이과정 2
 시간 안에 몇명 처리할 수 있는지 검사
 예를 들어
 28/7 = 4
 28/10 = 2

 총 6명

 1. 시간 0 ~ 최악의 시간 * n 값에서 n명 처리할 수 있는 곳을 찾기
 2. 시간 범위의 중간값을 찾아 왼쪽 오른쪽 탐색
 3. n과 같으면 시간 return

 오래걸렷던 점
 long 타입 변환
 **/
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {

        // 시간 탐색
        Arrays.sort(times);
        long answer = search(n, times);

        return answer;
    }

    long search(int n, int[] times) {
        long left = 0;
        long right = (long) times[times.length - 1] * n;
        long answer = right;

        while (left <= right) {
            long total = 0;
            long mid = (left + right) / 2;
            for (int time : times) {
                total += mid / time;
            }
            if (total >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
