package programmers_49994_방문_길이;

/**
 문제이해
 게임캐릭터가 명령어를 받고 이동할 때
 처음 걸어본 길의 길이를 구하여라.
 좌표평면의 경계를 넘어가는 명령어도 무시

 제한사항
 dirs는 string형으로 주어지며, 'U', 'D', 'R', 'L' 이외에 문자는 주어지지 않습니다.
 dirs의 길이는 500 이하의 자연수

 풀이과정
 ULURRDLLU
 U -> (0, 1)
 L -> (-1, 0)
 R -> (1, 0)
 D -> (0, -1)

 1. dirs for문을 돌린다.
 2. set에 없으면 cnt++후 add
 3. set에 있으면 넘어가고 실행
 4. 좌표평면을 넘어가면 contiue;

 **/

import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;

        Set<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        for (char d : dirs.toCharArray()) {
            int tempX = x;
            int tempY = y;
            if (d == 'U') {
                if (y + 1 > 5) {
                    continue;
                }
                y++;
            } else if (d == 'L') {
                if (x - 1 < -5) {
                    continue;
                }
                x--;
            } else if (d == 'R') {
                if (x + 1 > 5) {
                    continue;
                }
                x++;
            } else {
                if (y - 1 < -5) {
                    continue;
                }
                y--;
            }
            String s = "" + tempX + tempY + x + y;
            String s1 = "" + x + y + tempX + tempY;
            if (!set.contains(s) && !set.contains(s1)) {
                set.add(s);
                set.add(s1);
                answer++;
            }
        }

        return answer;
    }
}

