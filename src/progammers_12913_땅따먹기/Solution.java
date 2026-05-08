package progammers_12913_땅따먹기;
/**
 문제이해
 1행부터 땅을 밟으며 한 행 씩 내려올 때, 최고점이 되게 내려와라

 제한사항
 한 행씩 내려올 때, 같은 열을 연속해서 밟을 수 없는 특수 규칙
 행의 개수 N : 100,000 이하의 자연수
 열의 개수는 4개이고, 땅(land)은 2차원 배열
 점수 : 100 이하의 자연수

 풀이과정
 밟았던 열을 기억, 최대값을 찾아야함
 | 1 | 2 | 3 | 5 |
 | 5 | 6 | 7 | 8 |
 | 4 | 3 | 2 | 1 |
 이중 for문 400,000인데 시간 복잡도가 괜찮을 듯?
 1.  이중 for문을 돌고 max값과 index값을 기억해두자.
 2. 같은 인덱스면 패스

 1. 무작정 큰 값을 내려오면 안된다 -> 최고 값을 찾아야함
 2. 각 배열마다 값 더하기 같은 인덱스빼고

 **/

class Solution {
    int solution(int[][] land) {

        for (int i = 1; i < land.length; i++) {

            land[i][0] += Math.max(
                    Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);

            land[i][1] += Math.max(
                    Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);

            land[i][2] += Math.max(
                    Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]);

            land[i][3] += Math.max(
                    Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]);
        }


        int answer = 0;
        int lastRow = land.length - 1;
        for (int j = 0; j < 4; j++) {
            answer = Math.max(answer, land[lastRow][j]);
        }

        return answer;
    }
}
