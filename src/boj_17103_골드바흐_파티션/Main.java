package boj_17103_골드바흐_파티션;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] array = new boolean[1000000 + 1];
        array[0] = array[1] = true;
        int limit = (int) Math.sqrt(array.length);
        for (int i = 2; i <= limit ; i++) {
            if (!array[i]) {
                for (int j = i * i; j < array.length; j+= i) {
                    array[j] = true;
                }
            }
        }

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            limit = num / 2;
            int cnt = 0;
            for (int j = 2; j <= limit; j++) {
                if (!array[j]) {
                    if (!array[num - j]) {
                        cnt ++;
                    }
                }
            }
            bw.write(cnt + "\n");
        }


        bw.flush();
        br.close();
    }
}
