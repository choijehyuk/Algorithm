import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N, L;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken()) - 1;

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int end = 0;
        int answer = 0;

        while (end < N) {
            int cnt = 1;
            for (int i = end + 1; i < arr.length; i++) {
                if (Math.abs(arr[i] - arr[end]) <= L) {
                    cnt++;
                } else {
                    break;
                }
            }
            end += cnt;
            answer++;
        }
        System.out.println(answer);

    }

}