import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] mara;
    static int[][] map;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        mara = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 0);
        System.out.println(answer);
    }

    private static void comb(int cnt, int idx) {
        if (cnt == K) {
            int sum = 0;
            for (int i = 0; i < K; i++) {
                for (int j = i + 1; j < K; j++) {
                    sum += map[mara[i]][mara[j]];
                }
            }

            answer = Math.max(answer, sum);
            return;
        }

        for (int i = idx; i < N; i++) {
            mara[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }
}
