package programmers_12951_JadenCase_문자열_만들기;

class Solution {
    public String solution(String s) {

        // 쪼개기
        char[] arr = s.toCharArray();

        // for문을 돌아서
        // 첫단어가 숫자면 대문자 -> 소문자
        // 첫단어가 소문자 -> 대문자 / 이후는 소문자
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == ' '){ // 첫글자 판독
                flag = true;
                sb.append(arr[i]);
                continue;
            }

            if (flag) { // 첫글자
                sb.append(Character.toUpperCase(arr[i]));
                flag = false;
            } else {
                sb.append(Character.toLowerCase(arr[i]));
            }
        }
        String answer = sb.toString();
        return answer;
    }
}
