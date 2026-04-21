package programmers_132265_롤케이크_자르기;

/**
 문제이해
 롤케이크 위에 놓인 토핑의 종류가 공평하게 잘릴 수 있는
 경우의 수를 구하여라.

 제한사항
 1 ≤ topping의 길이 ≤ 1,000,000
 1 ≤ topping의 원소 ≤ 10,000

 풀이과정
 1. [1, 2, 1, 3, 1, 4, 1, 2]
 2. 처음에 0, 1로 자르고
 3. 초기값을 세팅해둠 map 2개로
 4. 다음에 들어오는 넣음 -> 있으면 넘어가고 없으면 추가 뒤로가면 제거
 5. map의 개수가 같아지면 cnt++x

 **/

import java.util.*;

class Solution {
    public int solution(int[] topping) {

        // 초기 세팅
        Map<Integer, Integer> older = new HashMap<>();
        Map<Integer, Integer> younger = new HashMap<>();

        older.put(topping[0], 1);
        for (int i = 1; i < topping.length; i++) {
            younger.put(topping[i], younger.getOrDefault(topping[i], 0) + 1);
        }

        int answer = 0;

        // 슬라이딩 윈도우
        for (int i = 1; i < topping.length; i++) {
            if (older.size() == younger.size()) {
                answer++;
            }

            int t = topping[i];
            older.put(t, older.getOrDefault(t, 0) + 1);
            if (younger.get(t) == 1) {
                younger.remove(t);
            } else if (younger.get(t) > 1) {
                younger.replace(t, younger.get(t) - 1);
            }

        }

        return answer;
    }
}
