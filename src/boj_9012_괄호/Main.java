package boj_9012_괄호;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            char[] array = br.readLine().toCharArray();
            Deque<Character> stack = new ArrayDeque<>();
            boolean isValid = true;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == '(') {
                    stack.push('(');
                } else {
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (isValid && stack.isEmpty()) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.flush();
        br.close();
    }
}
