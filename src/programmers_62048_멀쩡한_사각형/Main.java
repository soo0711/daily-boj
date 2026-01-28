package programmers_62048_멀쩡한_사각형;

public class Main {
    public long solution(int w, int h) {
        long total = (long) w * h;
        long answer = 0;

        // W와 H가 다를때
        long across = w + h - gcd(w, h);
        answer = total - across;

        return answer;
    }

    public long gcd(long w, long h) {
        while (h != 0) {
            long temp = w % h;
            w = h;
            h = temp;
        }
        return w;
    }
}
