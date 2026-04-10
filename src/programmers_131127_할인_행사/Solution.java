package programmers_131127_할인_행사;

/**
 문제이해
 원하는 할인품목 모두를 살 수 있는 회원 등록 날짜 일수를 구해서 return

 제한사항
 가능한 날이 없으면 0을 반환
 number[i]는 want[i]의 수량을 의미하며, number의 원소의 합은 10입니다.
 want와 discount의 원소들은 알파벳 소문자

 풀이과정
 회원자격은 10일
 1. 첫 날 10일을 했을 때 구할 수 있는 개수를 넣어둔다.
 2. 개수와 일치하거나 넘으면 answer++
 3. 아니면 포인터를 왼쪽으로 옮겨서 첫날에 있던 개수를 빼고 추가되는 품목을 더해준다.
 4. 슬라이딩을 할 수 있을 때까지 반복한다.

 banana=3, apple=2, rice=2, pork=2, pot=1
 "apple", "banana", "rice", "apple",
 "pork", "banana", "pork", "rice","pot", "banana"


 , "apple", "banana"

 **/

import java.util.*;

class Solution {
    Map<String, Integer> map;
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // 개수를 담아둘 것
        map = new HashMap<>();
        // 초기세팅
        for (int i = 0; i < 10; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) +1);
        }
        // 조건에 부합하면 answer + 1
        if (isSame(want, number)) answer++;

        for (int i = 0; i < discount.length - 10; i++) {
            map.put(discount[i], map.get(discount[i]) - 1);
            map.put(discount[10 + i],
                    map.getOrDefault(discount[10 + i], 0) + 1);
            // 조건에 부합하면 answer + 1
            if (isSame(want, number)) answer++;
        }

        return answer;
    }

    boolean isSame(String[] want, int[] discount) {
        for (int i = 0; i < want.length; i++) {
            if (map.getOrDefault(want[i], 0) < discount[i]) {
                return false;
            }
        }
        return true;
    }
}

