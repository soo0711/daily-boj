package programmers_42586_기능개발;

/**
 문제이해
 기능을 속도에 맞춰서 처리한다.
 기능이 100로면 배포할 수 있지만, 기능순서대로 배포 해야한다.

 제한사항
 작업의 개수(progresses, speeds배열의 길이)는 100개 이하
 작업 진도는 100 미만의 자연수
 작업 속도는 100 이하의 자연수
 배포는 하루에 한 번

 풀이과정
 1. 먼저 들어온게 먼저 나가야함 -> 큐
 2. 첫번째 기능의 100 - 작업률 95 = 5/1 = 5일 걸림
 3. 나머지 애들도 다  진행율 + 속도 * 이전기능진행기간해줌
 4. 그리고 큐 peek가 100이상이면 아웃

 근데 나머지 애들에 진행율 + 속도 * 이전기능진행기간은 어떻게 해주지????

 리스트 끝날때까지
 93
 100 - 93 = 7 / 1 = 7 + 7%1 == 0 이면 0 / !=이면 1
 아웃
 다음 인덱스 큐에 넣음
 30 + 30 * 7 = 210  > 100 면 ++
 그리고 아웃
 다음 인덱스 큐에 넣음
 55 + 5 * 7= 90

 100 - 90 = 10 / 5 = 2
 기간 = 7 + 2
 아웃
 ..

 **/

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> list = new ArrayList<>();
        Queue<Node> que = new LinkedList<>();

        // 초기 세팅
        for (int i = 0; i < progresses.length; i++) {
            que.add(new Node(progresses[i], speeds[i]));
        }

        int day = 1;
        while(!que.isEmpty()) {
            int cnt = 1;
            Node node = que.remove();
            int num = 100 - node.pro;
            day = num / node.speed;
            if (num % node.speed != 0) {
                day++;
            }

            node = que.peek();
            while(!que.isEmpty() && node.pro + node.speed * day >= 100) {
                cnt++;
                que.remove();
                if (que.peek() != null) node = que.peek();
            }

            list.add(cnt);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    class Node {
        int pro;
        int speed;

        Node(int pro, int speed) {
            this.pro = pro;
            this.speed = speed;
        }
    }
}
