package programmers_152996_시소_짝꿍;

/**
 문제이해
 탑승한 사람의 무게와 시소 축과 좌석 간의 거리의 곱이
 양쪽 다 같은 시소 짝궁이 몇쌍 존재하는지 출력해라.

 제한사항
 2 ≤ weights의 길이 ≤ 100,000
 100 ≤ weights[i] ≤ 1,000
 - 몸무게 단위는 N(뉴턴)
 - 몸무게는 모두 정수

 풀이과정
 좌석: 2, 3, 4
 몸무게: 100,180,360,270
 - 같은 몸무게는 같은 거리에 마주 앉으면 균형
 - 180 * 4 = 360 * 2 = 720
 - 180 * 3 = 270 * 2 = 540
 - 270 * 4 = 360 * 3 = 1,080

 200 300 400
 360 540 720
 720 1080 1440
 540 810 1080

 1. 짝꿍이 되는 기준 1:1 / 1:2 / 2:3 / 4:3
 2. 같은 몸무게가 있는지 먼저 체크
 3. map을 이용해서 넣는다.
 4. map에서 꺼내서 몸무게의 비율이 넣었을때 빈도수가 있으면 +

 **/
import java.util.*;

class Solution {
    public long solution(int[] weights) {

        long answer = 0;

        // 빈도수 세기
        Map<Long, Long> map = new HashMap<>();
        for (long w : weights) {
            map.put(w, map.getOrDefault(w, (long) 0) + 1);
        }

        long sameWeight = 0;
        // 비율이 있는지 확인
        for (long w : weights) {

            // 1 : 1
            sameWeight += (map.get(w) - 1);

            // 1 : 2
            if (map.containsKey(w * 2)) {
                answer += map.get(w * 2);
            }

            // 2 : 3
            if (w % 2 == 0 && map.containsKey(w * 3 / 2)) {
                answer += map.get(w * 3 / 2);
            }

            // 3 : 4
            if (w % 3 == 0 && map.containsKey(w * 4 / 3)) {
                answer += map.get(w * 4 / 3);
            }
        }

        answer += sameWeight / 2;

        return answer;
    }
}
