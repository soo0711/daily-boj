package programmers_42627_디스크_컨트롤러;

/**
 문제이해
 우선순위 디스크 컨트롤러로 처리한 요청 작업의 반환시간 평균을 구하여라

 제한사항
 1 ≤ jobs의 길이 ≤ 500
 작업의 소요시간이 짧은 것,
 작업의 요청 시각이 빠른 것,
 작업의 번호가 작은 것 순으로 우선순위
 [작업이 요청되는 시점, 작업의 소요시간]

 풀이과정
 [[0, 3], [1, 9], [3, 5]]
 0, 3
 1. 우선순위 큐를 만든다.
 2. 작업 클래스를 만든다. 우선순위 정렬 기준을 만든다.
 3. 처음 큐에 넣고 큐에서 꺼낸다.
 4. 큐에서 꺼내서 현재시각 시작시간을 뺀다.
 **/

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // 초기화
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int sum = 0;
        int time = 0;
        int cnt = 0;
        int idx = 0;

        // 작업시간 계산
        while(cnt < jobs.length) {
            // 현재 시각과 같거나 그 이전에 도착한 작업만 큐에 넣는다.
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(new Node(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            // 시간 점프
            if (pq.isEmpty()) {
                time = jobs[idx][0];
            }

            // 큐에 대기 중인 작업
            else {
                Node n = pq.remove();
                time += n.add;
                sum += (time - n.req);
                cnt++;
            }
        }

        int answer = sum / jobs.length;
        return answer;
    }

    class Node implements Comparable<Node>{
        int num;
        int req;
        int add;

        Node (int num, int req, int add) {
            this.num = num;
            this.req = req;
            this.add = add;
        }

        @Override
        public int compareTo(Node n) {
            if (this.add != n.add) {
                return this.add - n.add;
            }

            if (this.req != n.req) {
                return this.req - n.req;
            }

            return this.num - n.num;
        }
    }
}
