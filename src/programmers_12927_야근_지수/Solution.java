package programmers_12927_야근_지수;

/**
 문제이해
 퇴근까지 남은 시간과 야근 피로도를 최소화 하는 값을 구하여 출력해라

 제한사항
 works는 길이 1 이상, 20,000 이하
 works의 원소는 50000 이하인 자연수
 n은 1,000,000 이하인 자연수

 풀이과정
 [4, 3, 3] 4
 2 2 2 -> 4 * 3 -> 12

 [2, 1, 2] -> 1 1 2 -> 1 1 4 -> 6

 [1,1] -> 3 -> 0

 1. 우선순위 큐에 넣는다.
 2. 높은 값이 나오는 순서대로 -1를 해주고 다시 add 해줍니다.
 3. n만큼 for문이 끝나면 다시 야근 피로도를 계산합니다.

 **/

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        // 초기에 넣는다.
        for (int w : works) {
            pq.add(w);
        }

        for (int i = 0; i < n; i++) {
            if (pq.isEmpty()) {
                break;
            }
            int num = pq.remove() - 1;
            if (num <= 0) {
                continue;
            }
            pq.add(num);
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            int num = pq.remove();
            answer += (num * num);
        }
        return answer;
    }
}
