import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String DNA = br.readLine();

        st = new StringTokenizer(br.readLine());
        int[] word = new int[4];

        for (int i = 0; i < 4; i++) {
            word[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[4];
        String begin = DNA.substring(0, P);

        for (int i = 0; i < begin.length(); i++) {
            char c = begin.charAt(i);

            if (c == 'A') {
                cnt[0]++;
            } else if (c == 'C') {
                cnt[1]++;
            } else if (c == 'G') {
                cnt[2]++;
            } else if (c == 'T') {
                cnt[3]++;
            }

        }

        boolean check = true;
        int answer = 0;

        for (int i = 0; i < 4; i++) {
            if (cnt[i] < word[i]) {
                check = false;
            }
        }

        if (check) {
            answer++;
        }

        int end = P + 1;

        while (end <= S) {
            int start = end - P;

            char before = DNA.charAt(start - 1);
            char after = DNA.charAt(end - 1);

            if (before == 'A') {
                cnt[0]--;
            } else if (before == 'C') {
                cnt[1]--;
            } else if (before == 'G') {
                cnt[2]--;
            } else if (before == 'T') {
                cnt[3]--;
            }

            if (after == 'A') {
                cnt[0]++;
            } else if (after == 'C') {
                cnt[1]++;
            } else if (after == 'G') {
                cnt[2]++;
            } else if (after == 'T') {
                cnt[3]++;
            }

            check = true;

            for (int i = 0; i < 4; i++) {
                if (cnt[i] < word[i]) {
                    check = false;
                }
            }

            if (check) {
                answer++;
            }

            end++;
        }

        System.out.println(answer);

    }
}