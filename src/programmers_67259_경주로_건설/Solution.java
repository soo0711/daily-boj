package programmers_67259_경주로_건설;

/**
 문제이해
 경주로를 건설하는데 필요한 최소비용을 출력해라.

 제한사항
 직선거리는 100원, 코너는 500원이 추가된다.
 board는 2차원 정사각 배열로 배열의 크기는 3 이상 25 이하
 board 배열의 각 원소의 값은 0 또는 1
 0은 가능 1은 불가능

 풀이과정
 dfs를 사용해서 갈 수 있는 거리를 확인하고
 이전과 다음 가는 곳이 x값 y값 모두 다르면 코너로 확인
 모든 경우의 수 -> 시간초과..

 풀이과정2
 bfs를 사용해서 갈 수 있는 거리를 확인하고
 가격이 작은 길을 선택한다.
 방향에 따라 길이 달라지기 때문에 방향도 저장한다.

 **/
import java.util.*;

class Solution {

    public int solution(int[][] board) {
        // 위, 아래, 오른쪽, 왼쪽
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 방문 초기화
        int n = board.length;
        int m = board[0].length;
        int[][][] visited = new int[n][m][4];
        for (int[][] visit : visited) {
            for (int[] v : visit) {
                Arrays.fill(v, Integer.MAX_VALUE);
            }
        }

        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, -1, 0));

        while (!que.isEmpty()) {
            Node node = que.remove();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && nx < n &&
                        ny >= 0 && ny < m) {
                    if (board[nx][ny] != 1) {
                        int nextCost = node.cost;

                        if (node.dir == -1 || node.dir == i) {
                            nextCost += 100;
                        } else {
                            nextCost += 600;
                        }

                        if (visited[nx][ny][i] >= nextCost) {
                            visited[nx][ny][i] = nextCost;
                            que.add(new Node(nx, ny, i, nextCost));
                        }
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            if (answer > visited[n - 1][m - 1][i])
                answer = visited[n - 1][m - 1][i];
        }
        return answer;
    }

    class Node {
        int x;
        int y;
        int dir;
        int cost;

        Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
}
