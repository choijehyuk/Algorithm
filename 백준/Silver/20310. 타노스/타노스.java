import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        String s = br.readLine();

        int zeroCnt = 0;
        int oneCnt = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') zeroCnt++;
            else oneCnt++;
        }

        zeroCnt /= 2;
        oneCnt /= 2;

        int idx = 0;
        while (oneCnt > 0) {
            if (s.charAt(idx) == '1') {
                s = s.substring(0, idx) + s.substring(idx + 1);

                oneCnt--;
                idx -= 1;
            }
            idx++;
        }

        idx = s.length() - 1;
        while (zeroCnt > 0) {
            if (s.charAt(idx) == '0') {
                s = s.substring(0, idx) + s.substring(idx + 1);

                zeroCnt--;
                idx = s.length();
            }
            idx--;
        }

        System.out.println(s);
    }
}