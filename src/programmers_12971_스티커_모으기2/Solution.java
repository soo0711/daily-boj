package programmers_12971_스티커_모으기2;
/**
 문제이해
 스티커를 뜯어내어 얻을 수 있는 숫자의 합의 최댓값을 구하여라.

 제한사항
 길이(N)는 1 이상 100,000 이하
 각 칸에 적힌 숫자는 1 이상 100 이하의 자연수
 sticker 배열의 첫 번째 원소와 마지막 원소가 서로 연결

 풀이과정
 1, 3, 2, 5, 4
 시간복잡도를 고려해야한다. -> O(N)까지 허용
 길이 / 2 => 뽑는 개수
 모든 경우의 수. -> 시간초과
 1. 길이가 1이면 바로 return
 2. 길이가 2이면 큰 수 return
 3. 첫번째 스티커를 뜯는 경우
 4. 첫번째 스티커를 안 뜯는 경우로 나눈다.
 5. 그 중 큰 거를 선택

 **/
import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int len = sticker.length;

        // 길이가 1, 2 일 때
        if (len == 1) return sticker[0];
        if (len == 2) return Math.max(sticker[0], sticker[1]);

        // 첫번째 스티커를 뜯는 경우
        int[] dp1 = new int[len];
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for (int i = 2; i < len - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
        }

        // 첫번째 스티커 안 뜯은 경우
        int[] dp2 = new int[len];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i < len; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        int answer = Math.max(dp1[len - 2], dp2[len - 1]);;
        return answer;
    }
}
