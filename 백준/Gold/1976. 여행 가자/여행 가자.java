import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,M;
    static int[][] arr;
    static boolean flag = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(i == j){
                    arr[i][j] = 1;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if(arr[j][i] == 1 && arr[i][k] == 1) {
                        arr[j][k] = 1;
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        for (int i = 1; i < M; i++) {
            int end = Integer.parseInt(st.nextToken());

            if(arr[start][end] == 0){
                flag = false;
            }
        }
        
        if(flag) System.out.println("YES");
        else System.out.println("NO");


    }


}