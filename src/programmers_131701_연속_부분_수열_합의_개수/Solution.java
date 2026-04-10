package programmers_131701_연속_부분_수열_합의_개수;

/**
 풀이과정
 연속하는 숫자의 합의 개수를 구하여라.
 길이가 1일 때, 2일 때, 3일 때, 4일 때....n일 때

 제한사항
 3 ≤ elements의 길이 ≤ 1,000
 1 ≤ elements의 원소 ≤ 1,000
 중복되는 값을 제거해라

 풀이과정
 1. Set에 연속하는 숫자를 넣는다. (중복 x)
 2. 길이가 1일 때, 2일 때, 3일 때를 구한다.
 어떻게? -> 큐를 사용해서 사용한 건 뒤로 보낸다.
 그럼 언제 끝? ->

 풀이방법 2
 1. 79114 -> 01234
 2. 91147 -> 12340
 3. ..
 set에 넣고 더하기

 **/

import java.util.*;

class Solution {
    public int solution(int[] elements) {

        int n = elements.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += elements[(i + j) % n];
                set.add(sum);
            }
        }

        // set의 개수 (중복 X)
        int answer = set.size();
        return answer;
    }
}
