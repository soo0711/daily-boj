package boj_18258_큐2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    queue.addFirst(num);
                    break;
                case "pop":
                    if (queue.isEmpty()){
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(queue.removeLast() + "\n");
                    }
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    if (queue.isEmpty()){
                        bw.write(1 + "\n");
                    } else {
                        bw.write(0 + "\n");
                    }
                    break;
                case "front":
                    if (queue.isEmpty()){
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(queue.getLast() + "\n");
                    }
                    break;
                case "back":
                    if (queue.isEmpty()){
                        bw.write(-1 + "\n");
                    } else {
                        bw.write(queue.getFirst() + "\n");
                    }
                    break;
            }
        }
        bw.flush();
        br.close();
    }
}
