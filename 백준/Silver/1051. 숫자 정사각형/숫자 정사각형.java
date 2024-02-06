import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                map[i][j] = c - 48;
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 1; k + i < N && k + j < M; k++) {
                    if (map[i][j] == map[i + k][j] && map[i][j] == map[i][j + k] && map[i][j] == map[i + k][j + k]) {
                        answer = Math.max(answer, (k + 1) * (k + 1));
                    }
                }
            }
        }
        System.out.println(answer == Integer.MIN_VALUE ? 1 : answer);
    }

}