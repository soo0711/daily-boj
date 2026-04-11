package programmers_17683_3차_방금그곡;

/**
 ### 문제 이해
 ### 제한사항
 - 입력: 음악제목, 끝난시간, 악보
 - 음: 12개
 - 각 음은 1분에 1개씩 재생된다.
 - 음악이 끊김 없이 처음부터 반복해서 재생
 - 조건이 일치하는 음악이 여러 개 -> 재생된 시간이 제일 긴 음악 제목
 - 조건이 일치하는 음악이 없을 때 ->  “(None)”을 반환

 ### 풀이과정
 1. musicinfos를 클래스로 뽑아서 시작, 끝, 제목, 음, 재생시간, 조건에 맞는 지
 2. m과 시작하는게 같을 때 음을 둥글게 굴린다.
 3. 만약 입력 값 모두 true이면 재생시간이 가장 짧은 걸로 제목을 뽑는다.

 ### 복습
 문제이해
 방금 들었던 곡의 제목을 출력해라

 제한사항
 각 음은 1분에 1개씩 재생
 음은 C, C#, D, D#, E, F, F#, G, G#, A, A#, B 12개
 재생시간 동안 음악이 끊김 없이 처음부터 반복해서 재생된다
 조건이 일치하는 음악이 여러 개 -> 재생된 시간이 제일 긴 음악 제목 -> 먼저 입력된 음악 제목
 조건이 일치하지 않으면 -> None을 반환한다.
 곡 정보는 음악이 시작한 시각, 끝난 시각, 음악 제목, 악보 정보

 풀이과정
 1. # -> 이 있는 건 다른 소문자로 바꿔준다. (왜냐면 1분에 한 음)
 2. H * 60 + M 끝난 시각 - 시작 시간 => 숫자
 3. 숫자만큼 음악의 음을 늘리거나 자른다.
 4. m이 들어있는지 확인한다.
 5. 일치하는 곡이 여러개면 재생된 시간이 긴지 비교해준다.

 **/
import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {

        // 일치하는 게 없으면 (None)
        String answer = "(None)";
        int max = 0;

        // 먼저 # -> 바꿔준다.
        m = isChange(m);
        System.out.println(m);
        for (String music : musicinfos) {
            String[] musicinfo = music.split(",");
            int startH = Integer.parseInt(musicinfo[0].split(":")[0]) * 60;
            int startM = Integer.parseInt(musicinfo[0].split(":")[1]);

            int endH = Integer.parseInt(musicinfo[1].split(":")[0]) * 60;
            int endM = Integer.parseInt(musicinfo[1].split(":")[1]);

            String title = musicinfo[2];
            String info = isChange(musicinfo[3]);

            int total = (endH + endM) - (startH + startM);

            // 숫자만큼 음악의 음을 늘리거나 자른다.
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < total; i++) {
                sb.append(info.charAt(i % info.length()));
            }

            // 비교
            if (sb.toString().contains(m)) {
                if (max < total) {
                    answer = title;
                    max = total;
                }
            }
        }

        return answer;
    }

    String isChange(String m) {
        return m.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a")
                .replace("B#", "b");
    }
}
