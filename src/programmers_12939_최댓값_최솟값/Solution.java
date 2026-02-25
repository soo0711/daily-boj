package programmers_12939_최댓값_최솟값;

class Solution {
    public String solution(String s) {

        // 문자를 쪼개기
        String[] array = s.split(" ");

        // 비교하기
        int min = Integer.parseInt(array[0]);
        int max = min;
        for (int i = 1; i < array.length; i++) {
            int num = Integer.parseInt(array[i]);

            if (min > num) min = num;
            if (max < num) max = num;
        }

        // 출력
        String answer = min + " " + max;

        return answer;
    }
}
