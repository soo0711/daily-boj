package programmers_42628_이중우선순위큐;

/**
 문제이해
 이중 우선순위 큐의 명령어를 실행하고
 최댓값, 최솟값을 return해라.

 제한사항
 operations는 길이가 1 이상 1,000,000 이하
 operations의 원소는 큐가 수행할 연산
 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제
 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우 - 해당 연산은 무시

 풀이과정
 1. 이중 우선순위 큐를 사용한다. -> 초기에 큐에 넣는다.
 2. | 숫자 -> 큐를 삽입한다.
 3. D 1 -> 최댓값 삭제 -> 덱에 넣엇다가 삭제 후 다시 우선순위큐에 넣는다.
 4. D -1 -> 최솟값 삭제
 5. D 1 || D -1 을 하려는데 큐가 비어 있으면 넘김

 **/

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
        Map<Integer, Integer> map = new HashMap<>();

        for (String operation : operations) {
            String[] o = operation.split(" ");
            if (o[0].equals("I")) {
                min.add(Integer.parseInt(o[1]));
                max.add(Integer.parseInt(o[1]));
                map.put(Integer.parseInt(o[1]),
                        map.getOrDefault(Integer.parseInt(o[1]), 0) + 1);
            } else {
                if (min.isEmpty() && max.isEmpty()) {
                    continue;
                }
                if (o[1].equals("-1")) {
                    while(!min.isEmpty() && map.get(min.peek()) == 0) {
                        min.remove();
                    }

                    if (!min.isEmpty()){
                        int num = min.remove();
                        map.put(num, map.get(num) - 1);
                    }
                } else {
                    while(!max.isEmpty() && map.get(max.peek()) == 0) {
                        max.remove();
                    }

                    if (!max.isEmpty()){
                        int num1 = max.remove();
                        map.put(num1, map.get(num1) - 1);
                    }
                }
            }
        }

        // 남아있는 유령 숫자 지워주기
        while(!min.isEmpty() && map.get(min.peek()) == 0) {
            min.remove();
        }

        while(!max.isEmpty() && map.get(max.peek()) == 0) {
            max.remove();
        }


        int[] answer = new int[2];
        if(!min.isEmpty() && !max.isEmpty()) {
            answer[0] = max.peek();
            answer[1] = min.peek();
        }

        return answer;
    }
}
