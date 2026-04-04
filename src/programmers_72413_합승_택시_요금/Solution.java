package programmers_72413_합승_택시_요금;

/**
 문제이해
 지점의 개수 n
 출발지점 s
 도착지점 a
 도착지점 b
 s에서 출발해 각자 a, b로 간다고 가정할 때
 최저 예상 택시 요금을 계산해라

 제한사항
 합승하지않고 각자 이동하는 경우 요금이 더 낮다면
 합승하지 않아도 된다.

 지점 3 ~200
 다 다른 값 중복 x
 fares 2차원 배열
 c, d, 2
 c ~ d 사이는 2원
 요금 100,000원


 풀이과정
 fares
 4, 1, 10
 3, 5, 24
 5, 6, 2
 3, 1, 41
 5, 1, 24
 4, 6, 50
 2, 4, 66
 2, 3, 22
 1, 6, 25

 x, y, node, fee -> class생성
 근접한 노드 이동으로 bfs 사용
 1. 4부터 시작
 2. 큐에 4를 넣음
 2-1. 이전에 6와 2를 도착하면 조건을 확인하지않음
 -> int[][]로 체크?
 3. 조건 - 방문하지 않고, 4로 시작하는 것을 찾음
 (혹은 요금을 0으로 만듦 -> 방문 표시)
 4,1,10
 4,6,50
 2, 4, 66

 큐에 1, 6, 2을 넣음
 1(10), 6(50), 2(66)

 가중치에 따라 1가중치에 cnt+=10

 큐 1 꺼냄
 3, 1, 41
 5, 1, 24
 1, 6, 25

 3(24), 6(25), 1(41), 6(50), 2(66)
 1 -> 5 10+24 =34

 큐 5를 꺼냄
 3, 5, 24
 5, 6, 2

 6을 꺼냄 34 + 2 = 36
 6갓다고 체크
 중간값 체크

 34 + 24 = 58 + 22 = 80

 3꺼내기 == 80

 3, 1, 41
 2, 3, 22
 3 -> 22

 80 + 36 - 34 = 82

 풀이과정 2
 다익스트라 활용
 사유: 가중치가 다 다름
 포인트: s에서 출발해서 어디까지 같이 타고, 언제 갈라질까?
 -> 합승 지점 i를 하나 정한다


 **/

import java.util.*;

class Solution {

    class Node implements Comparable<Node> {
        int node; // 현재 위치
        int cost; // 현재 누적 비용

        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost; // 우선순위 큐를 사용하기 위해 오름차순
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {

        // 그래프 만들기
        List<int[]>[] graph = new ArrayList[n + 1];

        // list 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선마다 갈 수 있는 곳 저장
        for (int[] f : fares) {
            int u = f[0];
            int v = f[1];
            int c = f[2];

            graph[u].add(new int[] {v, c});
            graph[v].add(new int[] {u, c});
        }

        // s에서 같이 가는 비용
        // a만 가는 비용
        // b만 가는 비용
        int[] distS = dijkstra(s, n, graph);
        int[] distA = dijkstra(a, n, graph);
        int[] distB = dijkstra(b, n, graph);

        // 최대값을 비교하기 위해서
        int answer = Integer.MAX_VALUE;

        // s+a+b 합하기, s가 없을 경우도 있음
        for (int i = 1; i <= n; i++) {
            if (distS[i] == Integer.MAX_VALUE) continue;

            answer = Math.min(answer,
                    distS[i] + distA[i] + distB[i]);
        }

        return answer;
    }

    // 다익스트라
    private int[] dijkstra(int start, int n, List<int[]>[] graph) {

        // 거리를 채우기
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {

            Node cur = pq.poll();

            if (cur.cost > dist[cur.node]) continue;

            for (int[] next : graph[cur.node]) {

                int nextNode = next[0];
                int cost = next[1];

                if (dist[nextNode] > cur.cost + cost) {
                    dist[nextNode] = cur.cost + cost;
                    pq.add(new Node(nextNode, dist[nextNode]));
                }
            }
        }

        return dist;
    }
}
