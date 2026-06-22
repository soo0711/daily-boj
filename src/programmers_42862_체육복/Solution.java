package programmers_42862_체육복;

/**
 문제이해
 체육수업을 들을 수 있는 학생의 최댓값을 출력하도록 함수를 작성해라.

 제한사항
 - 전체 학생의 수는 2명 이상 30명 이하
 - 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 - 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
 - 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
 - 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.

 풀이과정
 1. n에서 lost한 수를 뺀다.
 2. lost와 reserve를 정렬한다.
 3. lost + 1, -1이 reserve에 있으면 num + 1, reserve -1

 **/
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        Set<Integer> set1 = new HashSet<>();
        for (int r : reserve) {
            set1.add(r);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int l : lost) {
            set2.add(l);
        }

        // 도둑 맞았지만 여벌이 있는 경우
        for (int l : lost) {
            if (set1.contains(l)) {
                set1.remove(l);
                set2.remove(l);
                answer++;
            }
        }

        // 도둑맞은 사람들
        for (int l : lost) {
            if (!set2.contains(l)) {
                continue;
            }
            if (set1.contains(l - 1)) {
                set1.remove(l - 1);
                answer++;
            } else if (set1.contains(l + 1)) {
                set1.remove(l + 1);
                answer++;
            }
        }

        return answer;
    }
}
