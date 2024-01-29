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

        int[] A = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + A[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        long answer = 0;
        for (int i = 1; i <= N; i++) {
            answer += map.getOrDefault(arr[i] - K, 0);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println(answer);
    }
}