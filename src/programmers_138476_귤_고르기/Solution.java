package programmers_138476_귤_고르기;

/**
 문제이해
 귤 k개를 고를 대 크기의 종류가 최소가 되게 하자
 귤의 종류 개수 return

 제한 사항
 1 ≤ k ≤ tangerine의 길이 ≤ 100,000
 1 ≤ tangerine의 원소 ≤ 10,000,000

 풀이과정
 1, 3, 2, 5, 4, 5, 2, 3
 총 개수 8개
 -> 2개 제거
 1 1
 2 2
 3 2
 4 1
 5 1

 5 2 3
 작은거 두개 삭제

 총 개수 8개
 -> 4개 제거
 2 3 -> 2개

 1. Map에 넣어서 개수를 센다.
 2. Map의 key를 뽑아서 정렬시킨다.
 3. 제거 개수 만큼 개수를 없앤다.
 4. 남은 개수 return
 **/

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> key = new ArrayList<>(map.keySet());
        Collections.sort(key, (a, b) -> map.get(b) - map.get(a));

        int answer = 0;
        int cnt = 0;
        for (int i = 0; i < key.size(); i++) {
            if (cnt >= k) {
                break;
            }
            cnt += map.get(key.get(i));
            answer++;
        }

        return answer;
    }
}
