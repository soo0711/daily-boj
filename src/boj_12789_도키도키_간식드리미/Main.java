package boj_12789_도키도키_간식드리미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Integer> line = new ArrayDeque<>();
        int first = 1;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == first) {
                first++;
            } else {
                line.push(num);
            }
            while(!line.isEmpty() && first == line.peek()) {
                line.pop();
                first++;
            }
        }

        System.out.println(line.isEmpty()? "Nice" : "Sad");
    }
}
