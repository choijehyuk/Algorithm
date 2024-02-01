import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        ArrayList<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) {
            list.add(arr[i], i);
        }

        for (Integer i : list) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}