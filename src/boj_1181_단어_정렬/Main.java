package boj_1181_단어_정렬;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] array = new String[n];

        for (int i = 0; i < n; i++) {
            array[i] = br.readLine();
        }

        Arrays.sort(array, (a1, a2) -> {
            if (a1.length() != a2.length()){
                return a1.length() - a2.length();
            } else {
                return a1.compareTo(a2);
            }
        });

        sb.append(array[0]).append("\n");
        for (int i = 1; i < array.length; i++) {
            if (!array[i].equals(array[i - 1])){
                sb.append(array[i]).append("\n");
            }
        }

        bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
    }
}
