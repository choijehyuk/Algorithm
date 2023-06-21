import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int sum;
    static int l,r;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        r = N-1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        while(l<r) {
            int sum = arr[l]+arr[r];

            if(min > Math.abs(sum)) {
                min = Math.abs(sum);
                sb = new StringBuffer();
                sb.append(arr[l] + " " + arr[r]);
            }

            if(sum>=0) {
                r--;
            }else {
                l++;
            }
        }

        System.out.println(sb);


    }
}