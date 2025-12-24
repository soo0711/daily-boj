package boj_4948_베르트랑_공준;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int max = 123456 * 2;
        int limit = (int) Math.sqrt(max);
        boolean[] array = new boolean[max + 1];
        array[0] = array[1] = true;

        for (int i = 2; i <= limit ; i++) {
            if (!array[i]) {
                for (int j = i * i; j < array.length; j += i) {
                    array[j] = true;
                }
            }
        }

        while(true) {
            int start = Integer.parseInt(br.readLine());
            if (start == 0) break;

            int end = start * 2;
            int cnt = 0;
            for (int i = start + 1; i <= end; i++) {
                if (!array[i]) {
                    cnt++;
                }
            }

            bw.write(cnt + "\n");
        }

        bw.flush();
        br.close();

    }
}
