import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T;
    static int J,N;
    static int[] arr;
    public static    void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            J = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            arr = new int[N];
            for (int i = 0; i < N; i++) {
                st=  new StringTokenizer(br.readLine());
                int R = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());

                arr[i] = R * C;
            }
            Arrays.sort(arr);
            int answer = 0;
            for (int i = arr.length-1; i >= 0; i--) {
                J -= arr[i];
                answer++;
                if(J <= 0 ){
                    break;
                }
            }
            System.out.println(answer);
        }

    }


}
