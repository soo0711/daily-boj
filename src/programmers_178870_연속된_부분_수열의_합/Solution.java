package programmers_178870_연속된_부분_수열의_합;

/**
 문제이해
 부분 수열의 합 k를 나타내는 길이가 짧은 수열을 찾아서 출력해라.

 제한사항
 5 ≤ sequence의 길이 ≤ 1,000,000
 1 ≤ sequence의 원소 ≤ 1,000
 sequence는 비내림차순으로 정렬
 k는 항상 sequence의 부분 수열

 풀이과정
 [1, 2, 3, 4, 5]
 1 < 7
 1 2 < 7
 1 2 3 < 7
 1 2 3 4 > 7
 2 3 4 > 7
 3 4 = 7
 3 4 5 < 7
 4 5 < 7
 5 < 7

 [1, 1, 1, 2, 3, 4, 5]
 1 < 5
 1 1 < 5
 1 1 1 < 5
 1 1 1 2 = 5
 1 1 1 2 3 > 5
 1 1 2 3 > 5
 1 2 3 > 5
 2 3 = 5
 2 3 4 > 5
 3 4 > 5
 4 < 5
 4 5 < 5
 5 = 5
 0

 1. 투포인터를 사용한다.
 2. left, right를 = 0으로 둔다.
 3. sum이 k보다 크거나 같으면 right + 1;
 4. sum이 k보다 작으면 left + 1;
 5. 종료 조건 left == right
 6. k면 right - left가 원래 있던 값보다 작으면 start, end값 갱신
 * 길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열을 찾습니다.

 **/

class Solution {
    public int[] solution(int[] sequence, int k) {

        int sum = 0; // 값
        int left = 0; // 왼쪽 포인터
        int right = 0; // 오른쪽 포인터

        int len = sequence.length + 1; // 최소 길이
        int start = 0; // 시작 인덱스
        int end = 0; // 마지막 인덱스


        while (left < sequence.length
                || right < sequence.length) {

            if (sum <= k && right < sequence.length) {
                sum += sequence[right];
                right++;
            } else {
                sum -= sequence[left];
                left++;
            }

            if (sum == k) {
                int num = right - left;
                if (len > num) {
                    if (len == num && start > left) {
                        continue;
                    }
                    len = num;
                    start = left;
                    end = right - 1;
                }
            }
        }

        int[] answer = new int[] {start, end};
        return answer;
    }
}
