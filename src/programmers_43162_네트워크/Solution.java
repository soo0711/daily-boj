package programmers_43162_네트워크;

/**
 문제이해
 : 연결된 컴퓨터를 찾고 네트워크의 개수를 찾아라

 제한사항
 : computer[i][i]는 항상 1입니다.
 : 2차원 배열 입력

 풀이과정
 1. 1이면 깊게 들어감
 [[1, 1, 0], [1, 1, 1], [0, 1, 1]]
 0,1 -> 1
 1,2 -> 1
 2,3 -> 1

 **/
class Solution {

    int answer = 0;
    boolean[] visited; // 방문한 컴퓨터
    public int solution(int n, int[][] computers) {

        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                visited[i] = true;
                dfs(computers, i, n);
            }
        }


        return answer;
    }


    void dfs(int[][] computers, int start, int depth) {
        for (int i = 0; i < depth; i++) {
            if (!visited[i] && computers[i][start] == 1) {
                visited[i] = true;
                dfs(computers, i, depth);
            }
        }
    }
}