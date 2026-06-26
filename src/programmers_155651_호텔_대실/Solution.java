package programmers_155651_호텔_대실;

/**
 문제이해
 코니에게 필요한 최소 객실의 수를 출력해라.

 제한사항
 한 번 사용한 객실은 퇴실 시간을 기준으로 10분간 청소를 하고 사용 가능
 1 ≤ book_time의 길이 ≤ 1,000
 book_time[i]는 ["HH:MM", "HH:MM"]
 "00:00" 부터 "23:59"까지
 시작 시각은 항상 종료 시각보다 빠릅니다.

 풀이과정
 ["14:10", "19:20"], +1
 ["14:20", "15:20"], -> 넘어가기
 [["15:00", "17:00"], -> 넘어가기
 ["16:40", "18:20"], + 1
 ["18:20", "21:20"]] + 1

 1. 입실시간으로 정렬
 2. 우선순위 큐 사용, 퇴실시간이 됐는지 아닌지 확인
 3. 퇴실시간 + 10 <= 입실시간 -> 큐 없애기
 4. 퇴실시간 + 10 > 입실시간 -> 큐 넣기

 **/
import java.util.*;

class Solution {
    public int solution(String[][] book_time) {

        List<Room> list = new LinkedList<>();
        for (String[] book : book_time) {
            // ["15:00", "17:00"]
            int checkIn = Integer.parseInt(book[0].split(":")[0]) * 60
                    + Integer.parseInt(book[0].split(":")[1]);
            int checkOut = Integer.parseInt(book[1].split(":")[0]) * 60
                    + Integer.parseInt(book[1].split(":")[1]);

            list.add(new Room(checkIn, checkOut + 10));
        }

        // 정렬
        Collections.sort(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Room r : list) {

            if (!pq.isEmpty() && pq.peek() <= r.checkIn) {
                pq.poll();
            }

            pq.add(r.checkOut);
        }

        int answer = pq.size();

        return answer;
    }

    class Room implements Comparable<Room>{
        int checkIn;
        int checkOut;

        Room (int checkIn, int checkOut) {
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }

        @Override
        public int compareTo (Room r) {
            return this.checkIn - r.checkIn;
        }
    }
}
