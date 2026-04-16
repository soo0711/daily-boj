package programmers_87946_피로도;

/**
 문제이해
 유저의 현재 피로도를 기준으로 탐험할 수 있는
 최소 필요도와 소모 피로도를 충족하는 최대 던전 수를 구하여라

 제한사항
 k는 1 이상 5,000 이하인 자연수
 dungeons의 세로(행) 길이(즉, 던전의 개수)는 1 이상 8 이하
 1 <= 소모 피로도 <= 최소 피로도 <= 1000
 다른 던전의 소모, 최소 피로도가 같을 수 있음

 풀이과정
 80
 80 - 20
 60 - 40
 1 -> 2 -> 3
 2번

 80 - 20
 60 - 10
 50 - 40
 10
 3번

 반환값 3

 1. dfs를 사용해서 모든 경우의 수 탐색
 2. class를 만들어서 최소, 소모를 넣어둔다.
 3. for문을 돌면서 방문을 한다.
 4. 체력이 안돼서 방문 못하면 break, 혹은 모두 다 방문하면 return

 **/

class Solution {

    boolean[] visit;
    int answer = 0;

    public int solution(int k, int[][] dungeons) {

        Node[] node = new Node[dungeons.length];
        visit = new boolean[dungeons.length];

        // 초기 값 세팅
        for (int i = 0; i < dungeons.length; i++) {
            int current = dungeons[i][0]; // 최소 피로도
            int use = dungeons[i][1]; // 소모 피로도

            Node n = new Node(current, use);
            node[i] = n;
        }

        dfs(k, node, 0);

        return answer;
    }

    void dfs(int k, Node[] node, int cnt) {
        if (answer < cnt) {
            answer = cnt;
        }

        for (int i = 0; i < node.length; i++) {
            if (!visit[i] && node[i].current <= k) {
                visit[i] = true;
                dfs(k - node[i].use, node, cnt + 1);
                visit[i] = false;
            }
        }
    }

    class Node {
        int current;
        int use;

        Node (int current, int use) {
            this.current = current;
            this.use = use;
        }
    }
}
