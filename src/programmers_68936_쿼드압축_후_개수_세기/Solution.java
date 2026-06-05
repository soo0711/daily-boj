package programmers_68936_쿼드압축_후_개수_세기;

/**
 문제이해
 쿼드압축 후 0과 1의 개수를 세서 출력해라.

 제한사항
 arr의 행의 개수는 1 이상 1024 이하
 arr의 각 행에 있는 모든 값은 0 또는 1

 풀이과정
 하나라도 다르면 쪼개기
 같으면 list에 넣기
 1. arr.length = n
 2. n / 4로 나누고
 3. 하나라도 다르면 쪼개기로 들어가기
 4. 같으면 list에 넣기

 **/
import java.util.*;

class Solution {

    int zero = 0;
    int one = 0;

    public int[] solution(int[][] arr) {

        dfs(arr, 0, 0, arr.length);

        int[] answer = new int[] {zero, one};
        return answer;
    }

    void dfs(int[][] arr, int x, int y, int size) {
        int start = arr[x][y];
        boolean flag = true;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (start != arr[i][j]) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            if (start == 1) one++;
            else zero++;
        } else {
            int newSize = size / 2;
            // 1사분면
            dfs(arr, x, y, newSize);
            // 2사분면
            dfs(arr, x, y + newSize, newSize);
            // 3사분면
            dfs(arr, x + newSize, y, newSize);
            // 4사분면
            dfs(arr, x + newSize, y + newSize, newSize);
        }
    }
}
