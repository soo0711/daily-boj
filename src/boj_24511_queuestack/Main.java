package boj_24511_queuestack;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        Deque<String> queueStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String num = st.nextToken();
            if (a[i] ==  0){
                queueStack.addLast(num);
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            queueStack.addFirst(st.nextToken());
            bw.write(queueStack.pollLast() + " ");
        }

        bw.flush();
        br.close();
    }
}
