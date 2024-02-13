import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static boolean[][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        v = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            v[a][b] = true;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (v[j][i] && v[i][k]) v[j][k] = true;
                }
            }
        }

        int[] cnt = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (v[i][j] || v[j][i]) cnt[i]++;
            }
        }

        int answer = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == N - 1) answer++;
        }

        System.out.println(answer);

    }
}