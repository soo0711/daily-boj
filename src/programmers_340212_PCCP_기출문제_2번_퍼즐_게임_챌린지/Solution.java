package programmers_340212_PCCP_기출문제_2번_퍼즐_게임_챌린지;

/**
 ### 문제이해
 제한 시간 내에 퍼즐을 모두 해결하기 위한 숙련도의 최솟값을 출력해라.

 ### 제한사항
 diff ≤ level이면 퍼즐을 틀리지 않고 time_cur만큼의 시간을 사용하여 해결
 diff > level이면, 퍼즐을 총 diff - level번 틀립니다.
 한번 틀릴 때마다 이전시간 + 현재시간
 diff - level번 틀린 이후에 다시 퍼즐을 풀면 time_cur만큼의 시간을 사용하여 퍼즐을 해결
 1 ≤ diffs의 길이 = times의 길이 = n ≤ 300,000
 diffs[i]는 i번째 퍼즐의 난이도, times[i]는 i번째 퍼즐의 소요 시간입니다.
 1 ≤ limit ≤ 10^15

 ### 풀이과정
 1. 숙련도가 n일 때 시간초과 되는지 아닌지를 확인하자.
 2. diff의 구간에서 숙련도 가운데 값을 뽑는다.
 3. 숙련도를 계산하다가 limit가 넘으면 오른쪽 값을 왼쪽으로
 4. limit 안 넘으면 왼쪽 값으로
 5. left < right일때까지 반복
 6. 최솟값을 찾는거니까 answer 비교로 최솟값 갱신

 **/
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {

        // 길이가 1인거 먼저 return
        if (diffs.length == 1) {
            return times[0];
        }

        // 구간 구하기
        // left, right
        int left = Integer.MAX_VALUE;
        int right = 0;
        for (int diff : diffs) {
            if (left > diff) left = diff;
            if (right < diff) right = diff;
        }

        // 이분탐색
        // 3이 통과 -> 더 작은값도 되나?로 봐야함
        // 그러면 mid가 더 작아져야함
        int mid = 0;
        int answer = right;
        while (left <= right) {
            mid = (left + right) / 2;
            if (isLimit(mid, diffs, times, limit)) {
                right = mid - 1;
                if (answer > mid) answer = mid;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    // 난이도 계산
    boolean isLimit (int level, int[] diffs, int[] times, long limit) {
        long sum = 0;
        for (int i = 0; i < diffs.length; i++) {

            if (sum > limit) {
                return false;
            }

            long diff = diffs[i];
            if (diff - level > 0) {
                long miss = diff - level;
                long time = times[i - 1] + times[i];
                sum += (miss * time);
            }

            sum += times[i];
        }

        if (sum > limit) {
            return false;
        }

        return true;
    }
}
