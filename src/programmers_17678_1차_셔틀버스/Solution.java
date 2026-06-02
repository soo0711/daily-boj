package programmers_17678_1차_셔틀버스;

/**
 ### 문제이해
 콘이 셔틀을 타고 사무실로 갈 수 있는 도착 시각 중 제일 늦은 시각 구하자.

 ### 제한사항
 같은 시각에 도착한 크루 중 대기열에서 제일 뒤에 선다.
 모든 크루는 잠을 자야 하므로 23:59에 집에 돌아간다.
 0 ＜ n ≦ 10 운행횟수
 0 ＜ t ≦ 60 운행간격
 0 ＜ m ≦ 45 탈 수 있는 수
 크루의 도착 시각 HH:MM은 00:01에서 23:59

 ### 풀이과정
 09:00부터 총 n회 t분 간격으로 역에 도착
 1	1	5	["08:00", "08:01", "08:02", "08:03"]	"09:00"
 2	10	2	["09:10", "09:09", "08:00"]	"09:09"
 1. m > timetalbe.length => "09:00"
 2. 시간 순으로 정렬
 3. 시간표 9:00 1 / 9:10 2 마지막 시간의 끝
 4. 시간이 같으면 맨 뒤

 ### 풀이과정2
 1. 정렬
 2. m > 타는 수 => 시간
 3. 가장 마지막 차를 타야함
 4. 9:00~9:n < m => 마지막 출발 시간
 5. 버스 시간표로 역순으로 보기
 6. 버스 타는 사람 세어보기
 7. 시간 갱신 => m 클경우를 대비해서
 8. 대기순번이 잇다, 23:59는 집에 감
 9. 시간 범위를 구해서 사람의 수 넣기 -> 사람의 수

 ### 풀이과정3
 1. 타임테이블 시간으로 바꾸고 정렬
 2. 버스 시간을 돌아보면서
 3. 탈 수 있는 수보다 작고, 시간도 작거나 같고, 타임테이블의 값보다 작으면
 4. idx ++, 한 버스의 수 ++
 5. 마지막 버스를 타야하므로 마지막 버스에서 m이 꽉 안찼으면 마지막 시간이 답
 6. 아니면 마지막 idx -1

 **/
import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {

        // 타임테이블 시간으로 변환
        int[] time = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            int hour = Integer.parseInt(timetable[i].split(":")[0]);
            int min = Integer.parseInt(timetable[i].split(":")[1]);
            time[i] = hour * 60 + min;
        }

        // 정렬
        Arrays.sort(time);

        // 버스시간 계산
        int bus = 540; // 9:00
        int idx = 0;
        int con = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            while (idx < timetable.length && cnt < m
                    && time[idx] <= bus) {
                idx++;
                cnt++;
            }

            if (i == n - 1) {
                if (cnt < m) {
                    con = bus;
                } else {
                    con = time[idx - 1] - 1;
                }
            }

            // bus 시간 넘어가기
            bus += t;
        }

        String answer = String.format("%02d:%02d", con/60, con%60);
        return answer;
    }
}
