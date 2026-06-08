package programmers_42583_다리를_지나는_트럭;

/**
 문제이해
 모든 트럭이 다리를 건너려면 몇 초가 걸리는 지 출력해라.

 제한사항
 bridge_length는 1 이상 10,000 이하
 weight는 1 이상 10,000 이하
 모든 트럭의 무게는 1 이상 weight 이하
 truck_weights의 길이는 1 이상 10,000 이하

 풀이과정
 0 / 2 / 10 / 7, 4, 5, 6
 현재 올라가 있는 무게
 현재 올라가 있는 트럭의 수
 추가는 시간당 한 트럭만
 1. 클래스 - 무게, 도착하는 시간
 2. 큐에 넣는다. - 7, 3
 3. 시간 for문으로 큐의 도착시간이면 pop한다.
 4. 만약 다리 위의 수와 무게 조건에 만족하면 시간마다 add해준다.
 5. que가 비어있으면 break;


 **/
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        // 다리 위에 있는 트럭
        Queue<Truck> que = new LinkedList<>();

        int idx = 0; // 배열 인덱스
        int cnt = 0; // 다리 위에 있는 트럭 수
        int sum = 0; // 무게 총합
        int answer = 0; // 시간

        while (idx < truck_weights.length || !que.isEmpty()) {
            answer++;

            // 제거할거 제거하기
            if (!que.isEmpty() && answer == que.peek().arrive) {
                Truck t = que.remove();
                cnt--;
                sum -= t.weight;
            }

            // 1대만 추가하기
            if (idx < truck_weights.length &&
                    cnt + 1 <= bridge_length &&
                    sum + truck_weights[idx] <= weight) {
                cnt++;
                sum += truck_weights[idx];
                que.add(new Truck(truck_weights[idx++],
                        answer + bridge_length));
            }
        }

        return answer;
    }

    class Truck {
        int weight;
        int arrive;

        Truck(int weight, int arrive) {
            this.weight = weight;
            this.arrive = arrive;
        }
    }
}
