package programmers_134239_우박수열_정적분;

/**
 ### 문제이해
 주어진 범위에서 우박수열의 정적분을 구하여라.

 ### 제한사항
 2 ≤ k ≤ 10,000
 1 ≤ ranges의 길이 ≤ 10,000
 정답에 실수형이 포함되는 문제 -> double
 단, 주어진 구간의 시작점이 끝점보다 크면 이때의 정적분 결과는 -1로 정의합니다.

 ### 풀이과정
 5
 [[0,0],[0,-1],[2,-3],[3,-3]]
 [33.0,31.5,0.0,-1.0]

 (0, 5), (1, 16), (2, 8), (3, 4), (4, 2), (5, 1)
 10.5, 12, 6, 3, 1.5
 사다리꼴 공식
 (y1 + y2) * width / 2
 10.5 + 12 + 6 + 3 + 1.5 = 33.0
 범위별로 넓이를 더함
 [0,-1] -> 0 <= x <= 4 -> 33.0 - 1.5 = 31.5
 [2, -3] -> 2 ~ 2 = 0.0
 [3, -3] -> 3 ~ 2 -> -1.0

 1. 먼저 우박수열을 구하면서 넓이를 넣어둔다.
 2. 그리고 범위를 보면서 넓이를 구한다.
 근데 넓이를 구할때 범위가 순서대로 주어지나?
 순서대로 주어지면 슬라이딩 윈도우를 써서 빼면 될 것같음
 -> 순서대로 주어진다는 말이 없어서 안전하게 범위를 구하는게 나을 것 같다.

 **/
import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {

        double[] answer = new double[ranges.length];

        // 우박수열 넓이 넣기
        List<Double> list = new ArrayList<>();
        while (k != 1) {
            double temp = k;
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            list.add((temp + k)/2);
        }

        // 범위 넣기
        for (int i = 0; i < ranges.length; i++) {
            int x = ranges[i][0];
            int y = list.size() + ranges[i][1];
            if (x > y) answer[i] = -1;
            if (x == y) answer[i] = 0;
            if (x < y) {
                double sum = 0;
                for (int j = x; j < y; j++) {
                    sum += list.get(j);
                }
                answer[i] = sum;
            }
            if (list.size() < x) answer[i] = -1;
        }

        return answer;
    }
}
