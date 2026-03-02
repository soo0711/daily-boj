package programmers_12941_최솟값_만들기;

import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        // 오름차순 정렬
        Arrays.sort(A);

        // 오름차순 정렬
        Arrays.sort(B);

        // 앞 * 뒤
        int answer = 0;
        for(int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - 1 - i];

        }

        return answer;
    }
}
