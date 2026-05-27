package programmers_42884_단속카메라;

/**
 문제이해
 모든 차량이 한 번은 단속용 카메라를 만나도록하려면 최소 몇 대의 카메라를
 설치해야할지 출력해라.

 제한사항
 차량의 대수는 1대 이상 10,000대 이하
 routes에는 차량의 이동 경로가 포함
 -> routes[i][0]에는 i번째 차량이 고속도로에 진입한 지점
 -> routes[i][1]에는 i번째 차량이 고속도로에서 나간 지점
 차량의 진입/진출 지점에 카메라가 설치되어 있어도 카메라를 만난것
 차량의 진입 지점, 진출 지점은 -30,000 이상 30,000 이하

 풀이과정
 [-20,-15],
 [-14,-5],
 [-18,-13],
 [-5,-3]

 1. 총 범위를 구하면 -20 ~ -3
 2. -20 -> -20 0 0 0
 3. -15 -> -15 -15 0 0
 4. -14 -> -15 -15 -14 0
 5. -5 -> -15 -15 -5 -5
 6. set에 넣는다. 개수를 센다 -> 2개


 풀이과정 (2)
 1. 나가는 지점 기준으로 정렬한다.
 2. 겹치치 않으면 cnt++하고 갱신
 3. 아니면 넘어가기

 **/
import java.util.*;

class Solution {
    public int solution(int[][] routes) {

        // 정렬
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        // 카메라 설치지점
        int camLocation = -30001;
        int answer = 0;
        for (int[] r : routes) {
            int in = r[0];
            int out = r[1];

            if (camLocation < in) {
                answer++;
                camLocation = out;
            }
        }

        return answer;
    }
}
