package programmers_72411_메뉴_리뉴얼;

import java.util.*;

class Solution {
    // Map 생성
    static Map<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        // 답 넣을 List 생성
        List<String> list = new ArrayList<>();

        // course당 모든 orders를 돌아야한다.
        for (int i = 0; i < course.length; i++) {
            // map을 비워준다.
            map.clear();

            // 조합
            for (int j = 0; j < orders.length; j++) {
                char[] arr = orders[j].toCharArray();
                Arrays.sort(arr);
                combination(arr, 0 , course[i], new StringBuilder());
            }

            // max 값 찾기
            int max = 0;
            for (String key : map.keySet()) {
                max = Math.max(max, map.get(key));
            }

            if (max >= 2) {
                for (String key : map.keySet()) {
                    if(map.get(key) == max) {
                        list.add(key);
                    }
                }
            }
        }

        // 오름차순 정렬
        Collections.sort(list);
        // 출력 list -> string[]
        String[] answer = list.toArray(new String[0]);
        return answer;
    }

    // 조합 -> 재귀를 이용해서 자르기
    void combination(char[] arr, int start, int depth, StringBuilder sb) {
        if (depth == sb.length()) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            sb.append(arr[i]);
            combination(arr, i + 1, depth, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}