package programmers_42842_카펫;

/**
 문제이해
 테두리 격자, 안쪽 격자를 통해서
 가로, 세로 길이를 구해라

 제한사항
 갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
 노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
 가로 >= 새로

 풀이과정
 1. 갈색 + 노란색 = 넓이
 2. 가로 * 세로 = 넓이
 3. 넓이의 소수를 구하기
 4. 소수: 1, 2, 3, 4, 6 , 12
 5. 어떻게 3, 4를 도출할건가?
 브라운: 10, 옐로우: 2
 소수: 1, 2, 3, 4, 6, 8, 12, 16, 24, 48

 * 중요한 문장 테두리 1줄은 갈색
 노란색 = w - 2 * h - 2
 w , h > 2

 **/

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = brown + yellow;
        for (int i = 1; i <= Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                // w >= h
                int h = i;
                int w = sum / i;
                if ((w - 2) * (h - 2) == yellow) {
                    answer[0] = w;
                    answer[1] = h;
                    break;
                }
            }
        }

        return answer;
    }
}
