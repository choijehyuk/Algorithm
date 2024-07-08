import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] fruit = new int[N];
        int[] totalFruit = new int[10];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruit[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int left = 0;
        int right = 0;
        int kind = 0;
        int cnt = 0;

        while (right < N) {
            if (totalFruit[fruit[right]] == 0) {
                kind++;
            }

            totalFruit[fruit[right]]++;
            cnt++;

            if (kind > 2) {
                totalFruit[fruit[left]]--;
                cnt--;

                if (totalFruit[fruit[left]] == 0) {
                    kind--;
                }

                left++;
            }
            answer = Math.max(answer, cnt);
            right++;
        }

        System.out.println(answer);
    }
}