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

        int N = Integer.parseInt(br.readLine());

        String word = br.readLine();
        int[] eng = new int[26];
        int[] copy = new int[26];
        int answer = 0;

        for (int i = 0; i < word.length(); i++) {
            eng[word.charAt(i) - 'A']++;
            copy[word.charAt(i) - 'A']++;
        }

        for (int i = 0; i < N - 1; i++) {
            String input = br.readLine();

            for (int j = 0; j < input.length(); j++) {
                eng[input.charAt(j) - 'A']--;
            }

            int cnt = 0;
            boolean check = false;
            for (int j = 0; j < eng.length; j++) {
                // 빼기
                if (eng[j] < 0) {
                    cnt -= eng[j];
                }

                // 더하기
                if (eng[j] > 0) {
                    cnt += eng[j];
                }

                // 단어 중복체크
                if (eng[j] >= 2 || eng[j] <= -2) {
                    check = true;
                }
            }

            if (cnt < 2 && !check) {
                answer++;
            }

            // 바꾸기
            int minus = 0;
            int plus = 0;
            for (int j = 0; j < eng.length; j++) {
                if (eng[j] == -1) {
                    minus++;
                }
                if (eng[j] == 1) {
                    plus++;
                }
            }

            if (cnt == 2 && minus == 1 && plus == 1) {
                answer++;
            }

            for (int j = 0; j < eng.length; j++) {
                eng[j] = copy[j];
            }
        }

        System.out.println(answer);
    }

}