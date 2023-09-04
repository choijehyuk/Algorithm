import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] candy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        candy = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 && j == 0) {
                    candy[i][j] = map[i][j];
                } else if (i == 0) {
                    candy[i][j] = candy[i][j - 1] + map[i][j];
                } else if (j == 0) {
                    candy[i][j] = candy[i - 1][j] + map[i][j];
                } else if (candy[i - 1][j] + map[i][j] >= candy[i][j] || candy[i][j - 1] + map[i][j] >= candy[i][j]) {
                    candy[i][j] = Math.max(candy[i - 1][j] + map[i][j], candy[i][j - 1] + map[i][j]);
                }
            }
        }

        System.out.println(candy[N - 1][M - 1]);
    }
}