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


        boolean[] burger = new boolean[N];
        boolean[] people = new boolean[N];

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'H') {
                burger[i] = true;
            }
            if (s.charAt(i) == 'P') {
                people[i] = true;
            }
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            if (people[i]) {
                for (int j = i - K; j <= i + K; j++) {
                    if (j < 0 || j >= N) continue;

                    if (burger[j]) {
                        burger[j] = false;
                        answer++;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}