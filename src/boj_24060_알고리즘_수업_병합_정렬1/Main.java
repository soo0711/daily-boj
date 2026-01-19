package boj_24060_알고리즘_수업_병합_정렬1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int cnt = 0;
    static int k = 0;
    static int result = -1;
    static int[] tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        tmp = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(array, 0, array.length - 1);
        System.out.println(result);
    }

    public static void merge_sort(int[] array, int p, int r) {
        if(cnt > k) return;
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(array, p, q);
            merge_sort(array, q + 1, r);
            merge(array, p, q, r);
        }
    }

    public static void merge(int[] array, int p, int q, int r) {
        int i = p;
        int j = q +1;
        int t = 1;

        while (i <= q && j <= r) {
            if (array[i] <= array[j]){
                tmp[t++] = array[i++];
            } else {
                tmp[t++] = array [j++];
            }
        }

        while (i <= q){
            tmp[t++] = array[i++];
        }

        while (j <= r){
            tmp[t++] = array[j++];
        }

        i = p;
        t = 1;

        while (i <= r){
            cnt ++;
            if (cnt == k) {
                result = tmp[t];
                break;
            }
            array[i++] = tmp[t++];
        }
    }
}
