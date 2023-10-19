import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        String[] str = new String[N - M + 1];
        int idx = 0;

        for (int i = M; i <= N; i++) {
            String s = String.valueOf(i);

            String eng = "";
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (c == '1') {
                    eng += "one";
                } else if (c == '2') {
                    eng += "two";
                } else if (c == '3') {
                    eng += "three";
                } else if (c == '4') {
                    eng += "four";
                } else if (c == '5') {
                    eng += "five";
                } else if (c == '6') {
                    eng += "six";
                } else if (c == '7') {
                    eng += "seven";
                } else if (c == '8') {
                    eng += "eight";
                } else if (c == '9') {
                    eng += "nine";
                } else if (c == '0') {
                    eng += "zero";
                }
                eng += " ";
            }
            str[idx] = eng;
            idx++;
        }
        Arrays.sort(str, Comparator.naturalOrder());

        int cnt = 0;
        for (int i = 0; i < str.length; i++) {
            st = new StringTokenizer(str[i]);

            String s = "";

            while (st.hasMoreTokens()) {
                String token = st.nextToken();

                if (token.equals("zero")) {
                    s += "0";
                } else if (token.equals("one")) {
                    s += "1";
                } else if (token.equals("two")) {
                    s += "2";
                } else if (token.equals("three")) {
                    s += "3";
                } else if (token.equals("four")) {
                    s += "4";
                } else if (token.equals("five")) {
                    s += "5";
                } else if (token.equals("six")) {
                    s += "6";
                } else if (token.equals("seven")) {
                    s += "7";
                } else if (token.equals("eight")) {
                    s += "8";
                } else if (token.equals("nine")) {
                    s += "9";
                }
            }

            System.out.print(s + " ");
            cnt++;

            if (cnt % 10 == 0) {
                System.out.println();
            }

        }
    }
}