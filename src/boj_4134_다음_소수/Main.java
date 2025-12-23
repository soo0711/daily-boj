package boj_4134_다음_소수;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            while (true){
                if (prime(num)){
                    bw.write(num + "\n");
                    break;
                }
                num++;
            }
        }

        bw.flush();
        br.close();

    }

    public static boolean prime (long a){
        long limit = (long)Math.sqrt(a);
        if (a == 0 || a == 1) {
            return false;
        }
        for (long i = 2; i <= limit; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}
