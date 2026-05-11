package programmers_17684_3차_압축;

/**
 문제이해
 메시지를 LZW로 압축해라.

 제한사항
 msg의 길이는 1 글자 이상, 1000 글자 이하이다.
 영문 대문자만 처리

 풀이과정
 1. 단어 사전을 초기화한다. (길이가 1인 모든 단어를 포함)
 2. w를 찾는다. -> 긴 문자열을 찾는다.
 2-1. 있으면 번호 출력
 2-2. 없으면 w+c 사전에 등록
 3. 반복

 1. 초기화는 Map으로 진행한다.
 **/
import java.util.*;

class Solution {
    public int[] solution(String msg) {

        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        // 초기화
        for (int i = 1; i < 27; i++) {
            sb = new StringBuilder();
            char c = (char) (96 + i);
            sb.append(Character.toUpperCase(c));
            map.put(sb.toString(), i);
        }

        int num = 27;
        String[] word = msg.split("");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < word.length; i++) {
            // 가장긴문자열 찾기
            String w = word[i];
            int idx = 0;
            int j = i;
            while (map.containsKey(w) && j < word.length - 1) {
                idx = map.get(w);
                w += word[++j];
                if (map.containsKey(w)){
                    i++;
                }
            }

            if (i == word.length -1) {
                idx = map.get(w);
                list.add(idx);
                continue;
            }

            // 없으면 사전에 넣기
            map.put(w, num++);
            // 색인 출력
            list.add(idx);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
