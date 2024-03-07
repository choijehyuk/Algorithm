import java.util.*;
import java.io.*;

public class Main {
    static int N, K, P, X;
    static int[][] arr = {
            {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
            {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
            {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
            {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
            {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
            {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
            {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
            {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
            {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
            {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
    };
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 1이상 N이하
        // K자리수
        // 최대 p개의 반전 계획
        // 실제 x층에 멈추어 있을 때
        // n k p x

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        solve(0, 1, 0, 0);

        System.out.println(--answer);
    }

    private static void solve(int idx, int temp, int num, int change) {
        if (change > P || num > N) return;
        if (idx == K) {
            if (num != 0) answer++;
            return;
        }

        for (int i = 0; i < 10; i++) {
            solve(idx + 1, temp * 10, i * temp + num, change + arr[X / temp % 10][i]);
        }
    }
}