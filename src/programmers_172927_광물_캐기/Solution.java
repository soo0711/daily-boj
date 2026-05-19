package programmers_172927_광물_캐기;

/**
 ### 문제이해
 곡갱이로 광물을 캘 때 필요한 최소한의 피로도를 계산하여라.

 ### 제한사항
 picks는 [dia, iron, stone]과 같은 구조
 - 0 ≤ dia, iron, stone ≤ 5
 - dia는 다이아몬드 곡괭이의 수를 의미합니다.
 - iron은 철 곡괭이의 수를 의미합니다.
 - stone은 돌 곡괭이의 수를 의미합니다.

 5 ≤ minerals의 길이 ≤ 50
 - minerals는 다음 3개의 문자열
 - diamond : 다이아몬드
 - iron : 철
 - stone : 돌

 ### 풀이과정
 [dia, iron, stone]
 [1, 3, 2]
 ["diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"]

 dia 곡갱이는 모두 1
 iro 곡갱이는 다이아 5, 나머지 1
 돌 곡갱이는 다이아 25, 철 5, 나머지 1

 광물 처리 순서 -> dia > iron > stone
 주의할점은 주어진 순서대로 캘 수 있음
 1. 작은거 선택해서 피로도를 누적해온다.
 2. 최종피로도 = 작은 피로도 + 작은 피로도 + ...
 3. 최종피로도 = Math.max(작은 피로도);
 4. 종료조건 = 곡갱이 0 혹은 광물 idx 끝
 5. while문 돌려서 종료조건 맞추기
 6. 곡갱이 종류와 광물/5개로 배열
 7. 배열을 돌면서 Math.min으로 작은 값 찾기

 ### 풀이과정(2)
 1. 먼저 곡갱이 보다 넘치는 광물을 자른다.
 2. 5개씩 그룹을 묶는다.
 3. 돌이 가장 피로도가 심하니까 돌을 기준 피로도를 구한다.
 4. 그 피로도 순으로 그룹을 내림차순 진행한다.
 5. 다이아부터 사용해 피로도를 줄인다.

 **/

import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {

        // 광물 개수 초기화
        int cnt = 0;
        for (int p : picks) {
            cnt += p;
        }
        cnt *= 5;
        if (minerals.length < cnt) {
            cnt = minerals.length;
        }

        List<Mineral> group = new ArrayList<>();
        // 돌일 때 피로도 계산
        for (int i = 0; i < cnt; i += 5) {
            List<String> list = new ArrayList<>();
            for (int j = i; j < cnt && j < i + 5; j++) {
                list.add(minerals[j]);
            }

            String[] min = new String[list.size()];
            for (int j = 0; j < min.length; j++) {
                min[j] = list.get(j);
            }
            group.add(new Mineral(min, accStone(min),
                    accIron(min), accDia(min)));
        }

        int answer = 0;
        Collections.sort(group);
        for (int i = 0; i < group.size(); i++) {
            if (picks[0] != 0) {
                answer += group.get(i).diaSum;
                picks[0]--;
            } else if (picks[1] != 0) {
                answer += group.get(i).ironSum;
                picks[1]--;
            } else {
                answer += group.get(i).stoneSum;
                picks[2]--;
            }
        }

        return answer;
    }

    class Mineral implements Comparable<Mineral>{
        String[] min;
        int stoneSum;
        int ironSum;
        int diaSum;

        Mineral(String[] min, int stoneSum, int ironSum, int diaSum) {
            this.min = min;
            this.stoneSum = stoneSum;
            this.ironSum = ironSum;
            this.diaSum = diaSum;
        }

        @Override
        public int compareTo(Mineral m) {
            return m.stoneSum - this.stoneSum;
        }
    }

    int accStone(String[] min) {
        int sum = 0;
        for (String m : min) {
            if (m.equals("diamond")){
                sum += 25;
            } else if (m.equals("iron")) {
                sum += 5;
            } else {
                sum += 1;
            }
        }
        return sum;
    }

    int accDia(String[] min) {
        int sum = 0;
        for (String m : min) {
            sum += 1;
        }
        return sum;
    }

    int accIron(String[] min) {
        int sum = 0;
        for (String m : min) {
            if (m.equals("diamond")){
                sum += 5;
            } else {
                sum += 1;
            }
        }
        return sum;
    }
}
