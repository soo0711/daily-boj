package programmers_154539_뒤에_있는_큰_수_찾기;

/**
 문제이해
 배열의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크고 가장 가까이 있는 수를
 뒷 큰 수라고하는데 모든 원소에 대해 뒷큰수들을 차례로 담아서 출력해라.

 제한사항
 뒷큰수가 존재하지않으면 -1
 4 ≤ numbers의 길이 ≤ 1,000,000
 1 ≤ numbers[i] ≤ 1,000,000

 풀이과정
 [2, 3, 3, 5]
 3, 5, 5, -1

 [9, 1, 5, 3, 6, 2]
 -1, 5, 6, 6, -1, -1

 1. 스택을 사용한다.
 2. 스택이 비어있지않고, 뒷 숫자를 찾으면 pop
 3. 이게 아니면 push

 **/

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {

        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                    numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.add(i);
        }

        return answer;
    }
}
