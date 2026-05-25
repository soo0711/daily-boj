package programmers_17686_3차_파일명_정렬;

/**
 문제이해
 파일명을 보고 순차적으로 정렬해라.

 제한사항
 우선순위 head > number > 입력순서
 중복된 파일명은 없으나, 대소문자나 숫자 앞부분의 0 차이가 있는 경우가 있다.
 -> (muzi1.txt, MUZI1.txt, muzi001.txt, muzi1.TXT는 함께 입력으로 주어질 수 있다.)
 대소문자 구분하지 않는다

 files는 1000 개 이하의 파일명을 포함하는 문자열 배열
 파일명은 100 글자 이하 길이로,
 영문 대소문자, 숫자, 공백(" "),
 마침표("."), 빼기 부호("-")

 풀이과정
 1. fileName 클래스를 만든다.
 이때 Head, number, input(들어 온 순서)로 구분한다.
 2. files를 돌면서 클래스에 저장한다.
 3. 돌 때 모두 소문자로 바꾸던가 대문자로 바꿔야한다.
 4. 0으로 시작하면 0 제외하고 저장 (이건 그냥 해도 될지도)

 **/

import java.util.*;

class Solution {
    public String[] solution(String[] files) {

        List<FileName> list = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            StringBuilder head = new StringBuilder();
            StringBuilder num = new StringBuilder();
            String file = files[i];
            boolean flag = true;

            for (int j = 0; j < file.length(); j++) {
                char cfile = file.charAt(j);
                cfile = Character.toLowerCase(cfile);

                // head일 때
                if (flag) {
                    if (cfile == ' ' || cfile == '.' ||
                            cfile == '-' || cfile - '0' >= 10) {
                        head.append(cfile);
                    } else {
                        flag = false;

                    }
                }

                // num, tail
                if (!flag) {
                    // tail
                    if (cfile == ' ' || cfile == '.' ||
                            cfile == '-' || cfile - '0' >= 10) {
                        break;
                    } else { // num
                        num.append(cfile);
                    }
                }
            }

            list.add(new FileName(file, head.toString(),
                    Integer.parseInt(num.toString()), i));
        }

        Collections.sort(list);

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).name;
        }

        return answer;
    }

    class FileName implements Comparable<FileName>{
        String name;
        String head;
        int num;
        int input;

        FileName(String name, String head, int num, int input) {
            this.name = name;
            this.head = head;
            this.num = num;
            this.input = input;
        }

        @Override
        public int compareTo(FileName fn) {
            if (!this.head.equals(fn.head)) {
                return this.head.compareTo(fn.head);
            }

            if (this.num != fn.num) {
                return this.num - fn.num;
            }

            return this.input - fn.input;
        }
    }
}
