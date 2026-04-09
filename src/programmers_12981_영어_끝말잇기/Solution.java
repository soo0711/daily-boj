package programmers_12981_영어_끝말잇기;

/**
 풀이과정
 끝말잇기를 하는데 가장 먼저 탈락하는 사람의 번호와 몇 번째 차레에 탈락하는 지를 구하여라

 제한사항
 참여하는 사람의 수 n은 2 이상 10 이하
 알파벳 소문자
 [ 번호, 차례 ]
 탈락자가 생기지 않는다면, [0, 0]

 풀이과정
 1. 검사하는 함수를 만든다.
 2. 검사를 통과 && 중복이 아니면 통과한 사람
 3. 통과 못하면 탈락자 -> 차례 % n -> 번호
 4. 검사를 하는 방식 전 단어와 현재 단어를 받아서 현재 앞과 단어의 끝을 검사.

 **/

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};


        // 중복 체크
        Set<String> set = new HashSet<>();
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String current = words[i];

            if(!isPass(prev, words[i]) || set.contains(words[i])) {
                return new int[] {(i % n) + 1, (i / n) + 1};
            }

            set.add(current);
        }

        return answer;
    }

    boolean isPass(String prev, String current) {

        return prev.charAt(prev.length() - 1) == current.charAt(0);
    }
}
