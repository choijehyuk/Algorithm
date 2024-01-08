import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][3];
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int cnt = 0;

                    for (int l = 0; l < N; l++) {
                        if (arr[i][0] >= arr[l][0] && arr[j][1] >= arr[l][1] && arr[k][2] >= arr[l][2]) cnt++;
                    }

                    if (cnt >= K) {
                        answer = Math.min(answer, arr[i][0] + arr[j][1] + arr[k][2]);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}