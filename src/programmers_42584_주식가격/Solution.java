package programmers_42584_주식가격;

/*
문제이해
주식가격이 떨어지지 않은 기간은 몇초인지 출력해라

제한사항
prices의 각 가격은 1 이상 10,000 이하
prices의 길이는 2 이상 100,000 이하

풀이과정
[1, 2, 3, 2, 3]
[4, 3, 1, 1, 0]
1초 1 -> 나머지 기간동안 떨어지지 않음 -> 4초
2초 2 -> 나머지 기간 동안 떨어지지 않음 -> 3초
3초 3 -> 뒤에 떨어짐 -> 3초->4초만 떨어지지 않음 -> 1초
4초 2 -> 뒤에 떨어지지 않음 -> 1초
5초 3 -> 뒤에 없음 -> 0초
1. 스택을 만든다.
2. 스택에 넣는다.
3. 스택 top과 지금 값과 비교하여 작은지 비교한다.
-> 작으면 지금 인덱스와 빼서 저장한다.

*/

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {

        // 스택
        Stack<Integer> stack = new Stack<>();

        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty()
                    && prices[stack.peek()] > prices[i]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.add(i);
        }

        while (!stack.isEmpty()) {
            int prevIndex = stack.pop();
            answer[prevIndex] = prices.length - prevIndex - 1;
        }

        return answer;
    }
}
