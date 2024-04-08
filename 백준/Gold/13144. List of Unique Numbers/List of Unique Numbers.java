import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashSet<Integer> set = new HashSet<>();

        int idx = 0;
        long answer = 0;
        for (int i = 0; i < N; i++) {
            if (set.contains(arr[i])) {
                for (int j = idx; j < i; j++) {
                    answer += i - j;
                    idx++;
                    if (arr[i] == arr[j]) break;
                    set.remove(arr[j]);
                }
            } else {
                set.add(arr[i]);
            }
        }

        for (int i = idx; i < N; i++) {
            answer += N - i;
        }
        System.out.println(answer);

    }
}