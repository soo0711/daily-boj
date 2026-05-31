package programmers_12907_거스름돈;

/**
 문제이해
 거스름돈을 줄 수 있는 경우의 수를 구하여라.

 제한사항
 n은 100,000 이하의 자연수
 화폐 단위는 100종류 이하
 모든 화폐는 무한하게 있다고 가정
 정답이 커질 수 있으니, 1,000,000,007로 나눈 나머지를 return

 풀이과정
 1. 정렬하기
 2. 처음 화폐가 할 수 있는 경우의 수를 넣기
 3. 예를 들어 1 => 1 + 1 => 2
 2. 0 + 1 => + 1 => + 1 => + 1. > + 1
 3. 0 + 2 => +2 => + 2..

 1 = cnt[1 - 1], 2 = cnt[2 - 1],
 3 = cnt[3-1], 4 = cnt[4 - 1], 5 = cnt[5 - 1]

 2 = cnt[2 - 2] = 1, 1 .. 2 , 3 = cnt[3 - 2] = 1,1,1 .. 1, 2
 4 = cnt[4 - 2] = 1, 1, 2 .. 2, 2, \
 5 = cnt[5 - 2] = 1, 2, 2, .. 1,1,1
 **/
import java.util.*;

class Solution {
    public int solution(int n, int[] money) {

        // 정렬
        Arrays.sort(money);

        int[] cnt = new int[n + 1];
        // 0가지 만드는 것은 1가지니까
        cnt[0] = 1;

        for (int m : money) { // 1
            for (int i = m; i <= n; i++) { // 1 2 3 4 5
                cnt[i] += cnt[i - m] % 1000000007;
            }
        }

        int answer = cnt[n];
        return answer;
    }
}
