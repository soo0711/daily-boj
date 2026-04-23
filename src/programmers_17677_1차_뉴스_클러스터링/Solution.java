package programmers_17677_1차_뉴스_클러스터링;

/**
 문제이해
 입력으로 돌아온 두 문자열의 자카드 유사도를 출력한다.
 유사도 값 * 65536 소수점 아래를 버린다.
 자카드 유사도란
 J(A, B) = A와 B의 교집합 / A와 B의 합집합

 제한사항
 문자열은 두 글자씩 끊어서 다중집합의 원소로 만든다.
 대문자와 소문자 차이는 무시한다.
 영문자로 된 글자 쌍만 유효하고, 기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다.
 A와 B가 공집하면 1이다.

 풀이과정
 1. str1 Map에 집합과 개수를 넣는다.
 넣을 때 모두 소문자로 바꾼다.
 쌍이 영문자가 아니라면 그 쌍은 버린다.

 2. str2도 1번과 같은 방식을 한다.

 3. str1과 str2가 같은 key가 있는지 확인하고 있으면 min(value, value)를 한다.
 없으면 max(value, value)

 4. int = 교집합/합집합 * 65536

 **/
import java.util.*;

class Solution {
    public int solution(String str1, String str2) {

        // 1. str1, str2 쪼개기
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        IsTwoWords(map1, str1.toLowerCase());
        IsTwoWords(map2, str2.toLowerCase());

        // 2. 공집합인지 확인
        if (map1.isEmpty() && map2.isEmpty()) {
            return 1 * 65536;
        }

        // 3. str1과 str2가 같은 key가 있는지 확인
        double min = 0;
        double max = 0;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                min += Math.min(map1.get(key), map2.get(key));
                max += Math.max(map1.get(key), map2.get(key));
            } else {
                max += map1.get(key);
            }
        }

        // 4. 나머지 str2 넣기
        for (String key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                max += map2.get(key);
            }
        }

        // 5. 자카드 유사도 계산
        double j = (min / max) * 65536;
        int answer = (int) j;
        return answer;
    }

    void IsTwoWords(Map<String, Integer> map, String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < str.length(); i++) {
            char c1 = str.charAt(i - 1);
            char c2 = str.charAt(i);

            if (c1 >= 'a' && c1 <= 'z' && c2 >= 'a' && c2 <= 'z') {
                String s = "" + c1 + c2;
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
    }
}
