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
        String s = br.readLine();

        int left = 0;
        int right = 0;
        int cnt = 0;
        int[] eng = new int[26];
        int answer = 0;
        while (right < s.length()) {
            if (eng[s.charAt(right) - 'a'] == 0) {
                cnt++;
            }
            eng[s.charAt(right) - 'a']++;

            while (cnt > N && left < right) {
                eng[s.charAt(left) - 'a']--;
                if (eng[s.charAt(left) - 'a'] == 0) {
                    cnt--;
                }
                left++;
            }

            answer = Math.max(answer, right - left + 1);
            right++;
        }

        System.out.println(answer);
    }
}