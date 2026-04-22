package programmers_64065_튜플;

/**
 문제이해
 특정 튜플을 표현하는 집합이 담긴 문자열이 매개변수로 주어질 때,
 s가 표현하는 튜플을 출력해라

 제한사항
 s의 길이는 5 이상 1,000,000 이하
 s는 숫자와 '{', '}', ',' 로만 이루어져 있다.
 0으로 시작하는 경우는 없습니다.
 항상 중복되는 원소가 없는 튜플을 올바르게 표현
 튜플의 원소는 1 이상 100,000 이하인 자연수
 배열의 길이가 1 이상 500 이하인 경우 입력으로 주어짐

 풀이방법
 1. 문자열 분리
 2. {, }, , 나오면 넘기고 숫자나오면 넣기
 3. {~~} 안에 숫자 여러개면 길이에 따라서 넣기
 4. {{4,2,3},{3},{2,3,4,1},{2,3}}
 5. 길이 1개 -> 첫번째 3
 6. 길이 2개 -> 3포함됐으니까 다음은 2
 7. 길이 3개 -> 2,3 있으니까 다음 4
 8. 길이 4개 -> 2, 3, 4 있으니까 -> 1

 **/

import java.util.*;

class Solution {
    public int[] solution(String s) {

        List<String> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length() -1; i++) {
            if (s.charAt(i) == '}') {
                list.add(sb.toString());
                sb = new StringBuilder();
            } else if (s.charAt(i) != '{') {
                sb.append(s.charAt(i));
            }
        }

        // 1개 일 때 return
        if (list.size() == 1) {
            return new int[] {Integer.parseInt(list.get(0))};
        }

        Collections.sort(list, (a, b) -> a.length() - b.length());

        // 여러개 일 때
        Set<String> set = new HashSet<>();
        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String[] n = list.get(i).split(",");
            for (String nn : n) {
                if (nn.equals("")) {
                    continue;
                }
                if (!set.contains(nn)) {
                    set.add(nn);
                    num.add(Integer.parseInt(nn));
                }
            }
        }


        int[] answer = new int[num.size()];
        for (int i = 0; i < num.size(); i++) {
            answer[i] = num.get(i);
        }

        return answer;
    }
}
