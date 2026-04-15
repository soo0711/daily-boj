package programmers_42747_H_Index;

/**
 문제이해
 과학자의
 n편 중 h번 이상 인용된 논문이 h편 이상이고, 나머지 논문이 h번 이하 인용 된
 최대 h를 h-index라고 하는데
 h-index를 찾아라

 제한사항
 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
 논문별 인용 횟수는 0회 이상 10,000회 이하입니다.

 풀이과정
 1. 정렬
 2. 0~n 만큼 돌면서 최대값을 찾는다.
 0 1 3 5 6
 3. array[i] = 0 h 보다 크거나 같으면 넘어감
 4. h보다 작으면 i를 ++

 1 3 5 6

 n = 5
 h = 0
 i = 0
 array[i] 1 >= h
 검증 n-i >= h

 h = 1
 i = 0
 1 >= 1

 **/
import java.util.*;

class Solution {
    public int solution(int[] citations) {

        Arrays.sort(citations);
        int n = citations.length;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int h = n - i;

            if (citations[i] >= h) {
                return h;
            }
        }

        return answer;
    }
}
