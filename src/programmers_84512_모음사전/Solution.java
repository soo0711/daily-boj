package programmers_84512_모음사전;

/**
 문제이해
 단어가 주어질 때 사전에서 몇 번째 단어인지 출력해라

 제한사항
 word의 길이는 1 이상 5 이하
 word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'


 풀이과정
 1. 'A', 'E', 'I', 'O', 'U' 경우의 수를 map에 넣어두고
 2. key 값을 넣으면 몇 번째 단어인지 출력
 3. dfs를 사용하자 -> 모든 경우의 수를 넣으려고

 A, AA, AAA, AAAA, AAAAA, AAAAE
 **/

import java.util.*;

class Solution {
    int cnt = 0;
    Map<String, Integer> map = new HashMap<>();
    String[] s = {"A", "E", "I", "O", "U"};

    public int solution(String word) {

        // 초기 세팅
        dfs(0, "");

        int answer = map.get(word);
        return answer;
    }

    void dfs(int depth, String word) {
        if (depth == s.length) {
            return;
        }

        for (int i = 0; i < s.length; i++) {
            String temp = word + s[i];
            map.put(temp, ++cnt);
            dfs(depth + 1, temp);
        }
    }
}
