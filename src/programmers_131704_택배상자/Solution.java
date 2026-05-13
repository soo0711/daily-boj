package programmers_131704_택배상자;

/**
 문제이해
 컨테이너벨트에 놓인 상자를 택배상자에 넣어야하는 순서로
 넣을 수 있게 하고, 넣을 수 있는 최대 수를 구하여라

 제한사항
 1 ≤ order의 길이 ≤ 1,000,000
 order[i]번째 상자를 i+1번째로 트럭에 실어야함

 풀이과정
 1. stack의 peek나
 [4, 3, 1, 2, 5]
 1 2 3 4 5
 네 번째, 세 번째, 첫 번째, 두 번째, 다섯 번째
 [3, 2, 1, 4, 5]

 **/

import java.util.*;

class Solution {
    public int solution(int[] order) {

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        int idx = 0;
        stack.add(num);

        while(num <= order.length) {

            if (!stack.isEmpty()) {
                int o = stack.peek();

                if (o == order[idx]) {
                    idx++;
                    stack.pop();
                    continue;
                }
            }
            stack.add(++num);
        }

        int answer = idx;
        return answer;
    }
}
